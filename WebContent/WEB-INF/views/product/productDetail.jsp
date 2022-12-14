<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header1.jsp"%>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/productDetail.css">
<script src="../resources/javascript/productDetail.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp"%>


<div id="detail" class="row">
	<div class=" col-1 col-md-1"></div>
	<div class=" col-12 col-md-12 col-lg-5 ">
		
		<div class="pt-4" style="width: 100%">
			<img class="slides productImg" src="ImageAttachController?imageId=${product.productImageList[0].imageId}" style="width:100%;"/>
			<img class="slides productImg" src="ImageAttachController?imageId=${product.productImageList[1].imageId}" style="width:100%;display:none"/>
			<img class="slides productImg" src="ImageAttachController?imageId=${product.productImageList[2].imageId}" style="width:100%;display:none"/>
		</div>
		<div class="row">
			<c:forEach var="productImg" items="${product.productImageList}" varStatus="proImg">
				<div class="pt-4 col-2" style="width: 100%">
					<c:if test="${proImg.index<3}">
						<img class="demo" src="ImageAttachController?imageId=${productImg.imageId}" onclick="currentDiv(${proImg.count})" />
					</c:if>
				</div>	
			</c:forEach>
			<%-- <div class="pt-4 col-2" style="width: 100%">
				<img class="demo" src="ImageAttachController?imageId=${product.productImageList[1].imageId}" onclick="currentDiv(2)" />
			</div>
			<div class="pt-4 col-2" style="width: 100%">
				<img class="demo" src="ImageAttachController?imageId=${product.productImageList[2].imageId}" onclick="currentDiv(3)" />
			</div> --%>
		</div>
	</div>
	<div class=" col-1 col-md-1"></div>
	<div id="item-info" class="d-none d-md-none d-lg-inline col-lg-4 m-4">
		<div class="item-detail border " style="height: 100%">
			<div class="mt-3 mx-4 " style="font-size: 200%">
				<b>${product.productName}</b>
			</div>
			<div id="productId" class="mb-3 mx-4">${product.productId}</div>
			<div class="flex-container">
				<div class="mx-5" style="flex-grow: 5; text-align: center">
					<h4>판매가</h4>
				</div>
				<div class="mx-5" style="flex-grow: 5; text-align: center">
					<h4>
						<b>${product.productPrice}</b>원
					</h4>
				</div>

			</div>
			<form method="post" id="detail-form" action="LoginController">
				<input type="hidden" name="productId" value="${product.productId}" />
				<input type="hidden" name="price" value="${product.productPrice}" />
				<div class="option  mt-4 mr-4 mb-2 ml-4" style="height: 350px">
					<div style="height: 80px; text-align: center; padding-top: 10px">
						색상
						<div class="colorRadio" style="height: 30px">
							<c:forEach var="color" items="${product.colorList}" varStatus="coStatus">
								<c:if test="${coStatus.count==1}">
									<input id="color1-${coStatus.count}" name="colorId" type="radio" value="${color.colorId}" checked="checked"> 
								</c:if>
								<c:if test="${coStatus.count!=1}">
									<input id="color1-${coStatus.count}" name="colorId" type="radio" value="${color.colorId}" > 
								</c:if>
								<label for="color1-${coStatus.count}" class="border rounded-circle" style="background-color: ${color.colorName};"></label> 
							</c:forEach>
						</div>

					</div>
					<div class="mt-3" style="text-align: center; height: 80px">
						용량
						<div class="capaRadio">
							<c:forEach var="capa" items="${product.capacityList}" varStatus="caStatus">
								<c:if test="${caStatus.count==1}">
									<input id="capa1-${caStatus.count}" name="capaId" type="radio" value="${capa.capacityId}" checked="checked"> 
								</c:if>
								<c:if test="${caStatus.count!=1}">
									<input id="capa1-${caStatus.count}" name="capaId" type="radio" value="${capa.capacityId}" > 
								</c:if>
								<label for="capa1-${caStatus.count}" class="border rounded" style="padding-top: 8px;">${capa.capacityName}</label> 
							</c:forEach>
						</div>
					</div>
					<hr />
					<div class="quan pb-4">
						<div style="flex-grow: 7; vertical-align: centr; text-align: center; padding-top: 18px">
							<h5>수량</h5>
						</div>
						<div style="flex-grow: 3; justify-content: center;"class=" quan-icon">

							<div class="m-3">
								<input onchange="updatePrice()" id="quantity" name="quantity" value="1" type="number" min="1" />
							</div>
						</div>

					</div>

					<div class="price">
						<div style="flex-grow: 5; text-align: center">
							<h3>판매가</h3>
						</div>
						<div style="flex-grow: 5; text-align: center">
							<h3>
								<b>${product.productPrice}</b>원
							</h3>
						</div>
					</div>



				</div>

				<div class="flex-container-button mt-2 ">
					<div style="flex-grow: 5">
						<!-- Button to Open the Modal -->
						<!-- <input onClick="window.location.href='CreateBasketDetailController'" value="장바구니" type="button" class="w-btn w-btn-indigo mx-1" data-toggle="modal" data-target="#myModal"/>
			        -->	<!-- 로그인 OFF -->
						<c:if test="${loginId==null}">
							<a href="../user/LoginController"  class="w-btn w-btn-indigo mx-1">장바구니</a>
						
						</c:if>
						
						<c:if test="${loginId!=null}">
							<button form="detail-form" type="button" class="w-btn w-btn-indigo mx-1"  data-toggle="modal"data-target="#myModal">장바구니</button>
						
							<!-- The Modal -->
							<div class="modal fade" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">
	
										<!-- Modal Header -->
										<div class="modal-header">
											장바구니 담기
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
	
										<!-- Modal body -->
										<div class="modal-body">장바구니에 상품을 담으시겠습니까?</div>
	
										<!-- Modal footer -->
										<div class="modal-footer">
	
											<button type="button" onClick="goBasket()" class="w-btn w-btn-indigo mx-1">네</button>
											<button type="button" class="w-btn w-btn-indigo mx-1" data-dismiss="modal">아니오</button>
	
										</div>
	
									</div>
								</div>
							</div>
							</c:if>
						</div>
						<div style="flex-grow: 5">
							<c:if test="${loginId==null}">
								<a href="../user/LoginController"  class="w-btn w-btn-indigo mx-1">구매하기</a>
							</c:if>
							<c:if test="${loginId!=null}">			
								<button type="button" onClick="goOrder()" id="Product_Detail_submit"  class="w-btn w-btn-indigo mx-1">구매하기</button>
							</c:if>
						</div>
	
					</div>
				
			</form>


		</div>
	</div>

	<div id="item-info" class=" d-lg-none col-lg-4 border mb-2">
		<div class="item-detail border " style="height: 350px">
			<div class=" mx-4 mt-3" style="font-size: 200%">
				<b>${product.productName}</b>
			</div>
			<div class=" mx-4">${product.productId}</div>
			<div class="flex-container p-3">
				<div class="mx-5" style="flex-grow: 5; text-align: left">
					<b>판매가</b>
				</div>
				<div class="mx-5" style="flex-grow: 5; text-align: right">
					${product.productPrice}원</div>

			</div>

			<div class="option-mini  p-3">

				<div class="mx-5" style="flex-grow: 5; text-align: left">
					<b>색상</b>
				</div>
				<div class="mx-5" style="flex-grow: 5; text-align: right">
					<div class="colorRadio" style="height: 30px">
						<c:forEach var="color" items="${product.colorList}" varStatus="minCoStatus">
							<c:if test="${minCoStatus.count==1}">
								<input id="color1-${minCoStatus.count}" name="color1" type="radio" value="${color.colorName}" checked="checked">
							</c:if>
							<c:if test="${minCoStatus.count!=1}">
								<input id="color1-${minCoStatus.count}" name="color1" type="radio" value="${color.colorName}">
							</c:if>
								<label for="color1-${minCoStatus.count}" class="border rounded-circle " style="background-color: ${color.colorName};"></label> 
						</c:forEach>
						
					</div>

				</div>

				<div class="mx-5" style="flex-grow: 5; text-align: left">
					<b>용량</b>
				</div>
				<div class="mx-5" style="flex-grow: 5; text-align: right">
					<div class="capaRadio">
						<c:forEach var="capa" items="${product.capacityList}" varStatus="minCaStatus">
							<c:if test="${minCaStatus.count==1}">
								<input id="capa1-${minCaStatus.count}" name="capa1" type="radio" value="${capa.capacityName}" checked="checked"> 
							</c:if>
							<c:if test="${minCaStatus.count!=1}">
								<input id="capa1-${minCaStatus.count}" name="capa1" type="radio" value="${capa.capacityName}" > 
							</c:if>
							<label for="capa1-${minCaStatus.count}" class="border rounded" style="width:50px; text-align:center;padding-top: 8px;">${capa.capacityName}</label> 
						</c:forEach>
						<!-- <input id="capa1-1" name="capa1" type="radio" value="512GB" checked="checked"> <label for="capa1-1" class="border rounded " style="padding-top: 8px;">512GB</label>
						<input id="capa1-2" name="capa1" type="radio" value="256GB">
						<label for="capa1-2" class="border rounded" style="padding-top: 8px;">256GB</label> 
						<input id="capa1-3" name="capa1" type="radio" value="1TB"> 
						<label for="capa1-3" class="border rounded " style="padding-top: 8px;">1TB</label> -->

					</div>

				</div>


			</div>
			<hr />

			<div class="flex-container-button">
				<div style="flex-grow: 5" class="px-3">
					<a href="" class="w-btn w-btn-indigo" style="width: 100%" data-toggle="modal" data-target="#myModal">장바구니</a>
				</div>
				<div style="flex-grow: 5;" class="px-3">
					<a href="" class="w-btn w-btn-indigo" style="width: 100%">구매하기</a>
				</div>

			</div>


		</div>
	</div>


</div>
<div id="p-name" class="row">
	<div class="col-1"></div>
	<div class="my-auto">${product.productName}</div>

</div>
<div class="row">
	<div class="col-1"></div>
	<div class="col-10">
		<c:forEach var="ad" items="${product.productImageList}" varStatus="imgStatus">
			<c:if test="${imgStatus.index>=3}">
				<img src="ImageAttachController?imageId=${ad.imageId}" />
			</c:if>
		</c:forEach>
	</div>
	<div class="col-1"></div>

</div>

<div id="p-name" class="row">
	<div class="col-1"></div>
	<div class="my-auto col-4">
		<b>Review</b>
	</div>
	<div class="m-auto col-3  "></div>
	<div class="my-auto col-2 ">
		<button class="w-btn w-btn-indigo" style="width: 100%" data-toggle="modal" data-target="#reviewModal">리뷰작성</button>
	</div>
	<div class="col-1"></div>

</div>

<div id="review" class="row">
	<div class="col-1"></div>
	<div class="col-10">
		<table>
			<tr>
				<td>1</td>
				<td>
					<div>
						<a role="button" data-toggle="collapse" href="#reivew1Content" aria-expanded="false" aria-controls="collapseExample">웹 프로그래밍</a>
					</div>
					<div class="collapse" id="reivew1Content">
						<div class="well">
							<br /> 축구 졌어잉 <br />
						</div>
					</div>

				</td>
				<td>ys1**</td>
				<td>2022.11.15</td>
			</tr>

			<tr>
				<td>2</td>
				<td>
					<div>
						<a role="button" data-toggle="collapse" href="#reivew2Content" aria-expanded="false" aria-controls="collapseExample">웹 프로그래밍</a>
					</div>
					<div class="collapse" id="reivew2Content">
						<div class="well">
							<br /> 축구 졌어잉 <br />
						</div>
					</div>
				</td>
				<td>tmd***</td>
				<td>2022.11.15</td>
			</tr>

			<tr>
				<td>3</td>
				<td>
					<div>
						<a role="button" data-toggle="collapse" href="#reivew3Content" aria-expanded="false" aria-controls="collapseExample">웹 프로그래밍</a>
					</div>
					<div class="collapse" id="reivew3Content">
						<div class="well">
							<br /> 축구 졌어잉 <br />
						</div>
					</div>
				</td>
				<td>tmd***</td>
				<td>2022.11.15</td>
			</tr>

			<tr>
				<td>4</td>
				<td>
					<div>
						<a role="button" data-toggle="collapse" href="#reivew4Content" aria-expanded="false" aria-controls="collapseExample">웹 프로그래밍</a>
					</div>
					<div class="collapse" id="reivew4Content">
						<div class="well">
							<br /> 축구 졌어잉 <br />
						</div>
					</div>
				</td>
				<td>tmd***</td>
				<td>2022.11.15</td>
			</tr>







		</table>
	</div>
	<div class="col-1"></div>


</div>



</div>


<!-- The Modal -->
<div class="modal fade" id="reviewModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">리뷰 작성</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">


				<form action="#">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="제목을 입력해주세요" id="title">
					</div>

					<div class="form-group" style="height: 100%">
						<textarea style="height: 300px; width: 100%" name="inquiryContent" id="inquiryContent" placeholder="문의 내용을 입력해 주세요. (500자 이내)"></textarea>
					</div>
					<%-- <div><button type="button" class="btn btn-secondary">사진 업로드</button></div>
                        <br/>
                        <div class="qnaNoti">
                           <p>상품과 무관한 사진/동영상을 첨부한 리뷰는 통보없이 삭제될 수 있습니다.</p>
                          
   
                        </div> --%>

				</form>

			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="submit" onClick="ProductDetailController" class="btn btn-secondary">등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

			</div>



		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>