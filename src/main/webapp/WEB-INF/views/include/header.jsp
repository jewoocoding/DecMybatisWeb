<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="header">
       <div id="logo">
            <h1><a href="/">Dream Jeju</a></h1>
        </div>
        <div id="nav">
            <ul>
                <li><a href="#">단체여행</a></li>
                <li><a href="#">맞춤여행</a></li>
                <li><a href="#">갤러리</a></li>
                <li><a href="/notice/list?currentPage=1">공지사항</a></li>
                <!-- 만약에 memberId가 없으면 로그인 버튼 보이고 -->
             <c:if test = "${sessionScope.result.memberId == null }" >
             	<li><a href="/member/login">로그인</a></li>
             </c:if>
             <c:if test = "${sessionScope.result.memberId != null }">
                <li><a href="/member/mypage">마이페이지</a></li>
           		<li style = "color=#fff">
           			<a href="/member/logout">로그아웃</a>
           		</li>
             </c:if>
             <!-- 만약에 memberId가 있으면 로그인이 안 보이도록 해야함. -->
    	</ul>
    </div>
</nav>