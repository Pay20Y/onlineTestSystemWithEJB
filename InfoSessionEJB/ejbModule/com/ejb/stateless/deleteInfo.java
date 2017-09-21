package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Info;

/**
 * Session Bean implementation class deleteInfo
 */
@Stateless
public class deleteInfo implements deleteInfoRemote {
	@PersistenceContext(unitName = "InfoJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public deleteInfo() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Info info = manager.find(Info.class, id);
		manager.remove(info);
	}

}
