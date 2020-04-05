document.addEventListener("DOMContentLoaded", function() {

    /**
     * parameters definitions
     * @type {HTMLElement}
     */
    const demoModeBtn = document.getElementById("demoModeBtn");
    const initDbBtn = document.getElementById("initDbBtn");
    const loginAsPmBtn = document.getElementById("loginAsPmBtn");
    const projectsBtn = document.getElementById("projectsBtn");
    const newProjectBtn = document.getElementById("newProjectBtn");
    const projectNewBtnSave = document.getElementById("projectNewBtnSave");

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
        demoModeBtn.setAttribute("title", "Turn on Demo Mode!");
        demoModeBtn.setAttribute("href", "/startDemoMode");
    }
    function startDemoMode() {
        initDbBtn.classList.replace("btn-warning", "btn-success");
        initDbBtn.setAttribute("href", "/demoStepNo1");
        alert("demo mode started");
    }
    function setButtonDemoModeDisabled() {
        demoModeBtn.classList.add("disabled");
        demoModeBtn.removeAttribute("data-toggle");
        demoModeBtn.removeAttribute("title");
        demoModeBtn.setAttribute("href", "/#");
    }
    function showCounter() {
        demoCounterTitle.classList.remove("text-hide");
        demoCounter.classList.remove("text-hide");
    }
    function setStepNo1Ready() {
        initDbBtn.classList.replace("btn-warning", "btn-success");
        initDbBtn.setAttribute("href", "/demoStepNo1");
    }
    function setStepNo2Ready() {
        loginAsPmBtn.classList.add('text-success');
        loginAsPmBtn.setAttribute("href", "/demoStepNo2");
    }
    function setStepNo3Ready() {
        projectsBtn.classList.replace('btn-light','btn-success');
        projectsBtn.setAttribute("href", "/demoStepNo3");
        loginAsPmBtn.classList.remove('text-success');
        loginAsPmBtn.setAttribute("href", "/login?guest=projectManager");
    }
    function setStepNo4Ready() {
        newProjectBtn.setAttribute("href", "/demoStepNo4");
    }
    function setStepNo5Ready() {
        //projectNewBtnSave.classList.add("disabled");
        projectNewBtnSave.setAttribute("href", "/#");
    }

    /**
     * demo mode functionality
     */

    /* beginning conditions check on the page (which demo mode step is set up)  */
    if (demoCounter.length === 0) {
        setButtonDemoModeActive();
        demoCounterTitle.classList.add("text-hide");
        demoCounter.classList.add("text-hide");
    }
    if (demoCounter === "0") {
        startDemoMode();
    }
    if (demoCounter === "1") {
        setStepNo2Ready();
    }
    if (demoCounter === "2") {
        setStepNo3Ready();
    }
    if (demoCounter === "3") {
        setStepNo4Ready();
    }
    if (demoCounter === "4") {
        setStepNo5Ready();
    }

});