package com.ejb.stateless;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface getUnjudgedRemote {
	public List<Integer> get();
}
