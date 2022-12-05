<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,DTO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ include file="/WEB-INF/views/common/header1.jsp" %>
<%@ include file="/resources/css/login.css" %>
<%@ include file="/WEB-INF/views/common/header2.jsp" %>

			
<!-- body -->
<div id="body" class="row" >
	<!-- 왼쪽 빈공간 -->
	<div class="col-0 col-md-3"></div>
	
	<!-- 메인 -->
	<div id="loginMain" class="col-12 col-md mt-5 mr-5">
		<div id="loginBody" class="container-fluid">
		
			<div id="loginLogo" class="row my-5">로그인</div>
			
			<div class="row container-fluid">
				<div class="col-3"></div>
				<div class="col">
					<div class="row form-group">
	           			<label for="uid">ID</label>
	            		<input type="text" class="form-control" id="uid" name="uid" value="Abc123"/>
	          		</div>
					<div class="row form-group" >
	            		<label for="password">Password</label>
	            		<input type="password" class="form-control" id="password" name="password" value="Abc12345"/>
	          		</div>
	          	</div>
				<div class="col-3"></div>
			</div>
			
			<div class = "row button-flex mt-5">
         			<div  style ="flex-grow: 3"></div>
					<div id="loginButton"class="mt-3 mx-auto" style ="flex-grow: 3">
					<input class="btn" type="submit" value="로그인"/>
					<a href="../user/JoinController" class="btn ml-3">회원가입</a>
				</div>
			</div>
					
			<div class = "row button-flex m-5">
				<div class="mt-3" style ="flex-grow:3;"></div>
				<div class="btn" style ="flex-grow: 2"><u>아이디 찾기</u></div>
				<div class="btn" style ="flex-grow: 2"><u>비밀번호 찾기</u></div>
				<div class="mt-3" style ="flex-grow: 3"></div>
			</div>
		</div>
	</div>
	<!-- 오른쪽 빈공간 -->
	<div class="col-0 col-md-3"></div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>