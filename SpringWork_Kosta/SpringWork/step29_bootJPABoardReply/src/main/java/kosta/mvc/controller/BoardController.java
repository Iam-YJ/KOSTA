package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.service.FreeBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private FreeBoardService service;
	
	
	/**
	 * 전체검색
	 */
	@RequestMapping("/list")
	public void selectAll(Model model,@RequestParam(defaultValue = "0") int nowPage){
		/* List<FreeBoard> list = service.selectAll();
		model.addAttribute("list", list); */
		
		//page 처리
		Pageable pageable = PageRequest.of(nowPage, 10, Direction.DESC, "bno");
		Page<FreeBoard> pageList = service.selectAll(pageable);
		pageList.getTotalPages();
		
		model.addAttribute("pageList",pageList);
		
	}
	
	/**
	 * 상세보기
	 */
	@RequestMapping("/read/{bno}")
	public ModelAndView read(@PathVariable Long bno, String state) {
		boolean b = state ==null ? true : false;
		FreeBoard board = service.selectBy(bno, b);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/read");
		mv.addObject("board", board);
		
		return mv;
		
	}


	/**
	 * 수정 폼
	 */
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(Long bno) {
		FreeBoard board = service.selectBy(bno, false);
		return new ModelAndView("board/update","board",board);
	}
	
	/**
	 * 수정완료하기
	 */
	@RequestMapping("/update")
	public String update(FreeBoard board) {
		service.update(board);
		
		return "redirect:/board/read/"+board.getBno()+"?state=1";
		
	}
	
	
	/**
	 * 삭제하기
	 */
	@RequestMapping("/delete")
	public String delete(Long bno, String password) {
		service.delete(bno,password);
		return "redirect:/board/list";
	}
	
	/**
	 * 등록하기 폼 띄우기
	 */
	@RequestMapping("/write")
	public void wirte() {
		
	}
	
	/**
	 * 등록완료
	 */
	@RequestMapping("/insert")
	public String insert(FreeBoard board) {
		
		//content에 스크립트 요소(태그)를 문자로 교체
		String content = board.getContent().replace("<", "&lt;");
		board.setContent(content);
		
		service.insert(board);
		return "redirect:/board/list";
	}
	
	
	
	/**
	 * 예외처리
	 */
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		return new ModelAndView("error/errorView", "errMsg", e.getMessage());
	}

}
