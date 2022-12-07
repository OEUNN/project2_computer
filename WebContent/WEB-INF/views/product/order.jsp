<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/order.css">
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

<div id="order_Wrapper" class="row">
	<form class="order_main col-8 col-md-12">
		<div class="order_sub">
			<h3 style="text-align: left; font-weight: bold;">결재 내역</h3>
			<hr />

			<div class="orderTable ">

				<table class=" table table-hover">
					<tr>
						<th>번호</th>
						<th>이미지</th>
						<th>상품</th>
						<th>가격</th>
						<th>수량</th>

					</tr>
					<tr>
						<td>1</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/monitor.png" />
						</td>
						<td>
							<div>
								컴퓨터1 <span>(black,512GB 택)</span>
							</div>
						</td>
						<td><div>500,000원</div></td>
						<td><div>2</div></td>

					</tr>
					<tr>
						<td>2</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/monitor.png" />
						</td>
						<td>
							<div>
								컴퓨터2 <span>(white,512GB 택)</span>
							</div>
						</td>
						<td><div>500,000원</div></td>
						<td><div>3</div></td>

					</tr>

				</table>
				<hr />
				<h4 id="totalPrice">
					총액 : <span>2,500,000</span>원
				</h4>

			</div>
		</div>
		<div class="order_sub">
			<!-- 받는사람입력 -->
			<div class="form-group ">
				<label for="user_id" class="order_title">받는사람</label> <input
					id="user_id" type="text" class="form-control " /> <small
					id="user_idHelp" class="form-text text-muted"></small>
				<p id="id_message"></p>
			</div>


			<!-- 전화번호 -->
			<div class="form-group">
				<label for="user_phone" class="join_title">전화번호</label> <input
					id="user_phone" type="text" class="form-control" /> <small
					id="user_phoneHelp" class="form-text text-muted">예)
					010-123-1234, 010-1234-1234</small>
				<p id="phone_message"></p>
			</div>


			<!-- 주소 -->
			<div class="form-group">
				<label for="user_address" class="join_title">주소</label> <input
					id="user_address" type="text" class="form-control" />
				<p id="address_message"></p>
			</div>
			<!-- submit -->
			<div class="text-center mt-4">
				<input id="order_submit" type="submit" class="btn btn-dark"
					value="결재하기" />
			</div>
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>