package com.example.demo1.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import util.DBManager;

@Repository
public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public boolean deleteUser(UserRequestDto userRequestDto) {
		boolean delete = false;
		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM users WHERE code=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userRequestDto.getCode());
			delete = pstmt.execute();
			System.out.println("유저 삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("유저 삭제 실패");
		}
		return delete;
	}

	public boolean joinUser(UserRequestDto userRequestDto) {
		boolean join = false;
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO users(user_name, password, first_name, email) VALUES (?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userRequestDto.getUserName());
			pstmt.setString(2, userRequestDto.getPassword());
			pstmt.setString(3, userRequestDto.getFirstName());
			pstmt.setString(4, userRequestDto.getEmail());

			join = pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return join;
	}

	public boolean updateUser(UserRequestDto userRequestDto, int code) {
		boolean update = false;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE users set user_name =?, password=?, first_name=?,email=? WHERE code=? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userRequestDto.getUserName());
			pstmt.setString(2, userRequestDto.getPassword());
			pstmt.setString(3, userRequestDto.getFirstName());
			pstmt.setString(4, userRequestDto.getEmail());
			pstmt.setInt(5, code);

			pstmt.execute();

			update = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}

	public void deleteUser(int code) {
		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM users WHERE code = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User findUserByIdAndPassword(UserRequestDto userDto) {
		User user = null;
		conn = DBManager.getConnection();
		String sql = "select * from users where user_name = ? and password = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getUserName());
			pstmt.setString(2, userDto.getPassword());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int code = rs.getInt("code");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				Timestamp regDate = rs.getTimestamp("reg_date");
				Timestamp modDate = rs.getTimestamp("mod_date");

				user = new User(code, userName, password, firstName, email, regDate, modDate);

				return user;
			}
		} catch (Exception e) {
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return user;
	}

	public User findUserByCode(int code) {
		User user = null;
		conn = DBManager.getConnection();
		String sql = "select * from users where code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String email = rs.getString("email");
				Timestamp regDate = rs.getTimestamp("reg_date");
				Timestamp modDate = rs.getTimestamp("mod_date");

				user = new User(code, userName, password, firstName, email, regDate, modDate);

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return user;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();

		conn = DBManager.getConnection();

		String sql = "SELECT * FROM users";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int code = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				String firstName = rs.getString(4);
				String email = rs.getString(5);
				Timestamp regDate = rs.getTimestamp(6);
				Timestamp modDate = rs.getTimestamp(7);

				User user = new User(code, userName, password, firstName, email, regDate, modDate);
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

}