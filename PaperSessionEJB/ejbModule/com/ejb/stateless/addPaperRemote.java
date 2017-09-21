package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface addPaperRemote {
	public void insert(String paperName,String paperPath,int score);
}
