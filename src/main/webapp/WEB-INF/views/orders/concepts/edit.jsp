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
                    <form:input path="id" disabled="true" cssStyle="max-width: 50px"/> | <%--${concept.title}--%> <form:input path="title"/>
                    <form:hidden path="dateTimeCreated"/>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">AUTOR:</p>
                            <p class="langEN">AUTHOR:</p>
                        </div>
                        <div class="col-6">
                            <form:select path="author.id" cssClass="w-100">
                                <c:forEach items="${usersAll}" var="user">
                                    <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">KLIENT</p>
                            <p class="langEN">CUSTOMER:</p>
                        </div>
                        <div class="col-6">
                            <form:input path="client" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">TERMIN REALIZAZJI:</p>
                            <p class="langEN">DEADLINE:</p>
                        </div>
                        <div class="col-6">
                            <%--<input type="date" name="inputDateDeadline" value="${concept.dateTimeDeadline.toLocalDate()}">--%>
                            <form:input path="dateTimeDeadline" cssClass="w-100"/>
                            <div>
                                <form:errors path="dateTimeDeadline" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">PRIORYTET:</p>
                            <p class="langEN">PRIORITY:</p>
                        </div>
                        <div class="col-6">
                            <form:input path="priority" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">PROJEKTANT/PLANISTA:</p>
                            <p class="langEN">DESIGNER/PLANNER:</p>
                        </div>
                        <div class="col-6">
                            <form:select path="planner.id" cssClass="w-100">
                                <form:option value="0" label="-"/>
                                <c:forEach items="${usersAll}" var="user">
                                    <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-6"></div>
                        <div class="col-6 error">
                            <form:errors path="planner"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">STATUS:</p>
                            <p class="langEN">STATUS:</p>
                        </div>
                        <div class="col-6">
                            <form:select path="status" cssClass="w-100">
                                <c:forEach items="${orderStatuses}" var="orderStatus">
                                    <form:option value="${orderStatus}" label="${orderStatus.toString()}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-6"></div>
                        <div class="col-6 error">
                            <form:errors path="status"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">APARAT:</p>
                            <p class="langEN">DEVICE:</p>
                        </div>
                        <div class="col-6">
                            <form:select path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">OPIS:</p>
                            <p class="langEN">DESCRIPTION:</p>
                        </div>
                        <div class="col-6">
                                <form:textarea path="description" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">PODKŁAD ARCHITEKTONICZNY:</p>
                            <p class="langEN">ARCHITECTURAL LAYOUT:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="layout"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">WIZJA LOKALNA:</p>
                            <p class="langEN">ON SITE VISITED:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="onSiteVisited"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">MOŻLIWOŚĆ INGERENCJI W UKŁAD ŚCIAN:</p>
                            <p class="langEN">WALL INTERFERENCE POSSIBILITY:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="wallInterferencePossible"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">SUGESTIE KLIENTA:</p>
                            <p class="langEN">CUSTOMER SUGGESTIONS:</p>
                        </div>
                        <div class="col-6">
                            <form:textarea path="customerSuggestions" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">WYZNACZENIE DROGI TRANSPORTOWEJ:</p>
                            <p class="langEN">TRANSPORT ROUTE TO MARK:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="transportRouteDesignNeeded"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">WSKAZANO MIEJSCE TABLICY ELEKTR.:</p>
                            <p class="langEN">ELECTRICAL BOX PLACE SPECIFIED:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="electricBoxSpecified"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">ZAPROJEKTOWANIE DODATKOWYCH POMIESZCZEŃ:</p>
                            <p class="langEN">ADDITIONAL ROOMS TO DESIGN:</p>
                        </div>
                        <div class="col-6">
                            <form:input path="additionalRoomsToDesign" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">INNE UWAGI KIEROWNIKA PROJEKTU:</p>
                            <p class="langEN">PROJECT MANAGER OTHER REMARKS:</p>
                        </div>
                        <div class="col-6">
                            <form:textarea path="remarks" cssClass="w-100"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-6 text-right">
                            <p class="langPL">WYTYCZNE:</p>
                            <p class="langEN">GUDELINE:</p>
                        </div>
                        <div class="col float-right">
                            <a href="#" class="btn btn-primary disabled">
                                <p class="langPL">SZCZEGÓLY</p>
                                <p class="langEN">DETAILS</p>
                            </a>
                            <a href="#" class="btn btn-danger disabled">
                                <p class="langPL">USUŃ</p>
                                <p class="langEN">DEL</p>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/concepts/details/${concept.id}" class="btn btn-warning float-left">
                        <p class="langPL">ANULUJ/WSTECZ</p>
                        <p class="langEN">CANCEL/BACK</p>
                    </a>
                    <form:button class="btn btn-success float-right">
                        <p class="langPL">ZAPISZ</p>
                        <p class="langEN">SAVE</p>
                    </form:button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
