<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header1.jsp"%>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/mypage.css">
<%@ include file="/WEB-INF/views/common/header2.jsp"%>
<%@ include file="/WEB-INF/views/common/mypageMenu.jsp"%>

<!-- 개인정보 수정 페이지 -->
<div id="centerBoard" class="col-12 col-md mt-5">
	<div class="container-fluid">
		<!-- title name -->
		<div id="centerText" class="row mt-5 ml-3">나의 정보</div>
		<!-- 개인 신상 정보 -->
		<div class="row m-3">
			<div class="container-fluid">
				<div id="mypage" class="row p-3" >
					<div class="col-md-12 col-lg-4">
						<div class="ml-3 p-2" >
							<c:if test="${users.userFileName != null}">
								<img src="UserImageAttachController?fileName=${users.userFileName}&savedName=${users.userSavedName}&contentType=${users.userContentType}" alt="userImg" style="border-radius:70%; height:350px; width:300px;" />
							</c:if>
						</div>
					</div>
					<div class="col-lg">
						<div class="m-5">
							<p style="font-size:300%;" class="fas fa-heart">${users.userName} 님</p>
							<p style="font-size:200%;">안녕하세요.</p>
							<p>${users.userNickname}</p>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="row" style="height:50%"></div>
						<div class="row">
							<p>저희 SAMSUNG과 함께 시작한 날은</p>
							<p class="fas fa-heart">${users.userInsertdate}입니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 중간 빈칸 -->
		<div class="row" style="height: 30px"></div>
		
		<!-- 밑에 칸 -->
		<div class="row m-3">
			<div class="container-fluid">
				<div class="row">
					<div id="mypage" class="col-md-12 col-lg-5 mr-2">
						<div id="user" class="container-fluid p-5">
							<div>
								<div class="mb-3">
									<p style=>Address</p>
									우편 번호 : ${users.userPost}<br/>
									${users.userAddr} ${users.userDetailAddr}<br/>
								</div>
								<div class="mb-3">
									<p>Email</p>
									${users.userEmail}<br/>
								</div>
								<div class="mb-3">
									<p>TEL</p>
									${users.userPhone}<br/>
								</div>
							</div>
						</div>
					</div>

					<div class="col"></div>

					<div id="mypage" class="col-lg-5">
						<div id="product" class="grid-container">
							<div class="card m-2">
								<div class="card-head">
									<img src="../resources/images/woman.png" alt="woman" />
								</div>
								<div class="card-body"></div>
							</div>
							<div class="card m-2">
								<div class="card-head">
									<img src="../resources/images/woman.png" alt="woman" />
								</div>
								<div class="card-body"></div>
							</div>
							<div class="card m-2">
								<div class="card-head">
									<img src="../resources/images/woman.png" alt="woman" />
								</div>
								<div class="card-body"></div>
							</div>
							<div class="card m-2">
								<div class="card-head">
									<img src="../resources/images/woman.png" alt="woman" />
								</div>
								<div class="card-body"></div>
							</div>
							<div class="card m-2">
								<div class="card-head">
									<img src="../resources/images/woman.png" alt="woman" />
								</div>
								<div class="card-body"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 오른쪽 상단 빈칸 -->
<div class="col-0 col-md-1 "></div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
