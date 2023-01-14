<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 18.01.2020
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="header.jsp"/>

    <div class="container">
        <form method="post">
        <div class="card">
            <div class="card-header text-center">
                <p class="langPL">LOGOWANIE</p>
                <p class="langEN">LOGIN FORM</p>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-6">
                        <p class="langPL">E-MAIL</p>
                        <p class="langEN">E-MAIL</p>
                    </div>
                    <div class="col-6">
                        <input type="email" name="email" value="jan.testowy@test.test">
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <p class="langPL">HASŁO</p>
                        <p class="langEN">PASSWORD</p>
                    </div>
                    <div class="col-6">
                        <input type="password" name="password" value="test">
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <a href="/home" class="btn btn-warning float-left">
                    <span><<</span>
                    <p class="langPL">ANULUJ / WSTECZ</p>
                    <p class="langEN">CANCEL / BACK</p>
                </a>
                <button type="submit" class="btn btn-success float-right">
                    <p class="langPL">.</p>
                    <p class="langPL">ZALOGUJ</p>
                    <p class="langEN">LOG IN</p>
                </button>
            </div>
        </div>
        </form>
    </div>

    <jsp:include page="footer.jsp"/>

</body>
</html>
