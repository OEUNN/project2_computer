
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
	var uid =$("#userId");
	var uidValue = uid.val();
	var uidPattern =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,10}$/g;
	var uidTest = uidPattern.test(uidValue);
	if(uidTest){
		uid.removeClass("bg-danger");
	}else{
		//한번 써본거
		uid.addClass("bg-danger");
		result=false;
	}
	
	//비밀번호 
	var password = $("#userPwd");
	var passwordValue = password.val();
	var passwordPattern =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/;
	var passwordTest = passwordPattern.test(passwordValue);
	if(passwordTest){
		$("#pwdMessage").text(" ");
	}else{
		$("#pwdMessage").text("다시 한번 확인해 주십시오.");
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
		phone.removeClass("bg-danger");
	}else{
		phone.addClass("bg-dnager");
		result=false;
	}
	
	//이메일(중복 x)
	var email =$("#userEmail");
	var emailValue = email.val();
	var emailPattern =  /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	var emailTest = emailPattern.test(emailValue);
	if(emailTest){
		email.removeClass("bg-danger");
	}else{
		email.addClass("bg-dnager");
		result=false;
	}
	
	
	
}

//주소
window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}