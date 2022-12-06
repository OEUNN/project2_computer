<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/productList.css">
<%@ include file="/WEB-INF/views/common/header2.jsp"%>


<!-- mainBoard -->
<div id="mainBoard" class="row">
	<!-- 메인 스크롤 -->
	<div class="col-lg-8 col-12 p-5" style="height:550px;">
		<!-- 이미지 슬라이드 -->
		<div id="mainImg" class="row mb-5">
			<img src="../resources/images/main1.png">
		</div>

		<!-- 검색 -->
		<div id="search" class="row mt-5">
			<div class="col-2 mr-2">
				<img src="../resources/images/search.png"
					style="width: 35px; height: 35px" />
			</div>
			<div class="col">
				<input id="searchVal" type="text"></input>
			</div>
		</div>
	</div>
	
	<!-- 메인 로그인 -->
	<div id="mainLogin" class="col-lg-4 p-5" style="height:100%;">
		
		<!-- 로그인 OFF -->
		<c:if test="${loginId==null}">
			<div class="container-fluid">
				<div class="row mb-5">
					<!-- 이미지 센터 -->
					<div style="width: 250px; height: 250px;">
						<img src="../resources/images/pngwing.com.png" alt="image Error" />
					</div>
				</div>
				<div class="row m-5">
					<div>
						<div id="loginButton" style="width: 300px; height: 60px"
							class="btn btn-black btn-sm">
							<a href="../user/LoginController">로그인</a>
						</div>
					</div>
					<div class="button-flex mt-3 mb-5 mx-auto">
						<div class="mt-3" style="flex-grow: 3"></div>
						<div class="btn" style="flex-grow: 2;">
							<u>아이디 찾기</u>
						</div>
						<div class="btn" style="flex-grow: 2;">
							<u>비밀번호 찾기</u>
						</div>
						<div class="mt-3" style="flex-grow: 3"></div>
					</div>
				</div>
			</div>
		</c:if>
		
		<!-- 로그인 ON -->
		<c:if test="${loginId!=null}">
			<div class="container-fluid">
				<div class="row mb-5">
					<!-- 이미지 센터 -->
					<div style="width: 250px; height: 250px;">
						<img src="../resources/images/welcome.png" alt="welcom image error" />
					</div>
				</div>
				<div class="row m-5">
					<div class="button-flex mt-3 mb-5 mx-auto">
						<div class="mt-3" style="flex-grow: 3"></div>
						<div class="btn" style="flex-grow: 2;">
							<u>아이디 찾기</u>
						</div>
						<div class="btn" style="flex-grow: 2;">
							<u>비밀번호 찾기</u>
						</div>
						<div class="mt-3" style="flex-grow: 3"></div>
					</div>
					
					<div>
						<div id="loginButton" style="width: 300px; height: 60px"
							class="btn btn-black btn-sm">
							<a href="../user/LoginController">로그아웃</a>
						</div>
					</div>
					
				</div>
			</div>
		</c:if>
		
	</div>
</div>


<!-- body -->
<div id="wrapper" class="row mt-5">
	<!-- 빈공간 -->
	<div class="col-0 col-md-1 "></div>
	<!-- 메뉴 -->
	<div id="menu" class="d-none d-md-inline col-md-2 mt-5">
		<!-- 메뉴1 -->
		<div id="menu1" class="my-5">
			<h5>
				<b>그래픽 카드</b>
			</h5>
			<div class="row my-3 mx-1">
				<input id="graphicCard1" name="graphicCard" type="radio" value="graphicCard3060" /> 
					<label for="graphicCard1" class="my-auto">3060</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="graphicCard2" name="graphicCard" type="radio" value="graphicCard3040" /> 
				<label for="graphicCard2" class="my-auto">3040</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="graphicCard3" name="graphicCard" type="radio" value="graphicCard3080" /> 
					<label for="graphicCard3" class="my-auto">3080</label>
			</div>
		</div>
		<!-- 메뉴2 -->
		<div id="menu1" class="my-4">
			<h5>
				<b>CPU</b>
			</h5>
			<div class="rowmy-3 mx-1">
				<input id="CPU1" name="CPU" type="radio" value="Intel-i3" /> 
				<label for="CPU1" class="my-auto">Intel-i3</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="CPU2" name="CPU" type="radio" value="Intel-i5" /> 
				<label for="CPU2" class="my-auto">Intel-i5</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="CPU3" name="CPU" type="radio" value="Intel-i7" /> 
				<label for="CPU4" class="my-auto">Intel-i7</label>
			</div>
		</div>
		<!-- 메뉴3 -->
		<div id="menu1" class="my-4">
			<h5>
				<b>메모리 카드</b>
			</h5>
			<div class="row my-3 mx-1">
				<input id="memoryCard1" name="memoryCard" type="radio" value="memoryCard128" /> 
					<label for="gmemoryCard1" class="my-auto">128GB</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="memoryCard2" name="memoryCard" type="radio" value="memoryCard256" /> 
					<label for="memoryCard2" class="my-auto">256GB</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="memoryCard3" name="memoryCard" type="radio" value="memoryCard512" /> 
					<label for="memoryCard3" class="my-auto">512GB</label>
			</div>
		</div>
		<!-- 메뉴4 -->
		<div id="menu1" class="my-4">
			<h5>
				<b>가격</b>
			</h5>
			<div class="row my-3 mx-1">
				<input id="price1" name="price" type="radio" value="price50" /> 
				<label for="price1" class="my-auto">0 ~ 50만원</label>
			</div>
			<div class="row m-1">
				<input id="price2" name="price" type="radio" value="price100" /> 
				<label for="price2" class="my-auto">50 ~ 100만원</label>
			</div>
			<div class="row my-3 mx-1">
				<input id="price3" name="price" type="radio" value="price_over" /> 
				<label for="price4" class="my-auto">100만원 ~ </label>
			</div>
		</div>
	</div>
	<div class="col-12 col-md-8">
		<div class="row ">

			<div class="col-12 col-md-6 col-lg-4 p-3">
				<div id="cardStyle" class="card text-center p-4 ">
					<div class="card-head ">
						<div>
							<img src="../resources/images/monitor3.png" />
						</div>
					</div>
					<div class="card-body">
						<form id="color1select">
							<div class="colorRadio">
								<input id="color1-1" name="color1" type="radio" value="blue" checked="checked"> 
									<label for="color1-1" class="border rounded-circle my-auto" style="background-color: steelblue;"></label> 
									<input id="color1-2" name="color1" type="radio" value="black">
								<label for="color1-2" class="border rounded-circle my-auto" style="background-color: black;"></label> 
									<input id="color1-3" name="color1" type="radio" value="white"> 
									<label for="color1-3" class="border rounded-circle my-auto" style="background-color: white;"></label>
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
				<div id="cardStyle" class="card text-center p-4 ">
					<div class="card-head">
						<div>
							<img src="../resources/images/monitor3.png" />
						</div>
					</div>
					<div class="card-body">
						<form id="color1select">
							<div class="colorRadio">
								<input id="color1-1" name="color1" type="radio" value="blue" checked="checked"> 
									<label for="color1-1" class="border rounded-circle my-auto" style="background-color: steelblue;"></label> 
									<input id="color1-2" name="color1" type="radio" value="black">
								<label for="color1-2" class="border rounded-circle my-auto" style="background-color: black;"></label> 
									<input id="color1-3" name="color1" type="radio" value="white"> 
									<label for="color1-3" class="border rounded-circle my-auto" style="background-color: white;"></label>
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
				<div id="cardStyle" class="card text-center p-4 ">
					<div class="card-head">
						<div>
							<img src="../resources/images/monitor3.png" />
						</div>
					</div>
					<div class="card-body">
						<form id="color1select">
							<div class="colorRadio">
								<input id="color1-1" name="color1" type="radio" value="blue" checked="checked"> 
								<label for="color1-1" class="border rounded-circle my-auto" style="background-color: steelblue;"></label>
									 <input id="color1-2" name="color1" type="radio" value="black">
								<label for="color1-2" class="border rounded-circle my-auto" style="background-color: black;"></label> 
									<input id="color1-3" name="color1" type="radio" value="white"> 
									<label for="color1-3" class="border rounded-circle my-auto" style="background-color: white;"></label>
							</div>
						</form>

						<h4 class="my-2">컴퓨터1</h4>
						<p>pro01</p>
						<p>500,000원</p>

						<a id="detailButton" href="../product/ProductDetailController"
							class="w-btn w-btn-indigo">구매하기</a>
					</div>
				</div>
			</div>

			<div class="col-12 col-md-6 col-lg-4 p-3">
				<div id="cardStyle" class="card text-center p-4 ">
					<div class="card-head">
						<div>
							<img src="../resources/images/monitor3.png" />
						</div>
					</div>
					<div class="card-body">
						<form id="color1select">
							<div class="colorRadio">
								<input id="color1-1" name="color1" type="radio" value="blue"
									checked="checked"> <label for="color1-1"
									class="border rounded-circle my-auto"
									style="background-color: steelblue;"></label> 
									<input
									id="color1-2" name="color1" type="radio" value="black">
								<label for="color1-2" class="border rounded-circle my-auto"
									style="background-color: black;"></label> 
									<input id="color1-3"
									name="color1" type="radio" value="white"> 
									<label
									for="color1-3" class="border rounded-circle my-auto"
									style="background-color: white;"></label>
							</div>
						</form>

						<h4 class="my-2">컴퓨터1</h4>
						<p>pro01</p>
						<p>500,000원</p>

						<a id="detailButton" href="../product/ProductDetailController"
							class="w-btn w-btn-indigo">구매하기</a>
					</div>
				</div>
			</div>

			<div class="col-12 col-md-6 col-lg-4 p-3">
				<div id="cardStyle" class="card text-center p-4 ">
					<div class="card-head">
						<div>
							<img src="../resources/images/monitor3.png" />
						</div>
					</div>
					<div class="card-body">
						<form id="color1select">
							<div class="colorRadio">
								<input id="color1-1" name="color1" type="radio" value="blue"
									checked="checked"> <label for="color1-1"
									class="border rounded-circle my-auto"
									style="background-color: steelblue;"></label> 
									<input
									id="color1-2" name="color1" type="radio" value="black">
								<label for="color1-2" class="border rounded-circle my-auto"
									style="background-color: black;"></label> 
									<input id="color1-3"
									name="color1" type="radio" value="white"> 
									<label
									for="color1-3" class="border rounded-circle my-auto"
									style="background-color: white;"></label>
							</div>
						</form>

						<h4 class="my-2">컴퓨터1</h4>
						<p>pro01</p>
						<p>500,000원</p>

						<a id="detailButton" href="../product/ProductDetailController"
							class="w-btn w-btn-indigo">구매하기</a>
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
<%@ include file="/WEB-INF/views/common/footer.jsp"%>