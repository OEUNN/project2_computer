<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/order.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../resources/javascript/order.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

<div id="order_Wrapper" class="row">
	<form method="post" action="OrderController" onsubmit="return check()" class="order_main col-8 col-md-12">
		<div class="order_sub">
			<h3 style="text-align: left; font-weight: bold;">결재 내역</h3>
			<hr />
			<div class="orderTable ">
			<c:set var="sum" value="0"/>
			<c:forEach var="orderDetail" items="${orderDetail}">
						<table class=" table table-hover">
							<thead>
								<tr>		
									<th>이미지</th>
									<th>상품</th>
									<th>가격</th>
									<th>수량</th>
								</tr>
							</thead>
							<tbody>
								<tr>
								<td>
                 					<span>
	                 					<img src="ImageAttachController?imageId=${orderDetail.product.productImageList[0].imageId}" width="100"/> 
                 					</span> 
                 					<br/>
               						
								</td>
								<td>
									<div>
										${orderDetail.product.productId} <span>(${orderDetail.color.colorName},${orderDetail.capacity.capacityName} 택)</span>
									</div>
								</td>
								<td><div>${orderDetail.product.productPrice}</div></td>
								<td><div>${orderDetail.productQnt}</div></td>
								</tr>	
							</tbody>
						</table>
						<c:set var= "sum" value="${sum + orderDetail.price}"/>
					</c:forEach>
						<hr />
							<h4 id="totalPrice">
								총액 : <span><c:out value="${sum}"/></span>원
							</h4>
			
			</div>
		</div>
		<div class="order_sub">
			<!-- 받는사람입력 -->
			<div class="form-group ">
				<label for="user_id" class="order_title">받는사람</label> 
				<input id="user_id" name="user_id" type="text" class="form-control " /> 
				<small id="user_idHelp" class="form-text text-muted"></small>
				<p id="id_message"></p>
			</div>


			<!-- 전화번호 -->
			<div class="form-group">
				<label for="user_phone" class="join_title">전화번호</label> 
				<input id="user_phone" name="user_phone" type="text" class="form-control" /> 
				<small id="user_phoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
				<p id="phone_message"></p>
			</div>


			<!-- 주소 -->
			<div class="form-group">
				<label for="user_address" class="join_title">주소</label> 
				<input id="addrBtn" class="m-3" type="button" value="주소 검색" onclick="findAddr()"readonly style="background-color:#0c1c32;color:white;width:100px;" />
				 <input id="userPost" type="text"  class="form-control" name="userPost" placeholder="우편번호" />
				<input id="userAddr" type="text"  class="form-control" name="userAddr" placeholder="주소"/>
				<input id="userDetailAddr" type="text" class="form-control" name="userDetailAddr" placeholder="상세 주소를 입력하세요."/>
				<p id="address_message"></p>
			</div>
			<!-- submit -->
			<div class="text-center mt-4">
				<button id="order_submit" type="submit" class="btn btn-dark">결제하기</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>