package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.*;
/**
 * Session Bean implementation class deleteQuesion2
 */
@Stateless
public class deleteQuestion2 implements deleteQuestion2Remote {
	@PersistenceContext(unitName = "Ques2JPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public deleteQuestion2() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void delete(int quesid) {
		// TODO Auto-generated method stub
		Question2 q2 = manager.find(Question2.class,quesid);
		manager.remove(q2);
	}

}
