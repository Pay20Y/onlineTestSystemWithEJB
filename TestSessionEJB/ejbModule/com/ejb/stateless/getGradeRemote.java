package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface getGradeRemote {
	public int getGrade(int testid);
}
