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
    <link rel="stylesheet" href="<c:url value="/resources/css/smnshStyles.css"/>"/>
</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <%--@elvariable id="conceptNew" type="pl.krzysztofskul.order.concept.Concept"--%>
        <form:form id="conceptNewForm" modelAttribute="conceptNew" method="post" action="/concepts/new">
            <div class="card">
                <div class="card-header text-center">
                    <h4 class="langPL">KREATOR ZAMÓWIENIA NOWEJ KONCEPCJI</h4>
                    <h4 class="langEN">NEW CONCEPT ORDER FORM</h4>
                    <form:hidden path="id" disabled="true"/>
                </div>
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
                                        <jsp:useBean id="usersAll" scope="request" type="java.util.List"/>
                                        <c:forEach items="${usersAll}" var="user">
                                            <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                        </c:forEach>
                                    </form:select>
                                </c:when>
                                <c:otherwise>
                                    <form:hidden path="author.id"/>
                                    <input type="text" readonly value="${conceptNew.author.nameFirst} ${conceptNew.author.nameLast}" class="w-100"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">DOT. UMOWY:</p>
                            <p class="langEN">AGREEMENT:</p>
                        </div>
                        <div class="col">
                            <c:choose>
                                <c:when test="${conceptNew.project ne null}">
                                    <p class="input-group-text text-black-50">${conceptNew.project.agreementNo}
                                    <form:hidden path="project.id"/>
                                </c:when>
                                <c:otherwise>
                                    <form:select path="project.id" cssClass="w-100" items="${projectList}" itemValue="id" itemLabel="agreementNo"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">SPRZĘT:</p>
                            <p class="langEN">DEVICE:</p>
                            <jsp:useBean id="devicesAll" scope="request" type="java.util.List"/>
                        </div>
                        <c:choose>
                        	<c:when test="${conceptNew.device ne null}">
                        		<form:hidden path="device.id"/>
                        		<div class="col">
                        			<form:select path="device.id" cssClass="w-100" items="${devicesAll}" itemValue="id" itemLabel="model" disabled="true"/>
                        		</div>
                        	</c:when>
                        	<c:otherwise>
		                        <div class="col">
		                            <c:choose>
		                                <c:when test="${conceptNew.project eq null}">
		                                    <form:select cssClass="w-100" path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id"/>
		                                </c:when>
		                                <c:otherwise>
		                                    <form:select cssClass="w-100" path="device.id">
		                                        <c:forEach items="${conceptNew.project.deviceList}" var="device">
		                                            <form:option value="${device.id}" label="${device.deviceCategory.code} ${device.model}"/>
		                                        </c:forEach>
		                                    </form:select>
		                                </c:otherwise>
		                            </c:choose>
		                        </div>
                        	</c:otherwise>
                        </c:choose>
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
                            <form:input cssClass="w-100" path="dateTimeDeadline"/>
                            <div>
                                <form:errors cssClass="error" path="dateTimeDeadline"/>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-6"></div>
                        <div class="col">
                            <span class="d-block text-black-50 font-italic">DD.MM.YY HH:MM</span>
                        </div>
                    </div>
                    <hr>
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">TYTUŁ:</p>
                            <p class="langEN">TITLE:</p>
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
                <div class="card-footer">
                    <c:choose>
                        <c:when test="${backToPage eq null}">
                            <c:set var="backTo" value="/concepts/all"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="backTo" value="${backToPage}"/>
                            <input type="hidden" name="backToPage" value="${backToPage}"/>
                        </c:otherwise>
                    </c:choose>
                    <a href="${backTo}" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
                    <form:button id="saveConceptBtn" class="btn btn-success float-right">
                        <span>.</span>
                        <p class="langPL">ZAMÓW</p>
                        <p class="langEN">ORDER</p>
                    </form:button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>


</body>
</html>
