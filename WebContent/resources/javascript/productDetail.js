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