<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
			padding-bottom:100px;
			}
		#top {
			background:#404658;;
			height: 100px;
		}
		
		#logo b {
			background-color: #404658;
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
			
			<!-- home가는 버튼 -->
			<div id="blank" class="row" style="height:50px;background-color:white; "></div>
			
			<!-- body -->
			<div id="body" class="row">
				<!-- 메뉴 -->
				<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
					<div class="ml-5 mt-5 btn btn-black btn-sm" style="font-size:200%;">
						<a href="#">관리자 페이지</a>
						<div class="row m-3">
							<div id="userUpdate"class="btn btn-black btn-sm">
								<a  href="#" >>상품 관리</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="orderList" class="btn btn-black btn-sm">
								<a href="#">>상품 디테일 관리</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="cartList" class="btn btn-black btn-sm">
								<a  href="#">>1:1 문의 관리</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="content" class="btn btn-black btn-sm">
							<a href="#">>사진등록</a>
						</div>
						</div>
					</div>
				</div>
				
				<!-- 메인 -->
				<div id="centerBoard" class="col-12 col-md mt-5">
				
				
				
				
				
				</div>
			
			
			
			</div>
		</div>
	</body>
</html>