$(document).ready(function() {
    //alert("test projectCharter.js jquery!"); // ok

    let btnEdit = $("#btnEdit");
    let btnEditProjectBackground = $("#btnEditProjectBackground");
    let btnCancel = $("#btnCancel");
    let btnSave = $("#btnSave");

    let projectCharterId = $("#projectCharterId").text();
    let projectId = $("#projectId").text();

    let inputReasons = $("#reasons");
    let inputGoals = $("#goals");
    let inputRisks = $("#risks");

    let successWhenPutProjectCharter = function () {
        window.location.reload(true)
    }

    let errorWhenPutProjectCharter = function () {
        alert("error while put project charter to db!")
    }

    function ajaxFunction(url, method, data, dataType, contentType, success, error) {
        $.ajax({
            url: url,
            method: method,
            data: data,
            dataType: dataType,
            contentType: contentType
        }).done(function () {
            success();
        }).fail(function (){
            error();
        });
    }

    function hideTestDivs() {
        $(".test").empty();
    }

    function setButtonCancelFunctionality() {
        btnCancel.on("click", function () {
            window.location.reload(true);
        });

    }

    function setButtonSaveFunctionality() {
        btnSave.on("click", function () {

            let data = {
                "id": projectCharterId,
                "project": projectId,
                "reasons": inputReasons.val(),
                "goals":  inputGoals.val(),
                "risks": inputRisks.val()
            }

            ajaxFunction(
                "/rest/project-charter/"+projectCharterId,
                "PUT",
                JSON.stringify(data),
                "json",
                "application/json",
                successWhenPutProjectCharter,
                errorWhenPutProjectCharter
            );

        });

    }

    function setButtonEditFunctionality() {
        btnEdit.on("click", function () {
            //test
            //$("textarea").css("border", "1px solid red");

            $("textarea").removeAttr("disabled");
            btnCancel.removeAttr("disabled");
            btnSave.removeAttr("disabled");
            $(this).attr("disabled", "true");

        });

    }
    
    function changeButtonToSaveButton(button) {
        	button.removeClass("btn-outline-primary");
        	button.addClass("btn-outline-success");
        	button.children().first().text("ZAPISZ").next().text("SAVE");
        	
        	button.on("click", function() {
        		alert("//TODO save function");
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
    		
    		let inputTag = $("#textareatProjectBackground");
    		disableInputTag(inputTag);
    	});
    	
    }
    
    function setButtonEditProjectBackgroundFunctionality() {
    
        btnEditProjectBackground.on("click", function (){
        	//alert("test button edit project background!");
        	let button = $(this);
        	changeButtonToSaveButton(button);
        	
        	let inputTag = $("#textareatProjectBackground");
        	enableInputTagToEdit(inputTag);
        	
        	let cancelButton = $("#btnCancelProjectBackground").children().first();
        	showCancelButton(cancelButton);
        	
        });
    
    }
    
    
    function init() {
        hideTestDivs();
        setButtonEditFunctionality();
        setButtonEditProjectBackgroundFunctionality();
        setButtonCancelFunctionality();
        setButtonSaveFunctionality();
    }

    init();

});