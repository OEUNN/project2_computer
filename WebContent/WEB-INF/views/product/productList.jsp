<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<%@ include file="/resources/css/productList.css" %>


		</style>
		
	</head>
	<body>
		<div id="back" class="container-fluid">
		
			<div id="top" class="row"> 
				<!-- 상단 메뉴 나오기전 빈공간 -->
				<div id="logo" class="btn mt-3">
               		<a href="../product/ProductListController"><b>SAMSUNG</b></a>
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
<%@ include file="/WEB-INF/views/common/footer.jsp" %>