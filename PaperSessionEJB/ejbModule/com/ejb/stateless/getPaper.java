package com.ejb.stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.ejb.jpa.Paper;

@Stateless
public class getPaper implements getPaperRemote {
	@PersistenceContext(unitName = "PaperJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getPaper() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<String> searchTitle() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select p from Paper p");
		List<String> papernames = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Paper paper = (Paper) iterator.next();
			papernames.add(paper.getPaperName());
		}
		return papernames;
	}

	@Override
	public List<String> searchPath() {
		Query query = manager.createQuery("select p from Paper p");
		List<String> paths = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Paper paper = (Paper) iterator.next();
			paths.add(paper.getPaperPath());
		}
		return paths;
	}

	@Override
	public List<Integer> searchtotalScore() {
		Query query = manager.createQuery("select p from Paper p");
		List<Integer> scores = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Paper paper = (Paper) iterator.next();
			scores.add(paper.getTotalScore());
		}
		return scores;
	}

	@Override
	public List<Integer> searchId() {
		Query query = manager.createQuery("select p from Paper p");
		List<Integer> ids = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Paper paper = (Paper) iterator.next();
			ids.add(paper.getPaperID());
		}
		return ids;
	}

}
