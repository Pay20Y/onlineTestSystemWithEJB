package com.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.jpa.Test;

/**
 * Session Bean implementation class getTest
 */
@Stateless
public class getTest implements getTestRemote {
	@PersistenceContext(unitName = "TestJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getTest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Integer> searchPaperID(int id) {
		Query query = manager.createQuery("select t from Test t where t.userID="+id);
		List<Integer> paperIds = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Test test = (Test) iterator.next();
			paperIds.add(test.getPaperID());
		}
		return paperIds;
	}

	@Override
	public List<Integer> searchScore(int id) {
		Query query = manager.createQuery("select t from Test t where t.userID="+id);
		List<Integer> scores = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Test test = (Test) iterator.next();
			scores.add(test.getScore());
		}
		return scores;
	}

}
