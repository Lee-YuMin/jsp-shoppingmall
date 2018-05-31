<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>��ǰ ����Ʈ</title>
	<script type="text/javascript">
		function addProduct(){
			location.href="product_add";
		}
	</script>

</head>
<body>	

<div id="wrap">

	<!-- �۸�� �� �κ�-->
	<br>
	<div id="topForm">
		<c:if test="${sessionScope.sessionID!=null}">
			<input type="button" value="��ǰ ���" onclick="addProduct()">
		</c:if>	
	</div>
	
	<!-- �Խñ� ��� �κ� -->
	<br>
	<div id="product">
		<table id="pList" width="800" border="3" bordercolor="lightgray">
			<tr heigh="30">
				<td>�̸�</td>
				<td>���ɴ�</td>
				<td>Ÿ��</td>
				<td>����</td>
				<td>���η�</td>
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
	
	<!-- ������ �ѹ� �κ� -->
	<br>
	<div id="pageForm">
		<c:if test="${startPage != 1}">
			<a href='BoardListAction.bo?page=${startPage-1}'>[ ���� ]</a>
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
			<a href='BoardListAction.bo?page=${endPage+1 }'>[����]</a>
		</c:if>
	</div>
	
	<!--  �˻� �κ� -->
	<br>
	<div id="searchForm">
		<form>
			<select name="opt">
				<option value="0">�̸�</option>
				<option value="1">���ɴ�</option>
				<option value="2">Ÿ��</option>
			</select>
			<input type="text" size="20" name="condition"/>&nbsp;
			<input type="submit" value="�˻�"/>
		</form>	
	</div>
</div>	

</body>
</html>