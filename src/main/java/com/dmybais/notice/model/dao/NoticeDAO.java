package com.dmybais.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dmybais.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession conn, Notice notice) {
		return conn.insert("NoticeMapper.insertNotice",notice);
	}

	public List<Notice> selectNoticeList(SqlSession conn) {
		int offset = 0; // 시작부분
		int limit = 10; // 가져올 개수
		RowBounds rowBounds = new RowBounds(offset, limit);
		return conn.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
	}

	public Notice selectOneByNo(SqlSession conn, int noticeNo) {
		return conn.selectOne("NoticeMapper.selectOneById", noticeNo);
	}

	public int deleteOneByNo(SqlSession conn, int noticeNo) {
		return conn.delete("NoticeMapper.deleteOneByNo",noticeNo);
	}

	public int updateNotice(SqlSession conn, Notice notice) {
		return conn.update("NoticeMapper.updateNotice",notice);
	}
	
}
