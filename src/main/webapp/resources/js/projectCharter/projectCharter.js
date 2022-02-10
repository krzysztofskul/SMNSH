$(document).ready(function() {
    // alert("test projectCharter.js jquery!"); // ok

    let btnEdit = $("#btnEdit");
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
    function init() {
        hideTestDivs();
        setButtonEditFunctionality();
        setButtonCancelFunctionality();
        setButtonSaveFunctionality();
    }

    init();

});