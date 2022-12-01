function idValidate(){
	var uid =$("#userId")
	var uidValue = uid.val();
	var uidPattern =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,10}$/g;
	var uidTest = uidPattern.test(uidValue);
	if(uidTest){
		$("#idMessage").text(" ");
	}else{
		$("#idMessage").text("다시 한번 확인해 주십시오.");
	}
}

function pwdValidate(){
	var password = $("#userPwd");
	var passwordValue = password.val();
	var passwordPattern =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/;
	var passwordTest = passwordPattern.test(passwordValue);
	if(passwordTest){
		$("#pwdMessage").text(" ");
	}else{
		$("#pwdMessage").text("다시 한번 확인해 주십시오.");
	}
}
function pwdCheckValidate(){
	var password = $("#userPwd");
	var passwordCheck = $("#userPwdCheck");
	
	if(password.val()==passwordCheck.val()){
		$("#pwdCheckMessage").text(" ");
	}else{
		$("#pwdCheckMessage").text("비밀번호가 다릅니다.");
	}
}
function phoneValidate(){
	var phone = $("#userPhone");
	var phoneValue = phone.val();
	var phonePattern =/^010-\d{3,4}-\d{4}$/;
	var phoneTest = phonePattern.test(phoneValue);
	if(phoneTest){
		$("#phoneMessage").text(" ");
	}else{
		$("#phoneMessage").text("다시 한번 확인해 주십시오.");
	}
}
function emailValidate(){
	var email =$("#userEmail");
	var emailValue = email.val();
	var emailPattern =  /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	var emailTest = emailPattern.test(emailValue);
	if(emailTest){
		$("#emailMessage").text(" ");
	}else{
		$("#emailMessage").text("다시 한번 확인해 주십시오.");
	}
}