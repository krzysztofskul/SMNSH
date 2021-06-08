<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 02.03.2020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" session="true" %>
<html>
<head>
    <!--jQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <%--JS--%>
    <script src="/resources/js/projects/details.js" type="text/javascript"></script>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form method="post" modelAttribute="project">
            <div class="card border border-dark border-left-0 border-right-0 border-bottom-0 mb-5">

                <div class="card-header">
                    <c:if test="${edit eq true}">
                        <form:hidden path="id"/>
                    </c:if>
                    <div class="row border-bottom pb-2">
                        <div class="col-sm-4 ml-2 position-absolute d-inline-block p-0">
                            <div class="text-left position-relative d-inline-block mr-2">
                                <p class="langPL"> ID:</p>
                                <p class="langEN"> ID:</p>
                            </div>
                            <div id="projectId" class="text-left position-relative d-inline-block align-top">
                                ${project.id}
                            </div>
                        </div>
                        <div class="col-sm-6 text-center">
                            <c:set var="pageTitlePL" value="SZCZEGÓŁY PROJEKTU"/>
                            <c:set var="pageTitleEN" value="PROJECT DETAILS"/>
                            <c:if test="${edit eq true}">
                                <c:set var="pageTitlePL" value="EDYCJA PROJEKTU"/>
                                <c:set var="pageTitleEN" value="PROJECT EDIT"/>
                            </c:if>
                            <p class="langPL">${pageTitlePL}</p>
                            <p class="langEN">${pageTitleEN}</p>
                        </div>
                        <div class="col-sm-6">
                            <c:set var="backTo" value="/projects/all"/>
                            <c:set var="forwardTo" value="/projects/details/${project.id}?edit=true"/>
                            <c:set var="forwardBtnPL" value="EDYCJA"/>
                            <c:set var="forwardBtnEN" value="EDIT"/>
                            <c:set var="forwardClr" value="btn-outline-primary"/>
                            <c:if test="${edit eq true}">
                                <c:set var="backTo" value="/projects/details/${project.id}"/>
                                <c:set var="forwardTo" value="/projects/details/${project.id}"/>
                                <c:set var="forwardBtnPL" value="ZAPISZ"/>
                                <c:set var="forwardBtnEN" value="SAVE"/>
                                <c:set var="forwardClr" value="btn-success"/>
                            </c:if>
                            <c:if test="${edit ne true}">
                                <a href="${forwardTo}" class="btn ${forwardClr} float-right">
                                    <p class="langPL">${forwardBtnPL}</p>
                                    <p class="langEN">${forwardBtnEN}</p>
                                </a>
                            </c:if>
                            <c:if test="${edit eq true}">
                                <form:button type="submit"
                                             class="btn ${forwardClr} float-right"
                                >
                                    <p class="langPL">${forwardBtnPL}</p>
                                    <p class="langEN">${forwardBtnEN}</p>
                                </form:button>
                            </c:if>
                            <a href="/logs/project/${project.id}" class="btn btn-outline-light float-right mr-2">
                                <p class="langPL">HISTORIA</p>
                                <p class="langEN">HISTORY</p>
                            </a>
                            <a href="/projects/details/${project.id}/comments" class="btn btn-outline-light float-right mr-2">
                                <p class="langPL">KOMENTARZE</p>
                                <p class="langEN">COMMENTS</p>
                            </a>
                            <a href="${backTo}" class="btn btn-outline-warning float-right mr-2">
                                <p class="langPL">WSTECZ</p>
                                <p class="langEN">BACK</p>
                            </a>
                        </div>
                    </div>
                    <div class="row border-bottom border-top">
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">NAZWA PROJEKTU:</p>
                            <p class="langEN">PROJECT NAME:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:input path="projectName"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.projectName}
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">NR UMOWY:</p>
                            <p class="langEN">AGREEMENT NO.:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:input path="agreementNo" cssClass="w-100"/>
                                    <form:errors path="agreementNo" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.agreementNo}
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="row border-bottom">
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">INWESTOR:</p>
                            <p class="langEN">INVESTOR.:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:select path="investor.id" cssClass="w-100">
                                        <c:forEach items="${allInvestorList}" var="investor">
                                            <form:option value="${investor.id}" label="${investor.name} ${investor.companyType.name}"/>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors path="investor" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.investor.name} ${project.investor.companyType.name}
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">MIEJSCE DOSTAWY:</p>
                            <p class="langEN">CUSTOMER:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:input path="recipient" cssClass="w-100"/>
                                    <form:errors path="recipient" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.recipient}
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="row border-bottom border-top">
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">HANDLOWIEC:</p>
                            <p class="langEN">SALES REP.:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:input path="sls" disabled="true" value="${project.sls.nameFirst} ${project.sls.nameLast}"/>
                                    <form:hidden path="sls.id"  value="${project.sls.id}"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.sls.nameFirst} ${project.sls.nameLast}
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">KIEROWNIK PROJEKTU:</p>
                            <p class="langEN">PROJECT MANAGER:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:select path="projectManager.id" cssClass="w-100">
                                        <c:forEach items="${allProjectManagerList}"
                                                   var="projectManager">
                                            <form:option
                                                    value="${projectManager.id}"
                                                    label="${projectManager.nameFirst} ${projectManager.nameLast}"
                                            />
                                        </c:forEach>
                                    </form:select>
                                    <form:errors path="projectManager" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.projectManager.nameFirst} ${project.projectManager.nameLast}
                                    (<span id="projectManagerId">${project.projectManager.id}</span>)
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="row border-bottom">
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">WYKONAWCA ADAPTACJI:</p>
                            <p class="langEN">BUILDING CONTRACTOR:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:select path="subcontractor.id" cssClass="w-100">
                                        <c:forEach items="${allSubcontractorList}" var="subcontractor">
                                            <form:option value="${subcontractor.id}" label="${subcontractor.name} ${subcontractor.type.name}"/>
                                        </c:forEach>
                                    </form:select>
                                </c:when>
                                <c:otherwise>
                                    ${project.subcontractor.name} ${project.subcontractor.type.name}
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">TERMIN REALIZACJI:</p>
                            <p class="langEN">DEADLINE:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:input type="date" path="deadline" cssClass="w-100"/>
                                    <form:errors path="deadline" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.deadline.toLocalDate()}
<%--                                    ${project.deadline.toLocalTime()}--%>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6"></div>
                        <div class="col-3 text-right pt-2 float-right">
                            <p class="langPL">STATUS PROJEKTU:</p>
                            <p class="langEN">PROJECT STATUS:</p>
                        </div>
                        <div class="col-3 pt-2 float-right">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:select path="status" items="${allStatusesProject}" itemLabel="name" cssClass="w-100"/>
                                    <form:errors path="status" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.status.toString()}
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                </div>

                <div class="card-body">
                    <div class="row border-50 border-top pb-3 bg-light">
                        <div class="col-12 text-center pt-2">
                            <p class="langPL">URZĄDZENIA PLANOWANE DO INSTALACJI:</p>
                            <p class="langEN">DEVICES PLANNED FOR INSTALLATION:</p>
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${edit eq true}">
                            <form:select path="deviceList" multiple="true" cssClass="w-100">
                                <c:forEach items="${allDeviceList}" var="device">
                                    <c:set var="marked" value="false"/>
                                    <c:forEach items="${project.deviceList}" var="deviceInProject">
                                        <c:if test="${device.id.toString() eq deviceInProject.id.toString()}">
                                            <form:option value="${device.id}" label="${device.model}" selected="true"/>
                                            <c:set var="marked" value="true"/>
                                        </c:if>
                                        <c:if test="${device.id.toString() ne deviceInProject.id.toString() && marked eq false}">
                                            <form:option value="${device.id}" label="${device.model}"/>
                                            <c:set var="marked" value="true"/>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </form:select>
                            <form:errors path="deviceList" cssClass="error"/>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${project.deviceList}" var="device">
                                <%--DEVICE NAME--%>
                                <div class="row pt-1 pb-2 border-top border-bottom border-dark no-gutters">
                                    <div class="col-6 font-weight-bold">
                                        <p style="top: 25%; position: absolute">
                                            ${device.deviceCategory.name}
                                        </p>
                                    </div>
                                    <div class="col-4 font-italic">
                                        <p style="top: 25%; position: absolute">
                                            ${device.model}
                                        </p>
                                    </div>
                                    <div class="col-2">
                                        <c:set var="btnConfClass" value="btn btn-sm btn-outline-primary"/>
                                        <c:set var="btnConfTitlePL" value="SPRAWDŹ KONFIGURACJĘ"/>
                                        <c:set var="btnConfTitleEN" value="CHECK CONFIGURATION"/>
                                        <c:if test="${sessionScope.userLoggedIn.businessPosition eq 'SALES_REP'}">
                                            <c:set var="btnConfClass" value="btn btn-sm btn-outline-success"/>
                                            <c:set var="btnConfTitlePL" value="EDYTUJ KONFIGURACJĘ"/>
                                            <c:set var="btnConfTitleEN" value="EDIT CONFIGURATION"/>
                                        </c:if>
                                        <button class="${btnConfClass}" disabled>
                                            <p class="langPL">${btnConfTitlePL}</p>
                                            <p class="langEN">${btnConfTitleEN}</p>
                                        </button>
                                    </div>
                                </div>
                                <%--DEVICE CONFIGURATION--%>
                                <div class="configuration-details border-bottom mb-5">
                                    <div class="row p-2 text-center font-weight-bold">
                                        <div class="col-12 text-center">
                                            <p class="langPL">KONFIGURACJA URZĄDZENIA</p>
                                            <p class="langEN">DEVICE CONFIGURATION</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2">
                                            <p class="langPL">ID</p>
                                            <p class="langEN">ID</p>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="langPL">NAZWA CZĘŚCI</p>
                                            <p class="langEN">PART NAME</p>
                                        </div>
                                        <div class="col-sm-3">
                                            <p class="langPL">CENA CZĘŚCI</p>
                                            <p class="langEN">PART PRICE</p>
                                        </div>
                                        <div class="col-sm-3 float-right">
                                            <p class="langPL">AKCJE</p>
                                            <p class="langEN">ACTIONS</p>
                                        </div>
                                    </div>
                                    <c:forEach items="${device.configurationList}" var="configuration">
                                        <c:if test="${device.id eq configuration.device.id && configuration.project.id eq project.id}">
                                            <div id="'configurationId-'+${configuration.id}">
                                            <c:forEach items="${configuration.partList}" var="part">
                                                <div class="row mt-1 mb-1 no-gutters">
                                                    <div class="col-sm-2">${part.id}</div>
                                                    <div class="col-sm-4">${part.name}</div>
                                                    <c:if test="${sessionScope.userLoggedIn.businessPosition eq 'SALES_REP'}">
                                                        <div class="col-sm-3">${part.price}</div>
                                                    </c:if>
                                                    <c:if test="${sessionScope.userLoggedIn.businessPosition ne 'SALES_REP'}">
                                                        <div class="col-sm-3">###</div>
                                                    </c:if>
                                                    <div class="col-sm-3 float-right">
                                                        <button class="btn btn-sm btn-primary" disabled>info</button>
                                                        <button class="btn btn-sm btn-danger" disabled>DEL</button>
                                                    </div>
                                                </div>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${sessionScope.userLoggedIn.businessPosition eq 'SALES_REP'}">
                                    <div class="row mb-1">
                                        <div class="col-sm-12">
                                            <button class="id-add-part btn btn-sm btn-outline-success float-right disabled" disabled>
                                                <p class="langPL">DODAJ CZĘŚĆ</p>
                                                <p class="langEN">ADD PART</p>
                                            </button>
                                        </div>
                                    </div>
                                    </c:if>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <div class="row border-dark border-top bg-light mt-5">
                        <div class="col-12 text-center mt-2 mb-2">
                            <p class="langPL">UWAGI DO PROJEKTU</p>
                            <p class="langEN">REMARKS</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:textarea path="remarks" cssClass="w-100"/>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${project.recipient ne null}">
                                        <p class="font-italic mt-2 mb-2">${project.remarks}</p>
                                    </c:if>
                                    <c:if test="${project.recipient eq null}">
                                        <p class="font-italic mt-2 mb-2">BRAK UWAG DO TEGO PROJEKTU / NO ADDITIONAL REMARKS TO THI PROJECT</p>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row border-50 border-top bg-light mt-3">
                        <div class="col-12 text-center mt-2 mb-3">
                            <p class="langPL">ZAŁĄCZNIKI</p>
                            <p class="langEN">ATTACHEMNTS</p>
                        </div>
                        <c:if test="${edit eq true}">
                            <div class="col-3 position-absolute mt-2 float-right">
                                <div class="btn btn-primary disabled">
                                    <p class="langPL">DODAJ ZAŁ.</p>
                                    <p class="langEN">UPLOAD ATT.</p>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div class="row pt-2">
                        <c:choose>
                            <c:when test="${project.attachment ne null}">
                                <div class="col-8 pt-3">
                                        ${project.attachment.fileName}
                                </div>
                                <div class="col-4">
                                    <a href="#" class="btn btn-danger float-right m-1 d-inline-block disabled">
                                        <p class="langPL">USUŃ</p>
                                        <p class="langEN">DEL</p>
                                    </a>
                                    <a href="/projects/${project.id}/attachment-download/${project.attachment.id}" class="btn btn-dark float-right m-1 d-inline-block">
                                        <p class="langPL">POBIERZ</p>
                                        <p class="langEN">DOWNLOAD</p>
                                    </a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-12">
                                    <p class="langPL">BRAK ZAŁĄCZNIKÓW</p>
                                    <p class="langEN">NONE ATTACHMENTS</p>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

<%--                <div class="card-footer">--%>

<%--                    <c:set var="backTo" value="/projects/all"/>--%>
<%--                    <c:set var="forwardTo" value="/projects/details/${project.id}?edit=true"/>--%>
<%--                    <c:set var="forwardBtnPL" value="EDYCJA"/>--%>
<%--                    <c:set var="forwardBtnEN" value="EDIT"/>--%>
<%--                    <c:set var="forwardClr" value="btn-primary"/>--%>
<%--                    <c:if test="${edit eq true}">--%>
<%--                        <c:set var="backTo" value="/projects/details/${project.id}"/>--%>
<%--                        <c:set var="forwardTo" value="/projects/details/${project.id}"/>--%>
<%--                        <c:set var="forwardBtnPL" value="ZAPISZ"/>--%>
<%--                        <c:set var="forwardBtnEN" value="SAVE"/>--%>
<%--                        <c:set var="forwardClr" value="btn-success"/>--%>
<%--                    </c:if>--%>

<%--                    <a href="${backTo}" class="btn btn-warning float-left">--%>
<%--                        <p class="langPL">WSTECZ</p>--%>
<%--                        <p class="langEN">BACK</p>--%>
<%--                    </a>--%>

<%--                    <c:if test="${edit ne true}">--%>
<%--                        <a href="${forwardTo}" class="btn ${forwardClr} float-right">--%>
<%--                            <p class="langPL">${forwardBtnPL}</p>--%>
<%--                            <p class="langEN">${forwardBtnEN}</p>--%>
<%--                        </a>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${edit eq true}">--%>
<%--                        <form:button type="submit"--%>
<%--                                     class="btn ${forwardClr} float-right"--%>
<%--                        >--%>
<%--                            <p class="langPL">${forwardBtnPL}</p>--%>
<%--                            <p class="langEN">${forwardBtnEN}</p>--%>
<%--                        </form:button>--%>
<%--                    </c:if>--%>
<%--                </div>--%>

            </div>


            <%--LIST OF RELATED ORDERS FOR CONCEPTUAL PROJECTS (PRELIMINARY PROJECTS) --%>
            <div class="card mt-2 border-dark border-left-0 border-right-0">

                <div class="card-header text-center p-0">
                    <div class="m-0 p-2">
                        <div class="langPL">ZAMÓWIENIA PROJEKTU KONCEPCYJNEGO</div>
                        <div class="langEN">LIST OF ORDERS FOR CONCEPTUAL (PRELIMINARY) PROJECT</div>
                    </div>
                </div>

                <div class="card-body">
                    <c:if test="${project.conceptList.size() == 0}">
                        <div class="row">
                            <div class="col-12">
                                <p class="langPL">NIE WYSŁANO JESZCZE ŻADNEGO ZAMÓWIENIA PROJKETU KONECPCYJNEGO</p>
                                <p class="langEN">NOT SENT ANY ORDERD FOR CONCEPTUAL (PRELIMINARY) PROJECT YET</p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${project.conceptList ne null}">
                        <c:forEach items="${project.conceptList}" var="concept">
                            <div class="card mb-3 border-50">
                                <div class="card-header">
                                    <div class="row h-100px">
                                        <div class="col-sm-1 <%--border border-dark--%> p-0 pr-sm-1">
                                            <div class="border border-50 m-0 p-2 w-100">
                                                <p class="langPL">ID:</p>
                                                <p class="langEN">ID:</p>
                                            </div>
                                            <p class="conceptId text-left pt-2 pl-2">${concept.id}</p>
                                        </div>
                                        <div class="col-sm-3 <%--border border-dark--%> p-0 pr-sm-1">
                                            <div class="border border-50 m-0 p-2 w-100">
                                                <p class="langPL">UTWORZONO:</p>
                                                <p class="langEN">CREATED:</p>
                                            </div>
                                            <p class="text-left pt-2 pl-2">${concept.dateTimeCreated.toLocalDate()}</p>
                                        </div>
                                        <div class="col-sm-3 <%--border border-dark--%> p-0 pr-sm-1">
                                            <div class="border border-50 m-0 p-2 w-100">
                                                <p class="langPL">TERMIN REALIZACJI:</p>
                                                <p class="langEN">DEADLINE:</p>
                                            </div>
                                            <p class="text-left pt-2 pl-2">
                                                    ${concept.dateTimeDeadline.toLocalDate()}
<%--                                                    ${concept.dateTimeDeadline.toLocalTime()}--%>
                                            </p>
                                        </div>
                                        <div class="col-sm-5 <%--border border-dark--%> p-0 pr-sm-1">
                                            <div class="border border-50 m-0 p-2 w-100">
                                                <p class="langPL">STATUS ZAMÓWIENIA PROJEKTU KONCEPCYJNEGO:</p>
                                                <p class="langEN">ORDER FOR THE CONCEPTUAL (PRELIMINARY) PROJECT STATUS:</p>
                                            </div>
                                            <c:choose>
                                                <c:when test="${concept.status.toString() eq 'OCZEKUJE / WAITING'}">
                                                    <p class="text-left pt-2 pl-2 text-danger font-weight-bold">${concept.status.toString()}</p>
                                                </c:when>
                                                <c:when test="${concept.status.toString() eq 'W TOKU / IN PROGRESS'}">
                                                    <p class="text-left pt-2 pl-2 text-warning font-weight-bold">${concept.status.toString()}</p>
                                                </c:when>
                                                <c:when test="${concept.status.toString() eq 'ZAKOŃCZONY / FINISHED'}">
                                                    <p class="text-left pt-2 pl-2 text-success font-weight-bold">${concept.status.toString()}</p>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-7 text-right ">
                                            <p class="langPL">PLANISTA:</p>
                                            <p class="langEN">PLANNER:</p>
                                        </div>
                                        <div class="col-5">
                                            <c:choose>
                                                <c:when test="${concept.planner eq null}">
                                                    <p class="langPL">BRAK PRZYPISANEGO PLANISTY</p>
                                                    <p class="langEN">NO PLANNER ASSIGNED</p>
                                                </c:when>
                                                <c:when test="${concept.planner ne null}">
                                                    <p class="text-left pt-2 pl-2">${concept.planner.nameFirst} ${concept.planner.nameLast}</p>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-12">
                                            <span class="w-100px font-weight-bold p-1 d-inline-block">${concept.device.deviceCategory.code}</span>
                                            <span>${concept.device.model}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <a href="/concepts/details/${concept.id}" class="btn btn-outline-primary float-right ml-1">
                                        <p class="langPL">SZCZEGÓLY</p>
                                        <p class="langEN">DETAILS</p>
                                    </a>
                                    <%-- BUTTON: ASSIGN DESIGNER --%>
                                    <c:if test="${concept.planner eq null && sessionScope.userLoggedIn.businessPosition.toString() eq 'Projektant/Planista / Designer/Planner'}">
                                        <c:if test="${concept.status.toString() eq 'OCZEKUJE / WAITING'}">
                                            <a id="setMeAsDesignerBtn" href="/concepts/setDesigner/${concept.id}/${sessionScope.userLoggedIn.id}?backToPage=projects/details/${project.id}" class="btn btn-outline-success float-right ml-1">
                                                <p class="langPL">PRZYPISZ MNIE JAKO PROJEKTANTA</p>
                                                <p class="langEN">ASSIGN ME AS A DESIGNER</p>
                                            </a>
                                        </c:if>
                                    </c:if>
                                    <%-- BUTTON: SET CONCEPTUAL PROJECT AS FINISHED --%>
                                    <c:if test="${concept.planner ne null && sessionScope.userLoggedIn.businessPosition.toString() eq 'Projektant/Planista / Designer/Planner'}">
                                        <c:if test="${concept.status.toString() eq 'W TOKU / IN PROGRESS'}">
                                            <a id="setOrderAsFinishedBtn" href="/concepts/setStatusFinished/${concept.id}?backToPage=projects/details/${project.id}" class="btn btn-outline-success float-right ml-1">
                                                <p class="langPL">USTAW JAKO ZAKOŃCZONY</p>
                                                <p class="langEN">SET AS FINISHED</p>
                                            </a>
                                        </c:if>
                                    </c:if>
                                    <%-- BUTTON: ORDER FINAL PLANNING (GUIDELINES) PROJECT --%>
                                    <c:set var="isLoggedPM" value="${sessionScope.userLoggedIn.businessPosition.toString() eq 'Kierownik projektu / Project Manager'}"/>
                                    <c:set var="isConceptFinished" value="${concept.status.toString() eq 'ZAKOŃCZONY / FINISHED'}"/>
                                    <c:set var="isOrderForGuidelineSent" value="${concept.guideline ne null}"/>
                                    <c:if test="${isLoggedPM && isConceptFinished && !isOrderForGuidelineSent}">
                                        <a id="newFinalProjectOrderBtn" href="/guidelines/new/?conceptId=${concept.id}&backToPage=projects/details/${project.id}" class="btn btn-outline-success float-right ml-1">
                                            <p class="langPL">ZAMÓWIENIE PROJEKTU WYTYCZNYCH</p>
                                            <p class="langEN">ORDER FOR FINAL PLANNING PROJECT</p>
                                        </a>
                                    </c:if>
                                    <c:if test="${isLoggedPM && isConceptFinished && isOrderForGuidelineSent}">
                                        <a href="/guidelines/new/?conceptId=${concept.id}&backToPage=projects/details/${project.id}" class="btn btn-outline-success float-right ml-1 disabled">
                                            <p class="langPL">ZAMÓWIENIE PROJEKTU WYTYCZNYCH</p>
                                            <p class="langEN">ORDER FOR FINAL PLANNING PROJECT</p>
                                        </a>
                                    </c:if>
                                    <div class="btn btn-outline-dark disabled float-right">
                                        <p class="langPL">ROZWIŃ</p>
                                        <p class="langEN">UNHIDE</p>
                                    </div>
                                </div>
                                <%-- FINAL PLANNING (GUIDELINES) LIST --%>
                                <c:if test="${concept.guideline ne null}">
                                    <div class="card d-block float-left w-100 mt-2 border-left-0 border-right-0 border-50">
                                        <div class="card-header text-center">
                                            <p class="langPL">ZAMÓWIENIE PROJEKTU WYTYCZNYCH INSTALACYJNYCH</p>
                                            <p class="langEN">ORDER FOR FINAL PLANNING (GUIDELINES) PROJECT</p>
                                        </div>
                                        <div class="card-body">
                                            <div class="row h-100px">
                                                <div class="col-sm-1 <%--border border-dark--%> p-0 pr-sm-1">
                                                    <div class="border border-50 m-0 p-2 w-100">
                                                        <p class="langPL">ID:</p>
                                                        <p class="langEN">ID:</p>
                                                    </div>
                                                    <p class="text-left pt-2 pl-2">${concept.guideline.id}</p>
                                                </div>
                                                <div class="col-sm-3 <%--border border-dark--%> p-0 pr-sm-1">
                                                    <div class="border border-50 m-0 p-2 w-100">
                                                        <p class="langPL">UTWORZONO:</p>
                                                        <p class="langEN">CREATED:</p>
                                                    </div>
                                                    <p class="text-left pt-2 pl-2">${concept.guideline.dateTimeCreated.toLocalDate()}</p>
                                                </div>
                                                <div class="col-sm-3 <%--border border-dark--%> p-0 pr-sm-1">
                                                    <div class="border border-50 m-0 p-2 w-100">
                                                        <p class="langPL">TERMIN REALIZACJI:</p>
                                                        <p class="langEN">DEADLINE:</p>
                                                    </div>
                                                    <p class="text-left pt-2 pl-2">
                                                            ${concept.guideline.dateTimeDeadline.toLocalDate()}
<%--                                                            ${concept.guideline.dateTimeDeadline.toLocalTime()}--%>
                                                    </p>
                                                </div>
                                                <div class="col-sm-5 <%--border border-dark--%> p-0 pr-sm-1">
                                                    <div class="border border-50 m-0 p-2 w-100">
                                                        <p class="langPL">STATUS ZAMÓWIENIA PROJEKTU WYTYCZNYCH:</p>
                                                        <p class="langEN">ORDER FOR THE FINAL PLANNING (GUIDELINES) PROJECT STATUS:</p>
                                                    </div>
                                                    <c:choose>
                                                        <c:when test="${concept.guideline.status.toString() eq 'OCZEKUJE / WAITING'}">
                                                            <p class="text-left pt-2 pl-2 text-danger font-weight-bold">${concept.guideline.status.toString()}</p>
                                                        </c:when>
                                                        <c:when test="${concept.guideline.status.toString() eq 'W TOKU / IN PROGRESS'}">
                                                            <p class="text-left pt-2 pl-2 text-warning font-weight-bold">${concept.guideline.status.toString()}</p>
                                                        </c:when>
                                                        <c:when test="${concept.guideline.status.toString() eq 'ZAKOŃCZONY / FINISHED'}">
                                                            <p class="text-left pt-2 pl-2 text-success font-weight-bold">${concept.guideline.status.toString()}</p>
                                                        </c:when>
                                                    </c:choose>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-7 text-right ">
                                                    <p class="langPL">PROJEKTANT:</p>
                                                    <p class="langEN">DESIGNER:</p>
                                                </div>
                                                <div class="col-5">
                                                    <c:choose>
                                                        <c:when test="${concept.guideline.designer eq null}">
                                                            <p class="langPL">BRAK PRZYPISANEGO PROJEKTANTA</p>
                                                            <p class="langEN">NO DESIGNER ASSIGNED</p>
                                                        </c:when>
                                                        <c:when test="${concept.guideline.designer ne null}">
                                                            <p class="text-left pt-2 pl-2">${concept.guideline.designer.nameFirst} ${concept.guideline.designer.nameLast}</p>
                                                        </c:when>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-footer h-75px">
                                            <div>
                                                <a href="/guidelines/details/${concept.guideline.id}" class="btn btn-outline-primary float-right ml-1 disabled">
                                                    <p class="langPL">SZCZEGÓŁY</p>
                                                    <p class="langEN">DETAILS</p>
                                                </a>
                                            </div>
                                            <%-- BUTTON: ASSIGN DESIGNER TO GUIDELINE PROJECT --%>
                                            <c:if test="${concept.guideline.designer eq null && sessionScope.userLoggedIn.businessPosition.toString() eq 'Projektant/Planista / Designer/Planner'}">
                                                <c:if test="${concept.guideline.status.toString() eq 'OCZEKUJE / WAITING'}">
                                                    <a id="setMeAsDesignerGuidelinesBtn" href="/guidelines/setDesigner/${concept.guideline.id}/${sessionScope.userLoggedIn.id}?backToPage=projects/details/${project.id}" class="btn btn-outline-success float-right ml-1">
                                                        <p class="langPL">PRZYPISZ MNIE JAKO PROJEKTANTA</p>
                                                        <p class="langEN">ASSIGN ME AS A DESIGNER</p>
                                                    </a>
                                                </c:if>
                                            </c:if>
                                                <%-- BUTTON: SET GUIDELINE PROJECT AS FINISHED --%>
                                            <c:if test="${concept.guideline.designer ne null && sessionScope.userLoggedIn.businessPosition.toString() eq 'Projektant/Planista / Designer/Planner'}">
                                                <c:if test="${concept.guideline.status.toString() eq 'W TOKU / IN PROGRESS'}">
                                                    <a id="setGuidelinesFinishedBtn" href="/guidelines/setStatusFinished/${concept.guideline.id}?backToPage=projects/details/${project.id}" class="btn btn-outline-success float-right ml-1">
                                                        <p class="langPL">USTAW JAKO ZAKOŃCZONY</p>
                                                        <p class="langEN">SET AS FINISHED</p>
                                                    </a>
                                                </c:if>
                                            </c:if>
                                            <div class="btn btn-outline-dark disabled float-right">
                                                <p class="langPL">ROZWIŃ</p>
                                                <p class="langEN">UNHIDE</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>

                <div class="card-footer">
                    <c:choose>
                        <c:when test="${sessionScope.userLoggedIn.businessPosition.toString() ne 'Projektant/Planista / Designer/Planner'}">
                            <a id="newConceptBtn" href="/concepts/new?projectId=${project.id}&userId=${project.projectManager.id}&backToPage=/projects/details/${project.id}" class="btn btn-success float-right">
                                <div class="langPL">ZAMÓWIENIE PROJEKTU KONCEPCYJNEGO</div>
                                <div class="langEN">ORDER FOR CONCEPTUAL (PRELIMINARY PROJECT)</div>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a id="newConceptBtn" href="/concepts/new?projectId=${project.id}&userId=${project.projectManager.id}" class="btn btn-success float-right disabled">
                                <div class="langPL">ZAMÓWIENIE PROJEKTU KONCEPCYJNEGO</div>
                                <div class="langEN">ORDER FOR CONCEPTUAL (PRELIMINARY PROJECT)</div>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>


    <jsp:include page="../footer.jsp"/>

</body>
</html>
