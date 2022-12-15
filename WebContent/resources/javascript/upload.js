function appendTable(){
	var colorList=new Array();
	$("input[name='colors']:checked").each(function(){
		colorList.push(this.value);
	});
	var capacityList=new Array();
	$("input[name='capacity']:checked").each(function(){
		capacityList.push(this.value);
	});
	
	var product={
		productId:$("input[name='productId']").val(),
		productName:$("input[name='productName']").val(),
		productPrice:$("input[name='productPrice']").val(),
		productGraphicCard:$("#productGraphicCard option:selected").val(),
		CPU:$("#CPU option:selected").val(),
		mainboard:$("#mainboard option:selected").val(),
		os:$("#os option:selected").val(),
		memory:$("#productGraphicCard option:selected").val(),
		colors:colorList,
		capacity:capacityList
	};
	console.log(product);
	
	$.ajax({
		url:"UploadController",
		type:"post",
		data:product,
		success:function(result){
				$("#subTable").empty();
				$("#subTable").append(result);
				//console.log(result);
				
			}
	});

	
}
