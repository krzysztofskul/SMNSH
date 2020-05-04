document.addEventListener("DOMContentLoaded", function () {

    var password = document.getElementById("password");
    var passwordVerification = document.getElementById("passwordVerification");
    var buttonSave = document.getElementById("buttonSave");



    passwordVerification.addEventListener("keyup", function () {
        if (passwordVerification.value === password.value) {
            buttonSave.classList.remove("invisible");
        } else {
            buttonSave.classList.add("invisible");
        }
    });

});