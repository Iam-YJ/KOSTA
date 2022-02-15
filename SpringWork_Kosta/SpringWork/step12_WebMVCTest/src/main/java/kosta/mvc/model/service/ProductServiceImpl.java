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
		System.out.println("service ȣ��");

		return productDao.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		// ���� üũ �ؾ���
		if (productDTO.getPrice() <= 1000 || productDTO.getPrice() > 10000) {
			throw new MyErrorException("������ 1000�� ~ 10000�� ���̸� �����մϴ� ");
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
			throw new MyErrorException("������ �߸��Ǿ� ���������� �� �� �����ϴ�.");
		}
		
		return dto;
	}

}
