package com.jdc.assignment.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.model.CourseModel;
import com.jdc.assignment.model.OpenClassModel;

@WebServlet(urlPatterns = {
	"/classes",
	"/class-edit"
		
})
public class OpenClassServlet extends AbstractBeanFactoryServlet{

	private static final long serialVersionUID = 1L;
	
	private static final String APPEARENCE = "/classes";

	private static final String SESSION_COURSE_ID = "session.course.id";


	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
		var courseId = req.getParameter("courseId");
		
		//Find Course
		
		//if course from request object is null , get it from Session Scope
		
		if(null == courseId) {
			HttpSession session = req.getSession();
			courseId = (String) session.getAttribute(SESSION_COURSE_ID);
		}
		
		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId));
		
		req.setAttribute("course", course);
		
		var page = switch(req.getServletPath()) {
		case APPEARENCE ->{
			
		 var model =getBean("openClassModel", OpenClassModel.class );
		 var openClassList = model.findbyCourse(Integer.parseInt(courseId));
		 req.setAttribute("classes", openClassList);
		   
		    
		   
			yield "classes";
		}
		 default  -> "class-edit";
		};
		
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession session = null;
		//get request parameter
		
			var courseId = req.getParameter("course_id");
	     var startdate = req.getParameter("start_date");
	     var teacher = req.getParameter("teacher");
		
	     	//get course object from spring.	     	
	     	var courseModel = getBean("courseModel", CourseModel.class);
	     	//use course with findbyId method
	     	var course = courseModel.findById(Integer.parseInt(courseId));
	     
			//create openclass ojbect
			var openClass = new OpenClass();
			openClass.setCourse(course);
			openClass.setStartDate(LocalDate.parse(startdate));
			openClass.setTeacher(teacher);
			
		//create Session
			session = req.getSession(true);
			session.setAttribute(SESSION_COURSE_ID, courseId);
		
		//save to database
			getBean("openClassModel",OpenClassModel.class).create(openClass);
		
		// redirect to top page.
			var sendredirect = req.getContextPath().concat(APPEARENCE);
			resp.sendRedirect(sendredirect);
	}

}
