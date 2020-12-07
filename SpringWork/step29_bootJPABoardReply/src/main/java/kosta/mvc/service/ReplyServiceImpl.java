package kosta.mvc.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Reply;
import kosta.mvc.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository replyRepo;
	
	/**
	 * 객체 생성이되고 주입 완료된 후에 자동 호출 
	 */
	@PostConstruct
	public void aa() {
		
	}
	
	@Override
	public void insert(Reply reply) {
		replyRepo.save(reply);
	}

	@Override
	public void delete(Long id) {
		replyRepo.deleteById(id);
	}

}
