package com.hw3.com.Jersey_JPA_hibernate_backend;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/students")
public class StudentController {

	
	@GET
	@Path("/all")
	//@Produces("application/json")
	@Produces({"application/xml", "application/json"})
	//@Produces({MediaType.APPLICATION_JSON})
	
	public List<Student> getstudents(){
		StudentResource sr = new StudentResource();
		//calling the resources method for getting all the list of students
		List<Student> s = sr.allstudentrecords();
		return s;
	}
	
	@POST
	@Path("/create")
	@Consumes("application/json")
	public void addStudent(Student s) {
		//Adding the student to records
		StudentResource sr = new StudentResource();
		sr.addingstudent(s);
		
	}
	
}
