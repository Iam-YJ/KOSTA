package spring.web.dao;

import spring.web.dto.UserDTO;

public interface UserDAO {
  /**
   * �α��� ���
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
