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
                        <thead class="text-center bg-light">
                            <tr>
                                <td colspan="7"><h4>ORDERS CREATED BY USER</h4></td>
                            </tr>
                            <tr class="font-weight-bold">
                                <td>DATE OF CREATION</td>
                                <td>DEVICE</td>
                                <td>TITLE</td>
                                <td>PRIORITY</td>
                                <td>DEADLINE</td>
                                <td>STATUS</td>
                                <td class="text-info">ACTIONS</td>
                            </tr>
                        </thead>
                        <c:forEach items="${user.conceptList}" var="concept">
                            <tbody>
                                <tr class="bg-light">    <!-- conceptList -->
                                    <td>${concept.dateTimeCreated.toString()}</td>
                                    <td>${concept.device.model}</td>
                                    <td>${concept.title}</td>
                                    <td>${concept.priority}</td>
                                    <td>${concept.dateTimeDeadline}</td>
                                    <td>${concept.status.toString()}</td>
                                    <td>
                                        <a href="#" class="btn btn-danger disabled float-right ml-1 mr-1">DEL</a>
                                        <a href="#" class="btn btn-primary disabled float-right ml-1 mr-1">DETAILS/EDIT</a>
                                        <br>
                                        <c:if test="${concept.guideline eq null}">
                                        <a href="/guidelines/new?conceptId=${concept.id}"
                                           class="btn btn-success mt-1 mb-1 float-right"
                                           style="display: block; max-width: 200px; font-size: small">
                                            NEW GUIDELINE FOR THIS CONCEPT
                                        </a>
                                        </c:if>
                                        <c:if test="${concept.guideline ne null}">
                                            <a href="/guidelines/new?conceptId=${concept.id}"
                                               class="btn btn-success mt-1 mb-1 float-right disabled"
                                               style="display: block; max-width: 200px; font-size: small">
                                                NEW GUIDELINE FOR THIS CONCEPT
                                            </a>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr class="font-italic">    <!-- guidelineList -->
                                    <c:choose>
                                        <c:when test="${concept.guideline eq null}">
                                            <td colspan="7">NOT SENT ANY ORDER OF GUIDELINE FOR THIS CONCEPT ORDER</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td colspan="4"></td>
                                            <td>${concept.guideline.title}</td>
                                            <td></td>
                                            <td class="float-right">
                                                <a href="#" class="btn btn-primary disabled">DETAILS/EDIT</a>
                                                <a href="#" class="btn btn-danger disabled">DEL</a>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
                <div class="card-footer">
                    <a href="/concepts/new?userId=${user.id}" class="btn btn-success float-right">NEW CONCEPT ORDER</a>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
