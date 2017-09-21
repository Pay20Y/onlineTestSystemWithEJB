package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getJudgedRemote {
	public List<Integer> getJudgedID();
	public List<Integer> getTestID();
	public List<String> getTitle();
	public List<String> getAnswer();
	public List<Integer> getScore();
}
