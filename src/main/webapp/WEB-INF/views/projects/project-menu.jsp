<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div class="container-fluid bg-light border mb-5">
			
		<c:if test="${null eq project}">
			<c:set var="projectId" value="${projectCharter.project.id}"/>
			<c:set var="projectCharterId" value="${projectCharter.id}"/>
		</c:if>
			<c:if test="${null eq projectCharter}">
			<c:set var="projectId" value="${project.id}"/>
			<c:set var="projectCharterId" value="${project.projectCharter.id}"/>
		</c:if>

        <ul class="nav nav-pills">
            <li class="nav-item ml-auto mr-auto text-center">
                <a class="nav-link btn btn-light" href="/projects/details/${projectId}">
                    <p class="langPL">WIDOK SZCZEGÓŁÓW PROJEKTU</p>
                    <p class="langEN">PROJECT DETAILS VIEW</p>
                </a>
            </li>
            <li class="nav-item  ml-auto mr-auto text-center">
                <a class="nav-link btn btn-light" href="/project-charter/${projectCharterId}">
                    <p class="langPL">WIDOK KARTY PROJEKTU</p>
                    <p class="langEN">PROJECT CHARTER VIEW</p>
                </a>
            </li>
            <li class="nav-item  ml-auto mr-auto text-center">
                <a class="nav-link btn btn-light" href="/projects/${projectId}/configuration/">
                    <p class="langPL">WIDOK KONFIGURACJI URZĄDZEŃ</p>
                    <p class="langEN">DEVICES CONFIGURATION VIEW</p>
                </a>
            </li>
            <li class="nav-item  ml-auto mr-auto text-center">
                <a class="nav-link btn btn-light" href="/projects/${projectId}/technical-documentation">
                    <p class="langPL">WIDOK DOKUMENTACJI TECHNICZNEJ</p>
                    <p class="langEN">TECHNICAL DOCUMENTATION VIEW</p>
                </a>
            </li>
			<li class="nav-item  ml-auto mr-auto text-center">
                <a class="nav-link btn btn-light" href="/projects/${projectId}/attachments">
                    <p class="langPL">ZAŁĄCZNIKI</p>
                    <p class="langEN">ATTACHMENTS</p>
                </a>
            </li>
            <li class="nav-item  ml-auto mr-auto text-center">
                <%-- <a class="nav-link btn btn-light" href="/generate-kpds/${projectId}"> --%>
                <a class="nav-link btn btn-light" href="/inprogress">                
                    <p class="langPL">GENERUJ I WYŚLIJ KPDS</p>
                    <p class="langEN">GENERATE AND SEND KPDS</p>
                </a>
            </li>
		</ul>
	</div>

</body>
</html>