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
		
		function modeDelete(){
			var values = document.getElementsByName('delete_id');
			var isChecked = false;
			var sequences = [];
			
			for(var i=0; i<values.length; i++){
				if(values[i].checked){
					sequences.push(values[i].value);
				}	
			}
			
			if(sequences.length != 0){
				var form = document.createElement('form');
				
				sequences.forEach(function(v){
					 var input=document.createElement("input");
					 input.type = "text";
					 input.name = 'delete_id';
					 input.value = v;
					 form.appendChild(input);
				})
				form.name = 'form';
				form.method = 'post';
				form.action = "product_multi_delete"; 
				document.body.appendChild(form);
				form.submit(); 
			}
			else{
				return;
			}
		}
	</script>

</head>
<body>	

<div id="wrap">

	<!-- �۸�� �� �κ�-->
	<br>
	<div id="topForm">
		<c:if test="${sessionScope.sessionID!=null}">
			<input type="button" value="���� ����" onclick="modeDelete()">
			<input type="button" value="��ǰ ���" onclick="addProduct()">
		</c:if>	
	</div>
	
	<!-- �Խñ� ��� �κ� -->
	<br>
	<div id="product">
		<table id="pList" width="800" border="3" bordercolor="lightgray" class="table table-condensed">
		<thead>
			<tr height="30">
			<c:if test="${sessionScope.sessionID!=null}">
				<th>üũ</th>
			</c:if>
				<th>�̸�</th>
				<th>���ɴ�</th>
				<th>Ÿ��</th>
				<th>����</th>
				<th>���η�</th>
				<th>HOT</th>
				<th>��������</th>
			</tr>
		</thead>
		<c:forEach var="product" items="${requestScope.list}">
		<tbody>
			<tr>
				<c:if test="${sessionScope.sessionID!=null}">
					<td>
						<input type="checkbox" class="form-check-input" name="delete_id" value="${product.sequence}">
					</td>
				</c:if>
				<td>
					<a href="get_product_update?sequence=${product.sequence}&page=${pageNum}">
					${product.product_name}
					</a>
				</td>
				<td>
					${product.age_group}
				</td>
				<td>
					${product.type}
				</td>
				<td>${product.price}</td>
				<td>${product.discount}</td>
				<td>${product.hot}</td>
				<td>${product.created_date}</td>
				
			</tr>
		</tbody>
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