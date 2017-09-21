package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Test;

/**
 * Session Bean implementation class signupTest
 */
@Stateless
public class signupTest implements signupTestRemote {
	@PersistenceContext(unitName = "TestJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public signupTest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void signup(String testinfo) {
		// TODO Auto-generated method stub
		String[] test_info = testinfo.split("\t");
		Test test = new Test();
		
		int userID = Integer.valueOf(test_info[0]);
		int paperID = Integer.valueOf(test_info[1]);
		int score = Integer.valueOf(-1);
		
		test.setUserID(userID);
		test.setPaperID(paperID);
		test.setScore(score);
		test.setJudged(-1);
		manager.persist(test);
	}

}
