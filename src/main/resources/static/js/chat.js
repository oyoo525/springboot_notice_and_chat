$(function() {

	let stompClient = null;
	let userName = null;
	let uuid = "";

	let colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
	];

	$("#makeChatRoom").on("submit", function() {
		if($("#makeChatRoomName").val().trim() <= 0) {
			alert("방 이름을 적어주세요.");
			return false;
		}
	})



	function connect() {
		if(userName) {
			let socket = new SockJS('/sehwaChat');
			stompClient = Stomp.over(socket);
			stompClient.connect({}, onConneted, onError);
		}
	}

	function onConneted() {
		stompClient.subscribe("/topic/" + uuid, onMessageReceived);
		stompClient.send("/app/chat.register/" + uuid , {}, JSON.stringify({sender : userName, type : 'JOIN', uuid : uuid}))
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
						type : "CHAT",
						uuid : uuid
			}
			stompClient.send("/app/chat.send/" + uuid, {}, JSON.stringify(chatMessage));
			$("#inputChat").val("");
		}
	}

	function onMessageReceived(payload) {
		let message = JSON.parse(payload.body);

		let chatArea = document.querySelector("#chatArea");
		let messageElement = document.createElement("li");

		if(message.type == 'JOIN') {
			messageElement.classList.add('chat-message');
			message.content = message.sender + "님이 입장하셨습니다.";
		} else if(message.type == "LEAVE") {
			messageElement.classList.add('chat-message');
			message.content = message.sender + "님이 퇴장하셨습니다.";
		} else {
			messageElement.classList.add('chat-message');

			let profileElement = document.createElement("i");
			let profile = document.createTextNode(message.sender[0]);
			profileElement.appendChild(profile);
			// profileElement.classList.add('bg-primary');
			profileElement.style.backgroundColor = getAvatarColor(message.sender);
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
			stompClient.send("/app/chat.register/" + uuid , {}, JSON.stringify(chatMessage));
			stompClient.disconnect();
		}
	}

	function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}


	$(".intoChatRoom").on("click", function() {
		userName = $("#loginId").val();
		uuid = $(this).data("uuid");
		connect();
		$("#chat-room").css("display", "block");
		$("#chat-list").css("display", "none");


	})

	$("#inputChatForm").on("submit", function(event) {
		event.preventDefault();
		send();
	});

	$("#closeChat").on("click", function() {
		disconnect();
		$("#chat-room").css("display", "none");
		$("#chat-list").css("display", "block");
		$("#chatArea").text("");
	
	})














})