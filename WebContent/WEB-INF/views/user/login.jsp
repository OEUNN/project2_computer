<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/login.css">
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

			
<!-- body -->
<div id="body" class="row" >
	<!-- 왼쪽 빈공간 -->
	<div class="col-0 col-md-3"></div>
	
	<!-- 메인 -->
	<div id="loginMain" class="col-12 col-md mt-5 mr-5">
		<form id="loginBody" method="post" class="container-fluid" action="LoginController">
		
			<div id="loginLogo" class="row my-5">로그인</div>
			
			<div class="row container-fluid">
				<div class="col-3"></div>
				<div class="col">
					<div class="row form-group">
	           			<label for="userId">ID</label>
	            		<input type="text" class="form-control" id="userId" name="userId"/>
	          		</div>
					<div class="row form-group" >
	            		<label for="userPwd">Password</label>
	            		<input type="password" class="form-control" id="userPwd" name="userPwd"/>
	          		</div>
	          	</div>
				<div class="col-3"></div>
			</div>
			
			<div class = "row button-flex mt-5">
         		<div  style ="flex-grow: 3"></div>
         		
				<div id="loginButton"class="mt-3 mx-auto" style ="flex-grow: 3">
					<button type="submit" class="btn btn-primary">로그인</button>
					<a href="${pageContext.request.contextPath}/user/JoinController" class="btn ml-3">회원가입</a>
				</div>
				
			</div>
					
			<div class = "row button-flex m-5">
				<div class="mt-3" style ="flex-grow:3;"></div>
				<div class="btn" style ="flex-grow: 2"><a href="#"><u>아이디 찾기</u></a></div>
				<div class="btn" style ="flex-grow: 2"><a href="#"><u>비밀번호 찾기</u></a></div>
				<div class="mt-3" style ="flex-grow: 3"></div>
			</div>
		</form>
	</div>
	<!-- 오른쪽 빈공간 -->
	<div class="col-0 col-md-3"></div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>