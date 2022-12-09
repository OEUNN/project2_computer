
//userId 중복 체크(submit?)
function idCheck(){
	//중복이라면
	if($("#userId").val() != ''){
		$.ajax({
			type: 'post',
			url : 'CheckController',
			data : {check : "id" , value : $("#userId").val()},
			success : function(data){
				let result = data.result;
				if(result == false){
					$("#idMessage").text('사용 가능한 아이디입니다.');
				}else{
					$("#idMessage").text('이미 사용중인 아이디 입니다.');
				}
			}
		});
	}else{
		console.log("입력 없음");
	}
};

//전화번호
function  phoneCheck(){
	//중복이라면
	if($("#userPhone").val() != ''){
		$.ajax({
			type: 'post',
			url : 'CheckController',
			data : {check : "phone" , value : $("#userPhone").val()},
			success : function(data){
				let result = data.result;
				if(result == false){
					
				}else{
					$("#phoneMessage").text('이미 사용중인 전화번호 입니다.');
				}
			}
		});
	}else{
		console.log("입력 없음");
	}
};

//이메일
function emailCheck(){
	//중복이라면
	if($("#userEmail").val() != ''){
		$.ajax({
			type: 'post',
			url : 'CheckController',
			data : {check : "email" ,value : $("#userEmail").val()},
			success : function(data){
				let result = data.result;
				if(result == false){
					
				}else{
					$("#emailMessage").text('이미 사용중인  이메일 입니다.');
				}
			}
		});
	}else{
		console.log("입력 없음");
	}
};

//유효성 검사
function check(){
	var result = true;
	
	//ID 유효성 검사
	if($('#userId').val() != ''){
		$('#userId').removeClass("mystyle");
	}else{
		$('#userId').addClass("mystyle");
		result= false;
	}
	
	//비밀번호 
	var password = $("#userPwd");
	var passwordValue = password.val();
	var passwordPattern =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/;
	var passwordTest = passwordPattern.test(passwordValue);
	if(passwordTest){
		$("#pwdMessage").text(" ");
		password.removeClass("mystyle");
	}else{
		$("#pwdMessage").text("다시 한번 확인해 주십시오.");
		password.addClass("mystyle");
		result=false;
	}
	
	//비밀 번호 한번더 확인
	var passwordCheck = $("#userPwdCheck");
	
	if(password.val()==passwordCheck.val()){
		$("#pwdCheckMessage").text(" ");
	}else{
		$("#pwdCheckMessage").text("비밀번호가 다릅니다. 다시입력해주세요");
		result=false;
	}
	
	//전화번호(중복 x)
	var phone = $("#userPhone");
	var phoneValue = phone.val();
	var phonePattern =/^010-\d{3,4}-\d{4}$/;
	var phoneTest = phonePattern.test(phoneValue);
	if(phoneTest){
		phone.removeClass("mystyle");
	}else{
		phone.addClass("mystyle");
		result=false;
	}
	
	//이메일(중복 x)
	var email =$("#userEmail");
	var emailValue = email.val();
	var emailPattern =  /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	var emailTest = emailPattern.test(emailValue);
	if(emailTest){
		email.removeClass("mystyle");
	}else{
		email.addClass("mystyle");
		result=false;
	}
	
	//닉네임
	if($('#userNickname').val() != ''){
		$('#userNickname').removeClass("mystyle");
	}else{
		$('#userNickname').addClass("mystyle");
		result= false;
	}
	
	return result;
}

function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('userPost').value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("userAddr").value = roadAddr;
            } 
            else if(jibunAddr !== ''){
                document.getElementById("userAddr").value = jibunAddr;
            }
        }
    }).open();
}