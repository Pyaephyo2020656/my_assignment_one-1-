package com.jdc.assignment.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.model.CourseModel;
import com.jdc.assignment.model.OpenClassModel;
import com.jdc.assignment.model.RegistrationModel;


@WebServlet(urlPatterns = {
		"/registration",
		"/registration-edit"
		
		
})
public class RegistrationServlet extends AbstractBeanFactoryServlet{

	private static final long serialVersionUID = 1L;
	private static final String SESSION_CLASS_ID = "session.openclass.id";
		private static final String APPEARENCE = "/registration";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var classId = req.getParameter("classId");
		
		//if classId from request object is null , get it from Session Scope
		
				if(null == classId) {
					HttpSession session = req.getSession();
					classId = (String) session.getAttribute(SESSION_CLASS_ID);
				}
				
				var classModel = getBean("openClassModel", OpenClassModel.class);
				
				var openclassList = classModel.findClassById(Integer.parseInt(classId));
				
				req.setAttribute("openclass", openclassList);
				
				var page = switch(req.getServletPath()) {
				
				case APPEARENCE -> {
					
					var model = getBean("registrationModel", RegistrationModel.class);
					var relist = model.findbyClass(Integer.parseInt(classId));
					req.setAttribute("registration", relist);
					
					yield "registration";
					
				}
				default -> "registration-edit";
				};
				
				getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
				
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = null;
		//get request parameter
		
			
	     var ocId = req.getParameter("open_class_id");
	     var student = req.getParameter("student");
	     var phone = req.getParameter("phone");
	     var email = req.getParameter("email");
		
	     	//create registration object	
	     
	        //get openclass object from spring.
	     
	     var openclass = getBean("openClassModel", OpenClassModel.class);
	     var classes = openclass.findClassById(Integer.parseInt(ocId));
	     	
	      //create registration object/
	     	
			var reobj = new Registration();
			reobj.setOpenClass(classes);
			reobj.setStudent(student);
			reobj.setPhone(phone);
			reobj.setEmail(email);
			
			//create Session
				session = req.getSession(true);
				session.setAttribute(SESSION_CLASS_ID, ocId);
		
				//save to database
				getBean("registrationModel", RegistrationModel.class).create(reobj);
				
		
		
				// redirect to top page.
				var sendredirect = req.getContextPath().concat(APPEARENCE);
				resp.sendRedirect(sendredirect);
	}
		
		
	}


