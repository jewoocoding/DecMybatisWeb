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
		// endNavi의 최대값이 전체게시물에 따라서 달라질 수 있음
		// ex) 전체 게시물의 개수가 232개이고 1페이지당 10개씩 보여준다고 하면
		// endNavi 최대값은 24가 됨 -> 이것을 식으로 써서 전체 게시물이 변경될 때마다
		// 달라지도록 해야함.
		int currentPage = request.getParameter("currentPage") != null 
				?  Integer.parseInt(request.getParameter("currentPage")) : 1;
		NoticeService nService = new NoticeService();
		List<Notice> nList = nService.selectNoticeList(currentPage);
		
		
		if(!nList.isEmpty()) {
			int totalCount = nService.getNoticeCount();
			int boardLimit = 10;
			int maxPage = totalCount % boardLimit == 0 
					? totalCount/boardLimit : totalCount/boardLimit + 1;
			maxPage = (int)Math.ceil((double)totalCount/boardLimit);
			int naviCountPerPage = 5;		
			// currentPage: 1 ~ 5, startNavi: 1, 1endNavi: 5
			// currentPage: 6 ~ 10, startNavi: 6, endNavi: 10
			int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1;
			int endNavi = startNavi+naviCountPerPage-1;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("maxPage",maxPage);
			request.setAttribute("nList", nList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.getRequestDispatcher("/WEB-INF/views/notice/noticelist.jsp")
			.forward(request, response);			
		}else {
			NavigationUtil.navigateToError("404", "데이터가 존재하지 않습니다.", request, response);
		}
	}
}
