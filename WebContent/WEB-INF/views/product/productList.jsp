<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/productList.css">
<script src="../resources/javascript/productList.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp"%>

<!-- mainBoard -->
<div id="mainBoard" class="row" >
	<!-- 메인 스크롤 -->
	<div class="col-lg-8 col-12 p-5 " style="height:600px;">
		<!-- 이미지 슬라이드 -->
		<div id="mainImg" class="row mb-5">
			<img class="mySlides" src="../resources/images/main1.png"> 
			<img class="mySlides" src="../resources/images/main2.png"> 
			<img class="mySlides" src="../resources/images/main3.png">
		</div>

		<!-- 검색 -->
		<div id="search" class="row mt-5">
			<div class="col-2 mr-2">
				<img src="../resources/images/search.png" onclick="searchProduct()" style="width: 35px; height: 35px" />
			</div>
			<div class="col">
				<input id="searchVal"  class="p-3" type="text"></input>
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
				<div class="row">
					<!-- 이미지 센터 -->
					<div style="width: 550px; height: 100%;">
						<img src="../resources/images/welcome.png" alt="welcom image error" />
					</div>
				</div>
				<div id="loginText" class="row mb-2">
					<div class="mx-auto">
						<div class="mt-3" style="flex-grow: 3"></div>
						<div style="flex-grow: 2;">
							<p style="font-size:200%;">${loginId}님 </p>
							<p style="font-size:150%;">환영합니다!</p>
						</div>
						<div class="mt-3" style="flex-grow: 3"></div>
					</div>
				</div>
				<div class="row pb-5">
					<div >
						<div id="loginButton" style="width: 300px; height: 60px"
							class="btn btn-black btn-sm">
							<a href="../user/LogoutController">로그아웃</a>
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
		<button class="btn btn-dark " style="width:100%" onclick="resetCategory()">reset</button>
		<form onchange="categoryUpdate()">
			<div id="menu1" class="my-5">
				<h5>
					<b>그래픽 카드</b>
				</h5>
				<c:forEach var="graphic" items="${graProList}" varStatus="graNum">
					<div class="row my-3 mx-1 productCategory">
						<input id="graphicCard${graNum.count}" name="graphicCard" type="radio" value="${graphic}" /> 
						<label for="graphicCard${graNum.count}" class="my-auto">${graphic}</label>
					</div>
				</c:forEach>
			</div>
			<!-- 메뉴2 -->
			<div id="menu1" class="my-4">
				<h5>
					<b>CPU</b>
				</h5>
				<c:forEach var="cpu" items="${cpuProList}" varStatus="cpuNum">
					<div class="row my-3 mx-1 productCategory">
						<input id="CPU${cpuNum.count }" name="CPU" type="radio" value="${cpu}" /> 
						<label for="CPU${cpuNum.count }" class="my-auto">${cpu}</label>
					</div>
				</c:forEach>
				
			</div>
			<!-- 메뉴3 -->
			<div id="menu1" class="my-4">
				<h5>
					<b>메모리 카드</b>
				</h5>
				<c:forEach var="memory" items="${meProList}" varStatus="meNum">
					<div class="row my-3 mx-1 productCategory">
						<input id="memoryCard${meNum.count}" name="memoryCard" type="radio" value="${memory}" /> 
						<label for="memoryCard${meNum.count}" class="my-auto">${memory}</label>
					</div>
				</c:forEach>
				
			</div>
			<!-- 메뉴4 -->
			<div id="menu1" class="my-4">
				<h5>
					<b>메인 보드</b>
				</h5>
				<c:forEach var="mainBoard" items="${maProList}" varStatus="maNum">
					<div class="row my-3 mx-1 productCategory">
						<input id="mainBoard${maNum.count}" name="mainBoard" type="radio" value="${mainBoard}" /> 
						<label for="mainBoard${maNum.count}" class="my-auto">${mainBoard}</label>
					</div>
				</c:forEach>
				
			</div>
			<div id="menu1" class="my-4">
				<h5>
					<b>운영체재</b>
				</h5>
				<c:forEach var="os" items="${osProList}" varStatus="osNum">
					<div class="row my-3 mx-1 productCategory">
						<input id="os${osNum.count}" name="os" type="radio" value="${os}" /> 
						<label for="os${osNum.count}" class="my-auto">${os}</label>
					</div>
				</c:forEach>
				
			</div>
			<div id="menu1" class="my-4">
				<h5>
					<b>가격</b>
				</h5>
				<div class="row my-3 mx-1 productCategory">
					<input id="price1" name="price" type="radio" value="500000" /> 
					<label for="price1" class="my-auto">0 ~ 50만원</label>
				</div>
				<div class="row m-1 productCategory">
					<input id="price2" name="price" type="radio" value="1000000" /> 
					<label for="price2" class="my-auto">50 ~ 100만원</label>
				</div>
				<div class="row my-3 mx-1 productCategory">
					<input id="price3" name="price" type="radio" value="1500000" /> 
					<label for="price3" class="my-auto">100만원 ~ </label>
				</div>
			</div>
		</form>
	</div>
	<div class="col-12 col-md-8 productListPage">
		<div class="row productList">
			<c:forEach var="product" items="${productList}" varStatus="status">
				<div class="col-12 col-md-6 col-lg-4 p-3">
					<div id="cardStyle" class="card text-center p-4 ">
						<div class="card-head ">
							<div>
								<img class="productImg" src="ImageAttachController?imageId=${product.productImageList[0].imageId}" />
							</div>
						</div>
						<div class="card-body">
							<form id="color1select">
								<div class="colorRadio">
									<c:forEach var="color" items="${product.colorList}" varStatus="coStatus">
										<c:if test="${coStatus.count==1}">
											<input id="color${status.count}-${coStatus.count}" name="color${status.count}" type="radio" value="${color.colorName}" checked="checked"> 
										</c:if>
										<c:if test="${coStatus.count!=1}">
											<input id="color${status.count}-${coStatus.count}" name="color${status.count}" type="radio" value="${color.colorName}" > 
										</c:if>
										<label for="color${status.count}-${coStatus.count}" class="border rounded-circle my-auto" style="background-color: ${color.colorName};"></label> 
									</c:forEach>
								</div>
							</form>
	
							<h4 class="my-2">${product.productName}</h4>
							<p>${product.productId}</p>
							<p>${product.productPrice }원</p>
	
							<a id="detailButton" href="../product/ProductDetailController?productId=${product.productId}" class="w-btn w-btn-indigo">구매하기</a>
						</div>
					</div>
				</div>
			</c:forEach>			


		</div>

		<!-- 페이징 -->
		<div class="pageBtn" style="text-align: center">
			<button onclick="pageUpdate(1)" class="btn btn-outline-primary btn-sm pagerBtn">처음</button>
			<c:if test="${pager.groupNo>1 }">
				<button onclick="pageUpdate(${pager.pageNo+1})" class="btn btn-outline-info btn-sm pagerBtn">이전</button>
			</c:if>
			<c:forEach var="i" begin="${pager.startPageNo }"
				end="${pager.endPageNo}">
				<c:if test="${pager.pageNo !=i }">
					<button onclick="pageUpdate(${i})" class="btn btn-outline-success btn-sm pagerBtn">${i}</button>
				</c:if>
				<c:if test="${pager.pageNo==i }">
					<button style="background-color: #e0e0e0" class="btn btn-danger btn-sm pagerBtn">${i}</button>
				</c:if>
			</c:forEach>
			<c:if test="${pager.groupNo<pager.totalGroupNo }">
				<button onclick="pageUpdate(${pager.pageNo+1})" class="btn btn-outline-info btn-sm pagerBtn">다음</button>
			</c:if>
			<button onclick="pageUpdate(${pager.totalPageNo})" class="btn btn-outline-primary btn-sm pagerBtn">맨끝</button>
		</div>
		<%-- <div class="pageBtn" style="text-align: center">
				<a href="ProductListController?pageNo=1"
					class="btn btn-outline-primary btn-sm pagerBtn">처음</a>
				<c:if test="${pager.groupNo>1 }">
					<a href="ProductListController?pageNo=${pager.pageNo-1}"
						class="btn btn-outline-info btn-sm pagerBtn">이전</a>
				</c:if>
				<c:forEach var="i" begin="${pager.startPageNo }"
					end="${pager.endPageNo}">
					<c:if test="${pager.pageNo !=i }">
						<a href="ProductListController?pageNo=${i}"
							class="btn btn-outline-success btn-sm pagerBtn">${i}</a>
					</c:if>
					<c:if test="${pager.pageNo==i }">
						<a href="ProductListController?pageNo=${i}"
							style="background-color: #e0e0e0"
							class="btn btn-danger btn-sm pagerBtn">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${pager.groupNo<pager.totalGroupNo }">
					<a href="ProductListController?pageNo=${pager.pageNo+1}"
						class="btn btn-outline-info btn-sm pagerBtn">다음</a>
				</c:if>
				<a href="ProductListController?pageNo=${pager.totalPageNo}"
						class="btn btn-outline-primary btn-sm pagerBtn">맨끝</a>
		</div> --%>

	</div>
</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>