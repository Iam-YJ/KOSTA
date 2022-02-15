package kosta.mvc;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;

import kosta.mvc.domain.Board;
import kosta.mvc.repository.BoardRepository;

@SpringBootTest
@Transactional
@Commit
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository rep;
	
	/**
	 * 등록하기
	 */
	@Test
	public void insert() {
		
		for(int i=0; i<=200; i++ ) {
			rep.save(new Board(null, "제목"+i,"user"+i,"springJPA"+i, null));
			
		}
	}
	
	/**
	 * 전체검색
	 */
	@Test
	public void select() {
		List<Board> list = rep.findAll();
		/*
		 * for(Board b : list) { System.out.println(b); }
		 */
		
		list.forEach(b->System.out.println(b));
	}
	
	/**
	 * 조건검색(pk대상)
	 */
	@Test
	public void selectByno() {
		// Optional은 null 여부를 체크하지 않아도 되도록.. 관련 메소드 제공
		// 자주 발생하는 NullPointException 떄문에 만들어진 문법 
		// 만약에 검색하는 값이 없으면 이것을 대체할 null을 넣으려고 만듦
		Optional<Board> op = rep.findById(202L);
		Board board = op.orElse(null);
		System.out.println(board);
	}
	
	/**
	 * 삭제하기
	 */
	@Test
	public void delete() {
		rep.deleteById(4L);
		
	}
	
	/**
	 * 수정하기
	 */
	@Test
	public void update() {
		Board board = rep.findById(3L).orElse(null);
		board.setContent("수정되나?");
		board.setTitle("불금이다요");
	}
	
	/**
	 * 전달 받은 글번호 이상인 레코드 삭제
	 */
	@Test
	public void delete2() {
		rep.deleteGreateThanId(150L);
	}
	
	@Test
	public void searchSelect() {
		List<Board> list = rep.searchSelect(130L, "제목12");
		list.forEach(b->System.out.println(b));
	}
	
	/**
	 * 메소드 기반 쿼리
	 */
	@Test
	public void findByQuery() {
		List<Board> list = rep.findByBnoLessThan(50L);
		list.forEach(b->System.out.println(b));
	}
	
	/**
	 * 페이징 처리
	 */
	@Test
	public void page() {
		Pageable page = PageRequest.of(1, 10, Direction.DESC, "bno");
		Page<Board> pageList = rep.findAll(page);
		pageList.getContent().forEach(b->System.out.println(b));
		
		System.out.println("**********************");
		System.out.println("pageList.getNumber() : "+ pageList.getNumber());
		System.out.println("pageList.getSize() : "+ pageList.getSize());
		System.out.println("pageList.getTotalPages() : "+ pageList.getTotalPages());
		System.out.println("pageList.previousOrFirstPageable() : "+ pageList.previousOrFirstPageable());
		System.out.println("pageList.nextPageable() : "+ pageList.nextPageable());
		
		System.out.println("**********************");
	}

}
