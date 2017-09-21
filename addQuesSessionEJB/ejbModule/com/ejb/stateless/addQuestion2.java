package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.ejb.jpa.Question2;


/**
 * Session Bean implementation class addQuestion2
 */
@Stateless
public class addQuestion2 implements addQuestion2Remote {
	@PersistenceContext(unitName = "Ques2JPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public addQuestion2() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(String question2) {
		// TODO Auto-generated method stub
		String[] question = question2.split("\t");
		String questionTitle = question[0];
		String item1 = question[1];
		String item2 = question[2];
		String item3 = question[3];
		String item4 = question[4];
		String answer = question[5];
		int score = Integer.valueOf(question[6]);
		Question2 q2 = new Question2();
		q2.setQuestion(questionTitle);
		q2.setItem1(item1);
		q2.setItem2(item2);
		q2.setItem3(item3);
		q2.setItem4(item4);
		q2.setAnswer(answer);
		q2.setScore(score);
		
		manager.persist(q2);
	}

}
