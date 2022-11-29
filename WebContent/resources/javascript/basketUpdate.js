$(document).ready(function(){
	for(let i=0;i<3;i++){
		appendBasket();
		console.log("ready");
	}
});
function appendBasket(){
	let div = $(".basketTable table tbody");
	//console.log(div);
	let num=div.children().length;
	let src="../resources/images/monitor.png";
	let proName="컴퓨터";
	let color="black";
	let capacity="512GB";
	let price=50000;
	let qnt=2;
	let totalPrice=$("#totalPrice span");
	let rowPrice=$(".rowPrice hr");
	$(".rowPrice h5>span").text(num);
	div.append( "<tr class='basketRow'>"+
						"<td>"+
							"<div><input type='checkbox' id='basket"+num+"' name='basket"+num+"'/></div>"+
						"</td>"+
						"<td ><img src='"+src+"'/></td>"+
						"<td><div >"+proName+"<span>("+color+","+capacity+" 택)</span></div></td>"+
						"<td><div>"+price+"원</div></td>"+
						"<td><div>"+qnt+"</div></td>"+	
					"</tr>");	
	rowPrice.before("<div id='row"+num+"Price'><span>"+price*qnt+"</span>원</div>");
	
	totalPrice.text(parseInt(totalPrice.text())+(price*qnt));
	//console.log(div);
	
}

function deleteBasket(){
	let basketRow = $(".basketRow input:checked");
	
	let basketNum=basketRow.attr("id").replace(/[^0-9]/g,"");
	let totalPrice=$("#totalPrice span");
	let rowPrice=$("#row"+basketNum+"Price");
	//console.log(basketNum);
	totalPrice.text(parseInt(totalPrice.text())-parseInt(rowPrice.children().text()));
	rowPrice.remove();
	basketRow.parent().parent().parent().remove();
	$(".rowPrice h5 span").text($(".basketTable table tbody").length);
}

function selectAll(){
	let checkbox=$("#basketAll:checked");
	if(checkbox!==null){
		$("#basketRow input").prop("checked",true);
	}
	
}