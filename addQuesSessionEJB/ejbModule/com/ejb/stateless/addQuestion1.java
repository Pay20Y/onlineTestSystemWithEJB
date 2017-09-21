package com.ejb.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.*;

/**
 * Session Bean implementation class addQuestion1
 */
@Stateless
public class addQuestion1 implements addQuestion1Remote {
	@PersistenceContext(unitName = "Ques1JPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public addQuestion1() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(String question1) {
		// TODO Auto-generated method stub
		String[] question = question1.split("\t");
		String questionTitle = question[0];
		String answer = question[1];
		int score = Integer.valueOf(question[2]);
		Question1 q1 = new Question1();
		q1.setQuestion(questionTitle);
		q1.setAnswer(answer);
		q1.setScore(score);
		
		manager.persist(q1);
	}


}
