package com.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.jpa.Paper;

/**
 * Session Bean implementation class addPaper
 */
@Stateless
public class addPaper implements addPaperRemote {
	@PersistenceContext(unitName = "PaperJPA")
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public addPaper() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(String paperName, String paperPath, int score) {
		// TODO Auto-generated method stub
		Paper paper = new Paper();
		paper.setPaperName(paperName);
		paper.setPaperPath(paperPath);
		paper.setTotalScore(score);
		
		manager.persist(paper);
	}

}
