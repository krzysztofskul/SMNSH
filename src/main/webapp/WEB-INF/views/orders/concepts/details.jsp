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
        <div class="card">
            <div class="card-header">
                ${concept.id} | ${concept.title}
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        AUTHOR:
                    </div>
                    <div class="col">
                        ${concept.author.nameFirst} ${concept.author.nameLast}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        CUSTOMER:
                    </div>
                    <div class="col">
                        ${concept.client}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        DEADLINE:
                    </div>
                    <div class="col">
                        ${concept.dateTimeDeadline.toLocalDate()} ${concept.dateTimeDeadline.toLocalTime()}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        PRIORITY:
                    </div>
                    <div class="col">
                        ${concept.priority}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        PLANNER:
                    </div>
                    <div class="col">
                        ${concept.planner.nameFirst} ${concept.planner.nameLast}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        STATUS:
                    </div>
                    <div class="col">
                        ${concept.status.toString()}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        DEVICE:
                    </div>
                    <div class="col">
                        ${concept.device.model}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        DESCRIPTION:
                    </div>
                    <div class="col">
                        ${concept.description}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        LAYOUT:
                    </div>
                    <div class="col">
                        ${concept.layout}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        ON SITE VISITED:
                    </div>
                    <div class="col">
                        ${concept.onSiteVisited}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        WALL INTERFERENCE POSSIBILITY:
                    </div>
                    <div class="col">
                        ${concept.wallInterferencePossible}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        CUSTOMER SUGGESTIONS:
                    </div>
                    <div class="col">
                        <c:if test="${concept.customerSuggestions eq null}">
                            NO SUGESTIONS FROM CUSTOMER
                        </c:if>
                        <c:if test="${concept.customerSuggestions ne null}">
                            ${concept.customerSuggestions}
                        </c:if>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        TRANSPORT ROUTE TO DESIGN:
                    </div>
                    <div class="col">
                        ${concept.transportRouteDesignNeeded}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        ELECTRICAL BOX PLACE SPECIFIED:
                    </div>
                    <div class="col">
                        ${concept.electricBoxSpecified}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        ADDITIONAL ROOMS TO DESIGN:
                    </div>
                    <div class="col">
                        <c:if test="${concept.additionalRoomsToDesign eq null}">
                            NO ADDITIONAL ROOM NEEDED
                        </c:if>
                        <c:if test="${concept.additionalRoomsToDesign ne null}">
                            ${concept.additionalRoomsToDesign}
                        </c:if>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        PROJECT MANAGER OTHER REMARKS:
                    </div>
                    <div class="col">
                        ${concept.remarks}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        GUDELINE:
                    </div>
                    <div class="col">
                        ${concept.guideline.id}
                    </div>
                </div>

            </div>
            <div class="card-footer text-right">
                <a href="/concepts/edit/${concept.id}" class="btn btn-primary">EDIT</a>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
