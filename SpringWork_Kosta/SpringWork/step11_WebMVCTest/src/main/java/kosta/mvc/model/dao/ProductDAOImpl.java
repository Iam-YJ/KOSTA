package kosta.mvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private List<ProductDTO> list;

	@Override
	public List<ProductDTO> select() {
		System.out.println("dao 호출");

		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {

		if (this.searchByCode(productDTO.getCode()) != null) {
			throw new MyErrorException(productDTO.getCode() + "는 중복입니다");
		}

		list.add(productDTO);
		
		return 1;
	}

	/**
	 * 상품코드에 해당하는 상품정보 가져오기
	 */

	@Override
	public int delete(String code) throws MyErrorException {
		System.out.println("dao delete");
		
		ProductDTO productDto = this.searchByCode(code);
		
		if(productDto ==null) {
			throw new MyErrorException("삭제 오류입니다.");
		}
		
		list.remove(productDto);


		return 1;
	}

	/**
	 * 상품코드에 해당하는 상품정보 가져오기
	 */
	@Override
	public ProductDTO searchByCode(String code) throws MyErrorException {

		for (ProductDTO p : list) {
			if (p.getCode().equals(code)) {
				return p;
			}
		}
		return null; // 없을 때 null 리턴
	}


}
