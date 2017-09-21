package com.ejb.stateless;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface postInfoRemote {
	public void post(String title,String cont,String date);
}
