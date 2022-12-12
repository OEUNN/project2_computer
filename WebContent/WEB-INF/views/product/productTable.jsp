<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="product" items="${productList}" varStatus="status">
	<tr>
		<td class="px-3">
			<span>${product.productId}</span>
		</td>
		<td class="px-3">
			<span>${product.productName}</span>
		</td>
		<td class="px-3">
			<span>${product.productPrice}</span>
		</td>
		
		<!-- 그래픽 카드 -->
		<td class="px-3">
			<div class="form-group">
				<span>${product.productGraphicCard}</span>
			</div>
		</td>
		<!-- cpu -->
		<td class="px-3">
			<div class="form-group">
				<span>${product.CPU}</span>
			</div>
		</td>
		<!-- main board -->
		<td class="px-3">
			<div class="form-group">
				<span>${product.mainboard}</span>
			</div>
		</td>
		<!-- os -->
		<td class="px-3">
			<div class="form-group" >
				<span>${product.os}</span>
			</div>
		</td>
		<!-- memory -->
		<td class="px-3">
			<div class="form-group">
				<span>${product.memory}</span>
			</div>
		</td>
		<!-- color-->
		<td class="px-3">
			<div class="form-group">
				<c:forEach var="color" items="${product.colorList}">
					<span>${color.colorName}</span>
				</c:forEach>
			</div>
		</td>
		<!-- 용량 -->
		<td class="px-3">
			<div class="form-group">
				<c:forEach var="capacity" items="${product.capacityList}">
					<span>${capacity.capacityName}</span>
				</c:forEach>
			</div>
		</td>
		<!-- 이미지 -->
		<td class="px-3">
			<div class="form-group">
				<img src="ImageAttachController?imageId=${product.productImageList[0].imageId}"/>
			</div>
		</td>
	</tr>
</c:forEach>