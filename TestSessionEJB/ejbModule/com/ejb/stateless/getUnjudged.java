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
 * Session Bean implementation class getUnjudged
 */
@Stateless
public class getUnjudged implements getUnjudgedRemote {
	@PersistenceContext(unitName = "TestJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getUnjudged() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Integer> get() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select t from Test t where t.judged="+0);
		List<Integer> testIds = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Test test = (Test) iterator.next();
			testIds.add(test.getTestID());
		}
		return testIds;
	}

}
