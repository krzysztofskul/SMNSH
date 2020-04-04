document.addEventListener("DOMContentLoaded", function() {

    /**
     * parameters definitions
     * @type {HTMLElement}
     */
    const demoModeBtn = document.getElementById("demoModeBtn");
    const initDbBtn = document.getElementById("initDbBtn");
    const demoCounterTitle = document.getElementById("demoCounterTitle");
    const demoCounter = document.getElementById("demoCounter").innerText;

    /* test js file*/
    // demoModeBtn.addEventListener("click", function () {
    //     alert(demoModeBtn.innerHTML);
    // })

    /**
     * functions definitions
     */
    function setButtonDemoModeActive() {
        demoModeBtn.classList.add("btn-success");
        demoModeBtn.setAttribute("data-toggle", "tooltip");
        demoModeBtn.setAttribute("title", "Turn on Demo Mode!")
        demoModeBtn.setAttribute("href", "/startDemoMode")
    };

    function setButtonDemoModeDisabled() {
        demoModeBtn.classList.add("disabled");
        demoModeBtn.removeAttribute("data-toggle");
        demoModeBtn.removeAttribute("title")
        demoModeBtn.setAttribute("href", "/#")
    }
    function showCounter() {
        demoCounterTitle.classList.remove("text-hide");
        demoCounter.classList.remove("text-hide");
    }
    function setStepNo1Ready() {
        initDbBtn.classList.replace("btn-warning", "btn-success");
        initDbBtn.setAttribute("href", "/demoStepNo1")
    }
    function startDemoMode() {
        //createCounter();
        showCounter();
        setButtonDemoModeDisabled();
        setStepNo1Ready();
        alert("demo mode started")
    }

    /**
     * demo mode functionality
     */

    /* beginning conditions check (which demo mode step is set up)  */
    if (demoCounter.length === 0) {
        setButtonDemoModeActive();
        demoCounterTitle.classList.add("text-hide");
        demoCounter.classList.add("text-hide");
    }
    if (demoCounter === "0") {
        startDemoMode();
    }
    if (demoCounter === "1") {
        // todo
    }

});