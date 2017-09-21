package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface deleteJudgedRemote {
	public void delete(int judgedID);
}
