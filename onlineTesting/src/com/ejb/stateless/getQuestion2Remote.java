package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getQuestion2Remote {
	public List<Integer> searchID();
	public List<String> searchTitle();
	public List<String> searchItem1();
	public List<String> searchItem2();
	public List<String> searchItem3();
	public List<String> searchItem4();
	public List<String>	searchAnswer();
	public List<Integer> searchScore();
}
