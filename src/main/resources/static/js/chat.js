$(function() {

	let stompClient = null;
	let userName = null;

	function connect() {
		if(userName) {
			let socket = new SockJS('/sehwaChat');
			stompClient = Stomp.over(socket);
			stompClient.connect({}, onConneted, onError);
		}
	}

	function onConneted() {
		stompClient.subscribe("/topic/public", onMessageReceived);
		stompClient.send("/app/chat.register", {}, JSON.stringify({sender : userName, type : 'JOIN'}))
		let connecting = document.querySelector("#connecting");
		connecting.style.display = "none";
	}

	function onError() {
		let connecting = document.querySelector("#connecting");
		connecting.textContent = "서버 연결에 실패하였습니다. 잠시 후 다시 시도해주세요.";
		connecting.style.color = "red";
	}

	function send(event) {
		let inputChat = $("#inputChat").val();
		if(inputChat.length > 0 && stompClient) {
			let chatMessage = {
						sender : userName,
						content : inputChat,
						type : "CHAT"
			}
			stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
			$("#inputChat").val("");
		}
	}

	function onMessageReceived(payload) {
		console.log("onMessageReceived 함수 시작");
		let message = JSON.parse(payload.body);

		let chatArea = document.querySelector("#chatArea");
		let messageElement = document.createElement("li");

		if(message.type == 'JOIN') {
			message.content = message.sender + "님이 입장하셨습니다.";
		} else if(message.type == "LEAVE") {
			message.content = message.sender + "님이 퇴장하셨습니다.";
		} else {
			let profileElement = document.createElement("i");
			let profile = document.createTextNode(message.sender[0]);
			profileElement.appendChild(profile);
			messageElement.appendChild(profileElement);

			let userNameElement = document.createElement("span");
			let userNameText = document.createTextNode(message.sender);
			userNameElement.appendChild(userNameText);
			messageElement.appendChild(userNameElement);
		}

		let textElement = document.createElement("p");
		let messageText = document.createTextNode(message.content);
		textElement.appendChild(messageText);
		messageElement.appendChild(textElement);

		chatArea.appendChild(messageElement);

		chatArea.scrollTop = chatArea.scrollHeight;
	}

	function disconnect() {
		if(stompClient) {
			let chatMessage = {
						sender : userName,
						type : "LEAVE"
			}
			stompClient.send("/app/chat.register", {}, JSON.stringify(chatMessage));
			stompClient.disconnect();
		}
	}


	$(".intoChatRoom").on("click", function() {
		userName = $("#loginId").val();
		connect();
	})

	$("#inputChatForm").on("submit", function(event) {
		event.preventDefault();
		send();
	});

	$("#closeChat").on("click", function() {
		disconnect();

	})














})