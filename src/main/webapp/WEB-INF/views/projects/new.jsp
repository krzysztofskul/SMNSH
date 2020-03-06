<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 29.02.2020
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form method="post" modelAttribute="projectNew">
            <div class="card">

                <div class="card-header text-center">
                    <p class="langPL">FORMULARZ NOWEJ KARTY PROJEKTU</p>
                    <p class="langEN">NEW PROJECT CARD FORM</p>
                </div>

                <div class="card-body">

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">ID:</p>
                            <p class="langEN">ID:</p>
                        </div>
                        <div class="col-8">
                            <form:hidden path="id" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">NAZWA PROJEKTU:</p>
                            <p class="langEN">PROJECT NAME:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="projectName" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">INWESTOR/KLIENT:</p>
                            <p class="langEN">INVESTOR:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="investor" cssClass="w-100"/>
                            <form:errors path="investor" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">MIEJSCE DOSTAWY:</p>
                            <p class="langEN">INSTALLATION PLACE:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="recipient" cssClass="w-100"/>
                            <form:errors path="recipient" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">NUMER UMOWY:</p>
                            <p class="langEN">AGREEMENT NO:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="agreementNo" cssClass="w-100"/>
                            <form:errors path="agreementNo" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">WYKONAWCA ADAPTACJI:</p>
                            <p class="langEN">BUILDING CONTRACTOR:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="buildingContractor" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">TERMIN REALIZACJI:</p>
                            <p class="langEN">DEADLINE:</p>
                        </div>
                        <div class="col-8">
                            <form:input type="date" path="deadline" cssClass="w-100"/>
                            <form:errors path="deadline" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">STATUS:</p>
                            <p class="langEN">STATUS:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="status" cssClass="w-100"/>
                            <form:errors path="status" cssClass="error"/>
                        </div>
                    </div>

                    <hr>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">PRZEDSTAWICIEL HANDLOWY:</p>
                            <p class="langEN">SALES REP.:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="sls" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">KIEROWNIK PROJEKTU:</p>
                            <p class="langEN">PROJECT MANAGER:</p>
                        </div>
                        <div class="col-8">
                            <form:select path="projectManager.id" cssClass="w-100">
                                <c:forEach items="${allProjectManagerList}" var="projectManager">
                                    <form:option value="${projectManager.id}" label="${projectManager.nameFirst} ${projectManager.nameLast}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                        <form:errors path="projectManager" cssClass="error"/>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">PUR:</p>
                            <p class="langEN">PUR:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="pur" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">LOG:</p>
                            <p class="langEN">LOG:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="log" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">PFC:</p>
                            <p class="langEN">PFC:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="pfc" cssClass="w-100"/>
                        </div>
                    </div>

                    <hr>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">LISTA URZĄDZEŃ:</p>
                            <p class="langEN">DEVICE LIST:</p>
                        </div>
                        <div class="col-8">
                            <form:select path="deviceList" cssClass="w-100" multiple="true">
                                <c:forEach items="${allDeviceList}" var="device">
                                    <form:option label="${device.deviceCategory.name} ${device.model}" value="${device.id}"/>
                                </c:forEach>
                            </form:select>
                            <form:errors path="deviceList" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">LISTA URZĄDZEŃ OBCYCH:</p>
                            <p class="langEN">3rd PARTY DEVICES:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="othersDeviceList" cssClass="w-100"/>
                        </div>
                    </div>

                    <hr>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">SZKOLENIA:</p>
                            <p class="langEN">TRAININGS:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="trainings" cssClass="w-100"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">UWAGI:</p>
                            <p class="langEN">REMARKS:</p>
                        </div>
                        <div class="col-8">
                            <form:textarea path="remarks" cssClass="w-100"/>
                        </div>
                    </div>

                </div>

                <div class="card-footer">
                    <a href="/projects/all" class="btn btn-warning float-left">
                        <p class="langPL">ANULUJ</p>
                        <p class="langEN">CANCEL</p>
                    </a>
                    <form:button type="submit" class="btn btn-success float-right">
                        <p class="langPL">ZAPISZ</p>
                        <p class="langEN">SAVE</p>
                    </form:button>
                </div>

            </div>
        </form:form>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
