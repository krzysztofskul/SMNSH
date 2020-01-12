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
    <link rel="stylesheet" href="/resources/css/smnshStyles.css"/>
</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form modelAttribute="conceptNew" method="post" action="/concepts/new">
            <div class="card">
                <div class="card-header text-center">
                    <h4 class="langPL">KREATOR ZAMÓWIENIA NOWEJ KONCEPCJI</h4>
                    <h4 class="langEN">NEW CONCEPT ORDER FORM</h4>
                    <form:hidden path="id" disabled="true"/>
                </div>
                <!-- *** AUTHOR/CUSTOMER/ SECTION *** -->
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <p class="langPL">AUTOR/ZAMAWIAJĄCY:</p>
                            <p class="langEN">AUTHOR:</p>
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
                            <p class="langPL">SPRZĘT:</p>
                            <p class="langEN">DEVICE:</p>
                        </div>
                        <div class="col">
                            <form:select cssClass="w-100" path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">KLIENT:</p>
                            <p class="langEN">RECIPIENT/CUSTOMER:</p>
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="client" disabled="true"/>
                        </div>
                    </div>
                    <hr>
                    <!-- *** DATES/PRIORITY SECTION *** -->
                    <div class="row">
                        <div class="col-6">
                            <p class="langPL">PRIORYTET:</p>
                            <p class="langEN">PRIORITY:</p>
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="priority"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">TERMIN REALIZACJI:</p>
                            <p class="langEN">DEADLINE:</p>
                        </div>
                        <div class="col">
                            <input class="w-100" type="date" disabled/>
                        </div>
                    </div>
                    <hr>
                    <!-- *** TITLE/DESCRIPTION SECTION *** -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">TYTUŁ:</p>
                            <p class="langEL">TITLE:</p>
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="title"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">OPIS:</p>
                            <p class="langEN">DESCRIPTION:</p>
                        </div>
                        <div class="col">
                            <form:textarea cssClass="w-100" path="description"/>
                        </div>
                    </div>
                    <!-- *** QUESTIONS SECTION *** -->
                    <hr>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">ZAŁ. RZUT POMIESZCZANIA W DWG:</p>
                            <p class="langEN">LAYOUT DWG IN ATTACHEMENT:</p>
                        </div>
                        <div class="col">
                            <form:checkbox path="layout"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">WYZJA LOKALNA / WERYFIKACJA WYMIARÓW POMIESZCZENIA:</p>
                            <p class="langEN">ON-SITE VISITED / LAYOUT VERIFIED:</p>
                        </div>
                        <div class="col">
                            <form:checkbox path="onSiteVisited"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">MOŻLIWOŚĆ INGERENCJI W UKŁAD ŚCIAN:</p>
                            <p class="langEN">POSSIBILITY TO DEMOLISH/MOVE/BUILD WALLS:</p>
                        </div>
                        <div class="col">
                            <form:checkbox path="wallInterferencePossible"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">SUGESTIE KLIENTA:</p>
                            <p class="langEN">CUSTOMER SUGGESTIONS:</p>
                        </div>
                        <div class="col">
                            <form:textarea cssClass="w-100" path="customerSuggestions"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">WYMAGANE ZAPLANOWANIE DROGI TRANSPORTOWEJ:</p>
                            <p class="langEN">TRANSPORT ROUT TO DESIGN:</p>
                        </div>
                        <div class="col">
                            <form:checkbox path="transportRouteDesignNeeded"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">OKREŚLONE POŁOŻENIE TABLICY ROZDZIELCZEJ:</p>
                            <p class="langEN">POWER BOX PLACE SPECIFIED:</p>
                        </div>
                        <div class="col">
                            <form:checkbox path="electricBoxSpecified"/>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">DODATKOWE POMIESZCZENIA DO ZAPLANOWANIA:</p>
                            <p class="langEN">ADDITIONAL ROOMS TO DESIGN:</p>
                        </div>
                        <div class="col">
                            <form:input cssClass="w-100" path="additionalRoomsToDesign"/>
                        </div>
                    </div>
                </div>
                <!-- *** FOOTER SECTION *** -->
                <div class="card-footer">
                    <a href="/concepts/all" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
<%--                    <input type="submit" class="btn btn-success float-right" value="SAVE"/>--%>
                    <form:button class="btn btn-success float-right">
                        <span>.</span>
                        <p class="langPL">ZAPISZ ZMIANY</p>
                        <p class="langEN">SAVE CHANGES</p>
                    </form:button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>


</body>
</html>
