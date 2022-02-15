package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dao.ProductDAOImpl;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDao;

	@Override
	public List<ProductDTO> select() {
		System.out.println("service 호출");

		return productDao.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		// 가격 체크 해야함
		if (productDTO.getPrice() <= 1000 || productDTO.getPrice() > 10000) {
			throw new MyErrorException("가격은 1000원 ~ 10000원 사이만 가능합니다 ");
		}

		int result = productDao.insert(productDTO);
		return result;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		int result = productDao.delete(code);

		return result;
	}

	@Override
	public ProductDTO searchByCode(String code) throws MyErrorException {
		ProductDTO dto = productDao.searchByCode(code);
		
		if(dto==null) {
			throw new MyErrorException("정보가 잘못되어 상세페이지를 볼 수 없습니다.");
		}
		
		return dto;
	}

}
