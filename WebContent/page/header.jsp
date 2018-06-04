<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
</head>

<body>
    <div>
        <div class='center-div'>
            <ul>
                <li>
                    <a href="do_user_delete">회원탈퇴</a>
                </li>
                <li class="inactivity">
                    <a href="">리뷰</a>
                </li>
                <li class="inactivity">
                    <a href="">나눔게시판</a>
                </li>
                <li>
           			<c:if test="${sessionScope.sessionID!=null}">
						<a href="logout">로그아웃</a>
					</c:if>	
					<c:if test="${sessionScope.sessionID==null}">
						<a href="login">로그인</a>
					</c:if>	
                </li>
                <li>
                    <a href="signup">회원가입</a>
                </li>
                <li class="inactivity">
                    <a href="">마이페이지</a>
                </li>
                <li class="inactivity">
                    <a href="">장바구니</a>
                </li>
                <li class="inactivity">
                    <a href="">주문조회</a>
                </li>
                <li class="inactivity">
                    <a href="">커뮤니티</a>
                </li>
                <li class="inactivity">
                    <a href="">b2b/도매</a>
                </li>
                <li class="inactivity">
                    <a href="">매장안내</a>
                </li>
                <li class="inactivity">
                    <a href="">페이스북</a>
                </li>
                <li class="inactivity">
                    <a href="">인스트</a>
                </li>
                <li>
                    <a href="product_add">상품 등록</a>
                </li>
            </ul>
        </div>
    </div>

    <div id="header">
        <header>
            <div id="contain-banner">
                <span class="centered">
                    <a id="banner" href="main">
                        <img src="image/banner.jpg">
                    </a>
                </span>
            </div>
            <div id="menu-bar">
                <div class="menu-list">
                    <a href="#home">시계</a>
                    <a href="#news">전등</a>
                    <a href="#contact">화분</a>
                    <a href="#about">수납</a>
                    <a href="#contact">장난감</a>
                    <a href="#about">기타</a>
                </div>
            </div>

        </header>
    </div>
</body>

</html>