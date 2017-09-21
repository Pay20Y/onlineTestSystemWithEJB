package com.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.jpa.Judged;

/**
 * Session Bean implementation class getJudged
 */
@Stateless
public class getJudged implements getJudgedRemote {
	@PersistenceContext(unitName = "JudgedJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getJudged() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Integer> getTestID() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select j from Judged j");
		List<Integer> ids = new ArrayList();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Judged judged = (Judged) iterator.next();
			ids.add(judged.getTestID());
		}
		return ids;
	}

	@Override
	public List<String> getTitle() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select j from Judged j");
		List<String> titles = new ArrayList();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Judged judged = (Judged) iterator.next();
			titles.add(judged.getTitle());
		}
		return titles;
	}

	@Override
	public List<String> getAnswer() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select j from Judged j");
		List<String> answers = new ArrayList();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Judged judged = (Judged) iterator.next();
			answers.add(judged.getAnswer());
		}
		return answers;
	}

	@Override
	public List<Integer> getScore() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select j from Judged j");
		List<Integer> scores = new ArrayList();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Judged judged = (Judged) iterator.next();
			scores.add(judged.getScore());
		}
		return scores;
	}

	@Override
	public List<Integer> getJudgedID() {
		Query query = manager.createQuery("select j from Judged j");
		List<Integer> jids = new ArrayList();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Judged judged = (Judged) iterator.next();
			jids.add(judged.getJudgedID());
		}
		return jids;
	}

}
