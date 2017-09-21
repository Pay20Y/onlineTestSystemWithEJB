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
 * Session Bean implementation class getGrade
 */
@Stateless
public class getGrade implements getGradeRemote {
	@PersistenceContext(unitName = "TestJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public getGrade() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int getGrade(int testid) {
		Query query = manager.createQuery("select t from Test t where t.testID="+testid);
		Test test = manager.find(Test.class, testid);
		return test.getScore();
	}

}
