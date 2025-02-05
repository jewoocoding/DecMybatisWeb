<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제주의 꿈 - 공지사항 상세</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
		<link rel="stylesheet" href="../resources/css/detail.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main>
				<article class="notice-detail">
					<div class="notice-header">
						<h2 class="notice-title">${notice.noticeSubject }</h2>
						<div class="notice-info">
							<span>작성자 : ${notice.noticeWriter }</span>
							<span>작성일 : ${notice.noticeDate }</span>
							<span>조회 : ${notice.viewCount }</span>
						</div>
					</div>
					<div class="notice-content">${notice.noticeContent }</div>
					<div class="notice-file">
						<h4>첨부파일</h4>
						<a href="${notice.attachmentPath }">${notice.attachmentName }</a>
					</div>
				</article>	
				<div class="button-group">
					<div class="admin-button">
						<a href="/notice/modify?noticeNo=${notice.noticeNo }" class="btn btn-admin">수정</a>
						<a href="/notice/delete?noticeNo=${notice.noticeNo }" class="btn btn-admin">삭제</a>
					</div>
					<div class="navigation-button">
						<a href="/notice/list" class="btn">목록</a>
						<a href="#" class="btn">이전글</a>
						<a href="#" class="btn">다음글</a>
					</div>
				</div>
			</main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
		</div>
	</body>
</html>