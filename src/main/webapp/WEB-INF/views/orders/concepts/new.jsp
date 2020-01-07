<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 04.01.2020
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form modelAttribute="conceptNew" method="post" action="/concepts/new">
            <div class="card">
                <div class="card-header">
                    <p>NEW CONCEPT ORDER FORM</p>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            ID:
                        </div>
                        <div class="col">
                            <form:input path="id" disabled="true"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            AUTHOR:
                        </div>
                        <div class="col">
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
                            TITLE:
                        </div>
                        <div class="col">
                            <form:input path="title"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            DESCRIPTION:
                        </div>
                        <div class="col">
                            <form:textarea path="description"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            DEVICE:
                        </div>
                        <div class="col">
                            <form:select path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            RECIPIENT/CUSTOMER:
                        </div>
                        <div class="col">
                            <form:input path="client" disabled="true"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            LAYOUT DWG IN ATTACHEMENT:
                        </div>
                        <div class="col">
                            <form:checkbox path="layout"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            ON-SITE VISITED:
                        </div>
                        <div class="col">
                            <form:checkbox path="onSiteVisited"/>
                        </div>
                    </div>
<%--                    <div class="row">--%>
<%--                        <div class="col">--%>
<%--                        </div>--%>
<%--                        <div class="col">--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <div class="card-footer">
                    <a href="/concepts/all" class="btn btn-warning float-left">CANCEL/BACK</a>
                    <input type="submit" class="btn btn-success float-right" value="SAVE"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>


</body>
</html>
