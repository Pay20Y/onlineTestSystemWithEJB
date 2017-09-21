package com.ejb.stateless;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.jpa.Info;

/**
 * Session Bean implementation class getInfo
 */
@Stateless
public class getInfo implements getInfoRemote {
	@PersistenceContext(unitName = "InfoJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
	
    public getInfo() {
        // TODO Auto-generated constructor stub
    }
	@SuppressWarnings("rawtypes")
	@Override
	public List<String> searchTitle() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select i from Info i");
		List<String> titles = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Info info = (Info) iterator.next();
			titles.add(info.getInfoTitle());
		}
		/*
		if(iterator.hasNext()){
			Info info = (Info) iterator.next();
			title = info.getInfoTitle();
		}*/
		return titles;
	}
	@Override
	public List<String> searchDate() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select i from Info i");
		List<String> dates = new ArrayList<String>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Info info = (Info) iterator.next();
			dates.add(info.getInfoDate());
		}
		return dates;
	}
	@Override
	public List<Integer> searchId() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select i from Info i");
		List<Integer> Ids = new ArrayList<Integer>();
		List results = query.getResultList();
		Iterator iterator = results.iterator();
		
		while(iterator.hasNext()) {
			//strings.add(iterator.next().toString());
			Info info = (Info) iterator.next();
			Ids.add(info.getInfoID());
		}
		return Ids;
	}

}
