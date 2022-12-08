<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/join.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../resources/javascript/join.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

<!-- 몸통 -->
<div id="body" class="row">
	
	<!-- menu -->
	<div class="col-0 col-md-3 "></div>

	<!-- 개인정보 수정 페이지 -->
	<div id="centerBoard" class="col-12 col-md mt-5 mr-5 p-5">
		<div id="centerText" class="row mt-5 ml-3 ">회원가입</div>
		
		<form class="p-2" method="post" action="JoinController" onsubmit="return check()" enctype="multipart/form-data" novalidate>
			<!-- 아이디입력 -->
			<div class="form-group m-4">
				<label for="userId" class="joinTitle">아이디</label>
				<input id="userId" type="text" class="form-control " name="userId" oninput="idCheck()"/>
				<small id="userIdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 6자 이상 10장 이하</small>
				<p id="idMessage"></p>
			</div>
			
			<!-- 비밀번호 입력및 비밀번호 확인 -->
			<div class="form-group m-4">
				<label for="userPwd" class="joinTitle">비밀번호</label>
				<input id="userPwd" type="password" class="form-control" name="userPwd"/>
				<small id="userPwdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 8자 이상 15장 이하</small>
				<p id="pwdMessage"></p>
			</div>
			<div class="form-group m-4">
				<label for="userPwdCheck" class="joinTitle">비밀번호 확인</label>
				<input id="userPwdCheck" type="password" class="form-control"/>
				<p id="pwdCheckMessage"></p>
			</div>
			<!-- 이름 -->
			<div class="form-group m-4">
				<label for="userName" class="joinTitle">이름</label>
				<input id="userName" type="text" class="form-control" name="userName" />
				<p id="nameMessage"></p>
			</div>
			
			<!-- 전화번호 -->
			<div class="form-group m-4">
				<label for="userPhone" class="join_title">전화번호</label>
				<input id="userPhone" type="text" class="form-control" name="userPhone" oninput="phoneCheck()" placeholder="000-0000-0000" />
				<small id="userPhoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
				<p id="phoneMessage"></p>
			</div>
			<!-- 이메일 -->
			<div class="form-group m-4">	
				<label for="userEmail" class="joinTitle">이메일</label>
				<input id="userEmail" type="text" class="form-control" name="userEmail" placeholder="000@" oninput="emailCheck()"/>
				<p id="emailMessage"></p>
			</div>
			<!-- 닉네임 -->
			<div class="form-group m-4">	
				<label for="userNickname" class="joinTitle">닉네임</label>
				<input id="userNickname" type="text" class="form-control" name="userNickname"/>
				<p id="nickMessage"></p>
			</div>
			<!-- 주소-->
			<div class="form-group m-4">
				<label for="userAddress" class="joinTitle">주소</label>
				<input id="addrBtn" class="m-3" type="button" value="주소 검색" onclick="findAddr()"readonly />
				<input id="userPost" type="text" class="form-control" name="userPost" placeholder="우편번호" />
				<input id="userAddr" type="text" class="form-control" name="userAddr" placeholder="주소"/>
				<input id="userDetailAddr" type="text" class="form-control" name="userDetailAddr" placeholder="상세 주소를 입력하세요."/>
			</div> 
			<!-- 이미지 -->
			<div class="form-group m-4">
				<label for="userImg" class="joinTitle">이미지</label> <br/>
				<input id="userImg" type="file" class="mt-2" name="userImg"/>
			</div>
			<!-- submit -->
			<div class="text-center m-5"> 
				<button id="joinSubmit" type="submit" class="btn btn-lg" value="확인" >확인</button>
				<input id="joinSubmit" type="reset" class="btn btn-lg" value="reset"/>
			</div>
		</form>
	</div>
	
	<!-- 오른쪽 빈칸 -->
	<div class="col-0 col-md-3 "></div>,///