<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap" rel="stylesheet">
		<style>
			*{
	            margin:0px;
	            padding:0px;
	            box-sizing: border-box;
	            font-family: 'Jua', sans-serif;
	         }
	         
	        #top{
				background:#0c1c32;
				height:100px;
			}
		
			#logo b{
				background-color:#0c1c32;
				color:white;
				font-size:300%;
				font-family: 'Black Han Sans', sans-serif;
			}
	        #body > .card{
	            background-color:black;
	            width:1000px;
	         }
			#join_Wrapper{
				width:500px;
				margin: 50px auto;
			}
			
			#join_main{
				width:100%;
				padding: 10px 20px;
			}
			#join_submit{
				width:80%;
			}
		</style>
	</head>
	<body>
		 <div class="container-fluid">
         	<!-- 가장위 logo -->
			<div id="top" class="row">
				<div id="logo" class="btn mt-3">
					<a href="../product/ProductListController"><b>SAMSUNG</b></a>
				</div>
			</div>

			<div id="join_Wrapper" class="row">
				<form class="join_main col-8 col-md-12" action="../product/ProductListController">
					<!-- 아이디입력 -->
					<div class="form-group ">
						<label for="user_id" class="join_title">아이디</label>
						
						<input id="user_id" type="text" class="form-control " />
						<small id="user_idHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 6자 이상 10장 이하</small>
						<p id="id_message"></p>
					</div>
					
					<!-- 비밀번호 입력및 비밀번호 확인 -->
					<div class="form-group">
						<label for="user_pwd" class="join_title">비밀번호</label>
						<input id="user_pwd" type="text" class="form-control" />
						<small id="user_pwdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 8자 이상 15장 이하</small>
						<p id="pwd_message"></p>
					</div>
					<div class="form-group">
						<label for="user_pwd_check" class="join_title">비밀번호 확인</label>
						<input id="user_pwd_chedk" type="text" class="form-control" />
						<p id="pwd_check_message"></p>
					</div>
					<!-- 이름 -->
					<div class="form-group">
						<label for="user_name" class="join_title">이름</label>
					
						<input id="user_name" type="text" class="form-control"/>
						<p id="name_message"></p>
					</div>
					
					<!-- 전화번호 -->
					<div class="form-group">
						<label for="user_phone" class="join_title">전화번호</label>
						<input id="user_phone" type="text" class="form-control"/>
						<small id="user_phoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
						<p id="phone_message"></p>
					</div>
					<!-- 이메일 -->
					<div class="form-group">	
						<label for="user_email" class="join_title">이메일</label>
						<input id="user_email" type="text" class="form-control"/>
						<p id="email_message"></p>
					</div>
					<!-- 닉네임 -->
					<div class="form-group">	
						<label for="user_nickname" class="join_title">닉네임</label>
						<input id="user_nickname" type="text" class="form-control"/>
						<p id="nick_message"></p>
					</div>
					<!-- 주소 -->
					<div class="form-group">
						<label for="user_address" class="join_title">주소</label>
						<input id="user_address" type="text" class="form-control"/>
						<p id="address_message"></p>
					</div>
					<!-- submit -->
					<div class="text-center mt-4"> <a href="#">
						<input id="join_submit" type="submit" class="btn btn-dark" value="Join"/></a>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>