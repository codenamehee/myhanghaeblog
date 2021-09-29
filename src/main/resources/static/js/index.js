$(document).ready(function(){
    getPostings();
})

function getPostings() {
    // $('contents-list').empty();
    $.ajax({
        type: 'GET',
        url: '/api/postings',
        success: function(response) {
            for (let i=0; i<response.length; i++) {
                let content = response[i];
                let id = content['id'];
                let username = content['username'];
                let title = content['title'];
                // let contents = content['contents'];
                let modifiedAt = content['modifiedAt'];
                addHTML(id, username, title, modifiedAt);
            }
        }
    })
}

function addHTML(id, username, title, modifiedAt) {
    // HTML 태그 만들기
    let temphtml = `<div class="list-group" id="contents-list">
                        <ul class="list-group list-group-horizontal">
                            <li class="list-group-item" style="width: 80px">${id}</li>
                            <li class="list-group-item" >${username}</li>
<!--                            게시글마다 id값에 따른 서로 다른 주소를 지정해주기. 이를 통해 상세 페이지로 이동 가능-->
                            <a href="detail.html?id=${id}" class="list-group-item list-group-item-action">${title}</a>
                            <li class="list-group-item">${modifiedAt}</li>
                        </ul>
                     </div>`;
    // contents-list에 html 붙이기
    $('#contents-list').append(temphtml);
}