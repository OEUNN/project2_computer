<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row productList">
			<c:forEach var="product" items="${productList}" varStatus="status">
				<div class="col-12 col-md-6 col-lg-4 p-3">
					<div id="cardStyle" class="card text-center p-4 ">
						<div class="card-head ">
							<div>
								<img class="productImg"  src="ImageAttachController?imageId=${product.productImageList[0].imageId}" />
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