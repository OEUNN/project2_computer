<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/upload.css">
<%@ include file="/WEB-INF/views/common/header2.jsp"%>
<%@ include file="/WEB-INF/views/common/adminMenu.jsp"%>

<div id="centerBoard" class="col-12 col-md mt-5 ">
	<form method="post" action="UploadController" onsubmit="return submit()" enctype="multipart/form-data">
		<table class="talbe table-bordered mb-5" style="background-color:white;">
			<thead style="height:30px;">
				<tr style="font-size:130%;">
					<th style="width:150px;">ID</th>
					<th style="width:150px;">이름</th>
					<th style="width:150px;">가격</th>
					<th style="width:150px;">개수</th>
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
				<tr>
					<td class="px-3">
						<input type="text" style="width:100px;"/>
					</td>
					<td class="px-3">
						<input type="text"style="width:100px;"/>
					</td>
					<td class="px-3">
						<input type="text" style="width:100px;"/>
					</td>
					<td class="px-3">
						<input type="text" style="width:100px;"/>
					</td>
					<!-- 그래픽 카드 -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="sel1">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- cpu -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="sel1">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- main board -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="sel1">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- os -->
					<td class="px-3">
						<div class="form-group" >
							<select class="form-control" id="sel1">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- memory -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="sel1">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- color-->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="sel1">
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- 용량 -->
					<td class="px-3">
						<div class="form-group">
							<select class="form-control" id="sel1" >
								<option>PTX 4080</option>
								<option>RTX 3090 Ti</option>
								<option>RTX 3060</option>
								<option>4</option>
							</select>
						</div>
					</td>
					<!-- 이미지 -->
					<td class="px-3">
						<div class="form-group">
							<label class="input-file-button" for="input-file">
							  업로드
							</label>
							<input type="file" id="input-file" style="display:none;" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<!-- submit -->
		<table id="btnTable" class="talbe table-bordered" style="width:150px; height:50px;" >
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


