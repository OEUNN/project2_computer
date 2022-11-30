<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>관리자메뉴</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap" rel="stylesheet">
	<style>
		* {
			margin: 0px;
			padding: 0px;
			box-sizing: border-box;
		}
		
		img {
			width: 100%;
			heigt: 100%;
		}
		#back{
				padding-bottom: 100px;
			}
		#top {
			background: #0c1c32;
			height: 100px;
		}
		
		#logo b {
			background-color: #0c1c32;
			color: white;
			font-size: 300%;
			font-family: 'Black Han Sans', sans-serif;
		}
		
		#icon {
			column-width: 15px;
			margin-top: 25px;
		}
		
		.item-detail {
			background-color: #f3f3f3;
			border-radius: 6%;
			box-sizing: border-box;
		}
		
		#p-name {
			height: 70px;
			background-color: #0c1c32;
			color: white;
		}
		
		.flex-container {
			display: flex;
		}
		
		.flex-container-button {
			display: flex;
		}
		
		.flex-container-button>div {
			text-align: center;
		}
		
		.w-btn-indigo {
			background-color: white;
			color: navy;
		}
		
		.w-btn-indigo:hover {
			background-color: black;
			color: #d4dfe6;
		}
		
		.w-btn {
			position: relative;
			border: none;
			display: inline-block;
			padding: 20px 50px;
			border-radius: 15px;
			font-family: "paybooc-Light", sans-serif;
			text-decoration: none;
			font-weight: 600;
			transition: 0.25s;
		}
		
		.option {
			background-color: white;
		}
		
		.option-mini {
			display: flex;
		}
		
		.price {
			display: flex;
		}
		
		.quan {
			display: flex;
		}
		
		table {
			width: 100%;
			font-size: 20px;
			text-align: center;
			border-collapse: collapse;
		}
		
		td {
			border-bottom: 1px solid #444444;
			padding: 15px;
		}
		
		.colorRadio input {
			display: none;
		}
		
		.colorRadio input+label {
			width: 25px;
			height: 25px;
		}
		
		.colorRadio input:checked+label {
			width: 30px;
			height: 30px;
		}
		
		.capaRadio input {
			display: none;
			width: 70px;
			height: 40px;
		}
		
		.capaRadio input+label {
			background-color: white;
			width: 70px;
			height: 40px;
		}
		
		.capaRadio input:checked+label {
			background-color: gray;
		}
		
		.quan-icon {
			display: flex;
		}
		
		#icon {
			display: flex;
		}
		
		button {
			border: none;
			border-radius: 30%;
		}
		
		#adminMenu {
			background-color: #f3f3f3;
		}
		
		#sidebar ul li a {
			display: block;
			padding: 13px 30px;
			border-bottom: 1px solid #10558d;
			color: black;
			font-size: 16px;
			position: relative;
		}
	</style>
	
	</head>
	
	<body>
		<div id="back" class="container-fluid">
			<!-- 상단 -->
			<div id="top" class="row">
				<div id="logo" class="col-4 col-md-1 btn mt-3">
					<a href="../product/ProductListController"><b>SAMSUNG</b></a>
				</div>
	
				<div class=" col "></div>
	
				<div id="icon" class="col-3 my-auto">
					<div style="flex-grow: 3; text-align: right">
						<img src="../resources/images/search_w.png"
							style="width: 40px; height: 40px" />
					</div>
					<div style="flex-grow: 3; text-align: center">
						<img src="../resources/images/cart_w.png"
							style="width: 40px; height: 40px" />
					</div>
					<div style="flex-grow: 3; text-align: left">
						<img src="../resources/images/Human_w.png"
							style="width: 40px; height: 40px" />
					</div>
				</div>
			</div>
	
			<div id="menu" class="row" style="height: 50px">
				<div class=" col-md-1"></div>
			</div>
			
			
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
					<div id="item-info"
						class="d-none d-md-none d-lg-inline col-lg-4 m-3">
						<div class="item-detail border " style="height: 100%">
							<div class="mt-3 mx-4 " style="font-size: 200%">
								<input type="text" class="form-control" placeholder="상품명을 입력해주세요"
									id="title">
							</div>
							<div class="mb-3 mx-4">
								<input type="text" class="form-control"
									placeholder="상품코드를 입력해주세요" id="title">
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
											for="capa1-3" class="border rounded "
											style="padding-top: 8px;">1TB</label>
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
		</div>
		<br />
	</body>
</html>