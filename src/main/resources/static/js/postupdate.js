$(document).ready(function () {
    getDetail();
})

function getDetail() {
    $('#contents-wrap').empty();
    let idx = location.href.split("id=")[1];
    $.ajax({
        type: 'GET',
        url: `/api/postings/${idx}`,
        data: {},
        success: function (response) {
            let detailcontent = response;
            let id = detailcontent.id;
            let username = detailcontent.username;
            let title = detailcontent.title;
            let contents = detailcontent.contents;
            let modifiedAt = detailcontent.modifiedAt;
            detailHTML(id, title, username, modifiedAt, contents);

        }
    });
}

function detailHTML(id, title, username, modifiedAt, contents) {
    // HTML 태그 만들기
    let temphtml1 = `<div id="contents-wrap">
                        <div class="contents-box">
                            <h2 class="page-name">수정하기</h2>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">제목</span>
                                <input id="${id}-title" type="text" class="form-control" value="${title}" aria-label="Username"
                                       aria-describedby="basic-addon1" >
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">작성자 명</span>
                                <input id="${id}-username" type="text" class="form-control" value="${username}" aria-label="Username"
                                       aria-describedby="basic-addon1" disabled>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">작성 날짜</span>
                                <input id="${id}-date" type="text" class="form-control" placeholder="${modifiedAt}" aria-label="Username"
                                       aria-describedby="basic-addon1" disabled>
                            </div>
                            <div class="input-group" style="height: 250px;">
                                <span class="input-group-text">작성 내용</span>
                                <textarea id="${id}-contents" class="form-control" aria-label="With textarea" >${contents}</textarea>
                            </div>
                        </div>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-end end-button">
                            <button class="btn btn-primary me-md-2" type="button" onclick="gotoHome()">홈으로</button>
                            <a class="btn btn-primary" role="button" onclick="submitEdit()">완료하기</a>
                        </div>
                      </div>`;
    // contents-list에 html 붙이기
    $('#contents-wrap').append(temphtml1);
}

// 수정하기
// function isValidTitle(title) {
//     // 제목이 공백일 경우
//     if (title === '') {
//         alert('제목을 입력해주세요!');
//         return false;
//     }
    // 제목이 50자 이상일 경우
    // if (title.trim().length > 51) {
    //     alert('제목은 공백 포함 50자 이하로 입력해주세요.');
    //     return false;
    // }
// }

// 사용자가 글 내용을 올바르게 입력했는지 확인하는 함수
// function isValidContents(contents) {
//     // 내용 부분이 공백일 경우
//     if (contents === '') {
//         alert('내용을 입력해주세요!');
//         return false;z
//     }
    //내용이 300자 이상일 경우 {
    // if (contents.trim().length > 301) {
    //     alert("공백 포함 300자 이하로 입력해주세요.")
    //     return false;
    // }
// }

function submitEdit() {
    let idx = location.href.split("id=")[1];

    let title = $(`#${idx}-title`).val();
    let username = $(`#${idx}-username`).val();
    let contents = $(`#${idx}-contents`).val();

    // if (isValidTitle(title) === false) {
    //     return;
    // }
    //
    // if (isValidContents(contents) === false) {
    //     return;
    // }

    let data = {'title': title, 'username': username, 'contents': contents};


    $.ajax({
        type: "PUT",
        url: `/api/postings/${idx}`,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function(response) {
            alert('게시글이 수정되었습니다.');
            window.location.href="/";
        }
    })
}

// 홈으로 버튼 클릭 시 페이지 전환
function gotoHome() {
    window.location.href="/";
}
