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





})