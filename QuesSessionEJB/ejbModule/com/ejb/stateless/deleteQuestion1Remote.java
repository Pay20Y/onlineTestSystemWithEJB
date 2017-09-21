package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface deleteQuestion1Remote {
	public void delete(int quesid);
}
