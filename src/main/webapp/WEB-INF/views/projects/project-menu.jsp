<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${null eq project}">
		<c:set var="projectId" value="${projectCharter.project.id}"/>
		<c:set var="projectCharterId" value="${projectCharter.id}"/>
	</c:if>
		<c:if test="${null eq projectCharter}">
		<c:set var="projectId" value="${project.id}"/>
		<c:set var="projectCharterId" value="${project.projectCharter.id}"/>
	</c:if>

    <div class="container-fluid">
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link btn btn-light" href="/projects/details/${projectId}">
                    <p class="langPL">WIDOK SZCZEGÓŁÓW PROJEKTU</p>
                    <p class="langEN">PROJECT DETAILS VIEW</p>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-light" href="/project-charter/${projectCharterId}">
                    <p class="langPL">WIDOK KARTY PROJEKTU</p>
                    <p class="langEN">PROJECT CHARTER VIEW</p>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-light" href="#">
                    <p class="langPL">WIDOK KONFIGURACJI URZĄDZEŃ</p>
                    <p class="langEN">DEVICES CONFIGURATION VIEW</p>
                </a>
            </li>
		</ul>
		
	</div>

</body>
</html>