

function deleteBasket(){
	var checkArr = new Array();
	$("input:checkbox[name='basket']").each(function(){
		if($(this).is(":checked") == true){
			checkArr.push($(this).val());
			console.log($(this).val());
		}
	});
	$.ajax({
		url: "BasketDeleteController",
		type: "post",
		traditional: true,
		data: {
			checkedId : checkArr
			
		},
		success: function(result){
			$("#basketMain").empty();
			$("#basketMain").html(result);
			//$(".basketDetailOne").remove();
			//$(".table").append(result);
	
			
		}
		
		
	});
	
	

}

function selectAll(){
	let checkbox=$("#basketAll:checked");
	if(checkbox!==null){
		$("#basketRow input").prop("checked",true);
	}
	
}