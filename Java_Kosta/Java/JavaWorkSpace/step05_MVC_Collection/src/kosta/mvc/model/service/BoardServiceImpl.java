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
	private static BoardServiceImpl instance = new BoardServiceImpl(); // ���������

	/**
	 * �ܺο��� ��ü���� ���ϵ��� private ������ : �ܺ� ~.properties ���� �ε��ؼ� Board�� ���� �Ŀ� Map �����ϴ�
	 * ������ �ʱ�ġ �����Ѵ�.
	 */

	private BoardServiceImpl() {
		// ���� �Խ��ǿ� ���� Map ����
		Map<String, Board> archiveMap = new TreeMap<String, Board>();
		Map<String, Board> photoMap = new TreeMap<String, Board>();

		// archiveInfo.properties �ε�
		ResourceBundle rb = ResourceBundle.getBundle("kosta/mvc/model/service/archiveInfo");

		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			// System.out.println(key + " = " + value);
			// value�� ���� �޸��� �������� �и��Ѵ�
			String v[] = value.split(",");

			Board board = new ArchiveBoard(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], v[5],
					Integer.parseInt(v[6]));

			archiveMap.put(key, board);
		}

		// photoInfo.properties �ε�
		rb = ResourceBundle.getBundle("kosta/mvc/model/service/photoInfo");

		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			// System.out.println(key + " = " + value);
			// value�� ���� �޸��� �������� �и��Ѵ�
			String v[] = value.split(",");

			Board board = new PhotoBoard(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], v[5]);

			photoMap.put(key, board);
		} // for�� ��

		// all BoardList ���� �ΰ��� map�� �����Ѵ�
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
			throw new InexistentException("��ü���� �Խù��� �������� �ʽ��ϴ�.");
		}
		return allBoardList;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);

		if (kindMap == null) { // kindMap �� �ƿ� ����
			throw new InexistentException(kind + "������ �Խ����� �������� �ʽ��ϴ�.");
		} else if (kindMap.isEmpty()) { // kindMap�� ����� ������ �Խù��� ����
			throw new InexistentException(kind + "������ �Խ��ǿ� �Խù��� �����ϴ�.");
		}

		return kindMap;
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);

		if (kindMap == null) {
			throw new InexistentException(kind + "������ �Խ����� �������� �ʽ��ϴ�.");
		} else if (kindMap.isEmpty()) {
			throw new InexistentException(kind + "������ �Խ����� ������ �������� �ʽ��ϴ�.");
		}
		Board board = kindMap.get(Integer.toString(no));
		if (board == null) {
			throw new InexistentException(kind + "������ �Խ��ǿ�" + no + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
		}

		return board;
	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		// TODO Auto-generated method stub
		if (!allBoardList.containsKey(kind)) {
			throw new InexistentException(kind + "������ �Խ����� �������� �ʽ��ϴ�.");
		}
		if (this.duplicateByNo(kind, board.getNo())) {
			throw new InexistentException(board.getNo() + "�� �̹� �����ϹǷ� ����� �� �����ϴ�.");
		}

		// ��Ͻ���
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
			throw new InexistentException(kind + "������ �߸��Ǿ� ������ �� �����ϴ�.");
		}
		Board board = kindMap.remove(Integer.toString(no));
		if (board == null) {
			throw new InexistentException(no + "������ �������� �ʾҽ��ϴ�.");
		}

	}

	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		// TODO Auto-generated method stub
		Map<String, Board> kindMap = allBoardList.get(kind);
		if (kindMap == null) {
			throw new InexistentException(kind + "������ �߸��Ǿ� ������ �� �����ϴ�.");
		}
		if (board == null) {
			throw new InexistentException("�Խù��� ������ ���� ������ �� �����ϴ�.");
		}
		
		Board dbBoard = kindMap.get(Integer.toString(board.getNo()));
		
		if(dbBoard == null) {
			throw new InexistentException(board.getNo() + "��ȣ ������ ������ �� �����ϴ�.");	
		}
		
		//��������
		if(board instanceof ArchiveBoard && dbBoard instanceof ArchiveBoard) {
			//�ڷ�� �Խ��� ����(����, �ۼ���, ����, fileName, fileSize)
			dbBoard.setSubject(board.getSubject());
			dbBoard.setWriter(board.getWriter());
			dbBoard.setContent(board.getContent()); //Ÿ���� ��Ȯ�ؾ� �����ϴ� ���� ��ȿ�ϱ� �����̴�
			
			//ĳ���� �䱸
			ArchiveBoard dbABoard  = (ArchiveBoard)dbBoard; // ������ �ִ� ���� 
			ArchiveBoard dataABoard  = (ArchiveBoard)board; //���� ���� ����
			
			dbABoard.setFileName(dataABoard.getFileName());
			dbABoard.setFileSize(dataABoard.getFileSize());
			
			
			
		}else if(board instanceof PhotoBoard && dbBoard instanceof PhotoBoard) {
			//���� �Խ��� ���� (����, �ۼ���, ����, imgName)
			dbBoard.setSubject(board.getSubject());
			dbBoard.setWriter(board.getWriter());
			dbBoard.setContent(board.getContent());
			
			//ĳ���� �䱸
			PhotoBoard dbPBoard  = (PhotoBoard)dbBoard;
			PhotoBoard dataPBoard  = (PhotoBoard)board;
			
			dbPBoard.setImgName(dataPBoard.getImgName());
			 
			
		}else {
			throw new InexistentException("Ÿ���� �߸��Ǿ� ������ �� �����ϴ�.");
		}

	}

}
