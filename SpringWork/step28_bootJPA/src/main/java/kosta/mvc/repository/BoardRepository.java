package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{ //관리해야할 것, 관리해야할 것의 데이터 타입

	/**
	 * JPQL 문법으로 쿼리를 작성한다 (객체(Entity) 중심으로 쿼리작성)
	 * 전달받은 글번호 보다 큰 레코드 삭제하기
	 */
	@Query("delete from Board b where b.bno > ?1")
	@Modifying
	void deleteGreateThanId(Long id);
	
	/**
	 * 검색(글번호 or 제목)
	 */
	@Query("select b from Board b where b.bno >= ?1 or b.title =?2")
	List<Board> searchSelect(Long bno, String title);
	
	/**
	 * 메소드 기반의 쿼리 - 교재 89p
	 * : findXxx - select 전용(좀 더 조건을 다양하게 처리해야함)
	 */
	List<Board> findByBnoLessThan(Long bno);
	
	
}
