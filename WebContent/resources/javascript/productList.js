function resetCategory(){
	$(".productCategory input").prop("checked",false);
	$("#searchVal").val("");
	categoryUpdate()
}

//페이징처리
function pageUpdate(pageNo){
	var page={
			pageNo:pageNo,
			graphic:$("input[name='graphicCard']:checked").val(),
			cpu:$("input[name='CPU']:checked").val(),
			memoryCard:$("input[name='memoryCard']:checked").val(),
			price:$("input[name='price']:checked").val(),
			mainBoard:$("input[name='mainBoard]:checked'").val()
	};
	$.ajax({
		url:"ProductListController",
		type:"post",
		data:page,
		success:function(result){
				$(".productListPage").empty();
				console.log(result);
				$(".productListPage").html(result);
			}
	});
}
function categoryUpdate(){
	var category={
				graphic:$("input[name='graphicCard']:checked").val(),
				cpu:$("input[name='CPU']:checked").val(),
				memoryCard:$("input[name='memoryCard']:checked").val(),
				price:$("input[name='price']:checked").val(),
				mainBoard:$("input[name='mainBoard']:checked").val(),
				os:$("input[name='os']:checked").val(),
				searchVal:$("#searchVal").val()
	};
	
	$.ajax({
		url:"ProductListController",
		type:"post",
		data:category,
		success:function(result){
				$(".productListPage").empty();
				console.log(result);
				$(".productListPage").html(result);
			}
	});
}
function searchProduct(){
	
	categoryUpdate()
}
//이미지 자동 슬라이드

$(document).ready(function(){
	var myIndex = 0;
	carousel();
	
	function carousel() {
	  var i;
	  var x = document.getElementsByClassName("mySlides");
	  for (i = 0; i < x.length; i++) {
	    x[i].style.display = "none";  
	  }
	  myIndex++;
	  if (myIndex > x.length) {myIndex = 1}    
	  x[myIndex-1].style.display = "block";  
	  setTimeout(carousel, 2000); // Change image every 2 seconds
	}
	
});










/*
function pageUpdate(pageNo){
		var page={pageNo:pageNo};
		$.ajax({
			url:"ProductListController",
			type:"post",
			data:page,
			success:function(json){
				$(".productList").empty();
				json.productList.forEach((product)=>{
					var productItem='<div class="col-12 col-md-6 col-lg-4 p-3">'
						+'<div id="cardStyle" class="card text-center p-4 ">'
						+'<div class="card-head ">'
						+'<div>'
						+'<img src="../resources/images/monitor3.png"/>'
						+'</div>'
						+'</div>'
						+'<div class="card-body">'
						+'<form id="color1select">'
						+'<div class="colorRadio">'
						+'<input id="color1-1" name="color1" type="radio" value="blue" checked="checked"> '
						+'<label for="color1-1" class="border rounded-circle my-auto" style="background-color: steelblue;"></label> '
						+'<input id="color1-2" name="color1" type="radio" value="black">'
						+'<label for="color1-2" class="border rounded-circle my-auto" style="background-color: black;"></label> '
						+'<input id="color1-3" name="color1" type="radio" value="white"> '
						+'<label for="color1-3" class="border rounded-circle my-auto" style="background-color: white;"></label>'
						+'</div>'
						+'</form>'

						+'<h4 class="my-2">'+product.productName+'</h4>'
						+'<p>'+product.productId+'</p>'
						+'<p>'+product.productPrice+'원</p>'

						+'<a id="detailButton" href="../product/ProductDetailController?'+product.productId+'" class="w-btn w-btn-indigo">구매하기</a>'
						+'</div>'
						+'</div>'
						+'</div>';
					$(".productList").append(productItem)
				});
			}
		})
	}*/

/*<button onclick="pageUpdate(1)" class="btn btn-outline-primary btn-sm pagerBtn">처음</button>
				<c:if test="${pager.groupNo>1 }">
					<button onclick="pageUpdate(${pager.pageNo+1})" class="btn btn-outline-info btn-sm pagerBtn">이전</button>
				</c:if>
				<c:forEach var="i" begin="${pager.startPageNo }"
					end="${pager.endPageNo}">
					<c:if test="${pager.pageNo !=i }">
						<button onclick="pageUpdate(${i})" class="btn btn-outline-success btn-sm pagerBtn">${i}</button>
					</c:if>
					<c:if test="${pager.pageNo==i }">
						<button style="background-color: #e0e0e0" class="btn btn-danger btn-sm pagerBtn">${i}</button>
					</c:if>
				</c:forEach>
				<c:if test="${pager.groupNo<pager.totalGroupNo }">
					<button onclick="pageUpdate(${pager.pageNo+1})" class="btn btn-outline-info btn-sm pagerBtn">다음</button>
				</c:if>
				<button onclick="pageUpdate(${pager.totalPageNo})" class="btn btn-outline-primary btn-sm pagerBtn">맨끝</button>*/