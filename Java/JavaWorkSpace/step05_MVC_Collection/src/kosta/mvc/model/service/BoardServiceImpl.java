package kosta.mvc.model.service;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import kosta.mvc.model.dto.ArchiveBoard;
import kosta.mvc.model.dto.Board;
import kosta.mvc.model.dto.PhotoBoard;
import kosta.mvc.model.exception.DuplicateException;
import kosta.mvc.model.exception.InexistentException;

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
		
		System.out.println(allBoardList);

	}


	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void duplicateByNo(String kind, int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		// TODO Auto-generated method stub

	}

}
