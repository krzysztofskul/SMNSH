/**
 * 
 */

$(document).ready(function() {
    //alert("test projectCharter.js jquery!"); // ok

    let btnEdit = $("#btnEdit");
    let btnEditProjectBackground = $("#btnEditProjectBackground");
    let btnEditRisks = $("#btnEditRisks");
    let btnEditGoals = $("#btnEditGoals");
    let btnCancel = $("#btnCancel");
    let btnCancelProjectBackground = $("#btnCancelProjectBackground");
    let btnCancelRisks = $("#btnCancelRisks");
    let btnCancelGoals = $("#btnCancelGoals");
    let btnSave = $("#btnSave");

    let projectCharterId = $("#projectCharterId").text();

    let inputProjectBackground = $("#textareaProjectBackground");
    let inputGoals = $("#textareaGoals");
    let inputRisks = $("#textareaRisks");

    let successWhenPutProjectCharter = function () {
        window.location.reload(true)
    }

    let errorWhenPutProjectCharter = function (data) {
        alert("error while put project charter no. "+projectCharterId+" data to db!");
    }

    function ajaxFunction(url, method, data, dataType, contentType, success, errorMyFunction) {
        $.ajax({
            url: url,
            method: method,
            data: data,
            dataType: dataType,
            contentType: contentType
        }).done(function () {
            success();
        }).fail(function (){
            errorMyFunction();
        });
    }

    function ajaxFunction2(url, method, data, success, errorMyFunction) {
        $.ajax({
            url: url,
            method: method,
            data: data,
        }).done(function () {
            success();
        }).fail(function (){
            errorMyFunction();
        });
    }

    function hideTestDivs() {
        $(".test").empty();
    }

    function setButtonCancelFunctionality() {
        btnCancel.on("click", function () {
            window.location.reload(true);
        });
        btnCancelProjectBackground.on("click", function () {
            window.location.reload(true);
        });
        btnCancelRisks.on("click", function () {
            window.location.reload(true);
        });
        btnCancelGoals.on("click", function () {
            window.location.reload(true);
        });

    }

    function setButtonSaveFunctionality() {

			alert("test save!");
            let data = {
                'reasons': inputProjectBackground.val(),
                'goals':  inputGoals.val(),
                'risks': inputRisks.val()
            }

            ajaxFunction2(
                "/rest/project-charter/"+projectCharterId,
                "POST",
                data,
                successWhenPutProjectCharter,
                errorWhenPutProjectCharter
            );


    }

    function setButtonEditFunctionality() {
        btnEdit.on("click", function () {
            //test
            //$("textarea").css("border", "1px solid red");

            $(this).parent().parent().$("textarea").removeAttr("disabled");
            $(this).parent().$(button.btnCancel).removeAttr("disabled");
            btnSave.removeAttr("disabled");
            $(this).attr("disabled", "true");

        });

    }
    
    function changeButtonToSaveButton(button) {
        	button.removeClass("btn-outline-primary");
        	button.addClass("btn-outline-success");
        	button.children().first().text("ZAPISZ").next().text("SAVE");
			
        	
        	button.on("click", function() {
				
				setButtonSaveFunctionality();
				changeSaveButtonToEditButton(button);
				let cancelButton = $("#btnCancelProjectBackground").children().first();
				hideCancelButton(cancelButton);
				let inputTag = $("#textareaProjectBackground");
				disableInputTag(inputTag);
        	});

    	}
    
    function enableInputTagToEdit(inputTag) {
    	inputTag.prop("disabled", false);
    };
    
    function hideCancelButton(button) {
    	button.parent().removeClass("visible").addClass("invisible");
    }
    
    function changeSaveButtonToEditButton(button) {
        	button.removeClass("btn-outline-success");
        	button.addClass("btn-outline-primary");
        	button.children().first().text("EDYTUJ").next().text("EDIT");
        	
        	button.off();
        	setButtonEditProjectBackgroundFunctionality();
        	
    }
    
    function disableInputTag(inputTag) {
    	inputTag.prop("disabled", true);
    }
    
    function showCancelButton(button) {
    	button.parent().removeClass("invisible").addClass("visible");
    	
    	button.on("click", function() {
    		hideCancelButton(button);
    		
    		let buttonSaveEdit = $("#btnEditProjectBackground");
    		changeSaveButtonToEditButton(buttonSaveEdit);
    		
    		let inputTag = $("#textareaProjectBackground");
    		disableInputTag(inputTag);
    	});
    	
    }
    
    function setButtonEditProjectBackgroundFunctionality() {
        btnEditProjectBackground.on("click", function (){
        	//alert("test button edit project background!");
        	let button = $(this);
        	changeButtonToSaveButton(button);
        	
        	let inputTag = $("#textareaProjectBackground");
        	enableInputTagToEdit(inputTag);
        	
        	let cancelButton = $("#btnCancelProjectBackground").children().first();
        	showCancelButton(cancelButton);     	
        });
    }
    function setButtonEditRisksFunctionality() {
        btnEditRisks.on("click", function (){
        	//alert("test button edit project background!");
        	let button = $(this);
        	changeButtonToSaveButton(button);
        	
        	let inputTag = $("#textareaRisks");
        	enableInputTagToEdit(inputTag);
        	
        	let cancelButton = $("#btnCancelRisks").children().first();
        	showCancelButton(cancelButton);     	
        });
    }
    function setButtonEditGoalsFunctionality() {
        btnEditGoals.on("click", function (){
        	//alert("test button edit project background!");
        	let button = $(this);
        	changeButtonToSaveButton(button);
        	
        	let inputTag = $("#textareaGoals");
        	enableInputTagToEdit(inputTag);
        	
        	let cancelButton = $("#btnCancelGoals").children().first();
        	showCancelButton(cancelButton);     	
        });
    }
    

	//TODO 
	function toggleButtonEditSave(button, input) {
		//toggle button
		
		//toggle input
		if (input != null) {
			toggleInputEdition(input);
		}
	}
	
	//TODO
	function toggleButtonCancel(button, input) {
		
		//toggle button

		
		//toggle input
		if (input != null) {
			toggleInputEdition(input);
		}		
	}
	
	//TODO
	function toggleInputEdition(input) {
		
	}
	
    function init() {
        hideTestDivs();
        setButtonEditFunctionality();
        setButtonEditProjectBackgroundFunctionality();
		setButtonEditRisksFunctionality();
		setButtonEditGoalsFunctionality();
        setButtonCancelFunctionality();
        
    }

    init();

});