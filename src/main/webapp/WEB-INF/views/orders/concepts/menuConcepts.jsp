<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 13.01.2020
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

    <div class="container-fluid text-center">
        <ul class="nav nav-pills border-top bg-light p-1 border-bottom mb-2 d-inline-block w-100">
            <li class="nav-item d-inline-block">
                <a class="nav-link btn-light border ml-1 mr-1" href="/concepts/all?filter=all">
                    <p class="langPL">WSZYSTKIE</p>
                    <p class="langEN">ALL</p>
                </a>
            </li>
            <li class="nav-item d-inline-block">
                <a class="nav-link btn-light border ml-1 mr-1" href="/concepts/all?filter=waiting">
                    <p class="langPL">OCZEKUJĄCE DO WYKONANIA</p>
                    <p class="langEN">WAITING TO DO</p>
                </a>
            </li>
            <li class="nav-item d-inline-block">
                <a class="nav-link btn-light border ml-1 mr-1" href="/concepts/all?filter=inProgress">
                    <p class="langPL">W TOKU</p>
                    <p class="langEN">IN PROGRESS</p>
                </a>
            </li>
            <li class="nav-item d-inline-block">
                <a class="nav-link btn-light border ml-1 mr-1" href="/concepts/all?filter=finished">
                    <p class="langPL">ZAKOŃCZONE</p>
                    <p class="langEN">FINISHED</p>
                </a>
            </li>
            <li class="nav-item d-inline-block">
                <a class="nav-link btn-light border ml-1 mr-1" href="#">
                    <p class="langPL">ANULOWANE</p>
                    <p class="langEN">CANCELED</p>
                </a>
            </li>
        </ul>
    </div>

</body>
</html>
