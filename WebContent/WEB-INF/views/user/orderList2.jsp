<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/orderList.css">
<%@ include file="/WEB-INF/views/common/header2.jsp" %>
<%@ include file="/WEB-INF/views/common/mypageMenu.jsp" %>


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
			<table id="order" class=" table table-hover">
         			<tr>
         			
         				<th>구매일자</th>
         				<th>주문번호</th>
         				<th>구매상품</th>
         				<th>수량</th>
         				
         			</tr>
         			
	         		<c:forEach  var="orders" items="${orders}" >	
	         		
	         	
		         			<c:forEach  var="orderDetail" items="${orders.orderDetail}" >			
		         				<tr class="basketDetailOne">
			         				
			         				<td >
			         					${orders.orderDate}
			         				</td>
			         				<td>
			         					${orders.orderId}
			         				</td>
			         				<td><div >
			         						${orderDetail.product.productName }	
			         						<span style="font-size: 15px;color: gray">(${orderDetail.color.colorName },${orderDetail.capacity.capacityName} 택)</span>
			         					</div>
			         				</td>
			         				<td><div>${orderDetail.productQnt }</div></td>
			         				
		         				</tr>
		         			</c:forEach>
         				</c:forEach>
         			
         		</table>

		</div>
	</div>
	
	
	<div class="col-0 col-md-1 "></div>
</div>
