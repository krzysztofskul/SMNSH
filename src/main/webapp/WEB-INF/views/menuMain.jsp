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
</head>
<body>
    <div class="container">
<%--        <a href="/initDB">INIT.DB</a>--%>
<%--        <a href="/">HOME</a>--%>
<%--        <a href="/concepts/all">CONCEPTS ALL</a>--%>
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link btn-warning ml-1 mr-1 font-weight-bold" href="/initDB">INIT.DB</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1 font-weight-bold" href="/home">HOME</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1" href="/concepts/all">CONCEPTS ALL</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn-light ml-1 mr-1 disabled" href="#" tabindex="-1" aria-disabled="true">USERS ALL</a>
            </li>
        </ul>
    </div>
</body>
</html>