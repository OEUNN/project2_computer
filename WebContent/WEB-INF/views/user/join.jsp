<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<%@ include file="/resources/css/header.css" %>
<%@ include file="/resources/css/join.css" %>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>
			

<!-- 몸통 -->
<div id="body" class="row">
	
	<!-- menu -->
	<div class="col-0 col-md-3 "></div>

	<!-- 개인정보 수정 페이지 -->
	<div id="centerBoard" class="col-12 col-md mt-5 mr-5 p-5">
		<div id="centerText" class="row mt-5 ml-3 ">회원가입</div>
		
		<form class="p-2" action="../product/ProductListController">
			<!-- 아이디입력 -->
			<div class="form-group m-4">
				<label for="userEd" class="joinTitle">아이디</label>
				
				<input onfocusout="idValidate()" id="userId" type="text" class="form-control " />
				<small id="userIdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 6자 이상 10장 이하</small>
				<p id="idMessage"></p>
			</div>
			
			<!-- 비밀번호 입력및 비밀번호 확인 -->
			<div class="form-group m-4">
				<label for="userPwd" class="joinTitle">비밀번호</label>
				<input onfocusout="pwdValidate()" id="userPwd" type="text" class="form-control" />
				<small id="userPwdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 8자 이상 15장 이하</small>
				<p id="pwdMessage"></p>
			</div>
			<div class="form-group m-4">
				<label for="userPwdCheck" class="joinTitle">비밀번호 확인</label>
				<input onfocusout="pwdCheckValidate()" id="userPwdCheck" type="text" class="form-control" />
				<p id="pwdCheckMessage"></p>
			</div>
			<!-- 이름 -->
			<div class="form-group m-4">
				<label for="userName" class="joinTitle">이름</label>
			
				<input id="userName" type="text" class="form-control"/>
				<p id="nameMessage"></p>
			</div>
			
			<!-- 전화번호 -->
			<div class="form-group m-4">
				<label for="userPhone" class="join_title">전화번호</label>
				<input onfocusout="phoneValidate()" id="userPhone" type="text" class="form-control"/>
				<small id="userPhoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
				<p id="phoneMessage"></p>
			</div>
			<!-- 이메일 -->
			<div class="form-group m-4">	
				<label for="userEmail" class="joinTitle">이메일</label>
				<input onfocusout="emailValidate()" id="userEmail" type="text" class="form-control"/>
				<p id="emailMessage"></p>
			</div>
			<!-- 닉네임 -->
			<div class="form-group m-4">	
				<label for="userNickname" class="joinTitle">닉네임</label>
				<input id="userNickname" type="text" class="form-control"/>
				<p id="nickMessage"></p>
			</div>
			<!-- 주소 -->
			<div class="form-group m-4">
				<label for="userAddress" class="joinTitle">주소</label>
				<input id="userAddress" type="text" class="form-control"/>
				<p id="addressMessage"></p>
			</div>
			<!-- submit -->
			<div class="text-center m-5"> 
				<a href="#">
					<input id="joinSubmit" type="submit" class="btn" value="확인"/>
				</a>
			</div>
		</form>
	</div>
	
	<!-- 오른쪽 빈칸 -->
	<div class="col-0 col-md-3 "></div>
</div>
