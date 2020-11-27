package kosta.web.mvc.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kosta.web.mvc.board.dto.ElectronicsDTO;

public interface BoardMapper {

	//전체보기
	@Select("select model_num, model_name, price, description, password, writeday,readnum,fname, fsize from electronics")
	List<ElectronicsDTO> selectAll();
	
	//모델 넘버로 검색하기
	@Select("select model_num, model_name, price, description, password, writeday,readnum,fname, fsize from electronics where model_num = #{modelNum}")//#{modelNum}
	ElectronicsDTO selectByModelNum(String modelNum);
	
	//등록하기
	@Insert("insert into Electronics values(#{modelNum},#{modelName},#{price},#{description},#{password},sysdate,0,#{fname},#{fsize})")
	int insert(ElectronicsDTO electronics);
}
