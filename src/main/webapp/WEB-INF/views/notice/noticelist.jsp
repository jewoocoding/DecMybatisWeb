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
							<!-- i.count or i.index -->
							<!-- 
								varStatus는 반복과정에서 반복 상태 정보를 담을 수 있게하는 속성
								* 1 ~ 2 결과값이 정수
								1. index : 현재 반복의 0부터 시작하는 인덱스 번호
								2. count : 반복된 항목의 수, 1부터 시작하는 번호
								* 3 ~ 6 결과값이 true, false
								3. first : 첫번째면 true, 아니면 false
								4. last : 마지막이면 true, 아니면 false
								5. even : 짝수번째면 true, 아니면 false
								6. odd : 홀수번째면 true, 아니면 false
							 -->
							<c:forEach items="${nList }" var="n" varStatus="i">
								<tr>
									<td class="num">${nList.size() - i.index }</td> 
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
						<c:if test="${startNavi ne 1 }">					
							<a href="/notice/list?currentPage=${startNavi-1 }" class="prev">&lt;</a>
						</c:if>
						<c:forEach begin="${startNavi }" end="${endNavi }" var="i">
							<a href="/notice/list?currentPage=${i }">${i }</a>						
						</c:forEach>			
						<c:if test="${endNavi ne maxPage }">					
							<a href="/notice/list?currentPage=${endNavi+1 }" class="next">&gt;</a>
						</c:if>	
					</div>
				</section>
			</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
		</div>
	</body>
</html>