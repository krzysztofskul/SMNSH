<%@ page import="pl.krzysztofskul.user.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.01.2020
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMNSH</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/smnshStyles.css"/>
</head>
<body>
    <div class="container border-bottom pt-4 pb-1 mb-5 bg-light">
        <div class="text-right">
            <%
                if (session.getAttribute("userLoggedIn") != null) {
                    User user = (User) session.getAttribute("userLoggedIn");
                    out.print(
                            user.getNameFirst()+" "
                                    +user.getNameLast()
                                    +" | "
                                    +"<a href='/logout' class='btn btn-danger'>LOG OUT</a>"
                    );
                } else {
                    out.print("<a href='/register' class='btn btn-dark mr-1'>REGISTER</a>");
                    out.print("<a href='/login' class='btn btn-dark ml-1'>LOGIN</a>");
                }
            %>
        </div>
        <div>
            <jsp:include page="menuMain.jsp"/>
        </div>
    </div>
</body>
</html>
