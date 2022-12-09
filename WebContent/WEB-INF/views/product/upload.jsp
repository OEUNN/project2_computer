<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/upload.css">
<%@ include file="/WEB-INF/views/common/header2.jsp"%>

<form>
	<div id="detail" class="row m-3">
		<div id="sidebar" class=" d-none d-lg-inline col-lg-2">
			<div>
				<h3>관리자 페이지</h3>
			</div>
			<hr />
			<ul>
				<li><a href="#"> <span class="item">회원 관리</span>
				</a></li>
				<li><a href="#"> <span class="item">상품 관리</span>
				</a></li>
				<li><a href="#"> <span class="item">1:1 문의 관리</span>
				</a></li>
				<li><a href="#"> <span class="item">리뷰 관리</span>
				</a></li>
			</ul>

		</div>
		<div class=" col-12 col-md-12 col-lg-5 ">
			<div style="width: 100%; margin: auto;">

				<button
					style="width: 150px; height: 70px; margin: auto; display: block"
					type="button" class="btn btn-secondary">사진등록</button>
			</div>

		</div>
		<div id="item-info" class="d-none d-md-none d-lg-inline col-lg-4 m-3">
			<div class="item-detail border " style="height: 100%">
				<div class="mt-3 mx-4 " style="font-size: 200%">
					<input type="text" class="form-control" placeholder="상품명을 입력해주세요"
						id="title">
				</div>
				<div class="mb-3 mx-4">
					<input type="text" class="form-control" placeholder="상품코드를 입력해주세요"
						id="title">
				</div>

				<div class="flex-container">
					<div class="mx-5" style="flex-grow: 5; text-align: center">
						<h4>판매가</h4>
					</div>
					<div class="mx-4" style="flex-grow: 5; text-align: center">
						<input type="text" class="form-control" placeholder="가격을 입력해주세요"
							id="title">
					</div>
				</div>

				<div class="option  mt-4 mr-4 mb-2 ml-4" style="height: 350px">
					<div style="height: 80px; text-align: center; padding-top: 10px">
						색상
						<div class="colorRadio" style="height: 30px">
							<input id="color1-1" name="color1" type="checkbox" value="blue"
								checked="checked"> <label for="color1-1"
								class="border rounded-circle "
								style="background-color: steelblue;"></label> <input
								id="color1-2" name="color1" type="checkbox" value="black">
							<label for="color1-2" class="border rounded-circle "
								style="background-color: black;"></label> <input id="color1-3"
								name="color1" type="checkbox" value="white"> <label
								for="color1-3" class="border rounded-circle "
								style="background-color: white;"></label>
						</div>
					</div>
					<div class="mt-3" style="text-align: center; height: 80px">
						용량
						<div class="capaRadio">
							<input id="capa1-1" name="capa1" type="radio" value="512GB"
								checked="checked"> <label for="capa1-1"
								class="border rounded " style="padding-top: 8px;">512GB</label>
							<input id="capa1-2" name="capa1" type="radio" value="256GB">
							<label for="capa1-2" class="border rounded"
								style="padding-top: 8px;">256GB</label> <input id="capa1-3"
								name="capa1" type="radio" value="1TB"> <label
								for="capa1-3" class="border rounded " style="padding-top: 8px;">1TB</label>
						</div>
					</div>
					<hr />
				</div>
			</div>
		</div>
	</div>
	<div id="p-name" class="row">
		<div class="col-1"></div>
		<div class="my-auto">상품명</div>
	</div>
	<br />
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<button
				style="width: 150px; height: 70px; margin: auto; display: block"
				type="button" class="btn btn-secondary">광고사진등록</button>
		</div>
		<div class="col-1"></div>
	</div>
	<hr />

	<div id="upload" class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<button
				style="width: 150px; height: 70px; margin: auto; display: block"
				onClick="#" type="submit" class="btn btn-secondary"
				data-toggle="modal" data-target="#uploadModal">상품등록</button>
		</div>
		<div class="col-1 "></div>
		<div class="col-1"></div>
	</div>
</form>


</div>
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
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>