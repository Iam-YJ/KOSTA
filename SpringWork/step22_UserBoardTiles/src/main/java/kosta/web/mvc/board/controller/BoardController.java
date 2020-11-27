package kosta.web.mvc.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.board.dto.ElectronicsDTO;
import kosta.web.mvc.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	private final String savePath = "C:\\Edu\\fileSave";

	/**
	 * 보드 리스트 보여주기
	 */
	@RequestMapping("/list")
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView();
		List<ElectronicsDTO> list = boardService.selectAll();
		mv.setViewName("board/list");
		mv.addObject("list", list);

		return mv;
	}

	/**
	 * 제품 등록 폼 보여주기
	 */
	@RequestMapping("/write")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/write");
		return mv;
	}

	/**
	 * 제품 등록하기
	 */
	@RequestMapping("/writeForm")
	public String insert(ElectronicsDTO electronics, HttpSession session) throws IOException {

		// 파일이 첨부되었다면 저장
		MultipartFile file = electronics.getFile();
		if (file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			long fileSize = file.getSize();

			electronics.setFname(fileName);
			electronics.setFsize(fileSize);

			file.transferTo(new File(savePath + "/" + fileName));
		}

		int result = boardService.insert(electronics);

		return "redirect:/board/list";
	}

	/**
	 * 제품 상세정보 보기 - 조회수 증가해야함
	 */
	@RequestMapping("/selectByNo/{modelNum}")
	public ModelAndView selectByModelNum(@PathVariable("modelNum") String modelNum, boolean state) {
		ElectronicsDTO elec = boardService.selectByModelNum(modelNum, true);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/read");
		mv.addObject("elec", elec);

		return mv;
	}

	/**
	 * 수정하기 - 조회수 증가하면 안됨
	 */
	@RequestMapping("/updateForm")
	public ModelAndView update() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("board/update");
		return mv;
	}

	/**
	 * 삭제하기
	 */
	// delete 할 때 (modelNum, password, savePath);

	/**
	 * 다운로드하기
	 */
	@RequestMapping("/down")
	public ModelAndView down(HttpSession session, String fname) {
		return new ModelAndView("downLoadView","fname",new File(savePath+"/"+fname));

	}
}
