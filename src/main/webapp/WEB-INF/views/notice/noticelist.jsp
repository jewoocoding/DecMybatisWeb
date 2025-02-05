<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제주의 꿈 - 공지사항 목록</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
		<link rel="stylesheet" href="../resources/css/noticelist.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main>
				<section class="board-title">
					<h1>공지사항</h1>				
				</section>
				<section class="board-content">	
					<table class="notice-table">
						<thead>
							<tr>
								<th class="num">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="date">작성일</th>
								<th class="views">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${nList }" var="n" >
								<tr>
									<td class="num">${n.noticeNo }</td>
									<td class="title"><a href="/notice/detail?noticeNo=${n.noticeNo }">${n.noticeSubject }</a></td>
									<td class="writer">${n.noticeWriter }</td>
									<td class="date">${n.noticeDate }</td>
									<td class="views">${n.viewCount }</td>
								</tr>
							</c:forEach>
							<!-- 
							<c:forEach begin="1" end="20">
								<tr>
									<td>우앙랑아아</td>
								</tr>
							</c:forEach>
							${nList[0]}
							${nList[2]}
							${nList[4]}
							 -->
						</tbody>
					</table>
					<div class="pagination">
						<a href="#" class="prev">&lt;</a>
						<a href="#" class="active">1</a>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#">4</a>
						<a href="#">5</a>
						<a href="#" class="next">&gt;</a>
					</div>
				</section>
			</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
		</div>
	</body>
</html>