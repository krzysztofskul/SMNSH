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
                    <p class="langPL">PROFIL UŻYTKOWNIKA</p>
                    <p class="langEN">USER'S PROFILE</p>
                    <form:input path="id" disabled="true" cssStyle="max-width: 50px"/> |
                    <form:input path="nameFirst"/>
                    <form:input path="nameLast"/>
                </div>
                <div class="card-body">
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
                    <table class="table table-sm">
                        <thead class="text-center bg-light">
                            <tr>
                                <td colspan="7">
                                    <p class="langPL">ZAMÓWENIA KONCPECJI/WYTYCZNYCH UŻYTKOWNIKA</p>
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
                                <tr class="bg-light">    <!-- conceptList -->
                                    <td>${concept.dateTimeCreated.toString()}</td>
                                    <td>${concept.device.model}</td>
                                    <td>${concept.title}</td>
                                    <td>${concept.priority}</td>
                                    <td>${concept.dateTimeDeadline}</td>
                                    <td>${concept.status.toString()}</td>
                                    <td colspan="7">
                                        <a href="#" class="btn btn-danger disabled float-right ml-1 mr-1">
                                            <p class="langPL">USUŃ</p>
                                            <p class="langEN">DEL</p>
                                        </a>
                                        <a href="/concepts/details/${concept.id}" class="btn btn-primary float-right ml-1 mr-1">
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
<%--                                               style="display: block; max-width: 200px; font-size: small"--%>
                                            >
                                                <p class="langPL">ZAMÓWENIE WYTYCZNYCH DLA TEJ KONCEPCJI</p>
                                                <p class="langEN">NEW GUIDELINE ORDER FOR THIS CONCEPT</p>
                                            </a>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr class="font-italic">    <!-- guidelineList -->
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
