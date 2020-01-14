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
    <%--<jsp:include page="menuConcepts.jsp"/>--%>

    <div class="container">

        <!-- *** NEW FRONT END *** -->
        <div class="row text-center mb-2">
            <div class="col-12">
                <h1 class="langPL">LISTA ZAMÓWIONYCH KONCEPCJI</h1>
                <h1 class="langEN">LIST OF ORDERS FOR CONCEPTUAL DESIGN</h1>
            </div>
        </div>
        <jsp:include page="menuConcepts.jsp"/>
        <c:forEach items="${conceptsAll}" var="concept">
            <div class="row border-top border-bottom bg-light font-weight-bold mb-2">
                <div class="col-2">${concept.id}</div>
                <div class="col-3">${concept.author.nameFirst} ${concept.author.nameLast}</div>
                <div class="col-3">${concept.device.model}</div>
                <div class="col-3">${concept.client}</div>
            </div>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-10">
                    <span class="font-weight-bold">UTWORZONO / DATE OF CREATION:</span>
                        ${concept.dateTimeCreated.toLocalDate()} ${concept.dateTimeCreated.toLocalTime()}
                </div>
            </div>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-10">
                    <span class="font-weight-bold">PRIORITY / PRIORYTET:</span>
                        ${concept.priority}
                </div>
            </div>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-10">
                    <span class="font-weight-bold">PROJEKTANT/PLANISTA / DESIGNER/PLANNER:</span>
                        ${concept.planner.nameFirst} ${concept.planner.nameLast}
                </div>
            </div>
            <div class="row text-right">
                <div class="col-2"></div>
                <div class="col-10">
                    <span class="font-weight-bold">TERMIN REALIZACJI / DEADLINE:</span>
                        ${concept.dateTimeDeadline.toLocalDate()} ${concept.dateTimeDeadline.toLocalDate()}
                </div>
            </div>
            <div class="row text-right">
                <div class="col-2"></div>
                <div class="col-10">
                    <span class="font-weight-bold">STATUS / STATUS:</span>
                        ${concept.status.toString()}
                </div>
            </div>
            <div class="row text-right border-bottom">
                <div class="col-12">
                    <a href="#" class="d-block">SZCZEGÓŁY / DETAILS</a>
                    <a href="/concepts/${concept.id}/setDesigner" class="d-block">PRZYPISZ PROJEKTANTA/PLANISTĘ / ASSIGN DESIGNER/PLANNER</a>
                    <a href="#" class="d-block">ZMIEŃ STATUS / CHANGE STATUS</a>
                    <a href="#" class="d-block">USUŃ / DEL</a>
                </div>
            </div>
        </c:forEach>

        <!-- *** OLD FRONT END *** -->
        <!--
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">DATE OF CREATION</th>
                    <th scope="col">AUTHOR / DEVICE</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">PRIORITY</th>
                    <th scope="col">DEADLINE</th>
                    <th scope="col">STATUS</th>
                    <th scope="col">OPTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${conceptsAll}" var="concept">
                    <tr>
                        <th scope="row">${concept.id}</th>
                        <th scope="row">
                                ${concept.dateTimeCreated.year} -
                                        ${concept.dateTimeCreated.month.name().substring(0,3)} -
                                    <c:choose>
                                        <c:when test="${concept.dateTimeCreated.dayOfMonth < 10}">
                                            0${concept.dateTimeCreated.dayOfMonth}
                                        </c:when>
                                        <c:otherwise>
                                            ${concept.dateTimeCreated.dayOfMonth}
                                        </c:otherwise>
                                    </c:choose>
                                    <br>
                                    <c:choose>
                                        <c:when test="${concept.dateTimeCreated.hour < 10}">
                                            0${concept.dateTimeCreated.hour} :
                                        </c:when>
                                        <c:otherwise>
                                            ${concept.dateTimeCreated.hour} :
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${concept.dateTimeCreated.minute < 10}">
                                            0${concept.dateTimeCreated.minute}
                                        </c:when>
                                        <c:otherwise>
                                            ${concept.dateTimeCreated.minute}
                                        </c:otherwise>
                                    </c:choose>
                        </th>
                        <td>
                            ${concept.author.nameFirst} ${concept.author.nameLast}
                            <hr>
                            ${concept.device.model}
                        </td>
                        <td>${concept.title}</td>
                        <td>${concept.priority}</td>
                        <td>${concept.dateTimeDeadline}</td>
                        <td>${concept.status.toString()}</td>
                        <td>
                            <a href="/concepts/details/${concept.id}" class="btn btn-primary">DETAILS</a>
                            <a href="/concepts/delete/${concept.id}" class="btn btn-danger">DEL</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr class="text-right">
                    <td colspan="8">
                        <a href="/concepts/new" class="btn btn-success">NEW</a>
                    </td>
                </tr>
            </tfoot>
        </table>
        -->
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
