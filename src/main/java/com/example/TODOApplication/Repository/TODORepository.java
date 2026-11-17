package com.example.TODOApplication.Repository;

import org.springframework.stereotype.Repository;

import com.example.TODOApplication.Entity.Todo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public class TODORepository {
	
	// EntityManager = a tool for interacting with the database.
	// @PersistenceContext = tells Spring to provide an EntityManager.
	// EntityManager is an interface provided by JPA that manages the interaction between Entity objects and the database.
	
    @PersistenceContext
	private EntityManager entityManager; 
  
    
    // Indicates that this method runs within a database transaction.
    @Transactional
    public void save(Todo todo) {
    	
    		entityManager.persist(todo); //  schedules the todo object for insertion into the database.
    		
    }

}
