package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardDTO> boardList = new ArrayList<BoardDTO>();

		String sql = proFile.getProperty("board.selectAll");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDTO board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				boardList.add(board);
			}

			for (int i = 0; i < boardList.size(); i++) {
				System.out.println("list[" + i + "] = " + boardList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return boardList;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();

		String sql = proFile.getProperty("board.selectBySubject");
		// select * from board where subject ?

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, "%" + keyWord + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDTO board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				boardList.add(board);
			}

			for (int i = 0; i < boardList.size(); i++) {
				System.out.println("list[" + i + "] = " + boardList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return boardList;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTO board = null;
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();

		String sql = proFile.getProperty("board.selectByNo");
		// board.selectByNo=select * from board where board_no = ?

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, boardNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				boardList.add(board);
			}

			for (int i = 0; i < boardList.size(); i++) {
				System.out.println("list[" + i + "] = " + boardList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return board;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		int i = 0;

		String sql = proFile.getProperty("board.insert");
		// board.insert=insert into board (board_no, subject, writer,content,board_date) values (board_seq.nextval, ?, ?, ?, sysdate)

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getWriter());
			ps.setString(2, boardDTO.getContent());
			ps.setString(3, boardDTO.getBoardDate());

			i = ps.executeUpdate();
			
			System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return i;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		int i = 0;

		String sql = proFile.getProperty("board.updateByNo");
		// board.updateByNo=update board set content = ? where board_no = ?

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return i;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		int i = 0;

		String sql = proFile.getProperty("board.deleteByNo");
		// board.deleteByNo=delete from board where board_no = ?0210

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, boardNo);

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return i;
	}

}
