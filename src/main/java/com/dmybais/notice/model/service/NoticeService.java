package com.dmybais.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dmybais.common.SqlSessionTemplate;
import com.dmybais.notice.model.dao.NoticeDAO;
import com.dmybais.notice.model.vo.Notice;

public class NoticeService {
	
	private SqlSession conn;
	private NoticeDAO nDao;
	
	public NoticeService() {
		conn = SqlSessionTemplate.getSqlSession();
		nDao = new NoticeDAO();
	}
	
	public int insertNotice(Notice notice) {
		return nDao.insertNotice(conn, notice);
	}

	public List<Notice> selectNoticeList() {
		return nDao.selectNoticeList(conn);
	}

}
