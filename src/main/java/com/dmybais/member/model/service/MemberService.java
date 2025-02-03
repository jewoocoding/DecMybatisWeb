package com.dmybais.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.dmybais.member.common.JDBCTemplate;
import com.dmybais.member.common.SqlSessionTemplate;
import com.dmybais.member.dao.MemberDAO;
import com.dmybais.member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	private SqlSession conn;
	
	public MemberService() {
		conn = SqlSessionTemplate.getSqlSession();
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}

	public Member selectOneByLogin(Member member) {
		Member result = mDao.selectOneByLogin(conn, member);
		return result;
		
//		// Connection conn = null;
//		Member result = null;
//		try {
//			// conn = jdbcTemplate.getConnection();
//			result = mDao.selectOneByLogin(conn, member);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
	}

	public int insertMember(Member member) {
		int result = mDao.insertMember(conn, member);
		return result;
	}

	public Member selectOneById(String memberId) {
		return mDao.selectOneById(conn, memberId);
	}

	public int updateMember(Member member) {
		return mDao.updateMember(conn, member);
	}

	public int deleteMember(String memberId) {
		return mDao.deleteMember(conn,memberId);
	}
}
