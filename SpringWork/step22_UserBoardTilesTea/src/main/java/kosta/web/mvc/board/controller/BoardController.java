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
	
	private final String savePath="C:\\Edu\\Spring\\fileSave";
	
	/**
	 * Board�� ��ü�˻�..
	 * */
	@RequestMapping("/list")
	public ModelAndView list() {
		List<ElectronicsDTO> list = boardService.selectAll();
		return new ModelAndView("board/list", "list" , list);
	}
	
	/**
	 * �۾��� ��
	 * */
	@RequestMapping("/write")
	public void write() {}
	
	/**
	 * �� ���
	 * */
	@RequestMapping("/insert")
	public String insert(ElectronicsDTO elecDTO) throws IOException {
		//������ ÷�εǾ��ٸ� ����
		MultipartFile file = elecDTO.getFile();
		if(file.getSize() > 0 ) {
			String fileName = file.getOriginalFilename();
			long fileSize = file.getSize();
			
			elecDTO.setFname(fileName);
			elecDTO.setFsize(fileSize);
			
			file.transferTo(new File(savePath+"/"+fileName));
		}
		
		boardService.insert(elecDTO);
		
		return "redirect:/board/list";
	}
	
	/**
	 * �󼼺���
	 * */
	@RequestMapping("/read/{modelNum}")
	public ModelAndView read(@PathVariable String modelNum) {
		
		ElectronicsDTO electronics=
			boardService.selectByModelNum(modelNum, true);
		
		return new ModelAndView("board/read" , "elec" , electronics);
	}
	
	/**
	 * �ٿ�ε��ϱ�
	 * */
	@RequestMapping("/down")
	public ModelAndView down(String fname) {
		return new ModelAndView("downLoadView","fname",new File(savePath+"/"+fname));
	}
	
	/**
	 * ������ 
	 * */
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(String modelNum) {
		ElectronicsDTO electronics =
		  boardService.selectByModelNum(modelNum, false);//��ȸ����������
		
		return new ModelAndView("board/update", "elec" , electronics);
	}
	
	/**
	 * �����Ϸ��ϱ�
	 * */
	@RequestMapping("/update")
	public ModelAndView update(ElectronicsDTO electronics) {
		
		boardService.update(electronics);
		ElectronicsDTO dbElec=
		 boardService.selectByModelNum(electronics.getModelNum(), false);
		
		return new ModelAndView("board/read","elec" , dbElec);
	}
	
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/delete")
	public String delete(String modelNum, String password) {
		boardService.delete(modelNum, password, savePath);
		return "redirect:list";
	}

	
	
}//BoardController







