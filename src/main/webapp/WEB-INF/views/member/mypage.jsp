<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제주의 꿈 - 마이페이지</title>
		<link rel="stylesheet" href="../../../resources/css/reset.css">
		<link rel="stylesheet" href="../../../resources/css/header.css">
		<link rel="stylesheet" href="../../../resources/css/footer.css">
		<link rel="stylesheet" href="../../../resources/css/mypage.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main>
				<div class="mypage-container">
					<div class="sidebar">
						<div class="profile-section">
							<div class="profile-image"></div>
							<h3 class="profile-name">${requestScope.member.memberName }님</h3>
							<p class="profile-info">여행의 발견</p>			
						</div>
						<ul class="menu-list">
							<li><a href="#" class="active">기본 정보</a></li>
							<li><a href="#">예약 내역</a></li>
							<li><a href="#">관심 상품</a></li>
							<li><a href="#">후기 관리</a></li>
							<li><a href="#">설정</a></li>
						</ul>
					</div>
					<div class="content-area">
						<h2 class="content-title">기본정보</h2>
						<form action="/member/update" method="post">
							<div class="info-group">
								<label>아이디</label>
								<input type="text" value="${requestScope.member.memberId}" name="memberId" readonly>
							</div>
							<div class="info-group">
								<label>이름</label>
								<input type="text" value="${requestScope.member.memberName}" readonly>
							</div>
							<div class="info-group">
								<label>성별</label>
								<div class="radio-group">
									<label>
										<input type="radio" disabled <c:if test="${requestScope.member.gender =='M' }">checked</c:if>>
										남
									</label>
									<label>
										<input type="radio" disabled <c:if test="${requestScope.member.gender eq 'F' }">checked</c:if>>
										여
									</label>
								</div>
							</div>
							<div class="info-group">
								<label>나이</label>
								<input type="number" value="${requestScope.member.age}" readonly>
							</div>
							<div class="info-group">
								<label>이메일</label>
								<input type="email" value="${requestScope.member.email}" name="email">
							</div>
							<div class="info-group">
								<label>전화번호</label>
								<input type="tel" value="${requestScope.member.phone}" name="phone">
							</div>
							<div class="info-group">
								<label>주소</label>
								<input type="text" value="${requestScope.member.address}" name="address">
							</div>
							<div class="info-group">
								<label>취미</label>
								<input type="text" value="${requestScope.member.hobby}" name="hobby">
							</div>
							<button type="submit" class="save-button">저장하기</button>
							<span class="del-button">
								<a href="/member/delete">회원탈퇴</a>							
							</span>
						</form>
					</div>
				</div>
			</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
		</div>
	</body>
</html>