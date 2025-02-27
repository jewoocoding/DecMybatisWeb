<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="../../../resources/css/reset.css">
<link rel="stylesheet" href="../../../resources/css/header.css">
<link rel="stylesheet" href="../../../resources/css/footer.css">
<link rel="stylesheet" href="../../../resources/css/loginMain.css">
</head>
<body>
    <header id="container">
        <jsp:include page="/WEB-INF/views/include/header.jsp"/>
        <main id="main">
            <div class="login-container">
                <div class="login-title">
                    <h2>로그인</h2>
                    <p>제주의 꿈과 함께하는 여행</p>
                </div>
                <form class="login-form" action="/member/login" method="post">
                    <div class="form-group">
                        <label for="">아이디</label>
                        <input type="text" name = "memberId">
                    </div>
                    <div class="form-group">
                        <label for="">비밀번호</label>
                        <input type="password" name = "memberPw">
                    </div>
                    <button type="submit">로그인</button>
                    <div class="login-link">
                        <a href="">아이디 찾기</a>
                        <a href="">비밀번호 찾기</a>
                        <a href="/member/signup">회원가입</a>
                    </div>
                </form>
            </div>
        </main>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </header>
</body>
</html>