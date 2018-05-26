<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
    <title>Shopping-mall</title>
</head>

<body>    
    <div>
        <form method="post" action="do-signup" class="signup-container" name="userInfo" onsubmit="return checkValue()">
            <div class="grid-signup control-group">
                <div class="signup-title">회원가입</div>

                <div class="signup-id-title">
                    <label class="form-check-label">아이디</label>
                </div>
                <div class="signup-id-input">
                    <input class="form-control" type="text" name="id">
                </div>

                <div class="signup-password-title">
                    <label class="form-check-label">비밀번호</label>
                </div>
                <div class="signup-password-input">
                    <input class="form-control" type="password" name="password">
                </div>

                <div class="signup-name-title">
                    <label class="form-check-label">이름</label>
                </div>
                <div class="signup-name-input">
                    <input class="form-control" type="text" name="name">
                </div>

                <div class="signup-age-title">
                    <label class="form-check-label">나이</label>
                </div>
                <div class="signup-age-input">
                    <input class="form-control" type="number" name="age">
                </div>

                <div class="signup-gender-title">
                    <label class="form-check-label">성별</label>
                </div>
                <div class="signup-gender-input">
                    <label class="custom-control custom-radio">
                        <input name="gender" type="radio" class="custom-control-input" value="man">
                        <span class="custom-control-description">남</span>
                    </label>
                    <label class="custom-control custom-radio">
                        <input name="gender" type="radio" class="custom-control-input" value="woman">
                        <span class="custom-control-description">여</span>
                    </label>
                </div>

                <div class="signup-phone-title">
                    <label class="form-check-label">핸드폰</label>
                </div>
                <div class="signup-phone-input">
                    <input type="tel" class="form-control bfh-phone" data-format="ddd-dddd-dddd" name="phone">
                </div>

                <div class="signup-introduction-title">
                    <label class="form-check-label">소개</label>
                </div>
                <div class="signup-introduction-input">
                    <input class="form-control" type="text" name="introduction">
                </div>

                <div class="signup-input">
                    <input id="signup-submit" class="btn btn-default" type="submit" value="회원가입">
                    <input class="btn btn-default" type="submit" value="메인으로">
                </div>
            </div>

            
        </form>
    </div>


</body>

</html>