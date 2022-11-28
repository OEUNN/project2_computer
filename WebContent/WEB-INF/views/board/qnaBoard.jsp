<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1대1 문의게시판</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<!-- 부트스트랩 아이콘 -->
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
		<style>
			*{
				margin:0px;
				padding:0px;
				box-sizing: border-box;
				border:1px solid black;
			}

			#logo{
				background-color:#0c1c32;
				height:100px;
			}
			#logo .logo{
				margin:25px 100px;
				text-align:left;
				color:#f8f8f8 ;
				
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
			<div id="logo" class="row">
				<div class="logo btn" style="font-size:200%" onclick="location.href='../product/productlist.html'">
				<b>SAMSUNG</b>
				</div>
			</div>
			<!-- home가는 버튼 -->
			<div id="blank" class="row" style="height:50px"></div>
			<!-- 몸통 -->
			<div id="body" class="row">
				<div class="col-0 col-md-1" ></div>
				
				<!-- menu -->
				<div class=" d-none d-md-inline col-md-2 mt-3 mr-5 border" style="background-color: #f3f3f3;">
					<div id="menu1" class="m-3"><h5><b>마이페이지</b></h5>
						<div class="row m-3">
							<div id="userUpdate" onclick="#" class="btn btn-black btn-sm"><h5>개인정보</h5></div>
						</div>
						<div class="row m-3">
							<div id="orderList" onclick="#" class="btn btn-black btn-sm"><h5>주문내역</h5></div>
						</div>
						<div class="row m-3">
							<div id="cartList" onclick="#" class="btn btn-black btn-sm"><h5>장바구니</h5></div>
						</div>
						<div class="row m-3">
							<div id="content" onclick="#" class="btn btn-black btn-sm"><h5>1:1 문의</h5></div>
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
						<div class="row">
							<div class="col-1">
								<!-- <i class="btn fas" >&#xf00d;</i> -->
							</div>
							<div class="col-11">
								<a href="#">컴퓨터가 안켜져요. 환불해주세요<span>(답변완료)</span></a>
								<p>작성일자<span>2022.11.24.</span></p>
							</div>
						</div>
						<div class="row">
							<div class="col-1">
								<!-- <i class="btn fas" >&#xf00d;</i> -->
							</div>
							<div class="col-11">
								<a href="#">컴퓨터가 안켜져요. 환불해주세요<span>(답변완료)</span></a>
								<p>작성일자<span>2022.11.24.</span></p>
							</div>
						</div>
						<div class="row">
							<div class="col-1">
								<!-- <i class="btn fas" >&#xf00d;</i> -->
							</div>
							<div class="col-11">
								<a href="#">컴퓨터가 안켜져요. 환불해주세요<span>(답변완료)</span></a>
								<p>작성일자<span>2022.11.24.</span></p>
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