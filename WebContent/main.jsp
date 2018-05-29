<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contentPage=request.getParameter("contentPage");
	if(contentPage==null)
		contentPage="page/product_list.jsp";
%>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<html>
<head>
<title>쇼핑몰</title>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript"></script>
    
    <!-- Bootstrap -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- Bootstrap Form Helpers -->
    <script src="BootstrapFormHelpers/dist/js/bootstrap-formhelpers.min.js"></script>
    <script src="js/signup-check-value.js"></script>
    <script src="js/login-check-value.js"></script>
    
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="BootstrapFormHelpers/dist/css/bootstrap-formhelpers.min.css" rel="stylesheet" media="screen">
    <link href="css/control-bar.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/manu-bar.css" rel="stylesheet">
    <link href="css/grid-signup.css" rel="stylesheet">
    <link href="css/grid-product-add.css" rel="stylesheet">
    <link href="css/signup-sucess.css" rel="stylesheet">
    <link href="css/product-list.css" rel="stylesheet">
    
</head>
<body>
	<div>
		<div id="control-bar">
			<jsp:include page="page/header.jsp" />
		</div>
		<div id="content" >
			<jsp:include page="<%=contentPage%>" />
		</div>
		<div id="footer"> 하단 </div>
	</div>
</body>
</html>