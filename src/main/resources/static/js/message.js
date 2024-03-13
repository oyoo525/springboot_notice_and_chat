$(function() {

	let possibleSendMessage = false;
	
	// 메세지 받는 사람 유효성 검사
	$("#sendMessageFormToId").on("blur", function() {
		let id = $(this).val().trim();

		$.ajax({
			"url" : "joinIdCheck.ajax",
			"data" : {"id" : id},
			"type" : "post",
			"dateType" : "json",
			"success" : function(resData) {
				if(Object.keys(resData).length <= 0) {
					alert("회원 아이디가 올바르지 않습니다.");
					possibleSendMessage = false;
				} else {
					possibleSendMessage = true;
				}
			},
			"error" : function(err) {	
				console.log("err : ", err)
			}
		})
	})

	// 메세지 보내기 유효성검사
	$("#sendMessageForm").on("submit", function() {
		if(!possibleSendMessage) {
			alert("메세지를 보낼 아이디를 확인해주세요.");
			return false;
		}
		if($("#content").val().trim().length <= 0) {
			alert("보낼 메세지를 입력해주세요.");
			$("#content").focus();
			return false;
		}
	})



})