<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/upload.css">
<script src="../resources/javascript/upload.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp"%>
<%@ include file="/WEB-INF/views/common/adminMenu.jsp"%>

<div id="centerBoard" class="col-12 col-md mt-5 ">
	<form  method="post" enctype="multipart/form-data">
		<table class="talbe table-bordered mb-5" style="background-color:white;">
			<thead style="height:30px;">
				<tr class="submitButton">
					<th colspan="7" >	
					</th>	
					<th class="px-5">
						<button type="button" id="insertSubmit" onclick="appendTable()" class="btn btn-sm btn-dark" value="추가하기" style="width:100%;">추가하기</button>
					</th>
					<th class="px-5">
						<button id="joinSubmit" type="submit" class="btn btn-sm btn-dark" value="저장하기" style="width:100%;">저장하기</button>
					</th>
					<th class="px-5">
						<input id="joinSubmit" type="reset" class="btn btn-sm btn-dark" value="reset"style="width:100%;"/>
					</th>
					<th></th>
				</tr>
				<tr style="font-size:130%;">
					<th style="width:150px;">ID</th>
					<th style="width:150px;">이름</th>
					<th style="width:150px;">가격</th>
					
					<th style="width:150px;">그래픽 카드</th>
					<th style="width:150px;">CPU</th>
					<th style="width:150px;">메인 보드</th>
					<th style="width:150px;">OS</th>
					<th style="width:150px;">Memory</th>
					<th style="width:150px;">color</th>
					<th style="width:150px;">용량</th>
					<th style="width:150px;">사진</th>
				</tr>
			</thead>
			<tbody id="subTable" style="height:70px;">	
				<tr id="insertValue">
					<td class="px-3">
						<input type="text" name="productId" style="width:100px;"/>
					</td>
					<td class="px-3">
						<input type="text" name="productName" style="width:100px;"/>
					</td>
					<td class="px-3">
						<input type="text" name="productPrice" style="width:100px;"/>
					</td>
					
					<!-- 그래픽 카드 -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="productGraphicCard">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								
							</select>
						</div>
					</td>
					<!-- cpu -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="CPU">
								<option>AMD 7773X</option>
								<option>Intel 8380</option>
								<option>Intel Core i7</option>
								
							</select>
						</div>
					</td>
					<!-- main board -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="mainboard">
								<option>B450 AORUS</option>
								<option>ASUS B550M-PLUS</option>
								<option>GIGABYTE B550M</option>
								
							</select>
						</div>
					</td>
					<!-- os -->
					<td class="px-3">
						<div class="form-group" >
							<select class="form-control" id="os">
								<option>Windows</option>
								<option>Linux</option>
								<option>MacOS</option>
								
							</select>
						</div>
					</td>
					<!-- memory -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="memory">
								<option>삼성전자 DDR4 8GB</option>
								<option>South Bridge DDR3 8GB</option>
								<option>G Skill DDR4 16G</option>
								
							</select>
						</div>
					</td>
					<!-- color-->
					<td class="px-3">
						<div class="form-group">
							<table style="width:100%; height:100%">
								<tr>
									<td class="colorBtn" style="background-color:black">
										<input style="display:none" type="checkbox" id="black" name="colors" value="black"/>
										<label  for="black"  style="color:black">V</label>
									</td>
									<td class="colorBtn" style="background-color:white">
										<input style="display:none" type="checkbox" id="white" name="colors" value="white"/>
										<label  for="white" style="color:white">V</label>
									</td>
									<td class="colorBtn" style="background-color:gray">
										<input style="display:none" type="checkbox" id="gray" name="colors" value="gray"/>
										<label for="gray" style="color:gray">V</label>
									</td>
								</tr>
								<tr>
									<td class="colorBtn" style="background-color:red">
										<input style="display:none" type="checkbox" id="red" name="colors" value="red"/>
										<label  for="red" style="color:red">V</label>
									</td>
										
									<td class="colorBtn" style="background-color:blue">
										<input style="display:none" type="checkbox" id="blue" name="colors" value="blue"/>
										<label  for="blue" style="color:blue">V</label>
									</td>
									<td class="colorBtn" style="background-color:green">
										<input style="display:none" type="checkbox" id="green" name="colors" value="green"/>
										<label  for="green" style="color:green">V</label>
									</td>
								</tr>
								<tr>
									<td class="colorBtn" style="background-color:yellow">
										<input style="display:none" type="checkbox" id="yellow" name="colors" value="yellow"/>
										<label for="yellow" style="color:yellow">V</label>
									</td>
										
									<td class="colorBtn" style="background-color:purple">
										<input style="display:none" type="checkbox" id="purple" name="colors" value="purple"/>
										<label  for="purple" style="color:purple">V</label>
									</td>
									<td class="colorBtn" style="background-color:brown">
										<input style="display:none" type="checkbox" id="brown" name="colors" value="brown"/>
										<label class="colorBtn" for="brown" style="color:brown">V</label>
									</td>
								</tr>
							</table>
							
						</div>
					</td>
					<!-- 용량 -->
					<td class="px-3">
						<div class="form-group capacityBtn">
							<input style="display:none" type="checkbox" id="capacity1" name="capacity" value="256GB"/>
							<label for="capacity1">256GB</label>
							<input style="display:none" type="checkbox" id="capacity2" name="capacity" value="512GB"/>
							<label for="capacity2">512GB</label>
							<input style="display:none" type="checkbox" id="capacity3" name="capacity" value="1TB"/>
							<label for="capacity3">1TB</label>
							
						</div>
					</td>
					<!-- 이미지 -->
					<td class="px-3">
						<div class="form-group">
							<label class="input-file-button" for="proImg">
							  업로드
							</label>
							<input id="proImg" type="file" multiple="multiple"  style="display:none;" />
						</div>
					</td>
				</tr>
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
			</tbody>
		</table>
		
		 <!-- submit -->
		<!--<table id="btnTable" class="talbe table-bordered" style="width:150px; height:50px;" >
			<thead>
				<tr>
					<th class="px-5">
						<button id="joinSubmit" type="submit" class="btn btn-lg" value="추가하기" >추가하기</button>
					</th>
					<th class="px-5">
						<button id="joinSubmit" type="submit" class="btn btn-lg" value="저장하기" >저장하기</button>
					</th>
					<th class="px-5">
						<input id="joinSubmit" type="reset" class="btn btn-lg" value="reset"/>
					</th>
				</tr>
			</thead>
		</table>
		 -->
	</form>
	<div class="modal fade" id="uploadModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">상품등록</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">상품등록이 완료되었습니다.</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>


