<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품 리스트</title>
	<script type="text/javascript">
		function addProduct(){
			location.href="product_add";
		}
	</script>

</head>
<body>	

<div id="wrap">

	<!-- 글목록 위 부분-->
	<br>
	<div id="topForm">
		<c:if test="${sessionScope.sessionID!=null}">
			<input type="button" value="상품 등록" onclick="addProduct()">
		</c:if>	
	</div>
	
	<!-- 게시글 목록 부분 -->
	<br>
	<div id="product">
		<table id="pList" width="800" border="3" bordercolor="lightgray">
			<tr heigh="30">
				<td>이름</td>
				<td>연령대</td>
				<td>타입</td>
				<td>가격</td>
				<td>할인률</td>
			</tr>
		<c:forEach var="board" items="${requestScope.list}">
			<tr>
				<td>
					<a href="product_update?num=${product.squence}&pageNum=${pageNum}">
					${product.product_name}
					</a>
				</td>
				<td>
					${product.age_group}
				</td>
				<td>
					<a href="#">
					${product.type}
					</a>
				</td>
				<td>${product.price}</td>
				<td>${product.discount}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<!-- 페이지 넘버 부분 -->
	<br>
	<div id="pageForm">
		<c:if test="${startPage != 1}">
			<a href='BoardListAction.bo?page=${startPage-1}'>[ 이전 ]</a>
		</c:if>
		
		<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
			<c:if test="${pageNum == spage}">
				${pageNum}&nbsp;
			</c:if>
			<c:if test="${pageNum != spage}">
				<a href='BoardListAction.bo?page=${pageNum}'>${pageNum}&nbsp;</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage != maxPage }">
			<a href='BoardListAction.bo?page=${endPage+1 }'>[다음]</a>
		</c:if>
	</div>
	
	<!--  검색 부분 -->
	<br>
	<div id="searchForm">
		<form>
			<select name="opt">
				<option value="0">이름</option>
				<option value="1">연령대</option>
				<option value="2">타입</option>
			</select>
			<input type="text" size="20" name="condition"/>&nbsp;
			<input type="submit" value="검색"/>
		</form>	
	</div>
</div>	

</body>
</html>