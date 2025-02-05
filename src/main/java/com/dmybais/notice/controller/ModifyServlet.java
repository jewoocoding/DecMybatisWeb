package com.dmybais.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dmybais.common.NavigationUtil;
import com.dmybais.member.model.vo.Member;
import com.dmybais.notice.model.service.NoticeService;
import com.dmybais.notice.model.vo.Notice;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/notice/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(noticeNo);
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp")
			.forward(request, response);
		}else {
			NavigationUtil.navigateToError("404", "데이터가 존재하지 않습니다.", request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		//String attachmentName = request.getParameter("attachmentName");
		
		Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
		int result = new NoticeService().updateNotice(notice);
		if(result > 0) {
			response.sendRedirect("/notice/detail?noticeNo="+noticeNo);
		}else {
			NavigationUtil.navigateToError("500", "서비스가 완료되지 않았습니다.", request, response);
		}
	}
}
