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

	public List<Notice> selectNoticeList(int currentPage) {
		return nDao.selectNoticeList(conn, currentPage);
	}

	public Notice selectOneByNo(int noticeNo) {
		return nDao.selectOneByNo(conn, noticeNo);
	}

	public int deleteOneByNo(int noticeNo) {
		return nDao.deleteOneByNo(conn, noticeNo);
	}

	public int updateNotice(Notice notice) {
		return nDao.updateNotice(conn, notice);
	}

	public int getNoticeCount() {
		return nDao.getNoticeCount(conn);
	}

}
