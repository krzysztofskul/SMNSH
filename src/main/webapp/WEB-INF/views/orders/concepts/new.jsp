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
                <div class="card-header text-center">
                    <h4>NEW CONCEPT ORDER FORM</h4>
                    <form:hidden path="id" disabled="true"/>
                </div>
                <!-- *** AUTHOR/CUSTOMER/ SECTION *** -->
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            AUTHOR:
                        </div>
                        <div class="col">
                            <c:choose>
                                <c:when test="${conceptNew.author.id eq null}">
                                    <form:select cssClass="w-100" path="author.id">
                                        <c:forEach items="${usersAll}" var="user">
                                            <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                        </c:forEach>
                                    </form:select>
                                </c:when>
                                <c:otherwise>
<%--                                    <form:select path="author.id">--%>
<%--                                        <c:forEach items="${usersAll}" var="user">--%>
<%--                                            <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}" disabled="true"/>--%>
<%--                                        </c:forEach>--%>
<%--                                    </form:select>--%>
                                    <form:hidden path="author.id"/>
                                    <input type="text" readonly value="${conceptNew.author.nameFirst} ${conceptNew.author.nameLast}"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            DEVICE:
                        </div>
                        <div class="col">
                            <form:select cssClass="w-100" path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            RECIPIENT/CUSTOMER:
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="client" disabled="true"/>
                        </div>
                    </div>
                    <hr>
                    <!-- *** DATES/PRIORITY SECTION *** -->
                    <div class="row">
                        <div class="col-6">
                            PRIORITY:
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="priority"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            DEADLINE:
                        </div>
                        <div class="col">
                            <input class="w-100" type="date" disabled/>
                        </div>
                    </div>
                    <hr>
                    <!-- *** TITLE/DESCRIPTION SECTION *** -->
                    <div class="row mt-2">
                        <div class="col-6">
                            TITLE:
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="title"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            DESCRIPTION:
                        </div>
                        <div class="col">
                            <form:textarea cssClass="w-100" path="description"/>
                        </div>
                    </div>
                    <!-- *** QUESTIONS SECTION *** -->
                    <hr>
                    <div class="row mt-2">
                        <div class="col-6">
                            LAYOUT DWG IN ATTACHEMENT:
                        </div>
                        <div class="col">
                            <form:checkbox path="layout"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            ON-SITE VISITED / LAYOUT VERIFIED:
                        </div>
                        <div class="col">
                            <form:checkbox path="onSiteVisited"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            POSSIBILITY TO DEMOLISH/MOVE/BUILD WALLS:
                        </div>
                        <div class="col">
                            <form:checkbox path="wallInterferencePossible"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            CUSTOMER SUGGESTIONS:
                        </div>
                        <div class="col">
                            <form:textarea cssClass="w-100" path="customerSuggestions"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            TRANSPORT ROUT TO DESIGN:
                        </div>
                        <div class="col">
                            <form:checkbox path="transportRouteDesignNeeded"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            POWER BOX PLACE SPECIFIED:
                        </div>
                        <div class="col">
                            <form:checkbox path="electricBoxSpecified"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            ADDITIONAL ROOMS TO DESIGN:
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="additionalRoomsToDesign"/>
                        </div>
                    </div>
                </div>
                <!-- *** FOOTER SECTION *** -->
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
