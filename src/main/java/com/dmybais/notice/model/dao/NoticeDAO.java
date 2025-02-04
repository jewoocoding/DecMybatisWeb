package com.dmybais.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dmybais.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession conn, Notice notice) {
		return conn.insert("NoticeMapper.insertNotice",notice);
	}

	public List<Notice> selectNoticeList(SqlSession conn) {
		return conn.selectList("NoticeMapper.selectNoticeList");
	}

}
