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
    const formNewProject = document.getElementById("formNewProject");
    const logoutBtn = document.getElementById("logoutBtn");
    const loginAsDesignerBtn = document.getElementById("loginAsDesignerBtn");

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
        initDbBtn.setAttribute("href", "/demoStepNumber1");
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
    function setStepNumber1Ready() {
        initDbBtn.classList.replace("btn-warning", "btn-success");
        initDbBtn.setAttribute("href", "/demoStepNumber1");
    }
    function setStepNumber2Ready() {
        loginAsPmBtn.classList.add('text-success');
        loginAsPmBtn.setAttribute("href", "/demoStepNumber2");
    }
    function setStepNumber3Ready() {
        projectsBtn.classList.replace('btn-light','btn-success');
        projectsBtn.setAttribute("href", "/demoStepNumber3");
        loginAsPmBtn.classList.remove('text-success');
        loginAsPmBtn.setAttribute("href", "/login?guest=projectManager");
    }
    function setStepNumber4Ready() {
        newProjectBtn.setAttribute("href", "/demoStepNumber4");
    }
    function setStepNumber5Ready() {
        formNewProject.setAttribute("action", "/demoStepNumber5");
    }
    function setStepNumber6Ready() {
        newProjectBtn.classList.add("disabled");
        logoutBtn.classList.replace("btn-danger", "btn-success");
        logoutBtn.setAttribute("href", "/demoStepNumber6");
    }
    function setStepNumber7Ready() {
        loginAsDesignerBtn.classList.add("text-success");
        loginAsDesignerBtn.setAttribute("href", "/demoStepNumber7");
    }

    function setStepNumber8Ready() {
        projectsBtn.classList.replace("btn-light","btn-success");
        projectsBtn.setAttribute("href", "/demoStepNumber8");
        newProjectBtn.classList.add("disabled");
    }
    function setStepNumber9Ready() {
        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerHTML.includes("DEMO")) {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(1);
                var child2 = child1.children.item(4); // 3
                var child3 = child2.children.item(2); // 2
                child3.classList.add("pt-5");
                // TODO
            }
        });
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
        setStepNumber2Ready();
    }
    if (demoCounter === "2") {
        setStepNumber3Ready();
    }
    if (demoCounter === "3") {
        setStepNumber4Ready();
    }
    if (demoCounter === "4") {
        setStepNumber5Ready();
    }
    if (demoCounter === "5") {
        setStepNumber6Ready();
    }
    if (demoCounter === "6") {
        setStepNumber7Ready();
    }
    if (demoCounter === "7") {
        setStepNumber8Ready();
    }
    if (demoCounter === "8") {
        setStepNumber9Ready();
    }

});