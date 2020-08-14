package kosta.mvc.model.service;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import kosta.mvc.model.dto.ArchiveBoard;
import kosta.mvc.model.dto.Board;
import kosta.mvc.model.dto.PhotoBoard;
import kosta.mvc.model.exception.DuplicateException;
import kosta.mvc.model.exception.InexistentException;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardServiceImpl implements BoardService {

	Map<String, Map<String, Board>> allBoardList = new TreeMap<String, Map<String, Board>>();
	private static BoardServiceImpl instance = new BoardServiceImpl(); // 멤버변수임

	/**
	 * 외부에서 객체생성 못하도록 private 생성자 : 외부 ~.properties 파일 로딩해서 Board로 만든 후에 Map 저장하는
	 * 데이터 초기치 세팅한다.
	 */

	private BoardServiceImpl() {
		// 각각 게시판에 따른 Map 생성
		Map<String, Board> archiveMap = new TreeMap<String, Board>();
		Map<String, Board> photoMap = new TreeMap<String, Board>();

		// archiveInfo.properties 로딩
		ResourceBundle rb = ResourceBundle.getBundle("kosta/mvc/model/service/archiveInfo");

		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			// System.out.println(key + " = " + value);
			// value의 값을 콤마를 기준으로 분리한다
			String v[] = value.split(",");

			Board board = new ArchiveBoard(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], v[5],
					Integer.parseInt(v[6]));

			archiveMap.put(key, board);
		}

		// photoInfo.properties 로딩
		rb = ResourceBundle.getBundle("kosta/mvc/model/service/photoInfo");

		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			// System.out.println(key + " = " + value);
			// value의 값을 콤마를 기준으로 분리한다
			String v[] = value.split(",");

			Board board = new PhotoBoard(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], v[5]);

			photoMap.put(key, board);
		} // for문 끝

		// all BoardList 에서 두개의 map을 저장한다
		allBoardList.put("archive", archiveMap);
		allBoardList.put("photo", photoMap);

	}

	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		// TODO Auto-generated method stub
		if (allBoardList.isEmpty()) {
			throw new InexistentException("전체에서 게시물이 존재하지 않습니다.");
		}
		return allBoardList;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);

		if (kindMap == null) { // kindMap 이 아예 없음
			throw new InexistentException(kind + "유형의 게시판은 존재하지 않습니다.");
		} else if (kindMap.isEmpty()) { // kindMap이 존재는 하지만 게시물이 없음
			throw new InexistentException(kind + "유형의 게시판에 게시물이 없습니다.");
		}

		return kindMap;
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);

		if (kindMap == null) {
			throw new InexistentException(kind + "유형의 게시판은 존재하지 않습니다.");
		} else if (kindMap.isEmpty()) {
			throw new InexistentException(kind + "유형의 게시판의 정보가 존재하지 않습니다.");
		}
		Board board = kindMap.get(Integer.toString(no));
		if (board == null) {
			throw new InexistentException(kind + "유형의 게시판에" + no + "에 해당하는 정보가 존재하지 않습니다.");
		}

		return board;
	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		if (!allBoardList.containsKey(kind)) {
			throw new InexistentException(kind + "유형의 게시판은 존재하지 않습니다.");
		}
		if (this.duplicateByNo(kind, board.getNo())) {
			throw new InexistentException(board.getNo() + "는 이미 존재하므로 등록할 수 없습니다.");
		}

		// 등록시작
		allBoardList.get(kind).put(Integer.toString(board.getNo()), board);

	}

	@Override
	public boolean duplicateByNo(String kind, int no) {
		// TODO Auto-generated method stub
		Board board = allBoardList.get(kind).get(Integer.toString(no));
		if (board != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);
		if (kindMap == null) {
			throw new InexistentException(kind + "유형이 잘못되어 삭제할 수 없습니다.");
		}
		Board board = kindMap.remove(Integer.toString(no));
		if (board == null) {
			throw new InexistentException(no + "오류로 삭제되지 않았습니다.");
		}

	}

	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);
		if (kindMap == null) {
			throw new InexistentException(kind + "유형이 잘못되어 삭제할 수 없습니다.");
		}
		if (board == null) {
			throw new InexistentException("게시물의 정보가 없어 수정할 수 없습니다.");
		}
		
		Board dbBoard = kindMap.get(Integer.toString(board.getNo()));
		
		if(dbBoard == null) {
			throw new InexistentException(board.getNo() + "번호 오류로 수정할 수 없습니다.");	
		}
		
		//수정시작
		if(board instanceof ArchiveBoard && dbBoard instanceof ArchiveBoard) {
			//자료실 게시판 수정(제목, 작성자, 내용, fileName, fileSize)
			dbBoard.setSubject(board.getSubject());
			dbBoard.setWriter(board.getWriter());
			dbBoard.setContent(board.getContent()); //타입이 정확해야 수정하는 것이 유효하기 때문이다
			
			//캐스팅 요구
			ArchiveBoard dbABoard  = (ArchiveBoard)dbBoard; // 기존에 있던 보드 
			ArchiveBoard dataABoard  = (ArchiveBoard)board; //내가 들고온 보드
			
			dbABoard.setFileName(dataABoard.getFileName());
			dbABoard.setFileSize(dataABoard.getFileSize());
			
			
			
		}else if(board instanceof PhotoBoard && dbBoard instanceof PhotoBoard) {
			//사진 게시판 수정 (제목, 작성자, 내용, imgName)
			dbBoard.setSubject(board.getSubject());
			dbBoard.setWriter(board.getWriter());
			dbBoard.setContent(board.getContent());
			
			//캐스팅 요구
			PhotoBoard dbPBoard  = (PhotoBoard)dbBoard;
			PhotoBoard dataPBoard  = (PhotoBoard)board;
			
			dbPBoard.setImgName(dataPBoard.getImgName());
			 
			
		}else {
			throw new InexistentException("타입이 잘못되어 수정할 수 없습니다.");
		}

	}

}
