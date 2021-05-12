$(document).ready(function () {

    //alert("@test: details.js"); //ok

    let btnIdAddPart = $('.id-add-part');

    function init() {
        function addEventListeners() {
            /* add event listeners to add part buttons */
            btnIdAddPart.each(function () {
                /* @test: */ //$(this).removeClass("btn-outline-success"); //ok
                $(this).prop("disabled", false);
                $(this).on("click", function (element) {

                    element.preventDefault();
                    //alert("@test: click button!"); //ok

                    let configurationId = $(this).parent().parent().parent().children("div:nth-child(3)").attr("id").substring(19);
                    // alert("@test: click button for configuration id: "+configurationId); // ok
                    //addTestPartToConfiguration(configurationId); //todo: 2021-05-12

                });
            });
        }

        addEventListeners();
    }

    init();

});