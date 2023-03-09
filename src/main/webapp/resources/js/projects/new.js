/**
 * 
 */

$(document).ready(function() {
    //alert("test project new js jquery!"); //ok

	var btnSearchDevices = $("#btn-search-devices");
	var modalityList = [];
	
	btnSearchDevices.on("click", function(event) {
		//alert("test button"); //ok
		showWindow("MODALITY LIST / MODALNOŚCI SPRZĘTOWE", getModalityList(), 25, 25);
	});

	function ajax(url, data, type, dataType, successFunc, errorFunc) {
			$.ajax({
				url: url,
				data: data,
				type: type,
				dataType: dataType
			}).done(function(data) {
				successFunc(data);
			}).fail(function(xhr, status, error) {
				alert("loading data failed");
			});
	}

	function showWindow(windowTitle, content, xPos, yPos) {
		//alert("show window with modality!");//ok
		$(".container").append(
			
			"<div class='fixed-top border card floating-window' style='top:"+yPos+"px; left:"+xPos+"px; width:350px; min-height:400px'>"+
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
				"<div class='card-body' id='card-body'>"+
				"</div>"+
			"</div>"
		);
		$(".btn-delete-window").on("click", function() {
			$(this).parent().parents().eq(2).remove();
		});
		$(".btn-delete-window").on("mouseover", function() {
			$(this).css("cursor", "pointer");
		});

		content;
	}

	function showRowsWithModality(data) {
		data.forEach(function (modality) {
			$("#card-body").append("<div class='row'>" + modality.code + " " + modality.name+"</div>");
		});
		setRowFunctionality();
	}

	function doSuccesWhenLoadModalityList(data) {
		//console.log(data);//ok
		modalityList = [];
		data.forEach(function(modality){
			var modality = {
				id: modality.id,
				code: modality.code,
				name: modality.name
			}
			//console.log("modality code: "+modality.code);

			modalityList.push(modality);	
			
		});
		
		showRowsWithModality(modalityList);
	}

	function getModalityList() {
		//var modalityList;
		ajax(
			"/rest/modality/all",
			{},
			"GET",
			"json",
			doSuccesWhenLoadModalityList,
			null
		)
	}

	function setRowFunctionality() {
		var rows = $(".floating-window > #card-body .row");
		rows.each(function() {
			//console.log($(this)[0]);
			$(this).on("click", function() {
				//alert("click " + $(this)[0].textContent);
				showWindow("test", console.log("2nd test widnow"), 300, 25);
			});
			var bgColor;
			$(this).on("mouseover", function() {
				bgColor = $(this).css("background-color");
				$(this).css("cursor", "pointer");
				$(this).css("background-color", "yellow");
			});
			$(this).on("mouseleave", function() {
				$(this).css("background-color", bgColor);
			});
			
		});
				
	}

});