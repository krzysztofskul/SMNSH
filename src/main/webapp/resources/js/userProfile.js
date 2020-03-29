document.addEventListener("DOMContentLoaded", function() {
// $(document).ready(function() { //jQuery version

    /**
     * def. hide/unhide buttons
     */
    var userDataHeader = document.getElementById("userDataHeader");
    // userDataHeader.style.backgroundColor = "darkgrey"; // check if .js is visible
    var userDataButton = userDataHeader.lastElementChild;
    var userDataBody = document.getElementById("userDataBody");
    var userDataFooter = document.getElementById("userDataFooter");
    /* buttons to hide and unhide order details*/
    var ordersHideUnhideBtns = document.querySelectorAll(".ordersHideUnhideBtn");

    /** hide user details divs functionality */
    userDataButton.addEventListener("click", userDataHideUnhide);

    /** hide order details divs functionality */
    ordersHideUnhideBtns.forEach(function (btn) {
        btn.addEventListener("click", function() {
            var parentRow =  btn.parentElement.parentElement.parentElement;
            var orderDetailsRow_1 = parentRow.querySelector(".orderDetailsRow-1");
            var orderDetailsRow_2 = parentRow.querySelector(".orderDetailsRow-2");
            var orderDetailsRow_3 = parentRow.querySelector(".orderDetailsRow-3");
            if (btn.lastElementChild.innerHTML === "HIDE") {
                orderDetailsRow_1.className = "row orderDetailsRow-1 d-none";
                orderDetailsRow_2.className = "row orderDetailsRow-2 d-none";
                orderDetailsRow_3.className = "card-body orderDetailsRow-3 d-none";
                btn.firstElementChild.innerHTML = "ROZWIŃ";
                btn.lastElementChild.innerHTML = "UNHIDE";
            } else {
                orderDetailsRow_1.className = "row orderDetailsRow-1";
                orderDetailsRow_2.className = "row orderDetailsRow-2";
                orderDetailsRow_3.className = "card-body orderDetailsRow-3";
                btn.firstElementChild.innerHTML = "ZWIŃ";
                btn.lastElementChild.innerHTML = "HIDE";
            }
        });
    })


    /** functions definitions */
    function userDataHideUnhide() {
        if (userDataButton.lastElementChild.innerHTML === "HIDE") {
            userDataBody.style.display = "none";
            userDataFooter.style.display="none";
            userDataButton.firstElementChild.innerHTML = "ROZWIŃ";
            userDataButton.lastElementChild.innerHTML = "UNHIDE";
        } else {
            userDataBody.style.display = "block";
            userDataFooter.style.display="block";
            userDataButton.firstElementChild.innerHTML = "ZWIŃ";
            userDataButton.lastElementChild.innerHTML = "HIDE";
        }
    }

    // function ordersHideUnhide(btn) {
    //     todo
    // }

});
