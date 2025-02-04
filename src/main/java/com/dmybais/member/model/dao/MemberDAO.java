package com.dmybais.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.dmybais.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneByLogin(SqlSession conn, Member member) {
		Member result = conn.selectOne("MemberMapper.selectOneByLogin",member);
		return result;
	}

	public int insertMember(SqlSession conn ,Member member) {
		int result = conn.insert("MemberMapper.insertMember",member);
		return result;
	}

	public Member selectOneById(SqlSession conn, String memberId) {
		return conn.selectOne("MemberMapper.selectOneById",memberId);
	}

	public int updateMember(SqlSession conn, Member member) {
		return conn.update("MemberMapper.updateMember",member);
	}

	public int deleteMember(SqlSession conn, String memberId) {
		return conn.delete("MemberMapper.deleteMember",memberId);
	}
	
	

//	public Member selectOneByLogin(Connection conn, Member member) throws SQLException {
//		Member result = null;
//		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
//		PreparedStatement pstmt = conn.prepareStatement(query);
//		pstmt.setString(1, member.getMemberId());
//		pstmt.setString(2, member.getMemberPwd());
//		ResultSet rset = pstmt.executeQuery();
//		if(rset.next()) {
//			String memberId = rset.getString("MEMBER_ID");
//			String memberName = rset.getString("MEMBER_NAME");
//			String email = rset.getString("EMAIL");
//			result = new Member(memberId, memberName, email);
//		}
//		rset.close();
//		pstmt.close();
//		return result;
//	}

}
