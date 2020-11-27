package kosta.web.mvc.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kosta.web.mvc.board.dto.ElectronicsDTO;

public interface BoardMapper {

	//��ü����
	@Select("select model_num, model_name, price, description, password, writeday,readnum,fname, fsize from electronics")
	List<ElectronicsDTO> selectAll();
	
	//�� �ѹ��� �˻��ϱ�
	@Select("select model_num, model_name, price, description, password, writeday,readnum,fname, fsize from electronics where model_num = #{modelNum}")//#{modelNum}
	ElectronicsDTO selectByModelNum(String modelNum);
	
	//����ϱ�
	@Insert("insert into Electronics values(#{modelNum},#{modelName},#{price},#{description},#{password},sysdate,0,#{fname},#{fsize})")
	int insert(ElectronicsDTO electronics);
}
