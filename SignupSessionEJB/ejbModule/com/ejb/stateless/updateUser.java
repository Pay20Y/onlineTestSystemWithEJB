package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ejb.jpa.*;
/**
 * Session Bean implementation class updateUser
 */
@Stateless
public class updateUser implements updateUserRemote {
	@PersistenceContext(unitName = "UserJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public updateUser() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void updatePwd(int id,String password) {
		// TODO Auto-generated method stub
		User user = manager.find(User.class, id);
		user.setUserPwd(password);
		manager.merge(user);
	}

	@Override
	public void updatePhone(int id,String phone) {
		// TODO Auto-generated method stub
		User user = manager.find(User.class, id);
		user.setUserPhone(phone);
		manager.merge(user);
	}

	@Override
	public void updateSecurity(int id,String security) {
		// TODO Auto-generated method stub
		User user = manager.find(User.class, id);
		user.setSecurity(security);
		manager.merge(user);
	}

	@Override
	public void updateAnswer(int id,String answer) {
		// TODO Auto-generated method stub
		User user = manager.find(User.class, id);
		user.setAnswer(answer);
		manager.merge(user);
	}

}
