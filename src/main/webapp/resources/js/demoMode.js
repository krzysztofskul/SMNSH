document.addEventListener("DOMContentLoaded", function() {

    /**
     * parameters definitions
     * @type {HTMLElement}
     */
    var tooltipDemoInfo = document.getElementById("tooltipDemoInfo");
    const demoModeBtn = document.getElementById("demoModeBtn");
    var demoModeResetBtn = document.getElementById("demoModeReset");
    var demoModeOffBtn = document.getElementById("demoModeOFF");
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

    function showDemoModeResetBtn() {
        demoModeResetBtn.classList.remove("invisible");
        showDemoModeOffBtn();
    }

    function showDemoModeOffBtn() {
        demoModeOffBtn.classList.remove("invisible");
    }

    function showTooltipDemoInfo() {
        tooltipDemoInfo.classList.remove("d-none");
        showDemoModeResetBtn();
    }


    function createTooltipDemoInfo(txtPL, txtEN) {
        tooltipDemoInfo.style.position = "fixed";
        tooltipDemoInfo.style.width = 550;
        tooltipDemoInfo.style.minHeight = 200;
        tooltipDemoInfo.style.bottom = 150;
        tooltipDemoInfo.style.left = 50;
        tooltipDemoInfo.style.border = "solid black 1px";
        tooltipDemoInfo.style.backgroundColor = "darkgrey";
        tooltipDemoInfo.style.padding = "10px";
        tooltipDemoInfo.style.opacity = .9;
        tooltipDemoInfo.style.fontSize = "24px";
        tooltipDemoInfo.style.letterSpacing = "2px";
        tooltipDemoInfo.innerHTML =
            "<p class='langPL'>"+txtPL+"</p><p class='langEN'>"+txtEN+"</p>"+
            "<div id='btnCloseTooltipDemoInfo' class='btn btn-outline-dark float-right mt-5'>" +
            "<p class='langPL'>ZAMKNIJ</p> " +
            "<p class='langEN'>CLOSE</p> " +
            "</div>"
        ;
        tooltipDemoInfo.style.zIndex="1";

        var btnCloseTooltipDemoInfo = document.getElementById("btnCloseTooltipDemoInfo");
        btnCloseTooltipDemoInfo.addEventListener("click", function () {
            tooltipDemoInfo.classList.add("d-none");
        });
        showDemoModeResetBtn();
    }

    function setButtonDemoModeActive() {
        demoModeBtn.classList.add("btn-success");
        demoModeBtn.setAttribute("data-toggle", "tooltip");
        demoModeBtn.setAttribute("title", "Turn on Demo Mode!");
        demoModeBtn.setAttribute("href", "/startDemoMode");
    }
    function startDemoMode() {
        setButtonReady(initDbBtn);
        initDbBtn.setAttribute("href", "/demoStepNumber1");
        createTooltipDemoInfo("TRYB DEMO ZOSTAŁ AKTYWOWANY. " +
            "KLIKNIJ ZIELONY MIGAJĄCY PRZYCISK ABY PRZEJŚĆ DO KOLEJNEGO KROKU ...",
            "DEMO MODE HAS BEEN STARTED. " +
            "CLICK THE GREEN BLINKING BUTTON TO GO TO THE NEXT STEP ...");
    }
    function setButtonDisabled(btn) {
        btn.classList.add("disabled");
    }

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
        createTooltipDemoInfo("TESTOWA BAZA DANYCH ZOSTAŁA ZAINICJOWANA. " +
            "ZALOGUJ SIĘ JAKO KIEROWNIK PROJEKTU ABY UTWORZYĆ NOWY TESTOWY PROJEKT ...",
            "TEST DATABASE HAS BEEN INITIALIZED. " +
            "LOG IN AS A PROJECT MANAGER IN ORDER TO CREATE NEW TEST PROJECT ...");
        loginAsPmBtn.setAttribute("href", "/demoStepNumber2");
    }
    function setStepNumber3Ready() {
        setButtonReady(projectsBtn);
        createTooltipDemoInfo(
            "JESTEŚ ZALOGOWANY JAKO KIEROWNIK PROJEKTU. " +
            "PRZEJDŹ TERAZ NA STRONĘ WYŚWIETLAJĄCĄ WSZYSTKIE ROZPOCZĘTE PROJEKTY ...",
            "YOU ARE LOGGED IN AS A PROJECT MANAGER. " +
            "GO TO THE PAGE SHOWING ALL STARTED PROJECTS NOW ...");
        projectsBtn.setAttribute("href", "/demoStepNumber3");
    }
    function setStepNumber4Ready() {
        setButtonReady(newProjectBtn);
        createTooltipDemoInfo(
            "JESTEŚ NA STRONIE WYŚWIATLAJĄCEJ WSZYSTKIE ROZPOCZĘTE PROJEKTY." +
            "UTWÓRZ TERAZ NOWY DEMONSTRACYJNY PROJEKT...",
            "THIS IS THE PAGE WITH ALL OF ACTIVE PROJECTS. " +
            "CREATE THE NEW DEMO PROJECT NOW AS A GUEST-PROJECT MANAGER..."
        );
        newProjectBtn.setAttribute("href", "/demoStepNumber4");
        // showDemoModeResetBtn();
    }
    function setStepNumber5Ready() {
        createTooltipDemoInfo(
            "WYPEŁNIJ FORMULARZ TWORZEANIA NOWEGO PROJEKTU ...",
            "FILL IN THE FORM TO CREATE THE NEW PROJECT ...."
        );
        setButtonReady(projectNewBtnSave);
        formNewProject.setAttribute("action", "/demoStepNumber5");
        showDemoModeResetBtn();
    }
    function setStepNumber6Ready() {

        createTooltipDemoInfo(
            "GRATULACJE, NOWY PROJEKT ZOSTAŁ UTWORZONY I UMIESZCZONY NA LIŚCIE WSZYSTKICH PROJEKTÓW." +
            "PRZEJDŹ TERAZ NA STRONĘ ABY WYŚWIETLIĆ SZCZEGÓŁY, EDYTOWAĆ STATUS LUB WYSŁAĆ ZAMÓWIENIE PROJEKTU KONCEPCYJNEGO ...",
            "CONGRATULATION, NEW PROJECT HAS BEEN CREATED AND SET UP ON THE LIST WITH " +
            "ALL PROJECTS. GO TO THE PAGE SHOWING ITS DETAILS, FOR EDITING OR SEND AN ORDER FOR PRELIMINARY DESIGN ..."
        );

        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            // if (e.innerHTML.includes("DEMO PROJECT NAME")) {
            if (e.innerText === "DEMO PROJECT NAME") {
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
        newProjectBtn.classList.add("disabled");
        showDemoModeResetBtn();
    }
    function setStepNumber7Ready() {

        createTooltipDemoInfo(
            "TO JEST STRONA WYŚWIETLAJĄCA WSZYSTKIE SZCZEGÓŁY PROJEKTU. TUTAJ MOŻESZ DOKONAĆ JEGO " +
            "EDYCJI POPRZEZ WYBÓR PRZYCISKU 'EDYCJA' LUB PRZEJŚĆ DO KOLEJNEGO KROKU TRYBU DEMO I UTWORZYĆ ZAMÓWIENIE DO DZIAŁU PROJEKTOWEGO NA WYKONANIE RYSUNKU KONCEPCYJNEGO " +
            "POSADOWIENIA I INSTALACJI APARATU ...",
            "THIS IS THE PAGE WITH ALL INFORMATION ABOUT THE PROJECT. " +
            "HERE YOU CAN EDIT IT OR" +
            "CREATE A NEW ORDER TO DESIGNING OFFICE FOR PREPARING A PRELIMINARY (CONCEPTUAL) DESIGN " +
            "OF THE DEVICE POSITIONING AND INSTALLATION ..."
        );

        var projectId = newConceptBtn.parentElement.parentElement.parentElement
            .firstElementChild.firstElementChild.firstElementChild.firstElementChild.children.item(1).innerHTML
        var userId = document.querySelector("#projectManagerId").innerHTML;
        setButtonReady(newConceptBtn);
        newConceptBtn.setAttribute("href", "/demoStepNumber7?projectId="+projectId+"&userId="+userId);
        showDemoModeResetBtn();
    }

    function setStepNumber8Ready() {

        createTooltipDemoInfo(
            "WYPEŁNIJ FORMULARZ ZAMÓWIENIA PROJEKTU KONCEPCYJNEGO ...",
            "FILL IN THE FORM FOR ORDER THE NEW PRELIMINARY (CONCEPTUAL) DESIGN ..."
        );

        setButtonReady(saveConceptBtn);
        conceptNewForm.setAttribute("action", "/demoStepNumber8");
        showDemoModeResetBtn();
    }
    function setStepNumber9Ready() {
        createTooltipDemoInfo(
            "WYPEŁNIJ DODATKOWY FORMULARZ Z DODATKOWYMI PYTANIAMI ZALEŻNYMI OD RODZAJU URZĄDZENIA...",
            "FILL IN ADDITIONA FORM WHICH DEPENDS ON THE TYPE OF DEVICE ..."
        );

        setButtonReady(questionSetSaveBtn);
        showDemoModeResetBtn();
    }
    function setStepNumber10Ready() {
        createTooltipDemoInfo(
            "GRATULACJE, ZAMÓWIENIE PROJEKTU KONCEPCYJNEGO ZOSTAŁO UTWORZONE." +
            "<BR>TEN ETAP TRYBU DEMONSTRACYJNEGO PROJEKTU ZOSTAŁ ZAKOŃCZONY." +
            "WYLOGUJ SIĘ TERAZ JAKO KIEROWNIK PROJKETU.",
            "Congratulation, the order for preliminary (conceptual) design of the device location has been created." +
            "This phase of demo mode has been finished." +
            "Log out now as a project manager."
        );
        setButtonReady(logoutBtn);
        logoutBtn.setAttribute("href", "/demoStepNumber10");
        newConceptBtn.classList.add("disabled");
        showDemoModeResetBtn();
    }
    function setStepNumber11Ready() {
        createTooltipDemoInfo(
            "ZALOGUJ SIĘ TERAZ JAKO PROJEKTANT.",
            "Log in as a designer now."
        );
        setButtonReady(loginAsDesignerBtn);
        loginAsDesignerBtn.setAttribute("href", "/demoStepNumber11")
        showDemoModeResetBtn();
    }
    function setStepNumber12Ready() {
        createTooltipDemoInfo(
            "PRZEJDŹ DO LISTY PROJEKTÓW.",
            "Go to the list of all projects."
        );
        setButtonReady(projectsBtn);
        projectsBtn.setAttribute("href", "/demoStepNumber12");
        showDemoModeResetBtn();
    }
    function setStepNumber13Ready() {
        createTooltipDemoInfo(
            "PRZEJDŹ DO SZCZEGÓŁÓW PROJEKTU DEMONSTRACYJNEGO.",
            "Go to the details of the demo project now."
        );
        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerText === "DEMO PROJECT NAME") {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                setButtonReady(child3);
                child3.setAttribute("href", "/demoStepNumber13/"+projectId);
            }
        });
        newProjectBtn.classList.add("disabled");
    }
    function setStepNumber14Ready() {
        var conceptId = document.querySelector(".conceptId").innerHTML;
        var designerId = document.getElementById("userLoggedIn").innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        createTooltipDemoInfo(
            "TO JEST STRONA PROJEKTU TESTOWEGO, KTÓRY ZOSTAŁ UTWORZONY WCZEŚNIEJ. <BR>" +
            "PONIŻEJ MOŻESZ ZOBACZYĆ LISTĘ WYSŁANYCH " +
            "ZAMÓWIEŃ PROJEKTÓW KONCEPCYJNYCH ORAZ ICH AKTUALNY STATUS." +
            "KLIKNIJ PRYCISK ABY OZNACZYĆ SIĘ JAKO PROJEKTANTA WYOKUNJĄCEGO PROJEKT I ZMIENIĆ STATUS ZAMÓWIENIA.",
            "This is the page of the test project, which was created earlier." +
            "Below you can see the list of orders for preliminary (conceptual) design and theirs actual status." +
            "Click the button to assign yourself as designer and change the status of the order."
        );
        setButtonReady(setMeAsDesignerBtn);
        setMeAsDesignerBtn.setAttribute("href", "/demoStepNumber14/"+conceptId+"/"+designerId+"?backToPage=projects/details/"+projectId);
    }
    function setStepNumber15Ready() {
        setButtonReady(setOrderAsFinishedBtn);
        var conceptId = document.querySelector(".conceptId").innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        setOrderAsFinishedBtn.setAttribute("href", "/demoStepNumber15/"+conceptId+"?backToPage=projects/details/"+projectId);
        //setOrderAsFinishedBtn.classList.replace("btn-outline-success", "btn-success");
        createTooltipDemoInfo(
            "ZAMÓWIENIE PROJEKTU " +
            "ZOSTAŁO PRZYIPSANE (DO  ZALOGOWANEGO PROJEKTANTA) " +
            "I JEST OZNACZONE JAKO 'W TOKU'.<BR>" +
            "ZMIEŃ TERAZ STATUS NA 'ZAKOŃCZONY'... ",
            "THE ORDER FOR PRELIMINARY DESIGN HAS BEEN " +
            "SET TO THE LOGGED USER AND IS SET AS 'IN PROGRESS'. " +
            "CHANGE THE STATUS FOR 'FINISHED NOW...'"
        );
    }
    function setStepNumber16Ready() {
        createTooltipDemoInfo("" +
            "ZAMÓWIENIE PROJEKTU WYTYCZNYCH ZOSTAŁO WYKONANE. KLINIK WYLOGUJ",
            "THE ORDER FOR PRELIMINARY DESIGN HAS BEEN DONE. CLICK THE LOG OUT BUTTON");
        // logoutBtn.classList.replace("btn-danger", "btn-success");
        setButtonReady(logoutBtn);
        logoutBtn.setAttribute("href", "/demoStepNumber16");
    }
    function setStepNumber17Ready() {
        createTooltipDemoInfo(
            "ZALOGUJ SIĘ TERAZ JAKO KIEROWNIK PROJEKTU I SPRAWDŹ STATUS " +
            "SWOJEGO ZAMÓWIENIA. JEŚLI JEST ZAKOŃCZONE MOŻESZ " +
            "ZAMÓWIĆ RYSUNEK WYTYCZNYCH INSTALCYJNCYCH GDY PROJEKT " +
            "KONCEPCYJNY ZOSTANIE PRZYJĘTY PRZEZ KLIENTA",
            "YOU CAN LOG IN AS PROJEKT " +
            "MANAGER AND CHECK YOUR ORDER STATUS. IF IT IS " +
            "FINISHED YOU CAN ORDER THE FINAL PLANNING DRAWING, " +
            "WHEN CONCEPTUAL DESIGN IS ACCEPTED BY CUSTOMER.");
        // loginAsPmBtn.classList.add("text-success");
        setButtonReady(loginAsPmBtn);
        loginAsPmBtn.setAttribute("href", "/demoStepNumber17");
    }
    function setStepNumber18Ready() {
        setButtonReady(projectsBtn);
        createTooltipDemoInfo(
            "PRZEJDŹ DO LISTY WSZYSTKICH PROJEKTÓW...",
            "GO TO THE LIST OF ALL PROJECTS PAGE...");
        projectsBtn.setAttribute("href", "/demoStepNumber18");
    }
    function setStepNumber19Ready() {
        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            if (e.innerText === "DEMO PROJECT NAME") {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                child3.classList.replace("btn-primary", "btn-success");
                child3.setAttribute("href", "/demoStepNumber19/"+projectId);
                setButtonReady(child3);
            }
        });
        newProjectBtn.classList.add("disabled");
        createTooltipDemoInfo(
            "PRZEJDŹ DO SZCZEGÓŁÓW PROJEKTU...",
            "GO TO DETAILS OF THE PROJECT...");
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
        createTooltipDemoInfo(
            "PROJEKT KONCEPCYJNY JEST WYKONANY. " +
            "MOŻESZ TERAZ ZAMÓWIĆ PROJEKT WYTYCZNYCH W ANALOGICZNY SPOSÓB JAK PROJEKT KONCEPCYJNY...",
            "PRELIMINARY (CONCEPTUAL) DESIGN HAS BEEN FINISHED. " +
            "YOU CAN ORDER FINAL PLANNING (GUIDELINES) DESIGN NOW...");
    }
    function setStepNumber21Ready() {
        newGuidelineForm.setAttribute("action", "/demoStepNumber21");
        var interval = setInterval(function () {
            setTimeout(function () {
                orderGuidelineBtn.classList.replace("btn-success", "btn-outline-success")
            }, 250);
            orderGuidelineBtn.classList.replace("btn-outline-success", "btn-success");
        }, 500);
        createTooltipDemoInfo(
            "WYPEŁNIJ FORMULARZ DLA ZAMÓWIENIA WYTYCZNYCH...",
            "FILL IN THE FORM FOR FINAL PLANNING ORDER...");
    }

    function setStepNumber22Ready() {
        newConceptBtn.classList.add("disabled");
        createTooltipDemoInfo(
            "ZAMÓWIENIE WYTYCZNYCH ZOSTAŁO UTWORZONE. MOŻESZ SIĘ WYLOGOWAĆ...",
            "FINAL PLANNING ORDER HAS BEEN CREATED. YOU CAN LOG OUT NOW...");
        logoutBtn.setAttribute("href", "/demoStepNumber22");
        setButtonReady(logoutBtn);
    }
    function setStepNumber23Ready() {
        loginAsDesignerBtn.setAttribute("href", "/demoStepNumber23")
        createTooltipDemoInfo(
            "ZALOGUJE SIĘ TERAZ JAKO PROJEKTANT...",
            "LOG IN AS DESIGNER NOW...");
        setButtonReady(loginAsDesignerBtn);
    }

    function setStepNumber24Ready() {
        projectsBtn.setAttribute("href", "/demoStepNumber24")
        createTooltipDemoInfo(
            "PRZEJDŹ DO LISTY WSZYSTKICH PROJEKTÓW...",
            "GO TO THE LIST OF ALL PROJECTS...");
        setButtonReady(projectsBtn);
    }

    function setStepNumber25Ready() {
        var x = document.querySelectorAll(".projectNameDiv");
        x.forEach(function (e, i , arr) {
            // if (e.innerHTML.includes("DEMO PROJECT NAME")) {
            if (e.innerText === "DEMO PROJECT NAME") {
                e.classList.add("text-success");
                var parent = e.parentElement.parentElement.parentElement.parentElement;
                var child1 = parent.children.item(0);
                var child2 = child1.children.item(2); // 3
                var child3 = child2.children.item(1); // 2
                var projectId = parent.children.item(0).children.item(0).innerHTML;
                child3.classList.replace("btn-primary", "btn-success");
                child3.setAttribute("href", "/demoStepNumber25/"+projectId);
                setButtonReady(child3);
            }
        });
        createTooltipDemoInfo(
            "PRZEJDŹ DO SZCZEGÓŁÓW PROJEKTU...",
            "GO TO THE PROJECT DETAILS..."
        );
    }

    function setStepNumber26Ready() {
        createTooltipDemoInfo(
            "PRZYPISZ PROJEKTANTA WYKONUJĄCEGO PROJEKT WYTYCZNYCH...",
            "SET THE DESIGNER PREPARING FINAL PLANNING DESIGN...");
        var setMeAsDesignerGuidelinesBtn = document.getElementById("setMeAsDesignerGuidelinesBtn");
        setButtonReady(setMeAsDesignerGuidelinesBtn);
        var guidelineId = setMeAsDesignerGuidelinesBtn.parentElement.parentElement
            .children.item(1)
            .children.item(0)
            .children.item(0)
            .children.item(1)
            .innerHTML;
        var designerId = document.getElementById("userLoggedIn").innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        setMeAsDesignerGuidelinesBtn.setAttribute("href", "/demoStepNumber26/"+guidelineId+"/"+designerId+"?backToPage=projects/details/"+projectId);
    }

    function setStepNumber27Ready() {
        createTooltipDemoInfo(
            "STATUS PROJEKTU WYTYCZNYCH ZOSTAŁ PRZYPISANY DO ZALOGOWANEGO PROJEKTANTA. " +
            "ZMIEŃ TERAZ SATATUS NA ZAKOŃCZONY...",
            "STATUS OF THE FINAL PLANNING DESIGN HAS BEEN SET TO LOGGED IN DESIGNER. " +
            "CHANGE THE STATUS FOR FINISHED NOW...");
        var setGuidelinesFinishedBtn = document.getElementById("setGuidelinesFinishedBtn");
        setButtonReady(setGuidelinesFinishedBtn);
        var guidelineId = setGuidelinesFinishedBtn.parentElement.parentElement
            .children.item(1)
            .children.item(0)
            .children.item(0)
            .children.item(1)
            .innerHTML;
        var projectId = document.getElementById("projectId").innerHTML;
        setGuidelinesFinishedBtn.setAttribute("href", "/demoStepNumber27/"+guidelineId+"?backToPage=projects/details/"+projectId);
    }

    function setStepNumber28Ready() {
        createTooltipDemoInfo(
            "GRATULACJE! TRYB DEMO PROJEKTANTA ZOSTAŁ ZAKOŃCZONY - " +
            "WYKONANA ZOSTAŁA KONCEPCYJA ORAZ WYTYCZNE POSADOWIENIA APARATU DOT. " +
            "PROJEKTU DEMONSTRACYJNEGO. WYLOGUJ SIĘ TERAZ...",
            "CONGRATULATION! DEMO MODE FOR DESIGNER HAS BEEN FINISHED - " +
            "CONCEPTUAL DESIGN AND FINAL PLANNING FOR DEVICE " +
            "INSTALLATION HAS BEEN FINISHED FOR DEMO PROJECT. YOU CAN LOG OUT NOW ..."
        );
        setButtonReady(logoutBtn);
        logoutBtn.setAttribute("href", "/demoStepNumber28");
    }
    function setStepNumber29Ready() {
        createTooltipDemoInfo(
            "MOŻESZ WYŁĄCZYĆ TRYB DEMO",
            "YOU CAN TURN OFF THE DEMO MODE"
        );
        setButtonReady(demoModeOffBtn);
        demoModeOffBtn.setAttribute("href", "/demoModeOff");
    }

        /**
     * demo mode functionality
     */

    /* beginning conditions check on the page (which demo mode step is set up)  */
    if (demoCounter.length === 0) {
        /**
         * demo mode button set ready
         */
        //setButtonDemoModeActive();
        //setButtonReady(demoModeBtn);
        demoCounterTitle.classList.add("invisible");
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
        setStepNumber7Ready();
    }
    if (demoCounter === "7") {
        setStepNumber8Ready();
    }
    if (demoCounter === "8") {
        setStepNumber9Ready();
    }
    if (demoCounter === "9") {
        setStepNumber10Ready();
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
        setStepNumber16Ready();
    }
    if (demoCounter === "16") {
        setStepNumber17Ready();
    }
    if (demoCounter === "17") {
        setStepNumber18Ready();
    }
    if (demoCounter === "18") {
        setStepNumber19Ready();
    }
    if (demoCounter === "19") {
        setStepNumber20Ready();
    }
    if (demoCounter === "20") {
        setStepNumber21Ready();
    }
    if (demoCounter === "21") {
        setStepNumber22Ready();
    }
    if (demoCounter === "22") {
        setStepNumber23Ready();
    }
    if (demoCounter === "23") {
        setStepNumber24Ready();
    }
    if (demoCounter === "24") {
        setStepNumber25Ready();
    }
    if (demoCounter === "25") {
        setStepNumber26Ready();
    }
    if (demoCounter === "26") {
        setStepNumber27Ready();
    }
    if (demoCounter === "27") {
        setStepNumber28Ready();
    }
    if (demoCounter === "28") {
        setStepNumber29Ready();
    }

});