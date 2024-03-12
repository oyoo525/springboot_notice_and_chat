$(function() {
	// 회원가입 유효성검사
	$("#joinForm").on("submit", function(event) {
		if($("#id").val().length <= 0) {
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		if($("#pass").val().length <= 0) {
			alert("비밀번호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		if($("#name").val().length <= 0) {
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return false;
		}
		if($("#nickName").val().length <= 0) {
			alert("닉네임을 입력해주세요.");
			$("#nickName").focus();
			return false;
		}

		let id = $("#id").val();
		$.ajax({
			"url" : "/joinIdCheck.ajax",
			"data" : {"id" : id},
			"type" : "post",
			"dataType" : "json",
			"success" : function(resData) {
				if(Object.keys(resData).length > 0 || resData.constructor !== Object) {
					alert("이미 사용중인 아이디입니다.");
					event.preventDefault();
					return false;
				}
			},
			"error" : function(xhr, status, err) {
				console.log("err : ", err);
			}
		});
	})


	// 로그인 유효성검사
	$("#loginSubmitBtn").on("click", function(){
		let id = $("#id").val();
		let pass = $("#pass").val();
		$.ajax({
			"url" : "/loginCheck.ajax",
			"data" : {"id" : id, "pass" : pass},
			"type" : "post",
			"dataType" : "json",
			"success" : function(resData) {
				if(resData) {
					location.href = '/';
				} else {
					alert("회원정보가 일치하지 않습니다.");
					return ;
				}
			},
			"error" : function(xhr, status, err) {
				console.log("err : ", err);
			}
		});
	})







})