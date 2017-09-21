package com.ejb.stateless;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getInfoRemote {
	public List<String> searchTitle();
	public List<String> searchDate();
	public List<Integer> searchId();
}
