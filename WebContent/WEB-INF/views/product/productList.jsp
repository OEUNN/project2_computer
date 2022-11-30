<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인화면</title>
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
			img{
				width:100%;
				height:100%;
				margin: auto;
    			display: block;
			}
			#back{
				padding-bottom: 100px;
			}
			#top{
				background:#0c1c32;
				height:100px;
			}
			
			#wrapper{
				width:100%;
			}

			#logo b{
				background-color:#0c1c32;
				color:white;
				font-size:300%;
				font-family: 'Black Han Sans', sans-serif;
			}
			
			#topMenu{
				font-size:150%;
				text-align: center;
			}
			#topMenu a{
				color:#c2c6cd;
			}
			
			#mainBoard div{
				text-align: center;
				margin : auto;
			}
			
			#mainImg{
				height:350px;
			}
			
			#mainImg img{
				width:100%;
				border-radius:30px;
			}
			
			#searchVal{
				border: 5px solid #0c1c32;
				width:100%;
				height:60px;
			}
			
			#mainLogin .container-fluid{
				box-shadow: 5px 5px 10px grey;
				border-radius: 15px;
			}
			#loginButton{
				background-color:#0c1c32;
				border: 2px solid #0c1c32;
				margin:20px;
				font-size:200%;
			}
			#loginButton a{
				color:white;
				text-align: center;
				
			}
			.button-flex {
				display : flex;
			}
			
			menu, #menu1{
				border:1.5px solid grey;
				border-style:none none solid none ;
				margin-right:20px;
			}
			
			.w-btn {
			    position: relative;
			    border: none;
			    display: inline-block;
			    padding: 15px 30px;
			    border-radius: 15px;
			    font-family: "paybooc-Light", sans-serif;
			    font-weight: 600;
			    transition: 0.25s;
			    background-color:white;
		    	color: navy; 
			}
			
			.w-btn:hover {
    			background-color: #0c1c32;
   			 	color: #d4dfe6;
			}
			
			#cardStyle{
				background-color:#f1f1f1;
				border-radius:30px;
			}
			
			.colorRadio input{
				display:none;
			}
			.colorRadio input+label{
				width:15px;
				height:15px;
			}
			.colorRadio input:checked+label{
				width:20px;
				height:20px;
			}
			
			#icon {
				 display : flex;
			}
			#detailButton{
				box-shadow: 2px 2px 3px grey;
			}
			 .submenu{ 
                display : none; /* 소메뉴 안보이게 하기 none | block */
                background-color : white;
            }
            
            #menuBtn:checked ~ .submenu{
                display : block;
            }
            
            //페이징
            .page-item{
            	
            }
		</style>
		
	</head>
	<body>
		<div id="back" class="container-fluid">
		
			<div id="top" class="row"> 
				<!-- 상단 메뉴 나오기전 빈공간 -->
				<div id="logo" class="col-2 mt-3">
					<div ><B>SAMSUNG</B></div>
				</div>
				<!-- 상단바 메뉴 -->
				<div id="topMenu" class="d-none d-md-inline col-md-2 my-3">
					<div class="container-fluid">
						<div class="row">
							<div class="col"><a href="#">제품</a></div>			
							<div class="col"><a href="#">게시판</a></div>		
							<div  class="col"><a href="../product/UploadController">관리자</a></div>	
						</div>
					</div>
				</div>
				
				<!-- 상단 빈공간 -->
				<div class="col"></div>
				
				<!-- 아이콘 -->
				<div id="icon" class=" col-2 mt-3">
					<div class = "mt-3">
						<a href="../product/BasketListController">
							<img src="../resources/images/cart_w.png" style="width:40px;height:40px;" />
						</a>
					</div>
					<!-- 아이콘안 메뉴 -->
					<div class = "mt-3 ml-5">
	                	<input type="checkbox" id="menuBtn" style="display:none;"/>
	                	<label for="menuBtn" class="labelBtn" onclick="">
	                		<img src="../resources/images/Human_w.png" style="width:40px;height:40px;" />
	                	</label>
	                	<ul class="submenu" style="width:90px;">
	                		<li ><a href="../user/MypageController">마이페이지</a></li>
	                    	<li ><a href="../user/JoinController">회원가입</a></li>
	                    	<li ><a href="../user/LoginController">로그인</a></li>
	                	</ul>
					</div>
				</div>
				
			</div>
			
			
			
			
			<!-- mainBoard -->
			<div id="mainBoard" class="row" >
				<!-- 메인 스크롤 -->
				<div  class="col-lg-8 col-12 p-5" style="height:550px;">
					<!-- 이미지 슬라이드 -->
					<div  id="mainImg" class="row mb-5">
						<img src="../resources/images/main1.png" >
					</div>
					
					<!-- 검색 -->
					<div id="search" class="row mt-5">
						<div class="col-2 mr-2">
							<img src="../resources/images/search.png" style="width:35px;height:35px" />
						</div>
						<div class="col" >
							<input  id="searchVal" type="text"></input>
						</div>
					</div>
				</div>
				<div id="mainLogin" class="col-lg-4 p-5" style="height:550px;">
					<div class="container-fluid">
						<div class="row mb-5">
							<!-- 이미지 센터 -->
							<div style="width:250px;height:250px;">
								<img src="../resources/images/pngwing.com.png" alt="image Error"/>
							</div>
						</div>
						<div class="row m-5">
							<div>
								<div id="loginButton" style="width:300px; height:60px" class="btn btn-black btn-sm">
									<a href="../user/LoginController">로그인</a>
								</div>
							</div>
							<div class = "button-flex mt-3 mb-5 mx-auto">
								<div class="mt-3" style ="flex-grow: 3"></div>
								<div class="btn" style ="flex-grow:2;"><u>아이디 찾기</u></div>
								<div class="btn" style ="flex-grow:2;"><u>비밀번호 찾기</u></div>
								<div class="mt-3" style ="flex-grow: 3"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			<!-- body -->
			<div id="wrapper" class="row mt-5">
				<!-- 빈공간 -->
				<div class="col-0 col-md-1 "></div>
				<!-- 메뉴 -->
				<div id="menu" class="d-none d-md-inline col-md-2 mt-5">
					<!-- 메뉴1 -->
					<div id="menu1" class="my-5"><h5><b>그래픽 카드</b></h5>
						<div class="row my-3 mx-1">
							<input id="graphicCard1" name="graphicCard" type="radio" value="graphicCard3060"/>
							<label for="graphicCard1" class="my-auto">3060</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="graphicCard2" name="graphicCard" type="radio" value="graphicCard3040"/>
							<label for="graphicCard2"class="my-auto">3040</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="graphicCard3" name="graphicCard" type="radio" value="graphicCard3080"/>
							<label for="graphicCard3"class="my-auto">3080</label>
						</div>
					</div>
					<!-- 메뉴2 -->
					<div id="menu1" class="my-4"><h5><b>CPU</b></h5>
						<div class="rowmy-3 mx-1">
							<input id="CPU1" name="CPU" type="radio" value="Intel-i3"/>
							<label for="CPU1"class="my-auto">Intel-i3</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="CPU2" name="CPU" type="radio" value="Intel-i5"/>
							<label for="CPU2"class="my-auto">Intel-i5</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="CPU3" name="CPU" type="radio" value="Intel-i7"/>
							<label for="CPU4"class="my-auto">Intel-i7</label>
						</div>
					</div>
					<!-- 메뉴3 -->
					<div id="menu1" class="my-4"><h5><b>메모리 카드</b></h5>
						<div class="row my-3 mx-1">
							<input id="memoryCard1" name="memoryCard" type="radio" value="memoryCard128"/>
							<label for="gmemoryCard1"class="my-auto">128GB</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="memoryCard2" name="memoryCard" type="radio" value="memoryCard256"/>
							<label for="memoryCard2"class="my-auto">256GB</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="memoryCard3" name="memoryCard" type="radio" value="memoryCard512"/>
							<label for="memoryCard3"class="my-auto">512GB</label>
						</div>
					</div>
					<!-- 메뉴4 -->
					<div id="menu1" class="my-4"><h5><b>가격</b></h5>
						<div class="row my-3 mx-1">
							<input id="price1" name="price" type="radio" value="price50"/>
							<label for="price1"class="my-auto">0 ~ 50만원</label>
						</div>
						<div class="row m-1">
							<input  id="price2" name="price" type="radio" value="price100"/>
							<label for="price2"class="my-auto">50 ~ 100만원</label>
						</div>
						<div class="row my-3 mx-1">
							<input id="price3" name="price" type="radio" value="price_over"/>
							<label for="price4"class="my-auto">100만원 ~ </label>
						</div>
					</div>
					</div>
				<div class="col-12 col-md-8">
					<div class="row ">
					
						<div class="col-12 col-md-6 col-lg-4 p-3">
							<div id ="cardStyle" class="card text-center p-4 ">
								<div class="card-head ">
									<div><img src="../resources/images/monitor3.png"/></div>
								</div>
								<div class="card-body">
									<form id="color1select">
										<div class = "colorRadio">
											<input id="color1-1" name="color1" type="radio" value="blue" checked="checked">
											<label for="color1-1" class="border rounded-circle my-auto" style="background-color:steelblue;  "></label>
											<input id="color1-2" name="color1" type="radio" value="black" >
											<label for="color1-2" class="border rounded-circle my-auto" style="background-color:black;  "></label>
											<input id="color1-3" name="color1" type="radio" value="white" >
											<label for="color1-3" class="border rounded-circle my-auto" style="background-color:white;  "></label>
										</div>
									</form>
									
									<h4 class="my-2">컴퓨터1</h4>
									<p>pro01</p>
									<p>500,000원</p>
									
									<a id="detailButton" href="../product/ProductDetailController" class="w-btn w-btn-indigo">구매하기</a>
								</div>
							</div>
						</div>
						
						<div class="col-12 col-md-6 col-lg-4 p-3">
							<div id ="cardStyle" class="card text-center p-4 ">
								<div class="card-head">
									<div><img src="../resources/images/monitor3.png"/></div>
								</div>
								<div class="card-body">
									<form id="color1select">
										<div class = "colorRadio">
											<input id="color1-1" name="color1" type="radio" value="blue" checked="checked">
											<label for="color1-1" class="border rounded-circle my-auto" style="background-color:steelblue;  "></label>
											<input id="color1-2" name="color1" type="radio" value="black" >
											<label for="color1-2" class="border rounded-circle my-auto" style="background-color:black;  "></label>
											<input id="color1-3" name="color1" type="radio" value="white" >
											<label for="color1-3" class="border rounded-circle my-auto" style="background-color:white;  "></label>
										</div>
									</form>
									
									<h4 class="my-2">컴퓨터1</h4>
									<p>pro01</p>
									<p>500,000원</p>
									<a id="detailButton" href="../product/ProductDetailController" class="w-btn w-btn-indigo">구매하기</a>
								</div>
							</div>
						</div>
						
						<div class="col-12 col-md-6 col-lg-4 p-3">
							<div id ="cardStyle" class="card text-center p-4 ">
								<div class="card-head">
									<div ><img src="../resources/images/monitor3.png"/></div>
								</div>
								<div class="card-body">
									<form id="color1select">
										<div class = "colorRadio">
											<input id="color1-1" name="color1" type="radio" value="blue" checked="checked">
											<label for="color1-1" class="border rounded-circle my-auto" style="background-color:steelblue;  "></label>
											<input id="color1-2" name="color1" type="radio" value="black" >
											<label for="color1-2" class="border rounded-circle my-auto" style="background-color:black;  "></label>
											<input id="color1-3" name="color1" type="radio" value="white" >
											<label for="color1-3" class="border rounded-circle my-auto" style="background-color:white;  "></label>
										</div>
									</form>
									
									<h4 class="my-2">컴퓨터1</h4>
									<p>pro01</p>
									<p>500,000원</p>
									
									<a id="detailButton" href="../product/ProductDetailController" class="w-btn w-btn-indigo">구매하기</a>
								</div>
							</div>
						</div>
						
						<div class="col-12 col-md-6 col-lg-4 p-3">
							<div id ="cardStyle" class="card text-center p-4 ">
								<div class="card-head">
									<div ><img src="../resources/images/monitor3.png"/></div>
								</div>
								<div class="card-body">
									<form id="color1select">
										<div class = "colorRadio">
											<input id="color1-1" name="color1" type="radio" value="blue" checked="checked">
											<label for="color1-1" class="border rounded-circle my-auto" style="background-color:steelblue;  "></label>
											<input id="color1-2" name="color1" type="radio" value="black" >
											<label for="color1-2" class="border rounded-circle my-auto" style="background-color:black;  "></label>
											<input id="color1-3" name="color1" type="radio" value="white" >
											<label for="color1-3" class="border rounded-circle my-auto" style="background-color:white;  "></label>
										</div>
									</form>
									
									<h4 class="my-2">컴퓨터1</h4>
									<p>pro01</p>
									<p>500,000원</p>
									
									<a id="detailButton" href="../product/ProductDetailController" class="w-btn w-btn-indigo">구매하기</a>
								</div>
							</div>
						</div>
						
						<div class="col-12 col-md-6 col-lg-4 p-3">
							<div id ="cardStyle" class="card text-center p-4 ">
								<div class="card-head">
									<div><img src="../resources/images/monitor3.png"/></div>
								</div>
								<div class="card-body">
									<form id="color1select">
										<div class = "colorRadio">
											<input id="color1-1" name="color1" type="radio" value="blue" checked="checked">
											<label for="color1-1" class="border rounded-circle my-auto" style="background-color:steelblue;  "></label>
											<input id="color1-2" name="color1" type="radio" value="black" >
											<label for="color1-2" class="border rounded-circle my-auto" style="background-color:black;  "></label>
											<input id="color1-3" name="color1" type="radio" value="white" >
											<label for="color1-3" class="border rounded-circle my-auto" style="background-color:white;  "></label>
										</div>
									</form>
									
									<h4 class="my-2">컴퓨터1</h4>
									<p>pro01</p>
									<p>500,000원</p>
									
									<a id="detailButton" href="../product/ProductDetailController" class="w-btn w-btn-indigo">구매하기</a>
								</div>
							</div>
						</div>
						
						
					</div>
					
					<!-- 페이징 -->
					<div class="row ">
						 <ul class="pagination m-auto ">
						    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
						    <li class="page-item"><a class="page-link" href="#">1</a></li>
						    <li class="page-item active"><a class="page-link" href="#">2</a></li>
						    <li class="page-item"><a class="page-link" href="#">3</a></li>
						    <li class="page-item"><a class="page-link" href="#">Next</a></li>
						  </ul>
					</div>
					
				</div>
			</div>
		</div>
	</body>
</html>