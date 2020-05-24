<%@ page import="pl.krzysztofskul.user.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.01.2020
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>SMNSH</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/smnshStyles.css"/>
    <script type="text/javascript" src="<c:url value="/resources/js/demoMode.js"/>"></script>
</head>
<body>
    <div class="container-fluid border-bottom pt-4 pb-1 mb-5 bg-light">
        <div id="tooltipDemoInfo"></div>
        <div class="text-left" id="headerTitle">
            <h4 class="pl-5 font-weight-bold" style="letter-spacing: 15px; color: dimgrey">SMNSH APP.</h4>
            <div>
                <div id="demoCounterTitle" class="d-inline-block">
                    <p class="langPL">Tryb demo aktywny - wykonano kroków:</p>
                    <p class="langEN">Demo mode activated - steps done:</p>
                </div>
                <span>
                    <p id="demoCounter" class="d-inline-block ml-5" style="font-size: 40px">${sessionScope.demoSession.toString()}</p>
                </span>
            </div>
            <div>
                <a id="demoModeReset" class="d-inline-block btn btn-outline-dark invisible disabled" href="/demoModeReset">DEMO MODE RESET</a>
                <a id="demoModeOFF" class="d-inline-block btn btn-outline-dark invisible" href="/demoModeOff">DEMO MODE OFF</a>
            </div>
        </div>
        <div class="text-right">
            <%
                if (session.getAttribute("userLoggedIn") != null) {
                    User user = (User) session.getAttribute("userLoggedIn");
                    out.print(
                            "<span>ID: </span>"+"<span id='userLoggedIn'>"+user.getId()+"</span>"+"<span> | </span>"+
                            user.getNameFirst()+" "+
                            user.getNameLast()+" "+
                            "<a href='/users/details/"+user.getId()+"' class='btn btn-primary ml-2 mr-2'>" +
                                "<div class='langPL text-white'>MÓJ PROFIL</div>" +
                                "<div class='langEN text-dark'>MY PROFILE</div>" +
                            "</a>"+
                            "<a id ='logoutBtn' href='/logout' class='btn btn-danger'>" +
                                "<div class='langPL text-white'>WYLOGUJ</div>" +
                                "<div class='langEN text-dark'>LOG OUT</div>" +
                            "</a>"
                    );
                } else {
                    out.print("<div>"+
                            "<a href='/register' class='btn btn-dark ml-1'>" +
                            "ZAREJESTRUJ" +
                            "<p class='langEN'>REGISTER</p>"+
                            "</a>"+
                            "<a id='logInBtn' href='/login' class='btn btn-dark ml-1'>" +
                            "ZALOGUJ" +
                            "<p class='langEN'>LOG IN</p>"+
                            "</a>"+
                            "</div>"+
                            "<div class='mt-2'>"+
//                            "<a href='/login?guest=admin' class='btn btn-light'>"+
//                            "LUB ZALOGUJ JAKO GOŚĆ/ADMIN"+
//                            "<p class='langEN'>OR LOGIN AS A GUEST/ADMIN</p>"+
//                            "</a>"+
                            "<a id='loginAsDesignerBtn' href='/login?guest=designer' class='btn btn-light'>"+
                            "LUB ZALOGUJ JAKO GOŚĆ/PROJEKTANT"+
                            "<p class='langEN'>OR LOGIN AS A GUEST/DESIGNER</p>"+
                            "</a>"+
                            "<a id='loginAsPmBtn' href='/login?guest=projectManager' class='btn btn-light'>"+
                            "LUB ZALOGUJ JAKO GOŚĆ/KIEROWNIK PROJEKTU"+
                            "<p class='langEN'>OR LOGIN AS A GUEST/PROJECT MANAGER</p>"+
                            "</a>"+
                            "</div>"
                    );

                }
            %>
        </div>
        <div class="mt-3 pt-1 border-top">
            <jsp:include page="menuMain.jsp"/>
        </div>
    </div>
</body>
</html>
