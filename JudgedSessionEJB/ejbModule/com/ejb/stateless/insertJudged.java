package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Judged;

/**
 * Session Bean implementation class insertJudged
 */
@Stateless
public class insertJudged implements insertJudgedRemote {
	@PersistenceContext(unitName = "JudgedJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public insertJudged() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(int testid, String title, String answer, int score) {
		// TODO Auto-generated method stub
		Judged judged = new Judged();
		judged.setTestID(testid);
		judged.setTitle(title);
		judged.setAnswer(answer);
		judged.setScore(score);
		manager.persist(judged);
		
	}

}
