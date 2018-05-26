<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
    <title>Shopping-mall</title>
</head>

<body>    
    <div>
        <form method="post" action="do-login" class="signup-container" name="userInfo" onsubmit="return checkValue_login()">
            <div class="grid-signup control-group">
                <div class="signup-title">로그인</div>

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

                <div class="signup-input">
                    <input id="signup-submit" class="btn btn-default" type="submit" value="로그인">
                </div>
            </div>

            
        </form>
    </div>


</body>

</html>