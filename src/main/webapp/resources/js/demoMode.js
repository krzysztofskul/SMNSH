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
    // const projectNewBtnSave = document.getElementById("projectNewBtnSave");
    const formNewProject = document.getElementById("formNewProject");
    const newConceptBtn = document.getElementById("newConceptBtn");
    const conceptNewForm = document.getElementById("conceptNewForm");
    const saveConceptBtn = document.getElementById("saveConceptBtn");
    const logoutBtn = document.getElementById("logoutBtn");
    const loginAsDesignerBtn = document.getElementById("loginAsDesignerBtn");
    const setMeAsDesignerBtn = document.getElementById("setMeAsDesignerBtn");
    const newFinalProjectOrderBtn = document.getElementById("newFinalProjectOrderBtn");
    const orderGuidelineBtn = document.getElementById("orderGuidelineBtn");
    const newGuidelineForm = document.getElementById("newGuidelineForm");

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
        // newProjectBtn.classList.add("disabled");
        // logoutBtn.classList.replace("btn-danger", "btn-success");
        // logoutBtn.setAttribute("href", "/demoStepNumber6");

        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerHTML.includes("DEMO PROJECT NAME")) {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                child3.classList.replace("btn-primary", "btn-success");
                child3.setAttribute("href", "/demoStepNumber6/"+projectId);
            }
        });
        //newProjectBtn.classList.replace("btn-success", "btn-light");
        newProjectBtn.classList.add("disabled");
    }
    function setStepNumber7Ready() {    // get ready the button for the new concept
        // loginAsDesignerBtn.classList.add("text-success");
        // loginAsDesignerBtn.setAttribute("href", "/demoStepNumber7");

        // /concepts/new?projectId=${project.id}&userId=${project.projectManager.id}
        var projectId = newConceptBtn.parentElement.parentElement.parentElement
            .firstElementChild.firstElementChild.firstElementChild.firstElementChild.children.item(1).innerHTML
        var userId = document.querySelector("#projectManagerId").innerHTML;
        // console.log("projectId: "+projectId);
        // console.log("userId "+userId);
        newConceptBtn.setAttribute("href", "/demoStepNumber7?projectId="+projectId+"&userId="+userId);
    }

    function setStepNumber8Ready() { // get save concept button ready
        // projectsBtn.classList.replace("btn-light","btn-success");
        // projectsBtn.setAttribute("href", "/demoStepNumber8");
        // newProjectBtn.classList.add("disabled");

        conceptNewForm.setAttribute("action", "/demoStepNumber8");
    }
    function setStepNumber9Ready() {
        // var x = document.querySelectorAll(".projectNameDiv");
        // x.forEach(function (e, i , arr) {
        //     if (e.innerHTML.includes("DEMO PROJECT NAME")) {
        //         e.classList.add("text-success");
        //         var parent = e.parentElement.parentElement.parentElement.parentElement;
        //         var child1 = parent.children.item(0);
        //         var child2 = child1.children.item(2); // 3
        //         var child3 = child2.children.item(1); // 2
        //         var projectId = parent.children.item(0).children.item(0).innerHTML;
        //         child3.classList.replace("btn-primary", "btn-success");
        //         child3.setAttribute("href", "/demoStepNumber9/"+projectId);
        //     }
        // });
        // //newProjectBtn.classList.replace("btn-success", "btn-light");
        // newProjectBtn.classList.add("disabled");
    }
    function setStepNumber10Ready() {
        logoutBtn.classList.replace("btn-danger", "btn-success");
        logoutBtn.setAttribute("href", "/demoStepNumber10");
        newConceptBtn.classList.add("disabled");
    }
    function setStepNumber11Ready() {   // get ready login as designer
        loginAsDesignerBtn.classList.add("text-success");
        loginAsDesignerBtn.setAttribute("href", "/demoStepNumber11")
    }
    function setStepNumber12Ready() {
        projectsBtn.classList.replace("btn-light","btn-success");
        projectsBtn.setAttribute("href", "/demoStepNumber12")
    }
    function setStepNumber13Ready() {
        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerHTML.includes("DEMO PROJECT NAME")) {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                child3.classList.replace("btn-primary", "btn-success");
                child3.setAttribute("href", "/demoStepNumber13/"+projectId);
            }
        });
        //newProjectBtn.classList.replace("btn-success", "btn-light");
        newProjectBtn.classList.add("disabled");
    }
    function setStepNumber14Ready() {
        // /concepts/setDesigner/${concept.id}/${sessionScope.userLoggedIn.id}?backToPage=projects/details/${project.id}"
        var conceptId = document.querySelector(".conceptId").innerHTML;
        var designerId = document.getElementById("userLoggedIn").innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        setMeAsDesignerBtn.setAttribute("href", "/demoStepNumber14/"+conceptId+"/"+designerId+"?backToPage=projects/details/"+projectId);
    }
    function setStepNumber15Ready() {
        var setOrderAsFinishedBtn = document.getElementById("setOrderAsFinishedBtn");
        var conceptId = document.querySelector(".conceptId").innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        setOrderAsFinishedBtn.setAttribute("href", "/demoStepNumber15/"+conceptId+"?backToPage=projects/details/"+projectId);
        setOrderAsFinishedBtn.classList.replace("btn-outline-success", "btn-success");
    }
    function setStepNumber16Ready() { // set logout button active
        logoutBtn.classList.replace("btn-danger", "btn-success");
        logoutBtn.setAttribute("href", "/demoStepNumber16");
    }
    function setStepNumber17Ready() { // login as PM active
        loginAsPmBtn.classList.add("text-success");
        loginAsPmBtn.setAttribute("href", "/demoStepNumber17")
    }
    function setStepNumber18Ready() {
        projectsBtn.classList.replace("btn-light", "btn-success");
        projectsBtn.setAttribute("href", "/demoStepNumber18")
    }
    function setStepNumber19Ready() {
        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerHTML.includes("DEMO PROJECT NAME")) {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                child3.classList.replace("btn-primary", "btn-success");
                child3.setAttribute("href", "/demoStepNumber19/"+projectId);
            }
        });
        newProjectBtn.classList.add("disabled");
    }
    function setStepNumber20Ready() { // get ready the button for the new final project
        var conceptId = document.querySelector(".conceptId").innerHTML;
        var designerId = document.getElementById("userLoggedIn").innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        newFinalProjectOrderBtn.setAttribute("href", "/demoStepNumber20/"+conceptId+"/"+designerId+"?backToPage=projects/details/"+projectId);
        newConceptBtn.classList.add("disabled");
        var interval = setInterval(function () {
            setTimeout(function () {
                newFinalProjectOrderBtn.classList.replace("btn-outline-success", "btn-success");
            }, 250);
            newFinalProjectOrderBtn.classList.replace("btn-success", "btn-outline-success");
        }, 500);
        // newFinalProjectOrderBtn.addEventListener("click", function () {
        //     clearInterval(interval);
        // });
    }
    function setStepNumber21Ready() {
        newGuidelineForm.setAttribute("action", "/demoStepNumber21")
        var interval = setInterval(function () {
            setTimeout(function () {
                orderGuidelineBtn.classList.replace("btn-success", "btn-outline-success")
            }, 250);
            orderGuidelineBtn.classList.replace("btn-outline-success", "btn-success");
        }, 500);
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
        setStepNumber7Ready(); // get ready the button for the new concept
    }
    if (demoCounter === "7") {
        setStepNumber8Ready(); // get save new concept button ready
    }
    if (demoCounter === "8") {
        // save new concept
        // setStepNumber9Ready();   // get ready addQuestionSet button save ready
    }
    if (demoCounter === "9") {
        // save additionalQuestionSet form
        alert("Zamówienie projektu koncepcji usytuowania aparatu zostało utworzone! / The order for preliminary (conceptual) design of the device location has been created!")
        setStepNumber10Ready();  // get log out PM button ready, disable other buttons
    }
    if (demoCounter === "10") {
        setStepNumber11Ready()
    }
    if (demoCounter === "11") {
        setStepNumber12Ready()
    }
    if (demoCounter === "12") {
        setStepNumber13Ready()
    }
    if (demoCounter === "13") {
        setStepNumber14Ready()
    }
    if (demoCounter === "14") {
        setStepNumber15Ready()
    }
    if (demoCounter === "15") {
        setStepNumber16Ready(); // set logout buttone active
    }
    if (demoCounter === "16") {
        setStepNumber17Ready(); // set login as PM active
    }
    if (demoCounter === "17") {
        setStepNumber18Ready(); // set projects button active
    }
    if (demoCounter === "18") {
        setStepNumber19Ready(); // set details of the demo project button ready
    }
    if (demoCounter === "19") { // set button for new final planning order ready
        setStepNumber20Ready();
    }
    if (demoCounter === "20") { // set save final planning order button ready
        setStepNumber21Ready();
    }
    if (demoCounter === "21") {
        //setStepNumber21Ready();
    }

});