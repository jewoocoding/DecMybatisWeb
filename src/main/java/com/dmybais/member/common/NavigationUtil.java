package com.dmybais.member.common;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NavigationUtil {
	private static final String ERROR_PAGE = "/WEB-INF/views/common/error.jsp";
	
	public static void navigateToError(String errorCode, String errorMessage
			,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errorCode", errorCode);
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
	}
}
