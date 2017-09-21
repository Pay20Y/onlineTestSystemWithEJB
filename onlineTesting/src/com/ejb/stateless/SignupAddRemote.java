package com.ejb.stateless;

import javax.ejb.Remote;
@Remote
public interface SignupAddRemote {
	public void insert(String userInfo);
	//public void insert();
}
