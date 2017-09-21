package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Question1;
import com.ejb.jpa.Question2;

/**
 * Session Bean implementation class deleteQuestion1
 */
@Stateless
public class deleteQuestion1 implements deleteQuestion1Remote {
	@PersistenceContext(unitName = "Ques1JPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public deleteQuestion1() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void delete(int quesid) {
		// TODO Auto-generated method stub
		Question1 q1 = manager.find(Question1.class,quesid);
		manager.remove(q1);
	}

}
