package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Test;

/**
 * Session Bean implementation class updateTest
 */
@Stateless
public class updateTest implements updateTestRemote {
	@PersistenceContext(unitName = "TestJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public updateTest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void update(int testID,int grade,int judged) {
		// TODO Auto-generated method stub
		Test test = manager.find(Test.class, testID);
		test.setScore(grade);
		test.setJudged(judged);
		manager.merge(test);
	}

}
