package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface deleteInfoRemote {
	public void delete(int id);
}
