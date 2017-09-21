package com.ejb.stateless;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Info;

/**
 * Session Bean implementation class postInfo
 */
@Stateless
public class postInfo implements postInfoRemote {
	@PersistenceContext(unitName = "InfoJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public postInfo() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void post(String title, String cont,String date) {
		// TODO Auto-generated method stub
		
		Info info = new Info();
		info.setInfoTitle(title);
		info.setInfoCont(cont);
		info.setInfoDate(date);
		info.setPaperID(-1);
		
		System.out.println("SessionBean 收到的消息是--"+title+"--"+cont+"--"+date);
		manager.persist(info);
	}

}
