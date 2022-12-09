<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <!-- 장바구니 -->
            <div class="mt-3">
               <!-- 로그인 x -->
               <c:if test="${loginId==null}">
                  <a href="${pageContext.request.contextPath}/user/LoginController">
                     <img src="${pageContext.request.contextPath}/resources/images/cart_w.png" style="width: 40px; height: 40px;" />
                  </a>
               </c:if>
               <!-- 로그인 o -->
               <c:if test="${loginId!=null}">
                  <a href="../product/BasketListController">
                     <img src="../resources/images/cart_w.png" style="width: 40px; height: 40px;" />
                  </a>
               </c:if>
               
            </div>
            <!-- 아이콘안 메뉴 -->
            <div>
               <!-- 로그인 안 되어있을 경우 -->
               <c:if test="${loginId==null}">
                  <div class="dropdown ml-5">
                     <button class="dropbtn">
                        <img src="../resources/images/off_human.png" style="width: 40px; height: 40px;" />
                     </button>
                     <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/user/LoginController">로그인</a>
                        <a href="${pageContext.request.contextPath}/user/JoinController">회원가입</a>
                     </div>
                  </div>
               </c:if>

               <!-- 로그인 되어있을 경우 -->
               <c:if test="${loginId!=null}">
                  <div class="dropdown ml-5">
                     <button class="dropbtn">
                        <img src="../resources/images/on_human.png" style="width: 40px; height: 40px;" />
                     </button>
                     <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/user/MypageController">나의 정보</a>
                        <a href="${pageContext.request.contextPath}/user/JoinController">주문 내역</a>
                        <a href="${pageContext.request.contextPath}/user/LogoutController">로그아웃</a>
                     </div>
                  </div>
               </c:if>
            </div>
         </div>

      </div>

      <!-- 상단바 메뉴 -->
      <div id="topmenu" class="row" style="height:50px;">
         <div class="col-1" ></div>
         <div class="col-4 p-2" >
            <a href="${pageContext.request.contextPath}/product/ProductListController" class="fa fa-desktop">
               Home  |
            </a>
            <a href="${pageContext.request.contextPath}/user/MypageController" class="fa fa-paw">
               MyPage
            </a>
         </div>
         <div class="col"></div>
      </div>