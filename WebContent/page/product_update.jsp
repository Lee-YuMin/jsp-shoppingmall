<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% request.setCharacterEncoding("UTF-8"); %>

<html>

<head>
    <title>Shopping-mall</title>
	<script type="text/javascript">
		function changeView()
		{
			location.href='get_product_list';
		}
		
		function doAction()
		{
			location.href="do_product_delete?sequence=${product.sequence}";
		}
			
	</script>
</head>

<body>    
    <div>
        <form method="post" action="do_product_update?sequence=${product.sequence}" class="product-add-container form-product-add" name="productInfo" >
            <div class="grid-container">
                <div class="grid-product-add">
                    <div class="product-add-title">상품 수정</div>

                    <div class="product-add-product-name-title">
                        <label class="form-check-label">상품이름</label>
                    </div>
                    <div class="product-add-product-name-input input-grid">
                        <input class="form-control" name="product_name" value="${product.product_name}">
                    </div>

                    <div class="product-add-age-group-title">
                        <label class="form-check-label">연령 그룹</label>
                    </div>
                    <div class="product-add-age-group-input input-grid">
                        <div class="bfh-selectbox" data-name="age_group" data-value="${product.age_group}">
                            <div data-value="kid">Kid</div>
                            <div data-value="adult">Adult</div>
                            <div data-value="all">All</div>
                        </div>
                    </div>
                    
                    <div class="product-add-type-title">
                        <label class="form-check-label">타입</label>
                    </div>
                    <div class="product-add-type-input input-grid">
                        <div class="bfh-selectbox" data-name="type" data-value="${product.type}">
                            <div data-value="clock">Clock</div>
                            <div data-value="lighting">Lighting</div>
                            <div data-value="flowerpot">Flowerpot</div>
                            <div data-value="storage">Storage</div>
                            <div data-value="toy">Toy</div>
                            <div data-value="etc">etc</div>
                        </div>
                    </div>

                    <div class="product-add-price-title">
                        <label class="form-check-label">가격</label>
                    </div>
                    <div class="product-add-price-input input-grid">
                        <input class="form-control" type="number" name="price" value="${product.price}">
                    </div>

                    <div class="product-add-discount-title">
                        <label class="form-check-label">할인률</label>
                    </div>
                    <div class="product-add-discount-input input-grid">
                        <input class="form-control" type="number" name="discount" placeholder="%" value="${product.discount}">
                    </div>

                    <div class="product-add-hot-title">
                        <label class="form-check-label">핫 체크</label>
                    </div>
                    <div class="product-add-hot-input input-grid">
                    <c:if test="${product.hot}">
                        
					</c:if>	
					
					<c:choose>
						<c:when test="${product.hot == true}">
							<input type="checkbox" class="form-check-input" name="hot" checked>
						</c:when>
						<c:otherwise>
							<input type="checkbox" class="form-check-input" name="hot">
						</c:otherwise>
					</c:choose>
		
                    </div>

                    <div class="product-add-input">
                    
						<input type="submit" class="btn btn-default" value="수정" >
						<input type="button" class="btn btn-default" value="삭제" onclick="doAction()">
						<input type="button" class="btn btn-default" value="목록" onclick="changeView()">
                    </div>
                </div>
            </div>

            
        </form>
    </div>


</body>

</html>