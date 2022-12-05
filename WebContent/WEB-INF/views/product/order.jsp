<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap" rel="stylesheet">
		
		<style>
			*{
	            margin:0px;
	            padding:0px;
	            box-sizing: border-box;
	            font-family: 'Jua', sans-serif;
	            background-color:#f3f3f3;
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
	        #body > .card{
	            background-color:black;
	            width:1000px;
	         }
			#order_Wrapper{
				width:1200px;
				margin: 50px auto;
				background-color:"#f3f3f3";
				box-shadow: 5px 5px 10px grey;
			}
			
			#order_main{
				width:100%;
				padding: 10px 20px;
			}
			#order_submit{
				width:80%;
			}
			.order_sub{
				border-radius:10px;
				background-color:white;
				margin: 10px;
			}
			.orderTable img{
	        	width:100px;
	        	
	        }
	        .orderTable{
	        	text-align:center;
	        	margin-top: 20px;
	        	
	        }
	        .orderTable th{
	        	
	       		font-size: 24px;
				font-weight: bold; 
				 
	        }
	        .orderTable td{
	       		font-size: 24px;
	        }
	        .orderTable td div{
				padding-top:25px;
	        }
	        .orderTable td span, #deleteBasket{
	       		font-size: 8px;
				color:gray;
	        }
	        #totalPrice{
	        	text-align:right;
	        	font-weight: bold;  
	        	border-top:1px solid black;
	        	padding-top:5px;
	        }
		</style>
	</head>
	<body>
		 <div id="back" class="container-fluid" >
		 	<!-- 로고 -->
         	<div id="top" class="row">
				<div id="logo" class="btn mt-3">
					<a href="../product/ProductListController"><b>SAMSUNG</b></a>
				</div>
			</div>

			<div id="order_Wrapper" class="row">
				<form method="post" action="ProductListController" class="order_main col-8 col-md-12">
					<div class="order_sub">
						<h3 style="text-align:left; font-weight: bold; ">결재 내역</h3>
	         			<hr/>
	         		
	         			<div class="orderTable ">
		         			
			         		<table class=" table table-hover">
			         			<tr>
			         				<th>
										번호
			         				</th>
			         				<th>이미지</th>
			         				<th>상품</th>
			         				<th>가격</th>
			         				<th>수량</th>
			         				
			         			</tr>
			         			<tr>
			         				<td>
			         					1
			         				</td>
			         				<td >
			         					<img src="../resources/images/monitor.png"/>
			         				</td>
			         				<td>
			         					<div >
			         						컴퓨터1	
			         						<span>(black,512GB 택)</span>
			         					</div>
			         				</td>
			         				<td><div>500,000원</div></td>
			         				<td><div>2</div></td>
			         				
			         			</tr>
			         			<tr>
			         				<td>
			         					2
			         				</td>
			         				<td >
			         						<img src="../resources/images/monitor.png"/>
			         				</td>
			         				<td>
			         					<div>컴퓨터2
			         						<span>(white,512GB 택)</span>
			         					</div>
			         				</td>
			         				<td><div>500,000원</div></td>
			         				<td><div>3</div></td>
			         				
			         			</tr>
			         			
			         		</table>
			         		<hr/>
         					<h4 id="totalPrice">총액 : <span>2,500,000</span>원</h4>
							
	         			</div>
         			</div>
					<div class="order_sub">
						<!-- 받는사람입력 -->
						<div class="form-group ">
							<label for="user_id" class="order_title">받는사람</label>
							
							<input id="user_id" type="text" class="form-control " />
							<small id="user_idHelp" class="form-text text-muted"></small>
							<p id="id_message"></p>
						</div>
						
					
						<!-- 전화번호 -->
						<div class="form-group">
							<label for="user_phone" class="join_title">전화번호</label>
							<input id="user_phone" type="text" class="form-control"/>
							<small id="user_phoneHelp" class="form-text text-muted">예) 010-123-1234, 010-1234-1234</small>
							<p id="phone_message"></p>
						</div>
						
						
						<!-- 주소 -->
						<div class="form-group">
							<label for="user_address" class="join_title">주소</label>
							<input id="user_address" type="text" class="form-control"/>
							<p id="address_message"></p>
						</div>
						<!-- submit -->
						<div class="text-center mt-4">
							<input id="order_submit" type="submit" class="btn btn-dark" value="결재하기"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
