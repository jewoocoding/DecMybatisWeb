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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
			int result = new MemberService().deleteMember(memberId);
			if(result > 0) {
				session.invalidate();
				response.sendRedirect("/member/logout");
			}else {
				NavigationUtil.navigateToError("500", "서비스처리가 완료되지 않았습니다.", request, response);
			}
		}else {
			NavigationUtil.navigateToError("404", "데이터가 존재하지 않습니다.", request, response);
		}
	}

}
