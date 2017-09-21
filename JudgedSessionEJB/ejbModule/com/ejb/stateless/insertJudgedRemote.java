package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface insertJudgedRemote {
	public void insert(int testid,String title,String answer,int score);
}
