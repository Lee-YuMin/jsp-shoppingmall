function checkValue_login() {
    if (!document.userInfo.id.value) {
        alert("아이디를 입력하세요.");
        return false;
    }

    if (!document.userInfo.password.value) {
        alert("비밀번호를 입력하세요.");
        return false;
    }
}