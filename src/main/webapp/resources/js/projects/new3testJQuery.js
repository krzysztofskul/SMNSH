/**
 * 
 */

$(document).ready(function() {
		//alert("test js jquery!");//ok
	let btnSearchDevices = $("#btn-search-devices").on('click', () => testJQuery(150));
	let xPos = 10;
	let yPos = 20;
	
	function testJQuery(step) {

		showWindow("windowTestId1", "window test title", "test content", xPos, yPos);
		showWindow("windowTestId2", "window test title", "test content", xPos, yPos);
	}
	
	function showWindow(windowId, windowTitle, content, xPosition, yPosition) {
		console.log(xPosition);
		console.log(yPosition);
		//alert("show window with modality!");//ok
		$(".container").append(
			
			"<div class='fixed-top border card floating-window' id="+windowId+" style='top:"+yPosition+"px; left:"+xPosition+"px; width:350px; min-height:400px'>"+
				"<div class='card-header'>"+
					"<div class='row'>"+
						
						"<div class='col-2 btn-menu'>"+
							"<span class='text-primary text-center border p-1 d-inline-block btn-menu-window' style='width: 40px'>M</span>"+
						"</div>"+
						
						"<div class='col-8 window-title'>"+
							windowTitle+
						"</div>"+
	
						"<div class='col-2 btn-close'>"+
							"<span class='text-danger text-center border p-1 d-inline-block btn-delete-window' style='width: 40px'>X</span>"+
						"</div>"+						
						
						
					"</div>"+
				"</div>"+
				"<div class='card-body'>"+
					content+
				"</div>"+
			"</div>"
			
		);
		
		xPos +=10;
		yPos +=20;
		console.log(xPos);
		console.log(yPos);
	}
	
});