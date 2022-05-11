package com.yedam.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.com.DataSource;

public class LibraryServiceImpl implements LibraryService {
	
	DataSource dao = DataSource.getInstance();
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void close() {
		// 연결순서: conn > psmt > rs
		// 닫는순서: rs > psmt > conn
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BookVO> selectAllList() {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM book_list";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public BookVO selectBookInfo(String name) {
		BookVO book = new BookVO();
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM book_list WHERE title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book;
	}

	@Override
	public List<BookVO> selectBookList(String keyword) {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM book_list WHERE content LIKE %?%";
			pstmt.setString(1, keyword);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public List<BookVO> selectRentalBookList() {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			conn = dao.getConnection();
			String sql = "SELECT * FROM book_list WHERE rental = 0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setContent(rs.getString("content"));
				book.setRental(rs.getInt("rental"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public void rentalBook(String name) {
		try {
			conn = dao.getConnection();
			String sql = "UPDATE book_list SET rental = 1 WHERE title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("해당 책이 정상적으로 대여되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void returnBook(String name) {
		try {
			conn = dao.getConnection();
			String sql = "UPDATE book_list SET rental = 0 WHERE title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("해당 책이 정상적으로 대여되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void insertBook(BookVO book) {
		try {
			conn = dao.getConnection();
			String sql = "INSERT INTO book_list VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getContent());
			pstmt.setInt(4, book.getRental());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
