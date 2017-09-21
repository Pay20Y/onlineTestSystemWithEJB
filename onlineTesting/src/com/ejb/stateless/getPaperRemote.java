package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getPaperRemote {
	public List<Integer> searchId();
	public List<String> searchTitle();
	public List<String> searchPath();
	public List<Integer> searchtotalScore();
}	
