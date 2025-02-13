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

	<!--JQuery  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <!--JS files-->
    <script src="<c:url value="/resources/js/projects/new.js"/>" type="text/javascript"></script>
    <%--
    	<script src="<c:url value="/resources/js/projects/new3testJQuery.js"/>" type="text/javascript"></script>
     --%>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form id="formNewProject" method="post" modelAttribute="projectNew" enctype="multipart/form-data">
            <div class="card smnshCard">

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
                            <p class="langPL">NR PROJEKTU:</p>
                            <p class="langEN">PROJECT NO.:</p>
                        </div>
                        <div class="col-8">
                            <c:choose>
                                <c:when test="${sessionScope.demoSession == null}">
                                    <form:input path="detailsSls.slsCodeShort" cssClass="w-100" value="TST0000"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input  path="detailsSls.slsCodeShort" value="TST0000" disabled="true" cssClass="w-100"/>
                                    <form:hidden path="detailsSls.slsCodeShort" value="TST0000"/>
                                </c:otherwise>

                            </c:choose>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">NAZWA PROJEKTU:</p>
                            <p class="langEN">PROJECT NAME:</p>
                        </div>
                        <div class="col-8">
                            <c:choose>
                                <c:when test="${sessionScope.demoSession == null}">
                                    <form:input path="projectName" cssClass="w-100" value="Projekt testowy"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input  path="projectName" value="DEMO PROJECT NAME" disabled="true" cssClass="w-100"/>
                                    <form:hidden path="projectName" value="DEMO PROJECT NAME"/>
                                </c:otherwise>

                            </c:choose>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">INWESTOR/KLIENT:</p>
                            <p class="langEN">INVESTOR:</p>
                        </div>
                        <div class="col-8">
                            <form:select path="investor.id" cssClass="w-100">
                                <c:forEach items="${investors}" var="investor">
                                    <form:option value="${investor.id}" label="${investor.name}"/>
                                </c:forEach>
                            </form:select>
                            <form:errors path="investor" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">MIEJSCE DOSTAWY:</p>
                            <p class="langEN">INSTALLATION PLACE:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="recipient" cssClass="w-100" value="ul. Testowa"/>
                            <form:errors path="recipient" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">NUMER UMOWY:</p>
                            <p class="langEN">AGREEMENT NO:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="agreementNo" cssClass="w-100" value="TEST-2023-00-00"/>
                            <form:errors path="agreementNo" cssClass="error"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">WYKONAWCA ADAPTACJI:</p>
                            <p class="langEN">BUILDING CONTRACTOR:</p>
                        </div>
                        <div class="col-8">
                            <form:select path="subcontractor.id" cssClass="w-100">
                            <form:option value="0">---</form:option> 
                                <c:forEach items="${subcontractorsForRoomAdaptation}" var="subcontractor">
                                        <form:option value="${subcontractor.id}" label="${subcontractor.name}"/>
                                </c:forEach>
                            </form:select>
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
                            <form:select path="status" items="${allStatusesProject}" itemLabel="name" cssClass="w-100"/>
                            <form:errors path="status" cssClass="error"/>
                        </div>
                    </div>

                    <hr>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">PRZEDSTAWICIEL HANDLOWY:</p>
                            <p class="langEN">SALES REP.:</p>
                        </div>
                        <c:choose>
                            <c:when test="${sessionScope.userLoggedIn.businessPosition.toString() eq 'Przedstawiciel handlowy / Sales rep.'}">
                                <div class="col-8">
                                    <form:input path="sls.id" cssClass="w-100" value="${sessionScope.userLoggedIn.nameFirst} ${sessionScope.userLoggedIn.nameLast}" disabled="true"/>
                                    <form:hidden path="sls.id" value="${sessionScope.userLoggedIn.id}"/>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-8">
                                    <%--<form:input path="sls" cssClass="w-100"/>--%>
                                    <form:select path="sls.id" cssClass="w-100">
                                        <c:forEach items="${allSlsList}" var="sls">
                                            <form:option value="${sls.id}" label="${sls.nameFirst} ${sls.nameLast}"/>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <form:errors path="sls" cssClass="error"/>
                            </c:otherwise>
                        </c:choose>

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
                            <p class="langPL">ZASTĘPCA KIEROWNIKA PROJEKTU:</p>
                            <p class="langEN">V-CE PROJECT MANAGER:</p>
                        </div>
                        <div class="col-8">
                            <form:select path="projectManagerAssistant.id" cssClass="w-100">
                                <c:forEach items="${allProjectManagerList}" var="projectManager">
                                    <form:option value="${projectManager.id}" label="${projectManager.nameFirst} ${projectManager.nameLast}"/>
                                </c:forEach>
                            </form:select>
                        </div>
                        <form:errors path="projectManager" cssClass="error"/>
                    </div>

					<hr>

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
                    	<div class="col-1">
                    		<button type="button" class="btn btn-sm" id="btn-search-devices" style="font-size: 2em">&#9783;</button>
                    	</div>
                        <div class="col-3 text-right">
                            <p class="langPL">LISTA URZĄDZEŃ:</p>
                            <p class="langEN">DEVICE LIST:</p>
                        </div>
                        <div class="col-8">
                            <form:select path="prototypeList" id="prototypeListSelect" cssClass="w-100" multiple="true">
                                <%-- <c:forEach items="${allDeviceList}" var="device"> --%>
                                <c:forEach items="${allProtopyteDeviceList}" var="device">
                                    <%-- <form:option label="${device.deviceCategory.name} ${device.model}" value="${device.id}"/> --%>
                                    <form:option label="${device.modelName}" value="${device.id}"/>
                                </c:forEach>
                            </form:select>
                            <form:errors path="deviceList" cssClass="error"/>
                        </div>
                    </div>

                    <hr>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">SZKOLENIA:</p>
                            <p class="langEN">TRAININGS:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="trainings" cssClass="w-100" disabled="true"/>
                        </div>
                    </div>

                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">UWAGI:</p>
                            <p class="langEN">REMARKS:</p>
                        </div>
                        <div class="col-8">
                            <form:textarea path="remarks" cssClass="myTextarea" value="Projekt trudny; po przetargu publicznym;"/>
                        </div>
                    </div>

	                <div class="card-footer">
	                    <c:if test="${backToPage ne null}">
	                        <input type="hidden" name="backToPage" value="${backToPage}">
	                    </c:if>
	                    <a href="/projects/all" class="btn btn-warning float-left">
	                        <p class="langPL">ANULUJ</p>
	                        <p class="langEN">CANCEL</p>
	                    </a>
	                    <form:button type="submit" id="projectNewBtnSave" class="btn btn-success float-right">
	                        <p class="langPL">ZAPISZ</p>
	                        <p class="langEN">SAVE</p>
	                    </form:button>
	                </div>

	            </div>
            </div>
        </form:form>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
