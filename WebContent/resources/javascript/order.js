
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

//유효성 검사
function check(){
	var result = true;
	//닉네임
	var userId=$("#user_id");
	if(userId != ""){
		userId.removeClass("mystyle");
	}else{
		userId.addClass("mystyle");
		result=false;
	}
	
	//닉네임
	var userPhone=$("#user_phone");
	if(userPhone != ""){
		userPhone.removeClass("mystyle");
	}else{
		userPhone.addClass("mystyle");
		result=false;
	}
	
	//닉네임
	var userPost=$("#userPost");
	if(userPost != 0){
		userPost.removeClass("mystyle");
	}else{
		userPost.addClass("mystyle");
		result=false;
	}
	
	//닉네임
	var userAddr=$("#userAddr");
	if(userAddr != ""){
		userAddr.removeClass("mystyle");
	}else{
		userAddr.addClass("mystyle");
		result=false;
	}
	
	var userDetailAddr=$("#userDetailAddr");
	if(userDetailAddr != ""){
		userDetailAddr.removeClass("mystyle");
	}else{
		userDetailAddr.addClass("mystyle");
		result=false;
	}
	return result;
}