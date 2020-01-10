<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 10.01.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="user">
            <div class="card">
                <div class="card-header">
                    <form:input path="id" disabled="true" cssStyle="max-width: 50px"/> |
                    <form:input path="nameFirst"/>
                    <form:input path="nameLast"/>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">E-mail:</div>
                        <div class="col"><form:input path="email"/></div>
                    </div>
                    <div class="row">
                        <div class="col">Business position:</div>
<%--                        <div class="col"><form:input path="businessPosition"/></div>--%>
                        <div class="col">
                            <form:select path="businessPosition" items="${businessPositions}"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">Avatar:</div>
                        <div class="col">
                                <%--<form:hidden path="avatar"/>--%>
                            <input type="file" name="file" id="file" disabled>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/users/all" class="btn btn-warning float-left">CANCEL/BACK TO ALL</a>
                    <input class="btn btn-success float-right" type="submit" value="SAVE">
                </div>
                <div class="card-body">
                    <%--<c:forEach items="${user.conceptList}" var="concept">
                        <div class="row">
                            <div class="col">
                                ${concept.dateTimeCreated.toString()}
                            </div>
                            <div class="col">
                                ${concept.device.model}
                            </div>
                            <div class="col">
                                    ${concept.title}
                            </div>
                        </div>
                     </c:forEach>--%>
                    <table class="table table-sm">
                        <thead>
                        <tr>
                            <th scope="col" colspan="5" class="text-center bg-light"><h4>ORDERS CREATED BY USER</h4></th>
                        </tr>
                        <tr>
                            <th scope="col">DATE OF CREATION</th>
                            <th scope="col">DEVICE</th>
                            <th scope="col">TITLE</th>
                            <th scope="col">STATUS</th>
                            <th scope="col" class="text-right text-info">ACTIONS</th>
                        </tr>
                        </thead>
                        <c:forEach items="${user.conceptList}" var="concept">
                            <tbody>
                                <tr>
                                    <th scope="row">${concept.dateTimeCreated.toString()}</th>
                                    <td>${concept.device.model}</td>
                                    <td>${concept.title}</td>
                                    <td>...</td>
                                    <td class="float-right">
                                        <a href="#" class="btn btn-primary disabled">DETAILS/EDIT</a>
                                        <a href="#" class="btn btn-danger disabled">DEL</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
