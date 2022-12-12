<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 몸통 -->
<div id="body" class="row">
 
	<!-- menu -->
	<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
		<div class="ml-5 mt-5 btn btn-black btn-sm" >
			<a style="font-size:250%;" href="${pageContext.request.contextPath}/user/MypageController">관리자 페이지</a>
			<div class="row m-3">
				<div id="userUpdate"class="btn btn-black btn-sm" style="font-size:150%;">
					<a  href="${pageContext.request.contextPath}/user/UserUpdataController" >>회원 관리</a>
				</div>
			</div>
			<div class="row m-3">
				<div id="orderList" class="btn btn-black btn-sm" style="font-size:150%;">
					<a href="${pageContext.request.contextPath}/user/OrderListController">>상품 관리</a>
				</div>
			</div>
			<div class="row m-3">
				<div id="cartList" class="btn btn-black btn-sm" style="font-size:150%;">
					<a  href="${pageContext.request.contextPath}/product/BasketListController">>1:1문의 관리</a>
				</div>
			</div>
			<div class="row m-3">
				<div id="content" class="btn btn-black btn-sm" style="font-size:150%;">
				<a href="${pageContext.request.contextPath}/board/QnaBoardController">>리뷰 관리</a>
			</div>
			</div>
		</div>
	</div>