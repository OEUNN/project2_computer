<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 몸통 -->
<div id="body" class="row">

	<!-- menu -->
	<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
		<div class="ml-5 mt-5 btn btn-black btn-sm" >
			<a style="font-size:250%;" href="${pageContext.request.contextPath}/user/MypageController">마이페이지</a>
			<div class="row m-3">
				<div id="userUpdate"class="btn btn-black btn-sm" style="font-size:150%;">
					<a  href="${pageContext.request.contextPath}/user/UserUpdataController" >>개인정보</a>
				</div>
			</div>
			<div class="row m-3">
				<div id="orderList" class="btn btn-black btn-sm" style="font-size:150%;">
					<a href="${pageContext.request.contextPath}/user/OrderListController">>주문내역</a>
				</div>
			</div>
			<div class="row m-3">
				<div id="cartList" class="btn btn-black btn-sm" style="font-size:150%;">
					<a  href="${pageContext.request.contextPath}/product/BasketListController">>장바구니</a>
				</div>
			</div>
			<div class="row m-3">
				<div id="content" class="btn btn-black btn-sm" style="font-size:150%;">
				<a href="${pageContext.request.contextPath}/board/QnaBoardController">>1:1 문의</a>
			</div>
			</div>
		</div>
	</div>