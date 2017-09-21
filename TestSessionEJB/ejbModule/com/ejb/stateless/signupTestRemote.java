package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface signupTestRemote {
	public void signup(String testinfo);
}
