<c:forEach var="product" items="${productList}" varStatus="status">
				<div class="col-12 col-md-6 col-lg-4 p-3">
					<div id="cardStyle" class="card text-center p-4 ">
						<div class="card-head ">
							<div>
								<img src="../resources/images/monitor3.png" />
							</div>
						</div>
						<div class="card-body">
							<form id="color1select">
								<div class="colorRadio">
									<input id="color1-1" name="color1" type="radio" value="blue" checked="checked"> 
										<label for="color1-1" class="border rounded-circle my-auto" style="background-color: steelblue;"></label> 
										<input id="color1-2" name="color1" type="radio" value="black">
									<label for="color1-2" class="border rounded-circle my-auto" style="background-color: black;"></label> 
										<input id="color1-3" name="color1" type="radio" value="white"> 
										<label for="color1-3" class="border rounded-circle my-auto" style="background-color: white;"></label>
								</div>
							</form>
	
							<h4 class="my-2">${product.productName}</h4>
							<p>${product.productId}</p>
							<p>${product.productPrice }원</p>
	
							<a id="detailButton" href="../product/ProductDetailController?${product.productId}" class="w-btn w-btn-indigo">구매하기</a>
						</div>
					</div>
				</div>
			</c:forEach>