<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/basket.css">
<script src="/resources/javascript/basketUpdate.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

<!-- body -->
<div id="body" class="row" >
	<!-- 왼쪽 빈공간 -->
	<div class="col-0 col-md-2"></div>
	
	<!-- 메인 -->
	<div id="basketMain" class="col-12 col-md mt-5 mr-5">
       		<h3 id="basketLogo" class="m-3">장바구니</h3>
       		<hr/>
       		<form style="width:100%" class="row" action="${pageContext.request.contextPath}/product/OrderController">
       			<div class="basketTable col-9">
        			<div id="deleteBasket"  style="text-align:right"><span class="btn" onclick="deleteBasket()">선택항목 삭제</span></div>
         		<div id="appendBasket"  style="text-align:right"><span class="btn" onclick="appendBasket()">항목 추가</span></div>
         		
         		<table class=" table table-hover">
         			<tr>
         				<th>
         					<input onclick="selectAll()" type="checkbox" id="basketAll" name="basketAll"/>
         					<label for="basketAll" style="font-size: 8px;font-weight: nomal; ">전체 선택</label>
         				</th>
         				<th>이미지</th>
         				<th>상품</th>
         				<th>가격</th>
         				<th>수량</th>
         				
         			</tr>
         			<%-- <tr>
         				<td>
         					<div>
         						<input type="checkbox" id="basket1" name="basket1"/>
         					</div>
         				</td>
         				<td >
         					<img src="../resources/images/monitor.png"/>
         				</td>
         				<td>
         					<div >
         						컴퓨터1	
         						<span>(black,512GB 택)</span>
         					</div>
         				</td>
         				<td><div>500,000원</div></td>
         				<td><div>2</div></td>
         				
         			</tr>
         			<tr>
         				<td>
         					<div>
         						<input type="checkbox" id="basket2" name="basket2"/>
         					</div>
         				</td>
         				<td >
         						<img src="../resources/images/monitor.png"/>
         				</td>
         				<td>
         					<div>컴퓨터2
         						<span>(white,512GB 택)</span>
         					</div>
         				</td>
         				<td><div>500,000원</div></td>
         				<td><div>3</div></td>
         				
         			</tr> --%>
         			
         		</table>
         		
				
       			</div>
       			<div id="submit" class="col-3 card">
       				<div class="card-header">
       					<h5><i class="fas">&#xf3c5;</i> 최근 배송지</h5>
       					<p>서울특별시 종로구 창경궁로 254 4층</p>
       					<button class="btn rounded-0" style="background-color: white; width:100% ;border:1px solid black;">배송지 변경하기</button>
       				
       				</div>
       				<div class="card-body rowPrice">
       					<h5><i class="fas">&#xf07a;</i>전체 주문:<span >0</span>개 </h5>
       					
       					<hr/>
       					<h4 id="totalPrice">총액 : <span>0</span>원</h4>
       				</div>
       				<div class="card-footer">
       					<button class="btn rounded-0" type="submit" style="background-color: #0c1c32; color:#f8f8f8; width:100% ">선택항목 주문하기</button>
       				</div>
       			</div>
       		</form>
       	</div>
       	<!-- 오른쪽 빈공간 -->
	<div class="col-0 col-md-2"></div>	
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>