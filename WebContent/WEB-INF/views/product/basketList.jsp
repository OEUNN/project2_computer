<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니</title>
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
	        #basketWrapper{
	        	width:1200px;
	        	margin: 100px auto;
	        	padding: 10px 20px;
	        	background-color:white;
	        	border-radius: 15px;
				box-shadow: 5px 5px 10px grey;
	        }
	        .basketTable{
	        	text-align:center;
	        	margin-top: 20px
	        }
	        .basketTable th{
	       		font-size: 24px;
				font-weight: bold; 
				 
	        }
	        .basketTable td{
	       		font-size: 24px;
	        }
	        .basketTable td div{
				
				padding-top:25px;
	        }
	        .basketTable td span, #deleteBasket{
	       		font-size: 8px;
				color:gray;
	        }
	        #totalPrice{
	        	text-align:right;
	        	font-weight: bold;  
	        	border-top:1px solid black;
	        	padding-top:5px;
	        }
	        #submit{
	        	text-align:center;
	        }
	        .basketTable img{
	        	width:100px;
	        	
	        }
	        #submit .card-body div{
	        	text-align:right;
	        	font-size:8px;
	        	color:gray;
	        }
	    </style>
	</head>
	<body>
		<div class="container-fluid" style="background-color:#f3f3f3; height:1000px">
		
         	<!-- 가장위 logo -->
			<div id="top" class="row">
				<div id="logo" class="btn mt-3">
					<a href="../product/ProductListController"><b>SAMSUNG</b></a>
				</div>
			</div>
			
			<!-- 몸통 -->
         	<div id="basketWrapper" >
         		<h3 style="text-align:left; font-weight: bold; ">장바구니</h3>
         		<hr/>
         		<form style="width:100%" class="row" action="../product/OrderController">
         			<div class="basketTable col-9">
	         			<div id=deleteBasket style="text-align:right"><span>선택항목 삭제</span></div>
		         		<table class=" table table-hover">
		         			<tr>
		         				<th>
		         					<input type="checkbox" id="basketAll" name="basketAll"/>
		         					<label for="basketAll" style="font-size: 8px;font-weight: nomal; ">전체 선택</label>
		         				</th>
		         				<th>이미지</th>
		         				<th>상품</th>
		         				<th>가격</th>
		         				<th>수량</th>
		         				
		         			</tr>
		         			<tr>
		         				<td>
		         					<div>
		         						<input type="checkbox" id="basket1" name="basket1"/>
		         					</div>
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
		         					<div>
		         						<input type="checkbox" id="basket2" name="basket2"/>
		         					</div>
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
		         		
						
         			</div>
         			<div id="submit" class="col-3 card">
         				<div class="card-header">
         					<h5><i class="fas">&#xf3c5;</i> 최근 배송지</h5>
         					<p>서울특별시 종로구 창경궁로 254 4층</p>
         					<button class="btn rounded-0" style="background-color: white; width:100% ;border:1px solid black;">배송지 변경하기</button>
         				
         				</div>
         				<div class="card-body">
         					<h5><i class="fas">&#xf07a;</i>전체 상품:<span >2</span>개 </h5>
         					<div>1,000,000원</div>
         					<div>1,500,000원</div>
         					<hr/>
         					<h4 id="totalPrice">총액 : <span>2,500,000</span>원</h4>
         				</div>
         				<div class="card-footer">
         					<button class="btn rounded-0" type="submit" style="background-color: #0c1c32; color:#f8f8f8; width:100% ">선택항목 주문하기</button>
         				</div>
         			</div>
         		</form>
         	</div>
        </div>
	</body>
</html>