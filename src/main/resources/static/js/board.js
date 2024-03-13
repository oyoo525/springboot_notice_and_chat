$(function() {	
	// 게시글 쓰기 유효성검사
	$("#writeBoardForm").on("submit", function() {
		if($("#title").val().length <= 0) {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		if($("#content").val().length <= 0) {
			alert("내용을 입력해주세요.");
			$("#content").focus();
			return false;
		}
	})

	// 게시글 수정하기 유효성검사
	$("#boardUpdateForm").on("submit", function() {
		if($("#title").val().length <= 0) {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		if($("#writer").val().length <= 0) {
			alert("로그인이 되지 않았습니다.");
			$("#writer").focus();
			return false;
		}
		if($("#content").val().length <= 0) {
			alert("내용을 입력해주세요.");
			$("#content").focus();
			return false;
		}
	})

	// 게시글 삭제하기 프로세스
	$("#boardDeleteBtn").on("click", function() {
		let res = confirm("해당 글을 삭제하시겠습니까?");
		let no = $("#no").val();

		if(res) {
			$.ajax({
				"url" : "boardDelete.ajax",
				"data" : { "no" : no },
				"type" : "post",
				"dataType" : "json",
				"success" : function(resData) {
					console.log("res : ", resData);
					location.href='/';
				},
				"error" : function(xhr, status, err) {
					console.log("err : ", err);
				}
			})
		}
	})

	// 댓글달기 유효성검사
	$("#boardReplyWriteForm").on("submit", function() {
		if($("#id").val().length <= 0) {
			alert("로그인 후 사용할 수 있는 서비스입니다.");
			return false;
		}
		if($("#reply").val().trim().length <= 0) {
			alert("댓글 내용을 입력해주세요.");
			$("#reply").focus();
			return false;
		}
	})

	// 댓글 수정하기 버튼 클릭
	$(".replyUpdateBtn").on("click", function() {
		let replyNo = $(this).data("no");
		let reply = $(this).parent().prev().text();
		console.log(replyNo);
		console.log(reply);

		$("#boardReplyWriteForm").attr("action", "updateReply");
		$("#reply").val(reply);
		$("#replyNo").val(replyNo);
	})

	// 댓글 삭제하기 버튼 클릭
	$(".replyDeleteBtn").on("click", function() {
		let replyNo = $(this).data("no");
		let boardNo = $("#no").val();

		let res = confirm("댓글을 삭제하시겠습니까?");
		if(res) {
			$.ajax({
				"url" : "deleteReply.ajax",
				"data" : {"no" : replyNo},
				"type" : "post",
				"dataType" : "text",
				"success" : function(resData) {
					console.log("res : ", resData);
					if(resData == '삭제완료') {
						location.href='/boardDetail?no='+ boardNo;
					}
				},
				"error" : function(err) {
					console.log("err : ", err);
				}
			})
		}
	})





})