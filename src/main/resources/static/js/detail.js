$(document).ready(function () {
    getContentsDetail();
})

function getContentsDetail() {
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
                            <h2 class="page-name">세부 내용 조회</h2>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">제목</span>
                                <input id="${id}-title" type="text" class="form-control" placeholder="${title}" aria-label="Username"
                                       aria-describedby="basic-addon1" disabled>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">작성자 명</span>
                                <input id="${id}-username" type="text" class="form-control" placeholder="${username}" aria-label="Username"
                                       aria-describedby="basic-addon1" disabled>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">작성 날짜</span>
                                <input id="${id}-date" type="text" class="form-control" placeholder="${modifiedAt}" aria-label="Username"
                                       aria-describedby="basic-addon1" disabled>
                            </div>
                            <div class="input-group" style="height: 250px;">
                                <span class="input-group-text">작성 내용</span>
                                <textarea id="${id}-contents" class="form-control" aria-label="With textarea" placeholder="${contents}" disabled></textarea>
                            </div>
                        </div>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-end end-button">
                            <button class="btn btn-primary me-md-2" type="button" onclick="gotoHome()">홈으로</button>
                            <a class="btn btn-primary" href="postupdate.html?id=${id}" role="button">수정하기</a>
                            <button class="btn btn-primary me-md-2" type="button" onclick="deleteOne()">삭제하기</button>
                        </div>
                      </div>`;
    // contents-list에 html 붙이기
    $('#contents-wrap').append(temphtml1);
}

// 버튼 클릭 시 페이지 전환
function gotoHome() {
    window.location.replace("index.html")
}

// 게시물 삭제하기
function deleteOne() {
    let idx = location.href.split("id=")[1];
    $.ajax({
        type: "DELETE",
        url: `/api/postings/${idx}`,
        success: function (response) {
            alert('게시글이 삭제되었습니다.');
            window.location.replace("index.html");
        }
    })
}