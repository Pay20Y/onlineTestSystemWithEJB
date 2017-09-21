package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Paper;

/**
 * Session Bean implementation class deletePaper
 */
@Stateless
public class deletePaper implements deletePaperRemote {
	@PersistenceContext(unitName = "PaperJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public deletePaper() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void delete(int paperid) {
		// TODO Auto-generated method stub
		Paper p = manager.find(Paper.class,paperid);
		manager.remove(p);
	}

}
