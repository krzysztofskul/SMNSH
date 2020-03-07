<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 02.03.2020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form method="post" modelAttribute="project">
            <div class="card">

                <div class="card-header">
                    <div class="row border-bottom pb-2">
                        <div class="col-12 text-center">
                            <c:set var="pageTitlePL" value="SZCZEGÓŁY PROJEKTU"/>
                            <c:set var="pageTitleEN" value="PROJECT DETAILS"/>
                            <c:if test="${edit eq true}">
                                <c:set var="pageTitlePL" value="EDYCJA PROJEKTU"/>
                                <c:set var="pageTitleEN" value="PROJECT EDIT"/>
                            </c:if>
                            <p class="langPL">${pageTitlePL}</p>
                            <p class="langEN">${pageTitleEN}</p>
                        </div>
                    </div>
                    <div class="row border-bottom">
                        <div class="col-sm-1 text-right pt-2">
                            <p class="langPL"> ID:</p>
                            <p class="langEN"> ID:</p>
                        </div>
                        <div class="col-sm-1 text-left pt-2">
                            ${project.id}
                            <c:if test="${edit eq true}">
                                <form:hidden path="id"/>
                            </c:if>
                        </div>
                        <div class="col-2 text-right pt-2">
                            <p class="langPL">NAZWA PROJEKTU:</p>
                            <p class="langEN">PROJECT NAME:</p>
                        </div>
                        <div class="col-2 text-left pt-2">
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
                                    <form:input path="agreementNo"/>
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
                                    <form:input path="investor"/>
                                    <form:errors path="investor" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.investor}
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
                                    <form:input path="recipient"/>
                                    <form:errors path="recipient" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.recipient}
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <div class="row border-bottom">
                        <div class="col-3 text-right pt-2">
                            <p class="langPL">HANDLOWIEC:</p>
                            <p class="langEN">SALES REP.:</p>
                        </div>
                        <div class="col-3 text-left pt-2">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:input path="sls"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.sls}
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
                                    <form:select path="projectManager.id">
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
                                    ${project.projectManager.nameFirst} ${project.projectManager.nameFirst}
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
                                    <form:input path="buildingContractor"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.buildingContractor}
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
                                    <form:input type="date" path="deadline"/>
                                    <form:errors path="deadline" cssClass="error"/>
                                </c:when>
                                <c:otherwise>
                                    ${project.deadline.toLocalDate()} ${project.deadline.toLocalTime()}
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-2"></div>
                        <div class="col-3 text-right pt-2 float-right">
                            <p class="langPL">STATUS:</p>
                            <p class="langEN">STATUS:</p>
                        </div>
                        <div class="col-3 pt-2 float-right">
                            <c:choose>
                                <c:when test="${edit eq true}">
                                    <form:select path="status" items="${allStatusesProject}" itemLabel="name"/>
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
                    <div class="row border-bottom pb-2">
                        <div class="col-12 text-center">
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
                                <div class="row">
                                    <div class="col-12">
                                        <span class="font-weight-bold">${device.deviceCategory.name}</span> ${device.model}
                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <div class="row border-bottom border-top">
                        <div class="col-12 text-center">
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
                                    <span class="font-italic">${project.remarks}</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>

                <div class="card-footer">

                    <c:set var="backTo" value="/projects/all"/>
                    <c:set var="forwardTo" value="/projects/details/${project.id}?edit=true"/>
                    <c:set var="forwardBtnPL" value="EDYCJA"/>
                    <c:set var="forwardBtnEN" value="EDIT"/>
                    <c:set var="forwardClr" value="btn-primary"/>
                    <c:if test="${edit eq true}">
                        <c:set var="backTo" value="/projects/details/${project.id}"/>
                        <c:set var="forwardTo" value="/projects/details/${project.id}"/>
                        <c:set var="forwardBtnPL" value="ZAPISZ"/>
                        <c:set var="forwardBtnEN" value="SAVE"/>
                        <c:set var="forwardClr" value="btn-success"/>
                    </c:if>

                    <a href="${backTo}" class="btn btn-warning float-left">
                        <p class="langPL">WSTECZ</p>
                        <p class="langEN">BACK</p>
                    </a>

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
                </div>

            </div>
        </form:form>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
