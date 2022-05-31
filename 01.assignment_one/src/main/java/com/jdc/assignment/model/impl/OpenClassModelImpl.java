package com.jdc.assignment.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assignment.domain.Course;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.model.OpenClassModel;

public class OpenClassModelImpl implements OpenClassModel{
	
	private static final String SELECT_SQL = """
			select  oc.id , oc.start_date, oc.teacher , 
			c.id courseId, c.name , c.duration,c.fees , c.description 
			from open_class oc  
			join course c on oc.course_id = c.id 
			where c.id=?	
			""";
	private static final String INSERT_OC = "insert into open_class (course_id, start_date, teacher) values (?,?,?)";
	private static final String SELECT_ONE = "select * from open_class where id=?";
	
	private DataSource dataSource;
	
	
	public OpenClassModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<OpenClass> findbyCourse(int courseId) {
		 var list = new ArrayList<OpenClass>(); 
		
		 try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_SQL)){
			 
			 stmt.setInt(1, courseId);
			 
			 var rs = stmt.executeQuery();
			 
			 while(rs.next()) {
				 
				var c = new Course();
				
				c.setId(rs.getInt("courseId"));
				c.setName(rs.getString("name"));
				c.setFees(rs.getInt("fees"));
				c.setDuration(rs.getInt("duration"));
				c.setDescription(rs.getString("description"));
				
				
					var oc = new OpenClass();
				
					oc.setCourse(c);
					oc.setTeacher(rs.getString("teacher"));
					oc.setId(rs.getInt("id"));
					oc.setStartDate(rs.getDate("start_date").toLocalDate());
					
					list.add(oc);
			 }
			 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void create(OpenClass openClass) {
		try(var conn = dataSource.getConnection()){
			var stmt = conn.prepareStatement(INSERT_OC);
			
			stmt.setInt(1, openClass.getCourse().getId());
			stmt.setString(2, openClass.getStartDate().toString());
			stmt.setString(3, openClass.getTeacher());
			
			stmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public OpenClass findClassById(int id) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_ONE) ){
			 
			 stmt.setInt(1, id);
			 
			 var result = stmt.executeQuery();
			 
			 while(result.next()) {
				 var course = new Course();
				
				 	course.setId(result.getInt("course_id"));
				 	
					
					
					var openClass = new OpenClass();
					 
					 openClass.setId(result.getInt("id"));
					 openClass.setCourse(course);
					 openClass.setStartDate(result.getDate("start_date").toLocalDate());
					 openClass.setTeacher(result.getString("teacher"));
					
					return openClass;
			 }
			 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		
	}

	



}
