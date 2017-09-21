package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface updateTestRemote {
	public void update(int testID,int grade,int judged);
}
