package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface deletePaperRemote {
	public void delete(int paperid);
}
