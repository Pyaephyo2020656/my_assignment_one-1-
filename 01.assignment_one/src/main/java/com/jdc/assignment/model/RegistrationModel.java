package com.jdc.assignment.model;

import java.util.List;

import com.jdc.assignment.domain.Registration;

public interface RegistrationModel {
	
	List<Registration> findbyClass(int classId);
	 
	 void create(Registration registration);

}
