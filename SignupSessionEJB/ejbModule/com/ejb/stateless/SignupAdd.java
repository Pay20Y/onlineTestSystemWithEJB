package com.ejb.stateless;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.*;
/**
 * Session Bean implementation class SignupAdd
 */
@Stateless
public class SignupAdd implements SignupAddRemote {
	@PersistenceContext(unitName = "UserJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public SignupAdd() {
        // TODO Auto-generated constructor stub
    }
	
	public void insert(String userInfo) {
		// TODO Auto-generated method stub
		String[] userinfo = userInfo.split("\t");
		User user = new User();
		user.setUserName(userinfo[0]);
		user.setUserPwd(userinfo[1]);
		user.setUserPhone(userinfo[2]);
		user.setSecurity(userinfo[3]);
		user.setAnswer(userinfo[4]);
		
		manager.persist(user);
	}
/*
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("hahaha success!");
	}
*/
}
