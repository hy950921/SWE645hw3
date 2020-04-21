package com.hw3.com.Jersey_JPA_hibernate_backend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


//This class is responsible for working with database using mysql
//Entity manager and transactions are being used to persist the data
public class StudentResource {

	private final String PEERSISTANCE_UNIT_NAME = "persisunit";
	private EntityManagerFactory factory= Persistence.createEntityManagerFactory(PEERSISTANCE_UNIT_NAME);
		
	
	//methos for adding a student to the database
	public void addingstudent(Student s) {
		//creating a entity manager inside the addstudent
		EntityManager em = factory.createEntityManager();
		//creating a transaction
		EntityTransaction etrans= null;
		try {
			etrans= em.getTransaction();
			etrans.begin();
			em.persist(s);
			etrans.commit();
		    }
		catch (Exception e) {
			System.out.println("catched an exception");
			etrans.rollback();
			e.printStackTrace();	
		}
		finally {
			em.close();
		}
		
	}
	
	//for getting all the records from the database
	public List<Student> allstudentrecords() {
		EntityManager em =factory.createEntityManager();
		String all= "select e from Student e";
		TypedQuery<Student> tq = 	em.createQuery(all, Student.class);
		List<Student> sall = tq.getResultList();
		return sall;	
	}
}
