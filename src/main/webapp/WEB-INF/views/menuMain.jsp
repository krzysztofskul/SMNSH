<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.01.2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMNSH</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/smnshStyles.css"/>
    <script type="text/javascript" src="<c:url value="/resources/js/demoMode.js"/>"></script>
</head>
<body>
    <div class="container">
<%--        <a href="/initDB">INIT.DB</a>--%>
<%--        <a href="/">HOME</a>--%>
<%--        <a href="/concepts/all">CONCEPTS ALL</a>--%>
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a id="demoModeBtn" class="nav-link btn btn-light ml-1 mr-1" href="#">
                    <p class="langPL">TRYB DEMO</p>
                    <p class="langEN">DEMO MODE</p>
                </a>
            </li>
            <li class="nav-item">
                <div class="myTooltip">
                    <a id="initDbBtn" class="nav-link btn btn-warning ml-1 mr-1" href="/initDB">
                            <p class="langPL">INICJALIZACJA BAZY DANYCH</p>
                            <p class="langEN">INIT.DB</p>
                    </a>
                    <%--<div>
                        <p class="langPL">WSTĘPNA INICJALIZACJA TESTOWEJ BAZY DANYCH</p>
                        <p class="langEN">TEST DATA BASE INITIALISATION</p>
                    </div>--%>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1" href="/home">
                    <p class="langPL">STRONA STARTOWA</p>
                    <p class="langEN">HOME</p>
                </a>
            </li>
            <li class="nav-item">
                <a id="projectsBtn" class="nav-link btn-light ml-1 mr-1" href="/projects/all">
                    <p class="langPL">PROJEKTY</p>
                    <p class="langEN">PROJECTS</p>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1" href="/users/all">
                    <p class="langPL">UŻYTKOWNICY</p>
                    <p class="langEN">ALL USERS</p>
                </a>
            </li>
        </ul>
        <ul class="nav nav-pills border-top m-1">
            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1" href="/concepts/all?filter=all">
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
        </ul>
    </div>
</body>
</html>