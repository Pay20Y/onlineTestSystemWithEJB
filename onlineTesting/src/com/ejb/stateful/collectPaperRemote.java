package com.ejb.stateful;

import javax.ejb.Remote;

@Remote
public interface collectPaperRemote {
	public void insert(int userID,int paperID);
	public void remove(int collectID);
}
