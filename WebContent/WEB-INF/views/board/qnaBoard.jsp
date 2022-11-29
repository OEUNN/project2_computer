<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1대1 문의게시판</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap" rel="stylesheet">
		
		<!-- 부트스트랩 아이콘 -->
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
			#menu div,a{
				background-color: white;
				color:black;
			}
			a{
				text-decoration: none;
				color:black;
			}
			a:hover{
				text-decoration: none;
				
			}
			.qnaList div:hover{
				background-color: #f3f3f3;
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
				
				<!-- 1대1문의 내역 -->
				<div class="col card rounded-0">
					<div class="card-header">
						<h4 style="text-align:left">1대1 문의</h4>
						<button class="btn btn-info btn-dark rounded-1" style="width:100%">문의하기</button>
					</div>
					<div class="card-body border-top qnaList">
						<div  class="row qnaList">
							
							<div class="col-1 qnaNum" >
								<!-- <i class="btn fas" >&#xf00d;</i> -->
								1
							</div>
							<div class="col-11 qnaTitle"  >
								<a href="#qnaDetail1" data-toggle="collapse">컴퓨터가 안켜져요. 환불해주세요<span></span></a>
								<p>작성일자<span>2022.11.24.</span></p>
							</div>
							
							<div class="qnaDetail collapse" id="qnaDetail1">
								<p>환불해주세요. 보상금도 요구할게요.</p>
							</div>
						</div>
						<div  class="row qnaList">
							
							<div class="col-1 qnaNum" >
								<!-- <i class="btn fas" >&#xf00d;</i> -->
								2
							</div>
							<div class="col-11 qnaTitle"  >
								<a href="#qnaDetail2" data-toggle="collapse">컴퓨터가 안켜져요. 환불해주세요<span></span></a>
								<p>작성일자<span>2022.11.24.</span></p>
							</div>
							
							<div class="qnaDetail collapse" id="qnaDetail2">
								<p>보상금도 요구할게요.</p>
								<hr/>
								<p>사랑하는 고객님 안녕하십니까. 당신의 영원한 파트너 입니다. 감사합니다.</p>
							</div>
						</div>
						<div  class="row qnaList">
							
							<div class="col-1 qnaNum" >
								<!-- <i class="btn fas" >&#xf00d;</i> -->
								1
							</div>
							<div class="col-11 qnaTitle"  >
								<a href="#qnaDetail3" data-toggle="collapse">컴퓨터가 안켜져요. 환불해주세요<span></span></a>
								<p>작성일자<span>2022.11.24.</span></p>
							</div>
							
							<div class="qnaDetail collapse" id="qnaDetail3">
								<p>환불해주세요. 보상금도 요구할게요.</p>
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