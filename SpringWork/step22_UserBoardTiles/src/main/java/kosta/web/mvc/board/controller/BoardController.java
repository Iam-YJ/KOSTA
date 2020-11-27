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
	 * ���� ����Ʈ �����ֱ�
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
	 * ��ǰ ��� �� �����ֱ�
	 */
	@RequestMapping("/write")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/write");
		return mv;
	}

	/**
	 * ��ǰ ����ϱ�
	 */
	@RequestMapping("/writeForm")
	public String insert(ElectronicsDTO electronics, HttpSession session) throws IOException {

		// ������ ÷�εǾ��ٸ� ����
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
	 * ��ǰ ������ ���� - ��ȸ�� �����ؾ���
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
	 * �����ϱ� - ��ȸ�� �����ϸ� �ȵ�
	 */
	@RequestMapping("/updateForm")
	public ModelAndView update() {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("board/update");
		return mv;
	}

	/**
	 * �����ϱ�
	 */
	// delete �� �� (modelNum, password, savePath);

	/**
	 * �ٿ�ε��ϱ�
	 */
	@RequestMapping("/down")
	public ModelAndView down(HttpSession session, String fname) {
		return new ModelAndView("downLoadView","fname",new File(savePath+"/"+fname));

	}
}
