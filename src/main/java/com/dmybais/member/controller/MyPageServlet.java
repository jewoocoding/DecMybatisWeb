package com.dmybais.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dmybais.member.common.NavigationUtil;
import com.dmybais.member.model.service.MemberService;
import com.dmybais.member.model.vo.Member;


/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/member/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member searchOne = (Member)session.getAttribute("result");
		if(searchOne != null) {
			String memberId = searchOne.getMemberId();
			Member member = new MemberService().selectOneById(memberId);
			if(member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp")
				.forward(request, response);			
			}else {
				NavigationUtil.navigateToError("404", "데이터가 존재하지 않습니다.", request, response);
			}
		}else {
			NavigationUtil.navigateToError("404", "로그인이 필요합니다.", request, response);
		}
	}


}
