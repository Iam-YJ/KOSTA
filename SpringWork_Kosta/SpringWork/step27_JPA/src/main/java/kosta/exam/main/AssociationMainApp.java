package kosta.exam.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.exam.domain.Team;

public class AssociationMainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
	
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 1. Team 등록
		/*
		 * Team t1 = new Team(null, "teamA"); Team t2 = new Team(null, "teamB");
		 * 
		 * 
		 * em.persist(t1); em.persist(t2);
		 */
		
		// 2. Member 등록
		/*
		 * em.persist(new Member(null, "희정", 25, t1)); em.persist(new Member(null, "나영",
		 * 28, t1));
		 * 
		 * em.persist(new Member(null, "효리", 22, t2)); em.persist(new Member(null, "재석",
		 * 23, t2)); em.persist(new Member(null, "수영", 21, t2));
		 */
		
		
		//검색하기 - 회원 정보를 검색
		/*
		 * Member member = em.find(Member.class, 3L); System.out.println(member);
		 */
		
		//검색 - 팀정보 검색
		Team team = em.find(Team.class, 2L);
		System.out.println(team);
		
		
		tx.commit();
		em.close();
		emf.close();
		
		
	}

}
