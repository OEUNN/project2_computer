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
			
			#order{
				border-radius: 15px;
				background-color: white;
				text-align: center;
				box-shadow: 5px 5px 10px grey;
			}
			
			#order div,td,img{
				background-color: white;
			}
			
			#dayButton{
				border:1px solid #0c1c32;
				width:60px;
				font-size: 90%;
				background-color: #f3f3f3;
			}
			
			#dayButton:hover{
				border:1px solid #0c1c32;
				background-color: #0c1c32;
				color:white;
			}
			
			#subText1{
				font-size: 200%;
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
			
			<!-- home가는 버튼 -->
			<div id="blank" class="row" style="height:50px;background-color:white; "></div>
			
			<!-- 몸통 -->
			<div id="body" class="row">
				
				<!-- menu -->
				<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
					<div class="ml-5 mt-5" style="font-size:200%;">마이페이지
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
				
				
				<!-- center Board -->
				<div id="centerBoard" class="col-12 col-md mt-5">
					<div class="container-fluid">
					
						<div id="centerText" class="row mt-5 ml-3">주문 내역</div>
						
						<!-- 주문 기간 -->
						<div id="order" class="row m-3 p-3" >
							<div class="col-1 m-1" style="font-size:130%;">기간조회</div>
							<div class="col m-1">
								<table >
									<tr>
										<td id="dayButton"class="btn">1주일</td>
										<td id="dayButton" class="btn">15일</td>
										<td id="dayButton" class="btn">1개월</td>
										<td id="dayButton" class="btn">3개월</td>
										<td id="dayButton" class="btn">1년</td>
									</tr>
								</table>
							</div>
							<div class="col-3"></div>
						</div>
						
						<!-- 리스트 로고 -->
						<div id="subText1" class="row mx-3">구매내역</div>
						<!-- 구매 내역 리스트 -->
						<div id="order" class="row mt-1 mx-3 p-3">
							<!-- 페이징 처리 -->
							<div class="container-fluid">
								<!-- 구매내역 위에 부분 -->
								<div class="row mb-5 p-2" style="font-size:120%; border-bottom:1px solid grey;">
									<div class="col-2">구매일자</div>
									<div class="col-2">주문번호</div>
									<div class="col">구매상품</div>
									<div class="col-2">선택</div>
								</div>
								<!-- 상품리스트1 -->
								<div class="row my-3 p-2">
									<div class="col-2">2022-11-27</div>
									<div class="col-2">1</div>
									<div class="col">
										<div class="container-fluid">
											<div><img class="col"src=""/></div>
											<div class="col-7">내용</div>
										</div>
									</div>
									<div class="col-2 "><input type="checkbox" id="choice" /></div>
								</div>
								<!-- 상품리스트2 -->
								<div class="row my-3 p-2">
									<div class="col-2">2022-11-27</div>
									<div class="col-2">1</div>
									<div class="col">
										<div class="container-fluid">
											<div><img class="col"src=""/></div>
											<div class="col-7">내용</div>
										</div>
									</div>
									<div class="col-2"><input type="checkbox" id="choice" /></div>
								</div>
							</div>
						</div>
			
					</div>
				</div>
				
				
				<div class="col-0 col-md-1 "></div>
			</div>
			<!-- 다리 -->
			<div id="blank" class="row"></div>
		</div>
	</body>
</html>