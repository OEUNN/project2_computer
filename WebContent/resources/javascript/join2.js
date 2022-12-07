
//userId 중복 체크(submit?)
function idCheck(){
	//중복이라면
	if(true){
		
	}else{
		
	}
}

//유효성 검사
function check(){
	var result = false;
	
	//ID 유효성 검사
	var uid =$("#userId");
	var uidValue = uid.val();
	var uidPattern =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,10}$/g;
	var uidTest = uidPattern.test(uidValue);
	if(uidTest){
		$("#idMessage").text(" ");
		uid.classList.remouve("mystyle");
	}else{
		$("#idMessage").text("다시 한번 확인해 주십시오.");
		//한번 써본거
		uid.classList.add("mystyle");
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
		$("#phoneMessage").text(" ");
	}else{
		$("#phoneMessage").text("다시 한번 확인해 주십시오.");
		result=false;
	}
	
	//이메일(중복 x)
	var email =$("#userEmail");
	var emailValue = email.val();
	var emailPattern =  /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	var emailTest = emailPattern.test(emailValue);
	if(emailTest){
		$("#emailMessage").text(" ");
	}else{
		$("#emailMessage").text("다시 한번 확인해 주십시오.");
		result=false;
	}
	
}
