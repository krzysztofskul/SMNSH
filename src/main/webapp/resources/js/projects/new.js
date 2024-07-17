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
	var formSelect = $("#prototypeListSelect");
	
	btnSearchDevices.on("click", function(event) {
		//alert("test button"); //ok
		showWindow("windowModalityList", "MODALITY LIST / MODALNOŚCI SPRZĘTOWE", () => getModalityList(), xPosition, yPosition);
		btnSearchDevices.prop("disabled", true);
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
			$("#windowPrototypeList > .card-body").append("<div class='row' id='devPrototypeId-"+elementPrototype.id+"'>" + elementPrototype.modelName+"</div>");
		});
		var prototypeRows = $("#windowPrototypeList > .card-body .row");
		console.log(prototypeRows);
		prototypeRows.each(function() {
			$(this).on('click', function(e) {
				setPrototypeRowFunctionality($(this));
			});	
			var bgColor;
			$(this).on("mouseenter", function() {
				bgColor = $(this).css("background-color");
			})
			
			$(this).on("mouseover", function() {
				$(this).css("cursor", "pointer");
				$(this).css("background-color", "green");
			});
			
			$(this).on("mouseleave", function() {
				$(this).css("background-color", bgColor);
			});
	
		});
	}

	function setPrototypeRowFunctionality(rowJqueryObject) {
			var idString = rowJqueryObject.attr('id');
			var id = idString.substring(idString.indexOf("-")+1);
			console.log("prototype device chosen... id: "+id+" | model name: "+rowJqueryObject[0].innerText);
			var formOptions = formSelect.find("option");
			
			formOptions.each(function() {
				if ($(this).attr("value") == id) {
					$(this).attr("selected", true);
				}
			});
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
			"/smnsh2/devicesprototypes/all/"+modalityCode,
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

	function setModalityRowFunctionality() {
		var rows = $("#windowModalityList > .card-body .row");
		rows.each(function() {
			
			clickOnModalityRow($(this)); //ok
			
		});
				
	}

});