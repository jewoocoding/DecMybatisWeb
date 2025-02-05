package com.dmybais.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dmybais.common.NavigationUtil;
import com.dmybais.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = new NoticeService().deleteOneByNo(noticeNo);
		
		if(result > 0) {
			response.sendRedirect("/notice/list");
		}else {
			NavigationUtil.navigateToError("500", "서비스가 완료되지 않았습니다.", request, response);
		}
	}

}
