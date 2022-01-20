$(document).ready(function() {
    // alert("test projectCharter.js jquery!"); // ok

    let btnEdit = $("#btnEdit");
    let btnCancel = $("#btnCancel");
    let btnSave = $("#btnSave");

    function hideTestDivs() {
        $(".test").empty();
    }

    function setButtonCancelFunctionality() {
        btnCancel.on("click", function () {
            // test
            window.location.reload(true);

        });

    }

    function setButtonSaveFunctionality() {
        btnSave.on("click", function () {
            // test
            alert("Save button functionality todo!");
            //window.location.refresh();

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