package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface addQuestion1Remote {
	public void insert(String question1);
	//public void sayOK();
}
