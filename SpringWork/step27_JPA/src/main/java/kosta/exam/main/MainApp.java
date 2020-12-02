package kosta.exam.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.exam.domain.Customer;

public class MainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//1. 등록
		
		
		/*
		 * em.persist(new Customer(null, "방융징1", 21, "융징마을1", null, null, null, null));
		 * em.persist(new Customer(null, "방융징2", 22, "융징마을2", null, null, null, null));
		 * em.persist(new Customer(null, "방융징3", 23, "융징마을3", null, null, null, null));
		 * em.persist(new Customer(null, "방융징4", 24, "융징마을4", null, null, null, null));
		 * em.persist(new Customer(null, "방융징5", 25, "융징마을5", null, null, null, null));
		 */
		
		
		//2.검색
//		 Customer cu = em.find(Customer.class,3L ); 
//		 System.out.println(cu); 
		 
		 
		 //3. 수정하기
			/*
			 * cu.setAddr("성남시 판교"); cu.setUserName("나영쓰");
			 */
		
		 //4. 삭제하기
//		 em.remove(cu);
//		 System.out.println(cu); 
		 
		 
		 //JPQL
			/*
			 * String sql = "select c from Customer c where c.addr = '융징마을2'";
			 * List<Customer> list = em.createQuery(sql, Customer.class).getResultList();
			 * 
			 * for(Customer c:list) { System.out.println(c); }
			 */
		 
		
		
		 //parameter를 전달
			/*
			 * String sql =
			 * "select c from Customer c where c.addr=:addr or c.userName =:name";
			 * List<Customer> list = em.createQuery(sql, Customer.class)
			 * .setParameter("addr", "융징마을2") .setParameter("name", "1") .getResultList();
			 * 
			 * System.out.println(list);
			 */
		
		
		//파라미터
		String sql = "select c from Customer c where c.addr like '%' || ?1 || '%' or c.userName =?2";
		
		List<Customer> list = 
		em.createQuery(sql, Customer.class)
		.setParameter(1, "을")
		.setParameter(2, "1")
		.getResultList();
		
		System.out.println(list);
		 
		tx.commit();
		em.close();
		emf.close();

	}

}
