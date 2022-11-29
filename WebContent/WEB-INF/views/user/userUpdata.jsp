<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>개인정보 수정</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap" rel="stylesheet">
		<style>
			*{
				border:1px solid black;
				margin:0px;
				padding:0px;
				box-sizing: border-box;
				font-family: 'Jua', sans-serif;
			}
			img{
				width:100%;
				height:100%;
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
			#update{
				text-color:black;
				text-size:100%;
			}
			
			
			#user{
				display: grid;
				grid-template-rows: auto auto auto auto;
				gap: 10px;
				padding: 10px;
			}
			.grid-container > div {
				background-color: rgba(255, 255, 255, 0.8);
				text-align: center;
				font-size: 30px;
				margin:30px;
			}
			.card-head{
				font-size : 80%;
				text-align: left;
				
			}
		</style>
	</head>
	<body>
		<div class="container-fluid" style="background-color: #f3f3f3;">
		
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
				<div class="col-md-2"></div>
	
				<!-- 개인정보 수정 페이지 -->
				<div id="update" class="col-12 col-md mt-5" style="background-color:white;">
					<div class="row mt-5 ml-3">
						<h3>회원정보 수정</h3>
					</div>
					<div id="user" class="grid-container m-3">
					  <div class="card">
					  	<div class="card-head">이름</div>
						<div class="card-body"></div>
					  </div>
					  <div class="card">
					  	<div class="card-head">비밀번호</div>
						<div class="card-body"></div>
					  </div>
					  <div class="card">
					  	<div class="card-head">닉네임</div>
						<div class="card-body"></div>
					  </div> 
					   <div class="card">
					  	<div class="card-head">전화번호</div>
						<div class="card-body"></div>
					  </div>
					  <div class="card">
					  	<div class="card-head">이메일</div>
						<div class="card-body"></div>
					  </div>
					  <div class="card">
					  	<div class="card-head">주소</div>
						<div class="card-body"></div>
					  </div>
					</div>
				</div>
				
				<!-- 오른쪽 블랭크 -->
				<div class="col-md-2"></div>
			</div>						
			<!-- 다리 -->
			<div id="blank" class="row"></div>
		</div>
	</body>
</html>