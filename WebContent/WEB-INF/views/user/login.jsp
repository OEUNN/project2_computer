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
				border-radius:15px;
				box-shadow: 5px 5px 10px grey;
			}
			#loginMain div,h1,label{
				background-color:white;
			} 
			.card-head{
				text-align:center;
				height:50px;
				margin:30px 0px;
			}
			.card-body>div{
				margin:10px;
			}
			
			.button-flex {
				display : flex;
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
			
			<div id="blank" class="row" style="height:50px"></div>
			
			<!-- body -->
			<div id="body" class="row" >
				<div class="col-0 col-md-3"></div>
				<div id="loginMain" class="col-12 col-md" >
					<div class="card text-black">
						<div class="card-head">
							<h1>로그인</h1>
						</div>
						
						<div class="card-body">
							<div class="form-group" style="margin:0 auto; width:300px">
		           				<label for="uid">ID</label>
		            			<input type="text" class="form-control" id="uid" name="uid" value="Abc123"/>
		          			</div>
							 <div class="form-group"  style="margin:0 auto; width:300px">
		            			<label for="password">Password</label>
		            			<input type="password" class="form-control" id="password" name="password" value="Abc12345"/>
		          			</div>
		          			<div class = "button-flex">
		          				<div class="mt-3" style ="flex-grow: 3"></div>
								<div class="mt-3 mx-auto" style ="flex-grow: 3">
									<input class="btn" style="width:100px; height:35px; background-color:#0c1c32;color:white;" type="submit" value="로그인"/>
									<a href="../user/join.html" class="btn" style="width:100px; height:35px; background-color:#0c1c32;color:white;">회원가입</a>
									<a href="../product/productlist.html" class="btn" style="width:100px; height:35px; background-color:#0c1c32;color:white;">메인</a>
								</div>
							</div>
							<div class = "button-flex">
								<div class="mt-3" style ="flex-grow: 3"></div>
								<div class="btn" style ="flex-grow: 2">아이디 찾기</div>
								<div class="btn" style ="flex-grow: 2">비밀번호 찾기</div>
								<div class="mt-3" style ="flex-grow: 3"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-0 col-md-3"></div>
			</div>

			<div id="blank" class="row"></div>

		</div>
	</body>
</html>