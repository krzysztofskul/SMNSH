<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 14.01.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <form:form modelAttribute="concept" method="post">
        <form:hidden path="id"/>
        <form:hidden path="dateTimeDeadline"/>
        <form:hidden path="status"/>
        <form:hidden path="priority"/>
        <form:hidden path="author.id"/>
        <form:hidden path="client"/>
        <form:hidden path="device.id"/>
        <form:hidden path="dateTimeCreated"/>
<%--        <form:hidden path="guideline.id"/>--%>
        <form:hidden path="electricBoxSpecified"/>
        <form:hidden path="additionalRoomsToDesign"/>
        <form:hidden path="transportRouteDesignNeeded"/>
        <form:hidden path="customerSuggestions"/>
        <form:hidden path="title"/>
        <form:hidden path="remarks"/>
        <form:hidden path="description"/>
        <form:hidden path="layout"/>
        <form:hidden path="onSiteVisited"/>
        <form:hidden path="wallInterferencePossible"/>
    <div class="container">
        <div class="card">
            <div class="card-header text-center">
                <p class="langPL">PRZYPISZ PROJEKTANTA / PLANISTĘ DO PROJEKTU KONCEPCJI</p>
                <p class="langEN">ASSIGN DESIGNER / PLANNER TO THE CONCEPTUAL PROJECT</p>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">WYBIERZ PROJEKTANTA / PLANISTĘ</p>
                        <p class="langEN">CHOOSE DESIGNER / PLANNER</p>
                    </div>
                    <div class="col-6">
                        <form:select path="planner.id" cssClass="w-75">
                            <c:forEach items="${usersDesigners}" var="designer">
                                <form:option value="${designer.id}" label="${designer.nameFirst} ${designer.nameLast}"/>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <a href="/concepts/all" class="btn btn-warning float-left">
                    <span><<</span>
                    <p class="langPL">ANULUJ / WSTECZ</p>
                    <p class="langEN">CANCEL / BACK</p>
                </a>
                <form:button class="btn btn-success float-right">
                    <span>.</span>
                    <p class="langPL">ZAPISZ</p>
                    <p class="langEN">SAVE</p>
                </form:button>
            </div>
        </div>
    </div>
    </form:form>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
