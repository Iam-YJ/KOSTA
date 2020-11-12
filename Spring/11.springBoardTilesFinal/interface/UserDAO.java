package spring.web.dao;

import spring.web.dto.UserDTO;

public interface UserDAO {
  /**
   * 로그인 기능
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
