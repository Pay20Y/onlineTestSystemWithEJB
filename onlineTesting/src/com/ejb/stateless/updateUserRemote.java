package com.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface updateUserRemote {
	public void updatePwd(int id,String password);
	public void updatePhone(int id,String phone);
	public void updateSecurity(int id,String security);
	public void updateAnswer(int id,String answer);
}
