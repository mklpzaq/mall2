package com.test.mall2.member.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import com.test.mall2.IndexController;
import com.test.mall2.driver.DriverDB;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	public void insertMember(Member member) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverDB.driverConnection();
			String sql = "INSERT INTO member(member_id, member_pw) VALUES(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMemberId());
			statement.setString(2, member.getMemberPw());
			statement.executeUpdate();
			
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
	}
	
	public ArrayList<Member> selectMember() {
		logger.info("insertMember");		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Member> list = null;
		Member member = null;
		
		try {
			connection = DriverDB.driverConnection();
			String sql = "SELECT * FROM member";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			list = new ArrayList<Member>();
			while(resultSet.next()) {
				member = new Member();
				member.setMemberNo(resultSet.getInt("member_no"));
				member.setMemberId(resultSet.getString("member_Id"));
				member.setMemberPw(resultSet.getString("member_Pw"));
				list.add(member);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		return list;
	}
}
