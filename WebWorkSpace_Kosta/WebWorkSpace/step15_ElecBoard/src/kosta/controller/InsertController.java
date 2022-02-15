package kosta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("insert ��û ");
		
		
		String saveDir = 
				request.getServletContext().getRealPath("/save");
		
		int maxSize=1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m = 
				new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		Electronics electronics = 
		new Electronics(modelNum, modelName, Integer.parseInt(price),
				description, password);
		
		//����÷���ΰ��....
		if(m.getFilesystemName("file")!=null) {
			electronics.setFname(m.getFilesystemName("file"));
			electronics.setFsize((int)m.getFile("file").length());
		}
		//insert�Ϸ� ����
		ElectronicsService.insert(electronics);
		
		ModelAndView mv = new ModelAndView("elec", true);
		
		//�����ϸ�...list.jsp�̵� 
		
		return mv;

	}

}
