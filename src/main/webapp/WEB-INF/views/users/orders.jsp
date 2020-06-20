<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 13.06.2020
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script src="/resources/js/userOrders.js" type="text/javascript"></script>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form modelAttribute="conceptList" method="post">

            <!-- ORDERS FOR  PRELIMINARY DESIGN -->
            <div class="card">
                <div class="card-body">
                    <div class="row border-top border-bottom text-center bg-light mt-3 mb-3 pt-2 pb-2"
                         style="font-size: larger">
                        <div class="col-12">
                            <p class="langPL">ZAMÓWIENIA KONCPECJI / WYTYCZNYCH UŻYTKOWNIKA</p>
                            <p class="langEN">ORDERS CREATED BY USER</p>
                        </div>
                    </div>
                    <c:forEach items="${conceptList}" var="concept">
                        <div class="card mt-2 mb-3">
                            <div class="card-header text-left border-top border-bottom-0 border-dark">
                                <div class="row border-bottom pb-2">
                                    <div class="btn btn-outline-dark col-2 float-right ordersHideUnhideBtn">
                                        <p class="langPL">ZWIŃ</p>
                                        <p class="langEN">HIDE</p>
                                    </div>
                                    <div class="col-3">
                                        <p class="langPL">ZAMÓWIENIE KONCEPCJI</p>
                                        <p class="langEN">CONCEPT ORDER</p>
                                    </div>
                                    <div class="col-2">
                                        ID: ${concept.id}
                                    </div>
                                    <div class="col-5">
                                        <a href="#"
                                           class="btn btn-danger disabled float-right ml-1 mr-1">
                                            <p class="langPL">USUŃ</p>
                                            <p class="langEN">DEL</p>
                                        </a>
                                        <a href="/concepts/details/${concept.id}"
                                           class="btn btn-primary float-right ml-1 mr-1">
                                            <p class="langPL">SZCZEGÓŁY / EDYCJA</p>
                                            <p class="langEN">DETAILS / EDIT</p>
                                        </a>
                                    </div>
                                </div>
                                <div class="row orderDetailsRow-1">
                                    <div class="col-4 border">
                                        <span class="d-inline-block align-top mr-5">
                                            <p class="langPL">DATA UTWORZENIA</p>
                                            <p class="langEN">CREATED</p>
                                        </span>
                                        <span class="d-inline-block align-top">
                                            ${concept.dateTimeCreated.toLocalDate()}<br>
                                            ${concept.dateTimeCreated.toLocalTime()}
                                        </span>
                                    </div>
                                    <div class="col-4 border">
                                        <span class="d-inline-block align-top mr-5">
                                            <p class="langPL">SPRZĘT</p>
                                            <p class="langEN">DEVICE</p>
                                        </span>
                                        <span class="d-inline-block align-top">
                                                ${concept.device.model}
                                        </span>
                                    </div>
                                    <div class="col-4 border">
                                        <span class="d-inline-block align-top mr-5">
                                            <p class="langPL">KLIENT</p>
                                            <p class="langEN">CUSTOMER</p>
                                        </span>
                                        <span class="d-inline-block align-top">
                                                ${concept.client}
                                        </span>
                                    </div>
                                </div>
                                <div class="row orderDetailsRow-2">
                                    <div class="col-4 border">
                                        <span class="d-inline-block align-top mr-5">
                                            <p class="langPL">PRIORYTET</p>
                                            <p class="langEN">PRIORITY</p>
                                        </span>
                                        <span class="d-inline-block align-top">
                                                ${concept.priority.toString()}
                                        </span>
                                    </div>
                                    <div class="col-4 border">
                                        <span class="d-inline-block align-top mr-5">
                                            <p class="langPL">STATUS</p>
                                            <p class="langEN">STATUS</p>
                                        </span>
                                        <c:if test="${concept.status == 'ORDERED_WAITING'}">
                                            <span class="d-inline-block align-top text-danger">
                                                    ${concept.status.toString()}
                                            </span>
                                        </c:if>
                                        <c:if test="${concept.status == 'IN_PROGRESS'}">
                                            <span class="d-inline-block align-top text-warning">
                                                    ${concept.status.toString()}
                                            </span>
                                        </c:if>
                                        <c:if test="${concept.status == 'FINISHED'}">
                                            <span class="d-inline-block align-top text-success">
                                                    ${concept.status.toString()}
                                            </span>
                                        </c:if>
                                    </div>
                                    <div class="col-4 border">
                                        <span class="d-inline-block align-top mr-5">
                                            <p class="langPL">TERMIN REALIZACJI</p>
                                            <p class="langEN">DEADLINE</p>
                                        </span>
                                        <span class="d-inline-block align-top">
                                            ${concept.dateTimeDeadline.toLocalDate()}<br>
                                            ${concept.dateTimeDeadline.toLocalTime()}
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body orderDetailsRow-3">
                                <c:choose>
                                    <c:when test="${concept.guideline eq null}">
                                        <div class="row">
                                            <div class="col-7">
                                                <p class="langPL">BRAK PROCEDOWANYCH WYTYCZNYCH DLA TEJ KONCEPCJI</p>
                                                <p class="langEN">NO GUIDELINE ORDER SENT FOR THIS CONCEPT</p>
                                            </div>
                                            <div class="col-5">
                                                <c:if test="${concept.guideline eq null}">
                                                    <a href="/guidelines/new?conceptId=${concept.id}&conceptStatus=${concept.status}"
                                                       class="btn btn-success float-right ml-1 mr-1"
                                                    >
                                                        <p class="langPL">ZAMÓWENIE WYTYCZNYCH</p>
                                                        <p class="langEN">NEW GUIDELINE ORDER</p>
                                                    </a>
                                                </c:if>
                                                <c:if test="${concept.guideline ne null}">
                                                    <a href="/guidelines/new?conceptId=${concept.id}&conceptStatus=${concept.status}"
                                                       class="btn btn-success float-right disabled ml-1 mr-1"
                                                    >
                                                        <p class="langPL">ZAMÓWENIE WYTYCZNYCH</p>
                                                        <p class="langEN">NEW GUIDELINE ORDER </p>
                                                    </a>
                                                </c:if>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="row">
                                            <div class="col-7">
                                                <span class="d-inline-block align-top mr-5">
                                                    <p class="langPL">ZAMÓWIENIE WYTYCZNYCH</p>
                                                    <p class="langEN">GUIDELINES ORDER</p>
                                                </span>
                                                <span class="d-inline-block align-top">
                                                    ID: ${concept.guideline.id}
                                                </span>
                                            </div>
                                            <div class="col-5">
                                                <a href="#" class="btn btn-danger disabled float-right ml-1 mr-1">
                                                    <p class="langPL">USUŃ</p>
                                                    <p class="langEN">DEL</p>
                                                </a>
                                                <a href="#" class="btn btn-primary disabled float-right ml-1 mr-1">
                                                    <p class="langPL">SZCZEGÓŁY / EDYCJA</p>
                                                    <p class="langEN">DETAILS / EDIT</p>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <div class="col-3 border">
                                                <span class="d-inline-block align-top mr-5">
                                                    <p class="langPL">DATA UTWORZENIA</p>
                                                    <p class="langEN">DATE OF CREATION</p>
                                                </span>
                                                <span class="d-inline-block align-top">
                                                    ${concept.guideline.dateTimeCreated.toLocalDate()} ${concept.guideline.dateTimeCreated.toLocalTime()}
                                                </span>
                                            </div>
                                            <div class="col-3 border">
                                                <span class="d-inline-block align-top mr-5">
                                                    <p class="langPL">PRIORYTET</p>
                                                    <p class="langEN">PRIORITY</p>
                                                </span>
                                                <span class="d-inline-block align-top">
                                                        ${concept.guideline.priority}
                                                </span>
                                            </div>
                                            <div class="col-3 border">
                                                <span class="d-inline-block align-top mr-5">
                                                    <p class="langPL">STATUS</p>
                                                    <p class="langEN">STATUS</p>
                                                </span>
                                                <c:if test="${concept.guideline.status == 'ORDERED_WAITING'}">
                                                    <span class="d-inline-block align-top text-danger">
                                                            ${concept.guideline.status.toString()}
                                                    </span>
                                                </c:if>
                                                <c:if test="${concept.guideline.status == 'IN_PROGRESS'}">
                                                    <span class="d-inline-block align-top text-warning">
                                                            ${concept.guideline.status.toString()}
                                                    </span>
                                                </c:if>
                                                <c:if test="${concept.guideline.status == 'FINISHED'}">
                                                    <span class="d-inline-block align-top text-success">
                                                            ${concept.guideline.status.toString()}
                                                    </span>
                                                </c:if>
                                            </div>
                                            <div class="col-3 border">
                                                <span class="d-inline-block align-top mr-5">
                                                    <p class="langPL">TERMIN REALIZACJI</p>
                                                    <p class="langEN">DEADLINE</p>
                                                </span>
                                                <span class="d-inline-block align-top">
                                                    ${concept.guideline.dateTimeDeadline.toLocalDate()} ${concept.guideline.dateTimeDeadline.toLocalTime()}
                                                </span>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="card-footer border border-dark border-top-0">
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="card-footer">
                    <a href="/concepts/new?userId=${sessionScope.userLoggedIn.id}&backToPage=/concepts/details/${sessionScope.userLoggedIn.id}?conceptListPage=true&conceptListPage=true" class="btn btn-success float-right">
                        <p class="langPL">NOWE ZAMÓWIENIE KONCEPCJI</p>
                        <p class="langEN">NEW CONCEPT ORDER</p>
                    </a>
                </div>
            </div>

        </form:form>

    </div>

    <jsp:include page="../footer.jsp"/>


</body>
</html>
