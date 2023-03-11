/**
 * 
 */

$(document).ready(function() {
    //alert("test project new js jquery!"); //ok

	var btnSearchDevices = $("#btn-search-devices");
	var modalityList = [];
	var prototypeList = [];
	xPosition = 25;
	yPosition = 25;
	
	btnSearchDevices.on("click", function(event) {
		//alert("test button"); //ok
		showWindow("windowModalityList", "MODALITY LIST / MODALNOŚCI SPRZĘTOWE", () => getModalityList(), xPosition, yPosition);
		console.log("btnSearchDevices clicked");
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

	function showWindow(windowId, windowTitle, content, xPos, yPos) {
		//alert("show window with modality!");//ok
		$("body").append(
			
			"<div class='fixed-top border card floating-window' id="+windowId+" style='top:"+yPos+"px; left:"+xPos+"px; width:350px; min-height:400px'>"+
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
				"</div>"+
			"</div>"
		);
		$(".btn-delete-window").on("click", function() {
			$(this).parent().parents().eq(2).remove();
		});
		$(".btn-delete-window").on("mouseover", function() {
			$(this).css("cursor", "pointer");
		});

		content();
		xPosition+=10;
		yPosition+=5;
	}

	function showRowsWithModality(data) {
		data.forEach(function (modality) {
			$("#windowModalityList > .card-body").append(
			
			
				"<div class='row'>" + 
				
					"<div class='col-2'>"+modality.code+"</div>"+
					"<div class='col-10'>"+modality.name+"</div>"+
				
				"</div>"
			
			
			);
		});
		setModalityRowFunctionality();
	}

	function showRowsWithDevicesPrototypes(rows) {
		$("#windowPrototypeList > .card-body").children().remove();
		rows.forEach(function (elementPrototype) {
			$("#windowPrototypeList > .card-body").append("<div class='row'>" + elementPrototype.modelName+"</div>");
		});
		var prototypeRows = $("#windowPrototypeList > .card-body .row");
		console.log(prototypeRows);
		prototypeRows.each(function() {
			$(this).on('click', function(e) {
				//console.log("click "+$(this)[0].innerText);
				var rowJqueryObject = $(this);
				setPrototypeRowFunctionality(rowJqueryObject);
			});	
	
		});
	}

	function setPrototypeRowFunctionality(rowJqueryObject) {
		console.log("row functionality for: "+rowJqueryObject[0].innerText);
		clickOnPrototypeRow(rowJqueryObject);
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

	function getPrototypeListByModalityCode(modalityCode) {
		ajax(
			"/smnsh/devicesprototypes/all/"+modalityCode,
			{},
			"GET",
			"json",
			doSuccesWhenLoadPrototypeList,
			null
		)
	}

	function doSuccesWhenLoadPrototypeList(data) {
		prototypeList = data;
		showRowsWithDevicesPrototypes(prototypeList);
	}

	function clickOnModalityRow(jqueryObject) {
			jqueryObject.on("click", function(e) {
				console.log("click modality row: " + jqueryObject[0].innerText);
				var modalityCode = jqueryObject[0].firstChild.innerText;
				showWindow("windowPrototypeList", "DEVICES LIST / WYKAZ URZĄDZEŃ", () => getPrototypeListByModalityCode(modalityCode), xPosition+350, yPosition);
			});
			
			var bgColor;
			jqueryObject.on("mouseenter", function() {
				bgColor = jqueryObject.css("background-color");
			})
			
			jqueryObject.on("mouseover", function() {
				jqueryObject.css("cursor", "pointer");
				jqueryObject.css("background-color", "darkgrey");
			});
			
			jqueryObject.on("mouseleave", function() {
				jqueryObject.css("background-color", bgColor);
			});
	}

	function clickOnPrototypeRow(jqueryObject) {
			jqueryObject.on("click", function() {
				console.log("click prototype row: jqueryObject " + jqueryObject);
				console.log("click prototype row: jqueryObject[0] " + jqueryObject[0].innerText);
			});
			
			var bgColor;
			jqueryObject.on("mouseenter", function() {
				bgColor = jqueryObject.css("background-color");
			})
			
			jqueryObject.on("mouseover", function() {
				jqueryObject.css("cursor", "pointer");
				jqueryObject.css("background-color", "green");
			});
			
			jqueryObject.on("mouseleave", function() {
				jqueryObject.css("background-color", bgColor);
			});
	};

	function setModalityRowFunctionality() {
		var rows = $("#windowModalityList > .card-body .row");
		rows.each(function() {
			
			clickOnModalityRow($(this)); //ok
			
		});
				
	}

});