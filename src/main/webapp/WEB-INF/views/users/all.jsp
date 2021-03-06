<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 04.01.2020
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container-fluid">

    <div class="card" style="min-width: 600px">

        <div class="card-header text-center">
            <p class="langPL">UŻYTKOWNICY</p>
            <p class="langEN">ALL USERS LIST</p>
        </div>

        <div class="card-body text-center">
            <c:forEach items="${usersAll}" var="user">
                <div class="card bg-light mb-3 w-500px d-inline-block">
                    <div class="card-header w-500px">
                        <div class="row h-50px">
                            <div class="col-3 border-right pt-3" style="font-size: 20px">
                                    ${user.id}
                            </div>
                            <div class="col-9 text-left font-weight-bold pt-3" style="font-size: 20px">
                                    ${user.nameFirst} ${user.nameLast}
                            </div>
                        </div>
                        <div class="row border-top border-50 mt-3 pt-2">
                            <div class="col-12 text-right">
                                    ${user.businessPosition.toString()}
                            </div>
                        </div>
                        <div class="row border-top border-50 mt-3 pt-2">
                            <div class="col-12 text-right">
                                    ${user.email.toString()}
                            </div>
                        </div>
                    </div>
                    <div class="card-body w-500px mb-3" style="min-height: 100px; max-height: 100px">
                        <c:choose>
                            <c:when test="${user.avatar eq null}">
                                <img src="/resources/img/avatars/img_avatar_someone.png" width="75px" height="75px"/>
                            </c:when>
                            <c:otherwise>
                                <img src="/users/avatar/${user.id}" width="75px" height="75px" alt="AVATAR"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="card-footer text-right w-500px">
                        <a href="/users/details/${user.id}" class="btn btn-primary">
                            <p class="langPL">SZCZEGÓŁY / EDYCJA</p>
                            <p class="langEN">DETAILS/EDIT</p>
                        </a>
                        <a href="#" class="btn btn-danger disabled">
                            <p class="langPL">USUŃ</p>
                            <p class="langEN">DEL</p>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="card-footer text-right">
            <a href="/home" class="btn btn-warning float-left">
                <span><<</span>
                <p class="langPL">WSTECZ</p>
                <p class="langEN">BACK</p>
            </a>
            <a href="/users/new" class="btn btn-success float-right">
                <span>+</span>
                <p class="langPL">NOWY</p>
                <p class="langEN">NEW</p>
            </a>
        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
