package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface deleteQuestion2Remote {
	public void delete(int quesid);
}
