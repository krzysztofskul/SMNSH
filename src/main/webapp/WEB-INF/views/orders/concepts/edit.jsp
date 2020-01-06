<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 05.01.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form modelAttribute="concept" method="post">
            <div class="card">
                <div class="card-header">
                    <%--${concept.id}--%> <form:input path="id" disabled="true"/> | <%--${concept.title}--%> <form:input path="title"/>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            AUTHOR:
                        </div>
                        <div class="col">
                            <%--${concept.author.nameFirst} ${concept.author.nameLast}--%>
                            <%--<form:select path="author.id" items="${usersAll}" itemLabel="id" itemValue="id"/>--%>
                            <form:select path="author.id">
                                <c:forEach items="${usersAll}" var="user">
                                    <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            DEVICE:
                        </div>
                        <div class="col">
                            <%--${concept.device.model}--%> <form:select path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            DESCRIPTION:
                        </div>
                        <div class="col">
                                <%--${concept.description}--%> <form:textarea path="description"/>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/concepts/all" class="btn btn-warning">BACK TO ALL CONCEPTS</a>
                    <input type="submit" class="btn btn-success" value="SAVE/UPDATE"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
