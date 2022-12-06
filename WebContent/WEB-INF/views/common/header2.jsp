<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      </style>
   </head>
   
   <body>

	<div id="back" class="container-fluid">
		<!-- 상단 -->
		<div id="top" class="row">
			<div id="logo" class="col-4 col-md-3 btn mt-3">
				<a href="${pageContext.request.contextPath}/product/ProductListController">
					<b>SAMSUNG</b>
				</a>
			</div>

			<div class=" col "></div>

			<!-- 아이콘 -->
			<div id="icon" class=" col-2 col-md-2 mt-3">
				<div class="mt-3">
					<a href="../product/BasketListController"> 
					<img src="../resources/images/cart_w.png" style="width: 40px; height: 40px;" />
					</a>
				</div>
				<!-- 아이콘안 메뉴 -->
				<div>
					<!-- 로그인 안 되어있을 경우 -->
					<c:if test="${loginId==null}">
						<div class="mt-3 ml-5">
							<input type="checkbox" id="menuBtn" style="display: none;" /> 
							<label for="menuBtn" class="labelBtn" onclick=""> 
							<img src="../resources/images/Human_w.png" style="width: 40px; height: 40px;" />
							</label>
							<ul class="submenu" style="width: 90px;">
								<li><a href="../user/MypageController"></a>마이페이지</li>
								<li><a href="../user/JoinController">회원가입</a></li>
								<li><a href="${pageContext.request.contextPath}/user/LoginController">로그인</a></li>
							</ul>
						</div>
					</c:if>

					<!-- 로그인 되어있을 경우 -->
					<c:if test="${loginId!=null}">
						<div class="mt-3 ml-5">
							<input type="checkbox" id="menuBtn" style="display: none;" /> 
							<label for="menuBtn" class="labelBtn" onclick=""> 
							<img src="../resources/images/Human_icon.png" style="width: 40px; height: 40px;" />
							</label>
							<ul class="submenu" style="width: 90px;">
								<li><a href="../user/MypageController">마이페이지</a></li>
								<li><a href="../user/JoinController">회원가입</a></li>
								<li><a href="../user/LoginController">로그아웃</a></li>
							</ul>
						</div>
					</c:if>
				</div>
			</div>

		</div>

		<!-- 상단바 메뉴 -->
		<div id="topmenu" class="row" style="height:50px;">
			<div class="col-1" ></div>
			<div class="col-4 p-2" >
				<a href="${pageContext.request.contextPath}/product/ProductListController">
					>Home
				</a>
			</div>
			<div class="col"></div>
		</div>
