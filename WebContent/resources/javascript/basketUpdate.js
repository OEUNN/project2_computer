function appendBasket(){
	let div = document.querySelector(".basketTable table");
	//console.log(div);
	
	div.innerHTML += "<tr>"+
						"<td>"+
							"<div><input type='checkbox' id='basket1' name='basket1'/></div>"+
						"</td>"+
						"<td ><img src='../resources/images/monitor.png'/></td>"+
						"<td><div >컴퓨터1<span>(black,512GB 택)</span></div></td>"+
						"<td><div>500,000원</div></td>"+
						"<td><div>2</div></td>"+	
					"</tr>";	
}

function deleteBasket(){
	let div = document.querySelector(".basketTable table>");
	
	div.removeChild(div.lastElementChild);
	
}