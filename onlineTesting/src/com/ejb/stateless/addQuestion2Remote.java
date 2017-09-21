package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface addQuestion2Remote {
	public void insert(String question2);
}
