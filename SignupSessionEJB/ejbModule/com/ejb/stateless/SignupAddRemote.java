package com.ejb.stateless;

import javax.ejb.Remote;
import com.ejb.jpa.*;
@Remote
public interface SignupAddRemote {
	public void insert(String userInfo);
	//public void insert();
}
