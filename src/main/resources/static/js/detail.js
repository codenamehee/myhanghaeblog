// th:inline="javascript"
//
// $(document).ready(function () {
//     getContentsDetail();
//     // getComments();
// })
//
// function getContentsDetail() {
//     $('#contents-wrap').empty();
//     let postid = location.href.split("id=")[1];
//     $.ajax({
//         type: 'GET',
//         url: `/api/postings/${postid}`,
//         data: {},
//         success: function (response) {
//             let detailcontent = response;
//             let id = detailcontent.id;
//             let username = detailcontent.username;
//             let title = detailcontent.title;
//             let contents = detailcontent.contents;
//             let modifiedAt = detailcontent.modifiedAt;
//             detailHTML(id, title, username, modifiedAt, contents);
//
//         }
//     });
// }
//
// function detailHTML(id, title, username, modifiedAt, contents) {
//     // HTML 태그 만들기
//     let temphtml1 = `<div id="contents-wrap">
//                         <div class="contents-box">
//                             <h2 class="page-name">세부 내용 조회</h2>
//                             <div class="input-group mb-3">
//                                 <span class="input-group-text" id="basic-addon1">제목</span>
//                                 <input id="${id}-title" type="text" class="form-control" placeholder="${title}" aria-label="Username"
//                                        aria-describedby="basic-addon1" disabled>
//                             </div>
//                             <div class="input-group mb-3">
//                                 <span class="input-group-text" id="basic-addon1">작성자 명</span>
//                                 <input id="${id}-username" type="text" class="form-control" placeholder="${username}" aria-label="Username"
//                                        aria-describedby="basic-addon1" disabled>
//                             </div>
//                             <div class="input-group mb-3">
//                                 <span class="input-group-text" id="basic-addon1">작성 날짜</span>
//                                 <input id="${id}-date" type="text" class="form-control" placeholder="${modifiedAt}" aria-label="Username"
//                                        aria-describedby="basic-addon1" disabled>
//                             </div>
//                             <div class="input-group" style="height: 250px;">
//                                 <span class="input-group-text">작성 내용</span>
//                                 <textarea id="${id}-contents" class="form-control" aria-label="With textarea" placeholder="${contents}" disabled></textarea>
//                             </div>
//                         </div>
//                         <div class="d-grid gap-2 d-md-flex justify-content-md-end end-button">
//                             <button class="btn btn-primary me-md-2" type="button" onclick="gotoHome()">홈으로</button>
//                             <a class="btn btn-primary" href="postupdate.html?id=${id}" role="button">수정하기</a>
//                             <button class="btn btn-primary me-md-2" type="button" onclick="deleteOne()">삭제하기</button>
//                         </div>
//                       </div>`;
//     // contents-list에 html 붙이기
//     $('#contents-wrap').append(temphtml1);
// }
//
// // 버튼 클릭 시 페이지 전환
// function gotoHome() {
//     window.location.href="/";
// }
//
// // // 게시물 삭제하기
// function deleteOne() {
//     let idx = location.href.split("id=")[1];
//     $.ajax({
//         type: "DELETE",
//         url: `/api/postings/${idx}`,
//         success: function (response) {
//             alert('게시글이 삭제되었습니다.');
//             window.location.href="/";
//         }
//     })
// }
//
// // // <!-------댓글--------->
// // // 댓글 불러오기
// function getComments() {
//     let postId = location.href.split("id=")[1];
//     $.ajax({
//         type: "GET",
//         url: `/api/comments/${postId}`,
//         data: {},
//         success: function(response) {
//             for (let i=0; i<response.length; i++) {
//                 let post = response[i];
//                 let id = post.id;
//                 let username = post.username;
//                 let comment = post.comment;
//                 let modifiedAt = post.modifiedAt;
//                 addCommentHTML(id, username, comment, modifiedAt);
//             }
//         }
//     });
// }
//
// // // 댓글 html에 붙여주기
// function addCommentHTML(id, username, comment, modifiedAt) {
//     let tempHtml = makecomment(id, username, comment, modifiedAt);
//     $('#comment-box').append(tempHtml);
// }
// //
// // // 댓글 형태 만들기
// function makecomment(id, username, comment, modifiedAt) {
//     let loginUsername = [[${username}]];
//     console.log(loginUsername)
//     let hide = "hide"
//     if (loginUsername === username) {
//         hide = ""
//     }
//     return `<div class="card w-75">
//                 <div class="card-body">
//                     <h6 id="${id}-name" class="card-title comment-name">${username}</h6>
//                     <p id="${id}-date" class="card-title comment-date">${modifiedAt}</p>
//                     <p id="${id}-comment" class="card-text comment-contents">${comment}</p>
//     <!--                <a href="#" class="btn btn-primary">수정</a>-->
//                 </div>
//             </div>`;
// }
//
//
// // 댓글 입력 여부 확인
// function isValidComments(comments) {
//     if(comments === '') {
//         alert('댓글 내용을 입력해주세요.');
//         return false;
//     }
//     return true;
// }
//
// // // 댓글 작성하기
// function writeComment() {
//     let postid = location.href.split("id=")[1];
//     // let username = [[${username}]];
//     //
//     var username = [[${username}]];
//     let comment = $('#comment').val();
//     if (isValidComments(comment) === false) {
//         return;
//     }
//
//     let data = {'postid': postid, 'username': username, 'comment': comment};
//
//     $.ajax({
//         type: "POST",
//         url: "/api/comments",
//         contentType: "application/json",
//         data: JSON.stringify(data),
//         success: function (response) {
//             if (response === true) {
//                 alert('메시지가 성공적으로 작성되었습니다.');
//                 window.location.reload();
//             } else {
//                 alert('로그인을 해주세요');
//                 window.location.href("/user/login");
//             }
//         },
//         error: function (xhr, ajaxOptions, thrownError) {
//             alert('로그인을 해주세요.');
//             window.location.href("/user/login");
//         }
//     });
// }
//
