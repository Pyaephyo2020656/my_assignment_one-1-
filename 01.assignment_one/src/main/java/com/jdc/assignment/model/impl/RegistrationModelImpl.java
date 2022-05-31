package com.jdc.assignment.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel {

	private static final String SELECT_SQL = """
			select  re.id, re.student, re.phone, re.email, oc.id openClassId, oc.start_date,oc.teacher 
			 from registration re 
			 join open_class oc on re.open_class_id = oc.id where oc.id=?
			 """;
	private static final String INSERT_RE = "insert into registration (open_class_id, student, phone,email) values (?,?,?,?)";
	private DataSource dataSource;

	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findbyClass(int classId) {
		var list = new ArrayList<Registration>(); 
		
		 try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_SQL)){
			 
			 stmt.setInt(1, classId);
			 
			 var rs = stmt.executeQuery();
			 
			 while(rs.next()) {
				 
				var oc = new OpenClass();
				oc.setId(rs.getInt("openClassId"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());
				oc.setTeacher(rs.getString("teacher"));
				
				
				var re = new Registration();
				re.setOpenClass(oc);
				re.setId(rs.getInt("id"));
				re.setEmail(rs.getString("email"));
				re.setPhone(rs.getString("phone"));
				re.setStudent(rs.getString("student"));
				
				list.add(re);
				
			 }
			 
		 } catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	
	}

	@Override
	public void create(Registration registration) {
		try(var conn = dataSource.getConnection()){
			
			 var stmt = conn.prepareStatement(INSERT_RE);
			
			
			stmt.setInt(1, registration.getOpenClass().getId());
			stmt.setString(2, registration.getStudent());
			stmt.setString(3, registration.getPhone());
			stmt.setString(4, registration.getEmail());
			
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

}
