function checkValue() {
    if (!document.userInfo.id.value) {
        alert("아이디를 입력하세요.");
        return false;
    }

    if (!document.userInfo.password.value) {
        alert("비밀번호를 입력하세요.");
        return false;
    }

    if (!document.userInfo.name.value) {
        alert("이름을 입력하세요.");
        return false;
    }

    if (!document.userInfo.age.value) {
        alert("나이를 입력하세요.");
        return false;
    }

    if (!document.userInfo.gender.value) {
        alert("성별을 선택하세요.");
        return false;
    }

    if (!document.userInfo.phone.value) {
        alert("전화번호를 입력하세요.");
        return false;
    }

    if (!document.userInfo.introduction.value) {
        alert("소개를 입력하세요.");
        return false;
    }

    // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인 <--- 나중에 쓸가봐 남겨둠
    if (document.userInfo.password.value != document.userInfo.passwordcheck.value) {
        alert("비밀번호를 동일하게 입력하세요.");
        return false;
    }
}