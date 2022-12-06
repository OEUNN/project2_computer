<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/orderList.css">
<%@ include file="/WEB-INF/views/common/header2.jsp" %>
<%@ include file="/WEB-INF/views/common/mypageMenu.jsp" %>

	<!-- center Board -->
	<div id="centerBoard" class="col-12 col-md mt-5">
		<div class="container-fluid">
		
			<div id="centerText" class="row mt-5 ml-3">주문 내역</div>
			
			<!-- 주문 기간 -->
			<div id="order" class="row m-3 p-3" >
				<div class="col-1 m-1" style="font-size:130%;">기간조회</div>
				<div class="col m-1">
					<table >
						<tr>
							<td id="dayButton"class="btn">1주일</td>
							<td id="dayButton" class="btn">15일</td>
							<td id="dayButton" class="btn">1개월</td>
							<td id="dayButton" class="btn">3개월</td>
							<td id="dayButton" class="btn">1년</td>
						</tr>
					</table>
				</div>
				<div class="col-3"></div>
			</div>
			
			<!-- 리스트 로고 -->
			<div id="subText1" class="row mx-3">구매내역</div>
			<!-- 구매 내역 리스트 -->
			<div id="order" class="row mt-1 mx-3 p-3">
				<!-- 페이징 처리 -->
				<div class="container-fluid">
					<!-- 구매내역 위에 부분 -->
					<div class="row mb-5 p-2" style="font-size:120%; border-bottom:1px solid grey;">
						<div class="col-2">구매일자</div>
						<div class="col-2">주문번호</div>
						<div class="col">구매상품</div>
						<div class="col-2">선택</div>
					</div>
					<!-- 상품리스트1 -->
					<div class="row my-3 p-2">
						<div class="col-2">2022-11-27</div>
						<div class="col-2">1</div>
						<div class="col">
							<div class="container-fluid">
								<div><img class="col"src=""/></div>
								<div class="col-7">내용</div>
							</div>
						</div>
						<div class="col-2 "><input type="checkbox" id="choice" /></div>
					</div>
					<!-- 상품리스트2 -->
					<div class="row my-3 p-2">
						<div class="col-2">2022-11-27</div>
						<div class="col-2">1</div>
						<div class="col">
							<div class="container-fluid">
								<div><img class="col"src=""/></div>
								<div class="col-7">내용</div>
							</div>
						</div>
						<div class="col-2"><input type="checkbox" id="choice" /></div>
					</div>
				</div>
			</div>

		</div>
	</div>
	
	
	<div class="col-0 col-md-1 "></div>
</div>
