package com.dmybais.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dmybais.common.NavigationUtil;
import com.dmybais.notice.model.service.NoticeService;
import com.dmybais.notice.model.vo.Notice;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/notice/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Notice> nList = new NoticeService().selectNoticeList();
		if(!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.getRequestDispatcher("/WEB-INF/views/notice/noticelist.jsp")
			.forward(request, response);			
		}else {
			NavigationUtil.navigateToError("404", "데이터가 존재하지 않습니다.", request, response);
		}
	}
}
