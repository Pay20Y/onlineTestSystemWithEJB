package com.ejb.stateful;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Collect;

/**
 * Session Bean implementation class collectPaper
 */
@Stateful
public class collectPaper implements collectPaperRemote {
	@PersistenceContext(unitName = "CollectJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public collectPaper() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(int userID, int paperID) {
		// TODO Auto-generated method stub
		Collect c = new Collect();
		c.setPaperID(paperID);
		c.setUserID(userID);
		manager.persist(c);
	}

	@Override
	public void remove(int collectID) {
		// TODO Auto-generated method stub
		Collect c = manager.find(Collect.class, collectID);
		manager.remove(c);
	}

}
