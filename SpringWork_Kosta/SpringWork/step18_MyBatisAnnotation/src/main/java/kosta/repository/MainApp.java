package kosta.repository;

import kosta.dto.EmpDTO;

public class MainApp {

	public static void main(String[] args) {

		EmpDAO.selectAll();

		// EmpDAO.selectByEmpNo(1111);

		// EmpDAO.delete(1111);

		// EmpDAO.insert(new EmpDTO(1113, "진박이", "박박이", 9000, null));

		// EmpDAO.update(new EmpDTO(1113, "박진이", "박진이", 9000, null));

		 EmpDAO.ifTest(new EmpDTO(0, null, null, 0, null));
	}

}
