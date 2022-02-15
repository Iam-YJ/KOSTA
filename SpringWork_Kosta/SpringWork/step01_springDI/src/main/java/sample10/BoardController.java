package sample10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component // id="boardController"
@Controller
public class BoardController {

	@Autowired // byType주입 -> byName
	private BoardDTO boardDTO;

	@Autowired
	// boardDTO 변수는 2개지만 사실 타입은 1개여서 주소값 같은 것으로 들어올 것이다.
	private BoardDTO boardDTO2;

	@Autowired
	private BoardService boardService;

	public BoardController() {

	}

	public void test() {
		System.out.println("BoardController의 test() 호출됨");
		System.out.println("boardDTO : " + boardDTO);
		System.out.println("boardDTO2 : " + boardDTO2);
	}

}
