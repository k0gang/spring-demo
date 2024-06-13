package com.example.demo1.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBManager;

@Repository
public class BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {
	}
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public boolean createBoard(BoardRequestDto boardRequestDto) {
		boolean create = false;
		try {
			conn = DBManager.getConnection();
			
			String sql = "INSERT INTO boards(author, title, content) VALUES (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardRequestDto.getAuthor());
			pstmt.setString(2, boardRequestDto.getTitle());
			pstmt.setString(3, boardRequestDto.getContent());
			
			create = pstmt.execute();
			System.out.println("게시글 작성 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 작성 실패");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return create;
	}
	
	public boolean updateBoard(BoardRequestDto boardRequestDto) {
		boolean update = false;
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE boards SET title=?, content=? WHERE code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardRequestDto.getTitle());
			pstmt.setString(2, boardRequestDto.getContent());
			pstmt.setInt(3, boardRequestDto.getCode());
			
			update = pstmt.execute();
			System.out.println("게시글 수정 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 수정 실패");
		}
		return update;
	}
	
	public List<Board> findAll(){
		List<Board> list = new ArrayList<Board>();
		
		conn = DBManager.getConnection();
		
		String sql = "SELECT * FROM boards";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int code = rs.getInt(1);
				int author = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				Timestamp regDate = rs.getTimestamp(5);
				Timestamp modDate = rs.getTimestamp(6);
				
				Board board = new Board(code, author, title, content, regDate, modDate);
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public Board findBoardByCode(int code) {
		Board board = null;
		
		conn = DBManager.getConnection();
		
		String sql = "SELECT * FROM boards WHERE code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int author = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				Timestamp regDate = rs.getTimestamp(5);
				Timestamp modDate = rs.getTimestamp(6);
				
				board = new Board(code, author, title, content, regDate, modDate);
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return board;
	}
	
	public boolean deleteBoardByCode(int code) {
		boolean delete = false;
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM boards WHERE code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			delete = pstmt.execute();
			System.out.println("게시글 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 삭제 실패");
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return delete;
	}
	
}
