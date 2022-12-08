	function goBasket() {
		/* var form = document.querySelector("#detail-form");
		form.action = "CreateBasketDetailController";
		form.submit(); */
		$("#detail-form").attr("action", "CreateBasketDetailController");
		$("#detail-form")[0].submit();
	}
	function goOrder() {
		$("#detail-form").attr("action", "CreateOrderController");
		$("#detail-form")[0].submit();
	}
	
	function currentDiv(n) {
		  showDivs(slideIndex = n);
		}

	function showDivs(n) {
	  var i;
	  var x = $(".Slides");
	  var dots = $(".demo");
	  if (n > x.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = x.length}
	  for (i = 0; i < x.length; i++) {
	    x[i].css("display" , "none");
	  }
	  for (i = 0; i < dots.length; i++) {
	    dots[i].css(" opacity", "1");
	  }
	  x[slideIndex-1].css("display","block");
	  dots[slideIndex-1].css(" opacity","0.5");
	}
	