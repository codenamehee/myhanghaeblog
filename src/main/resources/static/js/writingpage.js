// 사용자가 제목을 올바르게 입력했는지 확인하는 함수
function isValidTitle(title) {
    // 제목이 공백일 경우
    if (title === '') {
        alert('제목을 입력해주세요!');
        return false;
    }
    // 제목이 50자 이상일 경우
    if (title.trim().length > 51) {
        alert('제목은 공백 포함 50자 이하로 입력해주세요.');
        return false;
    }
}

// 사용자가 작성자명을 올바르게 입력했는지 확인하는 함수
function isValidUsername(username) {
    //작성자명이 공백일 경우
    if (username === '') {
        alert('이름을 입력해주세요!');
        return false;
    }
    // 작성자명이 11자 이상일 경우
    if (username.trim().length > 11) {
        alert('작성자명은 공백 포함 10자 이하로 입력해주세요.');
        return false;
    }
}

// 사용자가 글 내용을 올바르게 입력했는지 확인하는 함수
function isValidContents(contents) {
    // 내용 부분이 공백일 경우
    if (contents === '') {
        alert('내용을 입력해주세요!');
        return false;
    }
    //내용이 300자 이상일 경우 {
    if (contents.trim().length > 301) {
        alert("공백 포함 300자 이하로 입력해주세요.")
        return false;
    }
}

// 블로그 글 생성 함수
function writePost() {
    // 사용자가 입력할 내용들을 각각 변수에 저장하기
    let title = $('#contents-title').val();
    let username = $('#contents-username').val();
    let contents = $('#contents').val();

    // 제목 작성 확인하기
    if (isValidTitle(title) === false) {
        return; // return 값을 지정하지 않아 undefined 반환
    }

    // 작성자명 작성 확인하기
    if (isValidUsername(username) === false) {
        return;
    }
    // 내용 작성 확인하기
    if (isValidContents(contents) === false) {
        return;
    }

    // 전달한 data를 JSON으로 만들기
    let postdata = {'title': title, 'username': username, 'contents': contents};

    // POST API 활용하여 신규 글 생성하기
    $.ajax({
        type: "POST",
        url: "/api/postings",
        contentType: "application/json", //JSON 형식으로 전달함을 알리기
        data: JSON.stringify(postdata),
        success: function (response) {
            alert('성공적으로 등록되었습니다.');
            window.location.replace("index.html")
        }
    });

}
