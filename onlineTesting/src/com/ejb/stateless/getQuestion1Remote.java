package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getQuestion1Remote {
	public List<Integer> searchID();
	public List<String> searchTitle();
	public List<String>	searchAnswer();
	public List<Integer> searchScore();
}
