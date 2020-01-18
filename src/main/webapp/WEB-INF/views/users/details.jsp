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
                <div class="card-header text-center" style="font-size: larger">
                    <p class="langPL">PROFIL UŻYTKOWNIKA</p>
                    <p class="langEN">USER'S PROFILE</p>
                </div>
                <div class="card-body">
                    <div class="row border-bottom pb-2 mb-2">
                        <div class="col text-right">
                            <span class="font-weight-bold">ID:</span> <form:input path="id" disabled="true" cssStyle="max-width: 50px"/>
                        </div>
                        <div class="col text-left">
                            <form:input path="nameFirst" cssClass="w-40"/>
                            <form:input path="nameLast" cssClass="w-50"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-right" style="margin: auto">
                            <p class="langPL">Zdjęcie profilowe:</p>
                            <p class="langEN">Avatar:</p>
                        </div>
                        <div class="col">
                                <%--<form:hidden path="avatar"/>--%>
                            <img class="img-thumbnail" src="/resources/img/avatars/img_avatar_someone.png" width="75" height="75" alt="AVATAR ICO">
                            <input type="file" name="file" id="file" disabled>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6 text-right" style="margin: auto">
                            <p class="langPL">E-mail:</p>
                            <p class="langEN">E-mail:</p>
                        </div>
                        <div class="col-6"><form:input path="email" cssClass="w-100"/></div>
                        <div>
                            <form:errors cssClass="error" path="email"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col text-right" style="margin: auto">
                            <p class="langPL">Stanowisko:</p>
                            <p class="langEN">Business position:</p>
                        </div>
                        <div class="col">
                            <form:select path="businessPosition" items="${businessPositions}" cssClass="w-100"/>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/users/all" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
<%--                    <input class="btn btn-success float-right" type="submit" value="SAVE">--%>
                    <form:button class="btn btn-success float-right">
                        <span>.</span>
                        <p class="langPL">ZAPISZ ZMIANY</p>
                        <p class="langEN">SAVE CHANGES</p>
                    </form:button>
                </div>
                <div class="card-body">
                    <!-- OLD VER. WITH TABLE -->
                    <!--
                    <table class="table table-sm">
                        <thead class="text-center bg-light">
                            <tr>
                                <td colspan="7">
                                    <p class="langPL">ZAMÓWENIA KONCPECJI / WYTYCZNYCH UŻYTKOWNIKA</p>
                                    <p class="langEN">ORDERS CREATED BY USER</p>
                                </td>
                            </tr>
                            <tr class="font-weight-bold">
                                <td>
                                    <p class="langPL">DATA UTWORZENIA</p>
                                    <p class="langEN">DATE OF CREATION</p>
                                </td>
                                <td>
                                    <p class="langPL">SPRZĘT</p>
                                    <p class="langEN">DEVICE</p>
                                </td>
                                <td>
                                    <p class="langPL">TYTUŁ</p>
                                    <p class="langEN">TITLE</p>
                                </td>
                                <td>
                                    <p class="langPL">PRIORYTET</p>
                                    <p class="langEN">PRIORITY</p>
                                </td>
                                <td>
                                    <p class="langPL">TERMIN REALIZACJI</p>
                                    <p class="langEN">DEADLINE</p>
                                </td>
                                <td>
                                    <p class="langPL">STATUS</p>
                                    <p class="langEN">STATUS</p>
                                </td>
                                <td class="text-info">
                                    <p class="langPL">MENU</p>
                                    <p class="langEN">ACTIONS</p>
                                </td>
                            </tr>
                        </thead>
                        <c:forEach items="${user.conceptList}" var="concept">
                            <tbody>
                                <tr class="bg-light">
                                    <td>
                                        ${concept.dateTimeCreated.toLocalDate()}
                                        <br>
                                        ${concept.dateTimeCreated.toLocalTime()}
                                    </td>
                                    <td>${concept.device.model}</td>
                                    <td>${concept.title}</td>
                                    <td>${concept.priority}</td>
                                    <td>${concept.dateTimeDeadline}</td>
                                    <td>${concept.status.toString()}</td>
                                    <td colspan="7">
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
                                        <br>
                                        <c:if test="${concept.guideline eq null}">
                                        <a href="/guidelines/new?conceptId=${concept.id} "
                                           class="btn btn-success float-right ml-1 mr-1"
                                        >
                                            <p class="langPL">ZAMÓWENIE WYTYCZNYCH DLA TEJ KONCEPCJI</p>
                                            <p class="langEN">NEW GUIDELINE ORDER FOR THIS CONCEPT</p>
                                        </a>
                                        </c:if>
                                        <c:if test="${concept.guideline ne null}">
                                            <a href="/guidelines/new?conceptId=${concept.id}"
                                               class="btn btn-success float-right disabled ml-1 mr-1"
                                            >
                                                <p class="langPL">ZAMÓWENIE WYTYCZNYCH DLA TEJ KONCEPCJI</p>
                                                <p class="langEN">NEW GUIDELINE ORDER FOR THIS CONCEPT</p>
                                            </a>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr class="font-italic">
                                    <c:choose>
                                        <c:when test="${concept.guideline eq null}">
                                            <td colspan="7">
                                                <p class="langPL">BRAK PROCEDOWANYCH WYTYCZNYCH DLA TEJ KONCEPCJI</p>
                                                <p class="langEN">NO GUIDELINE ORDER SENT FOR THIS CONCEPT</p>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${concept.guideline.dateTimeCreated}</td>
                                            <td>${concept.guideline.device}</td>
                                            <td>${concept.guideline.title}</td>
                                            <td>${concept.guideline.priority.toString()}</td>
                                            <td>${concept.guideline.dateTimeDeadline}</td>
                                            <td>${concept.guideline.status}</td>
                                            <td class="float-right">
                                                <a href="#" class="btn btn-primary disabled float-right">
                                                    <p class="langPL">SZCZEGÓŁY / EDYCJA</p>
                                                    <p class="langEN">DETAILS / EDIT</p>
                                                </a>
                                                <a href="#" class="btn btn-danger disabled float-right">
                                                    <p class="langPL">USUŃ</p>
                                                    <p class="langEN">DEL</p>
                                                </a>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    -->
                    <!-- CARD FOR CONCEPTS / GUIDELINES -->
                    <div class="row border-top border-bottom text-center bg-light mt-3 mb-3 pt-2 pb-2"
                         style="font-size: larger">
                        <div class="col-12">
                            <p class="langPL">ZAMÓWIENIA KONCPECJI / WYTYCZNYCH UŻYTKOWNIKA</p>
                            <p class="langEN">ORDERS CREATED BY USER</p>
                        </div>
                    </div>
                    <!-- CONCEPT CARD VER. -->
                    <c:forEach items="${user.conceptList}" var="concept">
                        <div class="card mt-2 mb-3">
                            <div class="card-header text-left">
                                <div class="row border-bottom pb-2">
                                    <div class="col-3">
                                        <p class="langPL">ZAMÓWIENIE KONCEPCJI</p>
                                        <p class="langEN">CONCEPT ORDER</p>
                                    </div>
                                    <div class="col-2">
                                        ID: ${concept.id}
                                    </div>
                                    <div class="col-7">
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
                                <div class="row">
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
                                <div class="row">
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
                                        <span class="d-inline-block align-top">
                                            ${concept.status.toString()}
                                        </span>
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
                            <div class="card-body">
                                <c:choose>
                                    <c:when test="${concept.guideline eq null}">
                                        <div class="row">
                                            <div class="col-7">
                                                <p class="langPL">BRAK PROCEDOWANYCH WYTYCZNYCH DLA TEJ KONCEPCJI</p>
                                                <p class="langEN">NO GUIDELINE ORDER SENT FOR THIS CONCEPT</p>
                                            </div>
                                            <div class="col-5">
                                                <c:if test="${concept.guideline eq null}">
                                                    <a href="/guidelines/new?conceptId=${concept.id} "
                                                       class="btn btn-success float-right ml-1 mr-1"
                                                    >
                                                        <p class="langPL">ZAMÓWENIE WYTYCZNYCH</p>
                                                        <p class="langEN">NEW GUIDELINE ORDER</p>
                                                    </a>
                                                </c:if>
                                                <c:if test="${concept.guideline ne null}">
                                                    <a href="/guidelines/new?conceptId=${concept.id}"
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
                                                <span class="d-inline-block align-top">
                                                    ${concept.guideline.status}
                                                </span>
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
                            <div class="card-footer">
                            </div>
                        </div>
                    </c:forEach>
                    <!-- END CARD FOR CONCEPTS / GUIDELINES -->

                </div>
                <div class="card-footer">
                    <a href="/concepts/new?userId=${user.id}" class="btn btn-success float-right">
                        <p class="langPL">NOWE ZAMÓWIENIE KONCEPCJI</p>
                        <p class="langEN">NEW CONCEPT ORDER</p>
                    </a>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
