<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.01.2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>SMNSH</title>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" type="text/css" href="/resources/css/smnshStyles.css"/>--%>
<%--    <script type="text/javascript" src="<c:url value="/resources/js/demoMode.js"/>"></script>--%>
</head>
<body>
    <div class="container-fluid pl-5 pr-5">
<%--        <a href="/initDB">INIT.DB</a>--%>
<%--        <a href="/">HOME</a>--%>
<%--        <a href="/concepts/all">CONCEPTS ALL</a>--%>
        <ul class="nav nav-pills mb-2">
            <li class="nav-item">
                <a id="demoModeBtn" class="nav-link btn btn-light ml-1 mr-1 disabled" href="#">
                    <p class="langPL">TRYB DEMO</p>
                    <p class="langEN">DEMO MODE</p>
                </a>
            </li>
            
            <li class="nav-item dropdown border-left">
                <a id="initDbBtn" class="bg-warning nav-link dropdown-toggle btn-light ml-1" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
					<p class="langPL">INICJALIZACJA BAZY DANYCH</p>
					<p class="langEN">INIT DATA BASE</p>
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/initEssentialDB">
						<p class="langPL">DANE PODSTAWOWE</p>
						<p class="langEN">BASIC DATA</p>
                    </a>
                   <a class="dropdown-item" href="/initDemoDB">
						<p class="langPL">DANE TESTOWE</p>
						<p class="langEN">TEST DATA</p>
                    </a>
                </div>           
            </li>
            
            <li class="nav-item dropdown border-left">
                <a class="bg-warning nav-link dropdown-toggle btn-light ml-1" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
					<p class="langPL">IMPORT</p>
					<p class="langEN">IMPORT</p>
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/sapcustomers/import">
						<p class="langPL">IMPORTUJ KLIENTÓW</p>
						<p class="langEN">IMPORT CUUSTOMERS</p>
                    </a>
                   <a class="dropdown-item" href="#">
						<p class="langPL">IMPORTUJ KLIENTÓW (Z SZYFROWANIEM)</p>
						<p class="langEN">IMPORT CUUSTOMERS (WITH ENCRYPTION)</p>
                    </a>
                   <a class="dropdown-item" href="/importSlsProjects">
						<p class="langPL">IMPORTUJ PROJEKTY SLS</p>
						<p class="langEN">IMPORT SLS PROJECTS</p>
                    </a>
                   <a class="dropdown-item" href="/import/project-by-sls-code/ZZX0000">
						<p class="langPL">IMPORTUJ PROJEKT TESTOWY ZZX0000</p>
						<p class="langEN">IMPORT TEST PROJECT ZZX0000</p>
                    </a>
                   <a class="dropdown-item" href="/import/project-by-sls-directory">
						<p class="langPL">IMPORTUJ PROJEKT WG KATALOGU</p>
						<p class="langEN">IMPORT PROJECT BY FOLDER</p>
                    </a>
                   <a class="dropdown-item" href="/import/set-default-sls-projects-path">
						<p class="langPL">USTAW DOMYŚLNĄ ŚCIEŻKĘ KATALOGU PROJEKTÓW SLS</p>
						<p class="langEN">SET THE DEFAULT PATH TO SLS PROJECTS FOLDER</p>
                    </a>
                </div>           
            </li>

            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1" href="/home">
                    <svg class="bi bi-house-fill d-inline-block align-top" width="30px" height="30px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                        <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                    </svg>
                    <div class="d-inline-block align-top ml-2">
                        <p class="langPL">STRONA STARTOWA</p>
                        <p class="langEN">HOME</p>
                    </div>
                </a>
            </li>
            

            <li class="nav-item border-left">
                <a id="projectsBtn" class="nav-link btn-light ml-1 mr-1" href="/smnsh4/companies/all?category=investor">
                    <p class="langPL">KLIENCI</p>
                    <p class="langEN">CUSTOMERS</p>
                </a>
            </li>
            <li class="nav-item border-right">
                <a id="projectsBtn" class="nav-link btn-light ml-1 mr-1" href="/smnsh4/companies/all?category=subcontractor">
                    <p class="langPL">PODWYKONAWCY</p>
                    <p class="langEN">SUBCONTRACTORS</p>
                </a>
            </li>
            
            <%-- 
            <li class="nav-item dropdown border-left">
                <a class="nav-link dropdown-toggle btn-light ml-1" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <svg class="bi bi-arrow-down-square-fill" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 5a.5.5 0 0 0-1 0v4.793L5.354 7.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 9.793V5z"/>
                    </svg>
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/projects/all">
                        <p class="langPL">WSZYSTKIE</p>
                        <p class="langEN">ALL</p>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/projects/all?status=acquisition">
                        <p class="langPL">AKWIZYCJA</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=preliminaryPlanning">
                        <p class="langPL">UMOWA</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=preliminaryPlanning">
                        <p class="langPL">PROJEKT KONCEPCYJNY</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=finalPlanning">
                        <p class="langPL">PROJEKT WYTYCZNY</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=roomPreparation">
                        <p class="langPL">ADAPTACJA POMIESZCZEŃ</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=delivery">
                        <p class="langPL">DOSTAWA URZĄDZEŃ</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=installation">
                        <p class="langPL">INSTALACJA URZĄDZEŃ</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=startUp">
                        <p class="langPL">URUCHOMIENIE</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=trainings">
                        <p class="langPL">SZKOLENIA</p>
                        <p class="langEN"></p>
                    </a>
                    <a class="dropdown-item" href="/projects/all?status=finished">
                        <p class="langPL">ZAKOŃCZONE</p>
                        <p class="langEN"></p>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/projects/all?status=cancelled">
                        <p class="langPL">ANULOWANE</p>
                        <p class="langEN"></p>
                    </a>
                </div>
            </li>
            --%>
            
            <li class="nav-item">
                <a id="projectsBtn" class="nav-link btn-light ml-1 mr-1" href="/projects/all?view=list">
                    <p class="langPL">PROJEKTY W FIRMIE</p>
                    <p class="langEN">PROJECTS IN THE COMPANY</p>
                </a>
            </li>
            <li class="nav-itemy">
                <c:set var="user" value="?userId=${sessionScope.userLoggedIn.id}"/>
                <a id="projectsBtn" class="nav-link btn-light ml-1 mr-1 border border-primary" href="/projects/all${user}&view=list">
                    <p class="langPL">MOJE PROJEKTY</p>
                    <p class="langEN">MY PROJECTS</p>
                </a>
            </li>
            <li class="nav-item border-left">
                <a class="nav-link btn-light ml-1 mr-1" href="/users/all">
                    <p class="langPL">UŻYTKOWNICY</p>
                    <p class="langEN">ALL USERS</p>
                </a>
            </li>
            <c:if test="${sessionScope.userLoggedIn.businessPosition eq 'ADMIN'}">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle btn-light ml-1 mr-1" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <p class="langPL">ADMIN</p>
                    <p class="langEN">ADMIN</p>
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/admin/controlpanel">
                        <p class="langPL">PANEL STEROWANIA</p>
                        <p class="langEN">CONTROL PANEL</p>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/admin/logs/all">
                        <p class="langPL">LOGI</p>
                        <p class="langEN">LOGS</p>
                    </a>
                </div>
            </li>
            </c:if>
        </ul>
        <c:if test="${sessionScope.userLoggedIn.businessPosition eq 'PLANNER'}">
            <ul class="nav nav-pills border-top m-1">
                <li class="nav-item">
                    <a class="nav-link btn-light ml-1 mr-1" href="/concepts/all?filter=waiting">
                        <p class="langPL">ZAMÓWIENIA KONCEPCJI</p>
                        <p class="langEN">CONCEPT ORDERS</p>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn-light ml-1 mr-1 disabled" href="#">
                        <p class="langPL">ZAMÓWIENIA WYTYCZNYCH</p>
                        <p class="langEN">GUIDELINE ORDERS</p>
                    </a>
                </li>
            </c:if>
            <%--<li class="nav-item">
                <div class="myTooltip">
                    <a class="nav-link btn-light ml-1 mr-1" href="#">
                        <p class="langPL">TEST</p>
                        <p class="langEN">TEST</p>
                    </a>
                    <div>
                        myTtooltip text ...<br>
                        lorem ipsum
                    </div>
                </div>
            </li>--%>
<%--        </ul>--%>
    </div>
</body>
</html>