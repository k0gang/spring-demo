package com.example.demo1.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	public List<User> findAll(){
		List<User> list = new ArrayList<User>();
		
		conn = DBManager.getConnection();
		
		String sql = "SELECT * FROM users";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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