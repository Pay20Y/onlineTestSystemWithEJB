package com.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.jpa.Question1;

/**
 * Session Bean implementation class getQuestion
 */
@Stateless
public class getQuestion1 implements getQuestion1Remote {
	@PersistenceContext(unitName = "Ques1JPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getQuestion1() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<String> searchTitle() {
		// TODO Auto-generated method stub
		
		Query query = manager.createQuery("select q1 from Question1 q1");
		List<String> Qtitles = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question1 ques1 = (Question1) iterator.next();
			Qtitles.add(ques1.getQuestion());
		}
		return Qtitles;
	}

	@Override
	public List<String> searchAnswer() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q1 from Question1 q1");
		List<String> Qanswers = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question1 ques1 = (Question1) iterator.next();
			Qanswers.add(ques1.getAnswer());
		}
		return Qanswers;
	}

	@Override
	public List<Integer> searchScore() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q1 from Question1 q1");
		List<Integer> Qscores = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question1 ques1 = (Question1) iterator.next();
			Qscores.add(ques1.getScore());
		}
		return Qscores;
	}

	@Override
	public List<Integer> searchID() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q1 from Question1 q1");
		List<Integer> QIDs = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question1 ques1 = (Question1) iterator.next();
			QIDs.add(ques1.getQuestionID());
		}
		return QIDs;
	}

}
