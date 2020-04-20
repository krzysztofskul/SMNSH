document.addEventListener("DOMContentLoaded", function() {

    /**
     * parameters definitions
     * @type {HTMLElement}
     */
    var tooltipDemoInfo = document.getElementById("tooltipDemoInfo");
    const demoModeBtn = document.getElementById("demoModeBtn");
    const initDbBtn = document.getElementById("initDbBtn");
    const loginAsPmBtn = document.getElementById("loginAsPmBtn");
    const projectsBtn = document.getElementById("projectsBtn");
    const newProjectBtn = document.getElementById("newProjectBtn");
    const projectNewBtnSave = document.getElementById("projectNewBtnSave");
    const formNewProject = document.getElementById("formNewProject");
    const newConceptBtn = document.getElementById("newConceptBtn");
    const conceptNewForm = document.getElementById("conceptNewForm");
    const saveConceptBtn = document.getElementById("saveConceptBtn");
    const questionSetSaveBtn = document.getElementById("questionSetSaveBtn");
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

    function demoCounterEventListener() {
        demoCounterTitle.addEventListener("click", function () {
            showTooltipDemoInfo();
        });
    }

    function setButtonReady(btn) {
        setInterval(function () {
            var btnType = "";
            if (btn.classList.contains("btn-outline-primary")) {
                btnType = "btn-outline-primary";
            }
            if (btn.classList.contains("btn-outline-secondary")) {
                btnType = "btn-outline-secondary";
            }
            if (btn.classList.contains("btn-outline-success")) {
                btnType = "btn-outline-success";
            }
            if (btn.classList.contains("btn-outline-danger")) {
                btnType = "btn-outline-danger";
            }
            if (btn.classList.contains("btn-outline-warning")) {
                btnType = "btn-outline-warning";
            }
            if (btn.classList.contains("btn-outline-info")) {
                btnType = "btn-outline-info";
            }
            if (btn.classList.contains("btn-outline-light")) {
                btnType = "btn-outline-light";
            }
            if (btn.classList.contains("btn-outline-dark")) {
                btnType = "btn-outline-dark";
            }
            if (btn.classList.contains("btn-primary")) {
                btnType = "btn-primary";
            }
            if (btn.classList.contains("btn-secondary")) {
                btnType = "btn-secondary";
            }
            if (btn.classList.contains("btn-success")) {
                btnType = "btn-success";
            }
            if (btn.classList.contains("btn-danger")) {
                btnType = "btn-danger";
            }
            if (btn.classList.contains("btn-warning")) {
                btnType = "btn-warning";
            }
            if (btn.classList.contains("btn-info")) {
                btnType = "btn-info";
            }
            if (btn.classList.contains("btn-light")) {
                btnType = "btn-light";
            }
            if (btn.classList.contains("btn-dark")) {
                btnType = "btn-dark";
            }
            setTimeout(function () {
                btn.classList.replace(btnType, "btn-success");
            }, 250);
            btn.classList.replace(btnType, "btn-outline-success");
        }, 500);
    }

    function showTooltipDemoInfo() {
        tooltipDemoInfo.classList.remove("d-none");
    }

    function createTooltipDemoInfo(txtPL, txtEN) {
        tooltipDemoInfo.style.position = "fixed";
        tooltipDemoInfo.style.width = 300;
        tooltipDemoInfo.style.minHeight = 200;
        tooltipDemoInfo.style.top = 50;
        tooltipDemoInfo.style.left = 50;
        tooltipDemoInfo.style.border = "solid black 1px";
        tooltipDemoInfo.style.backgroundColor = "darkgrey";
        tooltipDemoInfo.style.padding = "10px";
        tooltipDemoInfo.style.opacity = .9;
        tooltipDemoInfo.style.fontSize = "16px";
        tooltipDemoInfo.style.letterSpacing = "5px";
        tooltipDemoInfo.innerHTML =
            "<p class='langPL'>"+txtPL+"</p><p class='langEN'>"+txtEN+"</p>"+
            "<div id='btnCloseTooltipDemoInfo' class='btn btn-outline-dark float-right mt-5'>" +
            "<p class='langPL'>ZAMKNIJ</p> " +
            "<p class='langEN'>CLOSE</p> " +
            "</div>"
        ;

        var btnCloseTooltipDemoInfo = document.getElementById("btnCloseTooltipDemoInfo");
        btnCloseTooltipDemoInfo.addEventListener("click", function () {
            // alert("test click");
            tooltipDemoInfo.classList.add("d-none");
        });
    }

    function setButtonDemoModeActive() {
        demoModeBtn.classList.add("btn-success");
        demoModeBtn.setAttribute("data-toggle", "tooltip");
        demoModeBtn.setAttribute("title", "Turn on Demo Mode!");
        demoModeBtn.setAttribute("href", "/startDemoMode");
    }
    function startDemoMode() {
        // initDbBtn.classList.replace("btn-warning", "btn-success");
        setButtonReady(initDbBtn);
        initDbBtn.setAttribute("href", "/demoStepNumber1");
        createTooltipDemoInfo("TRYB DEMO ZOSTAŁ AKTYWOWANY", "DEMO MODE HAS BEEN STARTED");
        // alert("demo mode started");
    }
    function setButtonDisabled(btn) {
        btn.classList.add("disabled");
        // demoModeBtn.removeAttribute("data-toggle");
        // demoModeBtn.removeAttribute("title");
        // demoModeBtn.setAttribute("href", "/#");
    }
    // function showCounter() {
    //     demoCounterTitle.classList.remove("text-hide");
    //     demoCounter.classList.remove("text-hide");
    // }

    /**
     * functions definitions - demo steps
     */

    function setStepNumber1Ready() {
        initDbBtn.classList.replace("btn-warning", "btn-success");
        initDbBtn.setAttribute("href", "/demoStepNumber1");
    }
    function setStepNumber2Ready() {
        var logInBtn = document.getElementById("logInBtn");
        setButtonReady(loginAsPmBtn);
        createTooltipDemoInfo("TESTOWA BAZA DANYCH ZOSTAŁA ZAINICJOWANA. ZALOGUJ SIĘ JAKO GOŚĆ - KIEROWNIK PROJEKTU ...", "TEST DATABASE HAS BEEN INITIALIZED. LOG IN AS A GUEST - PROJECT MANAGER ...")
        //loginAsPmBtn.classList.add('text-success');
        loginAsPmBtn.setAttribute("href", "/demoStepNumber2");
    }
    function setStepNumber3Ready() {
        // projectsBtn.classList.replace('btn-light','btn-success');
        setButtonReady(projectsBtn);
        createTooltipDemoInfo("ZALOGOWANO JAKO GOŚĆ - KIEROWNIK PROJEKTU. PRZEJDŹ DO LISTY PROJEKTÓW ...", "LOGGED IN AS A GUEST - PROJECT MANAGER. GO TO THE LIST OF ALL PEOJCTS NOW ...")
        projectsBtn.setAttribute("href", "/demoStepNumber3");
        // loginAsPmBtn.classList.remove('text-success');
        // loginAsPmBtn.setAttribute("href", "/login?guest=projectManager");
    }
    function setStepNumber4Ready() {
        setButtonReady(newProjectBtn);
        createTooltipDemoInfo(
            "TO JEST STRONA Z WSZYSTKIMI AKTYWNYMI PROJEKTAMI ZALOGOWANEGO KIEROWNIKA PROJEKTU. UTWÓRZ TERAZ NOWY PROJEKT ...",
            "THIS IS THE PAGE WITH ALL OF ACTIVE PROJECTS OF THE LOGGED IN PROJECT MANAGER. CREATE THE NEW ONE NOW ..."
        );
        newProjectBtn.setAttribute("href", "/demoStepNumber4");
    }
    function setStepNumber5Ready() {
        createTooltipDemoInfo(
            "WYPEŁNIJ FORMULARZ TWORZEANIA NOWEGO PROJEKTU ...",
            "FILL IN THE FORM TO CREATE THE NEW PROJECT ...."
        );
        setButtonReady(projectNewBtnSave);
        formNewProject.setAttribute("action", "/demoStepNumber5");
    }
    function setStepNumber6Ready() {
        // newProjectBtn.classList.add("disabled");
        // logoutBtn.classList.replace("btn-danger", "btn-success");
        // logoutBtn.setAttribute("href", "/demoStepNumber6");

        createTooltipDemoInfo(
            "NOWY PROJEKT ZOSTAŁ UTWORZONY I UMIESZCZONY NA LIŚCIE WSZYSTKICH PROJEKTÓW. PRZEJDŹ TERAZ DO SZCZEGÓŁÓW ...",
            "NEW PROJECT HAS BEEN CREATED AND SET UP ON THE LIST WITH ALL PROJECTS. GO TO THE DETAILS NOW ..."
        );

        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerHTML.includes("DEMO PROJECT NAME")) {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                // child3.classList.replace("btn-primary", "btn-success");
                setButtonReady(child3);
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

        createTooltipDemoInfo(
            "TO JEST STRONA WYŚWIETLAJĄCA WSZYSTKIE SZCZEGÓŁY PROJEKTU. UTWÓRZ ZAMÓWIENIE DO DZIAŁU PROJEKTOWEGO DLA PROJEKTU KONCEPCYJNEGO POSADOWIENIA I INSTALACJI APARATU ...",
            "THIS IS THE SITE WITH ALL INFORMATION ABOUT THE PROJECT. CREATE A NEW ORDER TO DESIGNING OFFICE FOR PRELIMINARY (CONCEPTUAL) DESIGN OF THE DEVICE POSITIONING AND INSTALLATION ..."
        );

        var projectId = newConceptBtn.parentElement.parentElement.parentElement
            .firstElementChild.firstElementChild.firstElementChild.firstElementChild.children.item(1).innerHTML
        var userId = document.querySelector("#projectManagerId").innerHTML;
        // console.log("projectId: "+projectId);
        // console.log("userId "+userId);
        setButtonReady(newConceptBtn);
        newConceptBtn.setAttribute("href", "/demoStepNumber7?projectId="+projectId+"&userId="+userId);
    }

    function setStepNumber8Ready() { // get save concept button ready
        // projectsBtn.classList.replace("btn-light","btn-success");
        // projectsBtn.setAttribute("href", "/demoStepNumber8");
        // newProjectBtn.classList.add("disabled");

        createTooltipDemoInfo(
            "WYPEŁNIJ FORMULARZ ZAMÓWIENIA PROJEKTU KONCEPCYJNEGO ...",
            "FILL IN THE FORM FOR ORDER THE NEW PRELIMINARY (CONCEPTUAL) DESIGN ..."
        );

        setButtonReady(saveConceptBtn);
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

        createTooltipDemoInfo(
            "WYPEŁNIJ DODATKOWY FORMULARZ ZALEŻNY OD RODZAJU URZĄDZENIA...",
            "FILL IN ADDITIONA FORM WHICH DEPENDS ON THE TYPE OF DEVICE ..."
        );

        setButtonReady(questionSetSaveBtn);
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
        setButtonReady(demoModeBtn);
        demoCounterTitle.classList.add("text-hide");
        demoCounter.classList.add("text-hide");
    }
    if (demoCounter === "0") {
        startDemoMode();
        demoCounterEventListener();
    }
    if (demoCounter === "1") {
        setStepNumber2Ready();
        demoCounterEventListener();
    }
    if (demoCounter === "2") {
        setStepNumber3Ready();
        demoCounterEventListener();
    }
    if (demoCounter === "3") {
        setStepNumber4Ready();
        demoCounterEventListener();
    }
    if (demoCounter === "4") {
        setStepNumber5Ready();
        demoCounterEventListener();
    }
    if (demoCounter === "5") {
        setStepNumber6Ready();
        demoCounterEventListener();
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
        setStepNumber9Ready();
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