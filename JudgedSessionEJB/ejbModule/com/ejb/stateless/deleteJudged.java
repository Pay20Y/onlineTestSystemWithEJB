package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Judged;


/**
 * Session Bean implementation class deleteJudged
 */
@Stateless
public class deleteJudged implements deleteJudgedRemote {
	@PersistenceContext(unitName = "JudgedJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public deleteJudged() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void delete(int judgedID) {
		// TODO Auto-generated method stub
		Judged j = manager.find(Judged.class,judgedID);
		manager.remove(j);
	}

}
