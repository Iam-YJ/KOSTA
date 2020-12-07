package kosta.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.domain.Reply;
import kosta.mvc.service.ReplyService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService service;
	
	/**
	 * 등록폼 
	 */
	@RequestMapping("/writeForm")
	public String writeForm(Long bno, Model model) {//부모글의 글번호
		model.addAttribute("bno",bno);
		
		
		return "reply/write";
	}
	
	/**
	 * 등록하기
	 */
	@RequestMapping("/insert")
	public String insert(Reply reply, Long bno) {
		FreeBoard freeBoard = new FreeBoard(bno);
		reply.setFreeBoard(freeBoard);
		service.insert(reply);
		
		return "redirect:/board/read/"+bno+"?state=1";
	}
	
	/**
	 * 댓글 삭제
	 */
	@RequestMapping("/delete/{id}/{bno}")
	public String delete(@PathVariable Long id,@PathVariable Long bno) { // ?id=3&bno=4 는 (Long id, Long bno) 했을 때
		service.delete(id);
		
		return "redirect:/board/read/"+bno+"?state=1";
	}
}
