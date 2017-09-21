package com.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.jpa.Question1;
import com.ejb.jpa.Question2;

/**
 * Session Bean implementation class getQuestion2
 */
@Stateless
public class getQuestion2 implements getQuestion2Remote {
	@PersistenceContext(unitName = "Ques2JPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getQuestion2() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<String> searchTitle() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<String> Qtitles = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Qtitles.add(ques2.getQuestion());
		}
		return Qtitles;
	}

	@Override
	public List<String> searchItem1() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<String> Item1s = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Item1s.add(ques2.getItem1());
		}
		return Item1s;
	}

	@Override
	public List<String> searchItem2() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<String> Item2s = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Item2s.add(ques2.getItem2());
		}
		return Item2s;
	}

	@Override
	public List<String> searchItem3() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<String> Item3s = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Item3s.add(ques2.getItem3());
		}
		return Item3s;
	}

	@Override
	public List<String> searchItem4() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<String> Item4s = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Item4s.add(ques2.getItem4());
		}
		return Item4s;
	}

	@Override
	public List<String> searchAnswer() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<String> Qanswers = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Qanswers.add(ques2.getAnswer());
		}
		return Qanswers;
	}

	@Override
	public List<Integer> searchScore() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<Integer> Qscores = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			Qscores.add(ques2.getScore());
		}
		return Qscores;
	}

	@Override
	public List<Integer> searchID() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select q2 from Question2 q2");
		List<Integer> QIDs = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Question2 ques2 = (Question2) iterator.next();
			QIDs.add(ques2.getQuestionID());
		}
		return QIDs;
	}

}
