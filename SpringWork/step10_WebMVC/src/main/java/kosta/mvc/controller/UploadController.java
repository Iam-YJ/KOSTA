package kosta.mvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.UploadDTO;

@Controller
public class UploadController {

	@RequestMapping("/upload.do")
	public ModelAndView upload(String name, MultipartFile file, HttpSession session) {

		// 실제 프로젝트 경로를 가져오기
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		String fileName = file.getOriginalFilename();

		// 파일을 저장
		try {
			file.transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		// 뷰쪽으로 전달될 정보를 저장한다
		ModelAndView mv = new ModelAndView();

		mv.addObject("name", name);
		mv.addObject("fileName", fileName);
		mv.addObject("path", path);
		mv.addObject("fileSize", file.getSize());

		mv.setViewName("uploadResult");

		return mv;
	}

	@RequestMapping("/upload2.do")
	public String upload2(UploadDTO dto, HttpSession session) { // 실제 프로젝트 경로를 가져오기
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		String fileName = dto.getFile().getOriginalFilename();

		// 파일을 저장
		try {
			dto.getFile().transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		return "uploadResult";
	}

	/**
	 * 다운로드 항목 가져오기
	 */
	@RequestMapping("/downList.do")
	public ModelAndView downList(HttpServletRequest request) {
		String pathName = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(pathName);

		File file = new File(pathName);
		String[] fileNames = file.list();

		return new ModelAndView("downloadResult", "fileNames", fileNames);
	}

	@RequestMapping("/down.do")
	public ModelAndView down(String fileName, HttpSession session) {

		String path = session.getServletContext().getRealPath("/WEB-INF/save");

		// 뷰쪽으로 전달될 정보를 저장한다
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("fname", new File(path + "/" + fileName));
		mv.setViewName("downLoadView"); //id = "downLoadView" 호출될 수 있따 

		return mv;
	}

}
