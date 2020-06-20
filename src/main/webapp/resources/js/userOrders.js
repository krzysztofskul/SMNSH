document.addEventListener("DOMContentLoaded", function() {
// $(document).ready(function() { //jQuery version

    /**
     * def. hide/unhide buttons
     */

    var ordersHideUnhideBtns = document.querySelectorAll(".ordersHideUnhideBtn");

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
    });

    /** hide order details divs at the beginning */
    ordersHideUnhideBtns.forEach(function (btn) {
        btn.click();
    });

});
