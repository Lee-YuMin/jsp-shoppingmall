<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%-- 자바빈 클래스 import --%>
<%@ page import="com.shopping.UserDTO" %>
<%-- DAO import --%>
<%@ page import="com.shopping.UserDAO" %>

<html>
    <head>
        <title>회원가입 처리 JSP</title>

        <!-- css 파일 분리 -->
        <link href='../../css/join_style.css' rel='stylesheet' style='text/css'/>
    </head>

    <body>
        <%-- JoinForm.jsp에서 입력한 정보를 넘겨 받아 처리한다. --%>
        <% 
            // 한글 깨짐을 방지하기 위한 인코딩 처리
            request.setCharacterEncoding("UTF-8"); 
        %>

        <%-- 자바빈 관련 액션태그 사용 --%>
        <jsp:useBean id="userDTO" class="com.shopping.UserDTO"/>
        <jsp:setProperty property="*" name="userDTO"/>

        <%
            UserDAO dao = UserDAO.getInstance();

            // 회원정보를 담고있는 userDTO을 dao의 insertMember() 메서드로 넘긴다.
            // insertMember()는 회원 정보를 JSP_MEMBER 테이블에 저장한다.
            dao.insertMember(userDTO);
        %>

         <%-- forword로 성공화면으로 이동? --%>

    </body>
</html>