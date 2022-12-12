
function deleteBasket() {
	var checkArr = new Array();
	$("input:checkbox[name='basket']").each(function() {
		if ($(this).is(":checked") == true) {
			checkArr.push($(this).val());
			console.log($(this).val());
		}
	});
	$.ajax({
		url : "BasketDeleteController",
		type : "post",
		traditional : true,
		data : {
			checkedId : checkArr

		},
		success : function(result) {
			$("#basketMain").empty();
			$("#basketMain").html(result);

		}

	});

}

function check() {
	var total = $("input[name='basket']").length;
	var checked = $("input[name='basket']:checked").length;

	if (total != checked) {
		$("#basketAll").prop("checked", false);
	} else {
		$("#basketAll").prop("checked", true);
	}

}

function selectAll() {
	if ($("input:checkbox[name='basketAll']").is(":checked") == true) {
		$("input:checkbox[name='basket']").prop("checked", true);
	} else {
		$("input:checkbox[name='basket']").prop("checked", false);
	}

}