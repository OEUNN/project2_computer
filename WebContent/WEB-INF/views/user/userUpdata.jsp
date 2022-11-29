<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 수정</title>
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
	            background-color: #f3f3f3;
	         }
	         img{
				width:100%;
				height:100%;
			}
			#back{
				padding-bottom: 100px;
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
			#menu{
				background-color: white;
				border-radius: 0px 50px 0px 0px;
				box-shadow: 5px 5px 10px grey;
			}
			
			#menu div,a{
				background-color: white;
				color:black;
			}
			
			#centerText{
				color:black;
				font-size: 250%;
			}
			#updataMain{
				background-color: white;
				border-radius:15px;
				box-shadow: 5px 5px 10px grey;
			}
			#updataMain *{
				background-color: white;
			}
			#joinSubmit{
				background-color:#0c1c32;
				color:white;
				widht:200px;
			}
			
		</style>
	</head>
	<body>
		 <div id="back" class="container-fluid">
         	<!-- 가장위 logo -->
			<div id="top" class="row">
				<div id="logo" class="btn mt-3">
					<a href="../product/ProductListController"><b>SAMSUNG</b></a>
				</div>
			</div>
			
			<!-- home가는 버튼 -->
			<div id="blank" class="row" style="height:50px;background-color:white; "></div>

			<!-- 몸통 -->
			<div id="body" class="row">
				
				<!-- menu -->
				<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
					<div class="ml-5 mt-5 btn btn-black btn-sm" style="font-size:200%;">
						<a href="../user/MypageController">마이페이지</a>
						<div class="row m-3">
							<div id="userUpdate"class="btn btn-black btn-sm">
								<a  href="../user/UserUpdataController" >>개인정보</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="orderList" class="btn btn-black btn-sm">
								<a href="../user/OrderListController">>주문내역</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="cartList" class="btn btn-black btn-sm">
								<a  href="../product/BasketListController">>장바구니</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="content" class="btn btn-black btn-sm">
							<a href="../board/QnaBoardController">>1:1 문의</a>
						</div>
						</div>
					</div>
				</div>
			
				<!-- 개인정보 수정 페이지 -->
				<div id="centerBoard" class="col-12 col-md mt-5 mr-5">
				
					<div id="centerText" class="row mt-5 ml-3">개인 정보 수정</div>
					
					<div id="updataMain"  class="col-8 col-md-12 m-3">
						<form class="p-5" action="../product/ProductListController">
							<!-- 아이디입력 -->
							<div class="form-group m-4">
								<label for="userEd" class="joinTitle">아이디</label>
								
								<input id="userId" type="text" class="form-control " />
								<small id="userIdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 6자 이상 10장 이하</small>
								<p id="idMessage"></p>
							</div>
							
							<!-- 비밀번호 입력및 비밀번호 확인 -->
							<div class="form-group m-4">
								<label for="userPwd" class="joinTitle">비밀번호</label>
								<input id="userPwd" type="text" class="form-control" />
								<small id="userPwdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 8자 이상 15장 이하</small>
								<p id="pwdMessage"></p>
							</div>
							<div class="form-group m-4">
								<label for="userPwdCheck" class="joinTitle">비밀번호 확인</label>
								<input id="userPwdChedk" type="text" class="form-control" />
								<p id="pwdCheckMessage"></p>
							</div>
							<!-- 이름 -->
							<div class="form-group m-4">
								<label for="userName" class="joinTitle">이름</label>
							
								<input id="userName" type="text" class="form-control"/>
								<p id="nameMessage"></p>
							</div>
							
							<!-- 전화번호 -->
							<div class="form-group m-4">
								<label for="userPhone" class="join_title">전화번호</label>
								<input id="userPhone" type="text" class="form-control"/>
								<small id="userPhoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
								<p id="phoneMessage"></p>
							</div>
							<!-- 이메일 -->
							<div class="form-group m-4">	
								<label for="userEmail" class="joinTitle">이메일</label>
								<input id="userEmail" type="text" class="form-control"/>
								<p id="emailMessage"></p>
							</div>
							<!-- 닉네임 -->
							<div class="form-group m-4">	
								<label for="userNickname" class="joinTitle">닉네임</label>
								<input id="userNickname" type="text" class="form-control"/>
								<p id="nickMessage"></p>
							</div>
							<!-- 주소 -->
							<div class="form-group m-4">
								<label for="userAddress" class="joinTitle">주소</label>
								<input id="userAddress" type="text" class="form-control"/>
								<p id="addressMessage"></p>
							</div>
							<!-- submit -->
							<div class="text-center m-5"> 
								<a href="#">
									<input id="joinSubmit" type="submit" class="btn" value="확인"/>
								</a>
							</div>
						</form>
					</div>
				</div>
				
				<!-- 오른쪽 빈칸 -->
				<div class="col-0 col-md-1 "></div>
			</div>
		</div>
	</body>
</html>