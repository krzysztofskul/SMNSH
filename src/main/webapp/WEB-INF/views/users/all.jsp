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

<div class="container">

    <div class="card">

        <div class="card-header text-center">
            <h3>ALL USERS LIST</h3>
        </div>

        <div class="card-body">
            <c:forEach items="${usersAll}" var="user">
                <div class="card bg-light mb-3" style="max-width: 18rem; display: inline-block">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-1 border-right">
                                    ${user.id}
                            </div>
                            <div class="col font-weight-bold">
                                    ${user.nameFirst} ${user.nameLast}
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                    ${user.businessPosition.toString()}
                            </div>
                        </div>
                    </div>
                        <div class="card-body" style="min-height: 100px; max-height: 100px">
                        </div>
                    <div class="card-footer text-right">
                        <a href="#" class="btn btn-primary disabled">DETAILS/EDIT</a>
                        <a href="#" class="btn btn-danger disabled">DEL</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="card-footer text-right">
            <a href="/home" class="btn btn-warning float-left">BACK TO HOME</a>
            <a href="#" class="btn btn-success float-right disabled">NEW</a>
        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
