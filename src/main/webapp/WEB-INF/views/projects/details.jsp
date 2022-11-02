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
    <%--css--%>
    <link rel="stylesheet" type="text/css" href="/resources/css/cards-in-columns.css"/>
    <!--jQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <%--JS--%>
    <script src="/resources/js/projects/details.js" type="text/javascript"></script>

</head>
<body>

    <jsp:include page="../header.jsp"/>

    <jsp:include page="./project-menu.jsp"/>

    <div class="container-fluid">

        <form:form method="post" modelAttribute="project">
		    <c:if test="${edit eq true}">
		        <form:hidden path="id"/>
		        <form:select path="configurationList" multiple="true" hidden="true">
		                <c:forEach items="${project.configurationList}" var="configuration">
		                        <form:option value="${configuration.id}" label="configuration id: ${configuration.id}" selected="true"/>
		                </c:forEach>
		         </form:select>
		    </c:if>
        
        	<!-- NEW VERSION -->
        	<div class="row cards-in-columns">
	       		<div class="col" >
	       			<div class="card">
	       				<div class="card-header">
	       					<div class="row mb-1">
	       						<div class="col-10">
			       					<p class="langPL">SZCZEGÓŁY PROJEKTU</p>
			       					<p class="langEN">PROJECT DETAILS</p>
		       					</div>
		       					<div class="col-2">
							            <div class="text-left position-relative d-inline-block mr-2">
							                <p class="langPL"> ID:</p>
							                <p class="langEN"> ID:</p>
							            </div>
							            <div id="projectId" class="text-left position-relative d-inline-block align-top pt-1">
							                ${project.id}
							            </div>
		       					</div>
	       					</div>
						    <div class="row border-top pt-2">
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
						    	<div class="col-sm-4">
						            <a href="${backTo}" class="btn btn-outline-warning float-left mr-2">
						                <p class="langPL">WSTECZ</p>
						                <p class="langEN">BACK</p>
						            </a>
					            </div>
						        <div class="col-sm-8">

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
						            <a href="/logs/project/${project.id}" class="btn btn-outline-dark float-right mr-2">
						                <p class="langPL">HISTORIA</p>
						                <p class="langEN">HISTORY</p>
						            </a>
						            <a href="/projects/details/${project.id}/comments" class="btn btn-outline-dark float-right mr-2">
						                <p class="langPL">KOMENTARZE</p>
						                <p class="langEN">COMMENTS</p>
						            </a>

						        </div>
						    </div>
	       				</div>
	       				<div class="card-body" style="min-height: 150px">									    


							    <div class="row first-row">
							        <div class="col-4 col-title">
							            <p class="langPL">NR PROJEKTU:</p>
							            <p class="langEN">PROJECT NO.:</p>
							        </div>
							        <div class="col-8 col-value">
					                    ${project.detailsSls.slsCodeShort}
							        </div>
						        </div>

							    <div class="row first-row">
							        <div class="col-4 col-title">
							            <p class="langPL">NAZWA PROJEKTU:</p>
							            <p class="langEN">PROJECT NAME:</p>
							        </div>
							        <div class="col-8 col-value">
							            <c:choose>
							                <c:when test="${edit eq true}">
							                    <form:input path="projectName"/>
							                </c:when>
							                <c:otherwise>
							                    ${project.projectName}
							                </c:otherwise>
							            </c:choose>
							        </div>
						        </div>
						        <div class="row middle-row">
							        <div class="col-4 col-title">
							            <p class="langPL">NR UMOWY:</p>
							            <p class="langEN">AGREEMENT NO.:</p>
							        </div>
							        <div class="col-8 col-value">
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
							
							    <div class="row middle-row">
							        <div class="col-4 col-title">
							            <p class="langPL">INWESTOR:</p>
							            <p class="langEN">INVESTOR.:</p>
							        </div>
							        <div class="col-8 col-value">
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
						        </div>
						        <div class="row middle-row">
							        <div class="col-4 col-title">
							            <p class="langPL">MIEJSCE DOSTAWY:</p>
							            <p class="langEN">CUSTOMER:</p>
							        </div>
							        <div class="col-8 col-value">
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
							
							    <div class="row middle-row">
							        <div class="col-3 col-title">
							            <p class="langPL">HANDLOWIEC:</p>
							            <p class="langEN">SALES REP.:</p>
							        </div>
							        <div class="col-3 col-value">
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
							        <div class="col-3 col-title">
							            <p class="langPL">KIEROWNIK PROJEKTU:</p>
							            <p class="langEN">PROJECT MANAGER:</p>
							        </div>
							        <div class="col-3 col-value">
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
							
							    <div class="row middle-row">
							        <div class="col-3 col-title">
							            <p class="langPL">WYKONAWCA ADAPTACJI:</p>
							            <p class="langEN">BUILDING CONTRACTOR:</p>
							        </div>
							        <div class="col-3 col-value">
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
							        <div class="col-3 col-title">
							            <p class="langPL">TERMIN REALIZACJI:</p>
							            <p class="langEN">DEADLINE:</p>
							        </div>
							        <div class="col-3 col-value">
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
							    <div class="row last-row">
							        <div class="col-6"></div>
							        <div class="col-3 col-title">
							            <p class="langPL">STATUS PROJEKTU:</p>
							            <p class="langEN">PROJECT STATUS:</p>
							        </div>
							        <div class="col-3 col-value">
							            <c:choose>
							                <c:when test="${edit eq true}">
							                    <form:select path="status" items="${allStatusesProject}" itemLabel="name" cssClass="w-100"/>
							                    <form:errors path="status" cssClass="error"/>
							                </c:when>
							                <c:otherwise>
							                    <p class="langPL">${project.status.getNamePL()}</p>
							                    <p class="langEN">${project.status.getNameEN()}</p>
							                </c:otherwise>
							            </c:choose>
							        </div>
							    </div>
							
	       				</div>
	       			</div>
	       			<div class="card">
	       				<div class="card-header">URZĄDZENIA DO INSTALACJI</div>
	       				<div class="card-body" style="min-height: 150px">
                        <c:if test="${edit eq true}">
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
                        </c:if>
                        <c:if test="${edit ne true}">
							<c:forEach items="${project.deviceList}" var="device">
								<div class="row first-row">
									<div class="col-2 font-weight-bold">
										${device.deviceCategory.code}
									</div>
									<div class="col-6">
										${device.deviceCategory.name}
									</div>
									<div class="col-4 font-weight-bold">
										${device.model}
									</div>
									 
								</div>
							</c:forEach>
						</c:if>
	       				</div>
	       			</div>	       			
	       			<div class="card">
	       				<div class="card-header">ZAŁĄCZNIKI</div>
	       				<div class="card-body" style="height: 150px">lorem ipsum</div>
	       			</div>	       			
	       		</div>
	       		<div class="col">
	       			<div class="card">
	       				<div class="card-header">UWAGI</div>
	       				<div class="card-body" style="height: 150px">lorem ipsum</div>
	       			</div>
	       			<div class="card">
	       				<div class="card-header">KOMENTARZE</div>
	       				<div class="card-body" style="height: 150px">lorem ipsum</div>
	       			</div>
	       		</div>
	       		<div class="col">
	       			<div class="card">
	       				<div class="card-header">
	       					<p class="langPL">HISTORIA PROJEKTU</p>
	       					<p class="langEN">PROJECT HISTORY</p>
       					</div>
	       				<div class="card-body" style="height: 750px">
	       					<c:forEach items="${project.loggerProjectList}" var="logger">
	       						<div class="row middle-row">
	       							<div class="col-3">
	       								<p>
	       									${logger.localDateTime.toLocalDate()}
	       									<br>
	       									${logger.localDateTime.toLocalTime()}
	       								</p>
	       								
	       							</div>
	       							<div class="col-5">${logger.actionPL}</div>
	       							<div class="col-3">${logger.actionBy}</div>
	       						</div>
	       					</c:forEach>
	       				</div>
	       			</div>
	       		</div>
        	</div>
      

        </form:form>
    </div>


    <jsp:include page="../footer.jsp"/>

</body>
</html>
