<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/basket.css">
<script src="../resources/javascript/basketUpdate.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

<!-- body -->
<div id="body" class="row" >
	<!-- 왼쪽 빈공간 -->
	<div class="col-0 col-md-2"></div>
	
	<!-- 메인 -->
	<div id="basketMain" class="col-12 col-md mt-5 mr-5">
       		<h3 id="basketLogo" class="m-3">장바구니</h3>
       		<hr/>
       		<form method="post" style="width:100%" class="row" action="${pageContext.request.contextPath}/product/CreateOrderController">
       			
       			<div class="basketTable col-9">
        			<div id="deleteBasket"  style="text-align:right"><span class="btn" onclick="deleteBasket()">선택항목 삭제</span></div>
         	
         		
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
         			<c:if test="${basket.totalPrice==0}"> 
         				<tr>
	         				<td colspan="5" style="font-size:20px;color:gray">
		         				장바구니에 담긴 상품이 없습니다.
		         			</td>
	         			</tr>
	         		</c:if>
	         		
         			<c:forEach  var="basketDetail" items="${basket.basketDetail}" >			
         				<tr class="basketDetailOne">
	         				<td>
	         					<div>
	         						<input type="checkbox" onclick="check()" value="${basketDetail.basketDetailId}"name="basket"/>
	         						<input type="hidden" name="colorId" value="${basketDetail.color.colorId }"/>
       								<input type="hidden" name="capaId" value="${basketDetail.capacity.capacityId }"/>
       								<input type="hidden" name="price" value="${basketDetail.product.productPrice }"/>
       								<input type="hidden" name="productId" value="${basketDetail.product.productId }"/>
       								<input type="hidden" name="quantity" value="${basketDetail.productQnt }"/>
	         					</div>
	         				</td>
	         				<td >
	         					<img src="ImageAttachController?imageId=${basketDetail.product.productImageList[0].imageId}"/>
	         				</td>
	         				<td>
	         					<div >
	         						${basketDetail.product.productName }	
	         						<span style="font-size: 15px;color: gray">(${basketDetail.color.colorName },${basketDetail.capacity.capacityName} 택)</span>
	         					</div>
	         				</td>
	         				<td><div>${basketDetail.product.productPrice}원</div></td>
	         				<td><div>${basketDetail.productQnt }</div></td>
	         				
         				</tr>
         			</c:forEach>
         			
         		</table>
         		
				
       			</div>
       			<div id="submit" class="col-3 card">
       				<div class="card-header">
       					<h5><i class="fas">&#xf3c5;</i> 최근 배송지</h5>
       					<p>서울특별시 종로구 창경궁로 254 4층</p>
       					<button class="btn rounded-0" type="submit" style="background-color: white; width:100% ;border:1px solid black;">배송지 변경하기</button>
       				
       				</div>
       				<div class="card-body rowPrice">
       					<h5><i class="fas">&#xf07a;</i>전체 주문:<span class="totalQuantity">${count}</span>개 </h5>
       					
       					<hr/>
       					<h4 id="totalPrice">총액 : <span class="totalPrice">${basket.totalPrice}</span>원</h4>
       				</div>
       				<div class="card-footer">
       					<button class="btn rounded-0" type="submit" style="background-color: #0c1c32; color:#f8f8f8; width:100% ">주문하기</button>
       				</div>
       			</div>
       		</form>
       	</div>
       	<!-- 오른쪽 빈공간 -->
	<div class="col-0 col-md-2"></div>	
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>