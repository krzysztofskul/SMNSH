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
                    <%--${concept.id}--%> <form:input path="id" disabled="true" cssStyle="max-width: 50px"/> | <%--${concept.title}--%> <form:input path="title"/>
                    <form:hidden path="dateTimeCreated"/>
                </div>
                <div class="card-body">
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
                            CUSTOMER:
                        </div>
                        <div class="col">
                            <form:input path="client"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            DEADLINE:
                        </div>
                        <div class="col">
                            <input type="date" name="inputDateDeadline" value="${concept.dateTimeDeadline.toLocalDate()}">
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            PRIORITY:
                        </div>
                        <div class="col">
                            <form:input path="priority"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            PLANNER:
                        </div>
                        <div class="col">
                            <form:select path="planner.id">
                                <c:forEach items="${usersAll}" var="user">
                                    <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            STATUS:
                        </div>
                        <div class="col">
                            <form:select path="status">
                                <c:forEach items="${orderStatuses}" var="orderStatus">
                                    <form:option value="${orderStatus}" label="${orderStatus.toString()}"/>
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
                    <hr>
                    <div class="row">
                        <div class="col">
                            DESCRIPTION:
                        </div>
                        <div class="col">
                                <%--${concept.description}--%> <form:textarea path="description"/>
                        </div>
                    </div>
                    <hr>
                    <hr>
                    <div class="row">
                        <div class="col">
                            LAYOUT:
                        </div>
                        <div class="col">
                            <form:checkbox path="layout"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            ON SITE VISITED:
                        </div>
                        <div class="col">
                            <form:checkbox path="onSiteVisited"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            WALL INTERFERENCE POSSIBILITY:
                        </div>
                        <div class="col">
                            <form:checkbox path="wallInterferencePossible"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            CUSTOMER SUGGESTIONS:
                        </div>
                        <div class="col">
                            <form:textarea path="customerSuggestions"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            TRANSPORT ROUTE TO DESIGN:
                        </div>
                        <div class="col">
                            <form:checkbox path="transportRouteDesignNeeded"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            ELECTRICAL BOX PLACE SPECIFIED:
                        </div>
                        <div class="col">
                            <form:checkbox path="electricBoxSpecified"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            ADDITIONAL ROOMS TO DESIGN:
                        </div>
                        <div class="col">
                            <form:input path="additionalRoomsToDesign"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            PROJECT MANAGER OTHER REMARKS:
                        </div>
                        <div class="col">
                            <form:textarea path="remarks"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            GUIDELINE:
                        </div>
                        <div class="col float-right">
                            <a href="#" class="btn btn-primary disabled">DETAILS</a>
                            <a href="#" class="btn btn-danger disabled">DEl</a>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/concepts/details/${concept.id}" class="btn btn-warning float-left">CANCEL/BACK</a>
                    <input type="submit" class="btn btn-success float-right" value="SAVE/UPDATE"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
