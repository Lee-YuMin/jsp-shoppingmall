<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
    <title>Shopping-mall</title>
</head>

<body>    
    <div>
        <form method="post" action="product_add" class="product-add-container form-product-add" name="productInfo" >
            <div class="grid-container">
                <div class="grid-product-add">
                    <div class="product-add-title">상품 등록</div>

                    <div class="product-add-product-name-title">
                        <label class="form-check-label">상품이름</label>
                    </div>
                    <div class="product-add-product-name-input">
                        <input class="form-control" type="text" name="product_name">
                    </div>

                    <div class="product-add-age-group-title">
                        <label class="form-check-label">연령 그룹</label>
                    </div>
                    <div class="product-add-age-group-input">
                        <div class="bfh-selectbox" data-name="age_group">
                            <div data-value="kid">Kid</div>
                            <div data-value="adult">Adult</div>
                            <div data-value="all">All</div>
                        </div>
                    </div>
                    
                    <div class="product-add-type-title">
                        <label class="form-check-label">타입</label>
                    </div>
                    <div class="product-add-type-input">
                        <div class="bfh-selectbox" data-name="age_group">
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
                    <div class="product-add-price-input">
                        <input class="form-control" type="number" name="price">
                    </div>

                    <div class="product-add-discount-title">
                        <label class="form-check-label">할인률</label>
                    </div>
                    <div class="product-add-discount-input">
                        <input class="form-control" type="number" name="discount" placeholder="%">
                    </div>

                    <div class="product-add-hot-title">
                        <label class="form-check-label">핫 체크</label>
                    </div>
                    <div class="product-add-hot-input">
                        <input type="checkbox" class="form-check-input" name="hot">
                    </div>

                    <div class="product-add-input">
                        <input id="product-submit" class="btn btn-default" type="submit" value="상품등록">
                        <input class="btn btn-default" type="submit" value="메인으로">
                    </div>
                </div>
            </div>

            
        </form>
    </div>


</body>

</html>