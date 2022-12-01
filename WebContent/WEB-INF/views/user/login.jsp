<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
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
	            background-color:#f3f3f3;
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
	        #loginMain{
	        	background-color: white;
	        	border-radius: 15px;
				box-shadow: 5px 5px 10px grey;
	        }
	         #loginMain *{
				background-color: white;
	        }
			#loginLogo{
				width:100%;
				font-size: 250%;
				text-align: center;
			}
			.button-flex {
				display : flex;
			}
			#loginButton *{
				width:200px; 
				height:35px; 
				background-color:#0c1c32;
				color:white;
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
			
			<!-- 화이트바 -->
			<div id="blank" class="row" style="height:50px;background-color:white; "></div>
			
			<!-- body -->
			<div id="body" class="row" >
				<!-- 왼쪽 빈공간 -->
				<div class="col-0 col-md-3"></div>
				
				<!-- 메인 -->
				<div id="loginMain" class="col-12 col-md mt-5 mr-5">
					<div id="loginBody" class="container-fluid">
					
						<div id="loginLogo" class="row my-5">로그인</div>
						
						<div class="row container-fluid">
							<div class="col-3"></div>
							<div class="col">
								<div class="row form-group">
				           			<label for="uid">ID</label>
				            		<input type="text" class="form-control" id="uid" name="uid" value="Abc123"/>
				          		</div>
								<div class="row form-group" >
				            		<label for="password">Password</label>
				            		<input type="password" class="form-control" id="password" name="password" value="Abc12345"/>
				          		</div>
				          	</div>
							<div class="col-3"></div>
						</div>
						
						<div class = "row button-flex mt-5">
		          			<div  style ="flex-grow: 3"></div>
								<div id="loginButton"class="mt-3 mx-auto" style ="flex-grow: 3">
								<input class="btn" type="submit" value="로그인"/>
								<a href="../user/JoinController" class="btn ml-3">회원가입</a>
							</div>
						</div>
								
						<div class = "row button-flex m-5">
							<div class="mt-3" style ="flex-grow:3;"></div>
							<div class="btn" style ="flex-grow: 2"><u>아이디 찾기</u></div>
							<div class="btn" style ="flex-grow: 2"><u>비밀번호 찾기</u></div>
							<div class="mt-3" style ="flex-grow: 3"></div>
						</div>
					</div>
				</div>
				<!-- 오른쪽 빈공간 -->
				<div class="col-0 col-md-3"></div>
			</div>
		</div>
	</body>
</html>