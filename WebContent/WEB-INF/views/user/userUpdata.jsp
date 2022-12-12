<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/userUpdata.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../resources/javascript/join.js"></script>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>
<%@ include file="/WEB-INF/views/common/mypageMenu.jsp" %>
			
	<!-- 개인정보 수정 페이지 -->
	<div id="centerBoard" class="col-12 col-md mt-5 mr-5">
	
		<div id="centerText" class="row mt-5 ml-3">개인 정보 수정</div>
		
		<div id="updataMain"  class="col-8 col-md-12 m-3">
			<form class="p-5" method="post" action="UserUpdataController" enctype="multipart/form-data">
				
				
				<!-- 비밀번호 입력및 비밀번호 확인 -->
				<div class="form-group m-4">
					<label for="userPwd" class="joinTitle">비밀번호</label>
					<input id="userPwd" name="userPwd" type="text" class="form-control" />
					<small id="userPwdHelp" class="form-text text-muted">알파벳 대소문자, 숫자를 혼용해서 8자 이상 15장 이하</small>
					<p id="pwdMessage"></p>
				</div>
				<div class="form-group m-4">
					<label for="userPwdCheck" class="joinTitle">비밀번호 확인</label>
					<input id="userPwdChedk" name="userPwdChedk" type="text" class="form-control" />
					<p id="pwdCheckMessage"></p>
				</div>
				<!-- 이름 -->
				<div class="form-group m-4">
					<label for="userName" class="joinTitle">이름</label>
				
					<input id="userName" name="userName" type="text" class="form-control" value="${user.userName}"/>
					<p id="nameMessage"></p>
				</div>
				
				<!-- 전화번호 -->
				<div class="form-group m-4">
					<label for="userPhone" class="join_title">전화번호</label>
					<input id="userPhone" name="userPhone" type="text" class="form-control" value="${user.userPhone}"/>
					<small id="userPhoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
					<p id="phoneMessage"></p>
				</div>
				<!-- 이메일 -->
				<div class="form-group m-4">	
					<label for="userEmail" class="joinTitle">이메일</label>
					<input id="userEmail" name="userEmail" type="text" class="form-control" value="${user.userEmail }"/>
					<p id="emailMessage"></p>
				</div>
				<!-- 닉네임 -->
				<div class="form-group m-4">	
					<label for="userNickname" class="joinTitle">닉네임</label>
					<input id="userNickname" name="userNickname" type="text" class="form-control" value="${user.userNickname }"/>
					<p id="nickMessage"></p>
				</div>
				<!-- 주소 -->
				<div class="form-group m-4">
					<label for="userAddress" class="joinTitle">주소</label>
					<input id="addrBtn" class="m-3" type="button" style="background-color:#0c1c32;" value="주소 검색" onclick="findAddr()"readonly />
					<input id="userPost" type="text" class="form-control" name="userPost"onclick="findAddr()"  value="${user.userPost}" />
					<input id="userAddr" type="text" class="form-control" name="userAddr" value="${user.userAddr }"/>
					<input id="userDetailAddr" type="text" class="form-control" name="userDetailAddr" value="${user.userDetailAddr}"/>
				</div> 
				<div class="form-group m-4">
					<label for="userImg" class="joinTitle">이미지 변경</label> <br/>
					<input id="userImg" type="file" class="mt-2" name="userImg"/>
				</div>	
				<!-- submit -->
				<div class="text-center m-5"> 
					<a href="#">
						<input id="joinSubmit" type="submit" class="btn" value="확인"/>
					</a>
				</div>
			</form>
		</div>
	</div>
	
	<!-- 오른쪽 빈칸 -->
	<div class="col-0 col-md-1 "></div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>