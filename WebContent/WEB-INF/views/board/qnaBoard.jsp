<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1대1 문의게시판</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap" rel="stylesheet">
		
		<!-- 부트스트랩 아이콘 -->
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
		<style>
			*{
				margin:0px;
				padding:0px;
				box-sizing: border-box;
				font-family: 'Jua', sans-serif;
				background-color:#f3f3f3;
			}
			img{
				width:100%;
				height:100%;
			}
			#back{
				padding-bottom: 100px;
			}
			#top{
				background:#0c1c32;
				height:100px;
			}
			#logo b{
				background-color:#0c1c32;
				color:white;
				font-size:300%;
				font-family: 'Black Han Sans', sans-serif;
			}
			
			#menu{
				background-color: white;
				border-radius: 0px 50px 0px 0px;
				box-shadow: 5px 5px 10px grey;
			}
			#menu div,a{
				background-color: white;
				color:black;
			}
			#centerText{
				color:black;
				font-size: 250%;
			}
			#contentBox{
				border-radius: 15px;
				box-shadow: 5px 5px 10px grey;
			}
			
			#contentText *{
				background-color:white;
			}
			#contentButton{
				border-radius: 15px;
			}
			a{
				text-decoration: none;
				color:black;
			}
			a:hover{
				text-decoration: none;
				
			}
			.qnaList div:hover{
				background-color: #f0f0f0;
			}
			#qnaModal *{
				background-color: white;
				
			}
			
			#qnaModal button{
				background-color:#0c1c32;
			}
		</style>
	</head>
	<body>
		<div id="back" class="container-fluid">
		
			<!-- 가장위 logo -->
			<div id="top" class="row">
				<div id="logo" class="btn mt-3">
					<a href="../product/ProductListController"><b>SAMSUNG</b></a>
				</div>
			</div>
			
			<!-- home가는 버튼 -->
			<div id="blank" class="row" style="height:50px;background-color:white; "></div>
			
			<!-- 몸통 -->
			<div id="body" class="row">
				
				<!-- menu -->
				<div id="menu" class=" d-none d-md-inline col-md-2 mt-5 mr-5 ">
					<div class="ml-5 mt-5 btn btn-black btn-sm" style="font-size:200%;">
						<a href="../user/MypageController">마이페이지</a>
						<div class="row m-3">
							<div id="userUpdate"class="btn btn-black btn-sm">
								<a  href="../user/UserUpdataController" >>개인정보</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="orderList" class="btn btn-black btn-sm">
								<a href="../user/OrderListController">>주문내역</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="cartList" class="btn btn-black btn-sm">
								<a  href="../product/BasketListController">>장바구니</a>
							</div>
						</div>
						<div class="row m-3">
							<div id="content" class="btn btn-black btn-sm">
							<a href="../board/QnaBoardController">>1:1 문의</a>
						</div>
						</div>
					</div>
				</div>
				
				
				<!-- 1대1문의 내역 -->
				<div id="centerBoard" class="col-12 col-md mt-5">
					<div class="container-fluid">
						<div id="centerText" class="row mt-5 ml-3">1:1 문의</div>
						
						<!-- 빈공간 -->
						<div class="row m-3"></div>
						
						<!-- 버튼 -->
						<div id="contentButton" class="row m-3" >
							<button class="btn btn-#0c1c32 btn-dark rounded-1" style="width:100%;"data-toggle="modal" data-target="#qnaModal">문의하기</button>
						</div>
					
						<!-- 빈공간 -->
						<div class="row m-3"></div>
						
						<!-- 문의글 -->
						<div id="contentText" class="row m-3">
							<div id="contentBox" class="container-fluid p-5">
								<c:forEach var="qnaBoard" items="${qnaList }" varStatus="status">
									<div id="qnaList" class="row m-1">
										<div id="qnaNum" class="col-1" >
											<!-- <i class="btn fas" >&#xf00d;</i> -->
											${status.count}
										</div>
										<div class="col-11 qnaTitle">
											<a href="#qnaDetail${status.count}" data-toggle="collapse">${qnaBoard.qnaBtitle }<span></span></a>
											<p>작성일자<span>${qnaBoard.qnaDate }</span></p>
										</div>
										<div class="qnaDetail collapse" id="qnaDetail${status.count}">
											<p>${qnaBoard.qnaBcontent }</p>
										</div>
									</div>
								</c:forEach>
								
							</div> 
						</div>
					</div>
				</div>
				
				<div class="col-0 col-md-1 "></div>
			</div>
		</div>
		
		
		
		<!-- The Modal -->
         <div class="modal fade"  id="qnaModal">
            <div class="modal-dialog modal-lg" >
               <div class="modal-content" >
   
                  <!-- Modal Header -->
                  <div class="modal-header">
                     <h4 class="modal-title">1:1 문의 작성</h4>
                     <button type="button" class="close" data-dismiss="modal">&times;</button>
                  </div>
   
                  <!-- Modal body -->
                  <div class="modal-body">
             
   
                     <form method="Post" action="QnaBoardWriteController" id="qnaBoardWrite">
                        <div class="form-group">
                			<input type="text" class="form-control" placeholder="제목을 입력해주세요" id="title" name="title">
                        </div>
                        
                        <div class="form-group" style="height:100%">
                			<textarea  style="height:300px;width:100%"
                                          name="inquiryContent" id="inquiryContent"
                                          placeholder="리뷰 내용을 입력해 주세요. (500자 이내)"></textarea >
                        </div>
                        
                 
                     </form>
   
                  </div>
   
                  <!-- Modal footer -->
                  <div class="modal-footer">
                  <button type="submit" form="qnaBoardWrite"  class="btn btn-secondary">등록</button>
                  <button type="button" class="btn btn-secondary"
                        data-dismiss="modal">Close</button>
                
           			</div>
           		</div>
           	</div>
        </div>
	</body>
</html>