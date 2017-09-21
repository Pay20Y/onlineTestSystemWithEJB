package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getTestRemote {
	public List<Integer> searchPaperID(int id);
	public List<Integer> searchScore(int id);
	//public List<String> searchScoreByTest(int testid);
}
