<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
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
			
			#menu div{
				background-color: white;
			}
			#centerText{
				color:black;
				font-size: 250%;
			}
			#mypage{
				background-color: white;
				border-radius:15px;
				box-shadow: 5px 5px 10px grey;
			}
			
			#mypage div,p,h3{
				background-color: white;
			}
			
			#id{
			  display: grid;
			  grid-template-rows: auto auto auto auto;
			  gap: 10px;
			  padding: 10px;
			}
			
			#product {
			  display: grid;
			  grid-template-columns: auto auto auto auto;
			  gap: 10px;
			  padding: 10px;
			}
			
			.grid-container > div {
			  background-color: rgba(255, 255, 255, 0.8);
			  border: 1px solid black;
			  text-align: center;
			  font-size: 30px;
			}
			.card-head{
				font-size : 80%;
				text-align: left;
			}
		</style>
	</head>
	<body>
		<div class="container-fluid">
		
			<!-- 가장위 logo -->
			<div id="top" class="row">
				<div id="logo" class="btn mt-3" onclick="/product/ProductListController">
					<b>SAMSUNG</b>
				</div>
			</div>
			
			<!-- home가는 버튼 -->
			<div id="blank" class="row" style="height:50px;background-color:white; "></div>
			
			<!-- 몸통 -->
			<div id="body" class="row">
				
				<!-- menu -->
				<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
					<div class="ml-5 mt-5" style="font-size:200%;">마이페이지
						<div class="row m-3">
							<div id="userUpdate" onclick="/product/UserUpdataController" class="btn btn-black btn-sm">>개인정보</div>
						</div>
						<div class="row m-3">
							<div id="orderList" onclick="/product/OrderListController" class="btn btn-black btn-sm">>주문내역</div>
						</div>
						<div class="row m-3">
							<div id="cartList" onclick="/product/BasketListController" class="btn btn-black btn-sm">>장바구니</div>
						</div>
						<div class="row m-3">
							<div id="content" onclick="/product/QnaBoardController" class="btn btn-black btn-sm">>1:1 문의</div>
						</div>
					</div>
				</div>
				
				
				<!-- 개인정보 수정 페이지 -->
				<div id="centerBoard" class="col-12 col-md mt-5">
					<div class="container-fluid">
					
						<div id="centerText" class="row mt-5 ml-3">나의 정보</div>
						
						<div id="mypage" class="row m-3" >
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12 col-lg-5">
										<div class="ml-3 p-2"style="height:300px; width:250px;">
											<img src="../resources/images/woman.png" alt="woman" style="border-radius:70%;"/>
										</div>
									</div>
									<div class="col-lg-5">
										<div class="m-5">
											<p><h3>장영은고객님</h3></p>
											<p >안녕하세요.</p>
										</div>
									</div>
									<div class="col-lg-2 "></div>
								</div>
							</div>
						</div>
						<div class="row" style="height:30px"></div>
						<div  class="row m-3" >
							<div  class="container-fluid">
								<div class="row">
									<div id="mypage" class="col-md-12 col-lg-5 mr-2">
										<div id="user" class="container-fluid p-3">
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
									
									<div class="col"></div>
									
									<div id="mypage" class="col-lg-5">
										<div id="product" class="grid-container">
										  <div class="card">
										  	<div class="card-head">
										  		<img src="../resources/images/woman.png" alt="woman"/>
										  	</div>
											<div class="card-body"></div>
										  </div>
										  <div class="card">
										  	<div class="card-head">
										  		<img src="../resources/images/woman.png" alt="woman"/>
										  	</div>
											<div class="card-body"></div>
										  </div>
										  <div class="card">
										  	<div class="card-head">
										  		<img src="../resources/images/woman.png" alt="woman"/>
										  	</div>
											<div class="card-body"></div>
										  </div> 
										  <div class="card">
										  	<div class="card-head">
										  		<img src="../resources/images/woman.png" alt="woman"/>
										  	</div>
											<div class="card-body"></div>
										  </div>
										  <div class="card">
										  	<div class="card-head">
										  		<img src="../resources/images/woman.png" alt="woman"/>
										  	</div>
											<div class="card-body"></div>
										  </div>
								
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row m-3" style="height:10px;"></div>
						
					</div>
				</div>
				<div class="col-0 col-md-1 "></div>
			</div>
			<!-- 다리 -->
			<div id="blank" class="row"></div>
		</div>
	</body>
</html>