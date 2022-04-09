<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <jsp:include page="../../header.jsp"/>

    <jsp:include page="../project-menu.jsp">
    	<jsp:param name="projectCharter" value="${project.projectCharter}"/>
    	<jsp:param name="project" value="${project}"/>
    </jsp:include>

    <div class="container">
		
		<c:forEach items="${configurationList}" var="configuration">
    
		<%--DEVICE NAME--%>
		<div class="row pt-1 pb-2 border-top border-bottom border-dark no-gutters">
		    <div class="col-6">
		        <p style="top: 25%; position: absolute">
		            ${configuration.device.deviceCategory.name}
		        </p>
		    </div>
		    <div class="col-4 font-weight-bold">
		        <p style="top: 25%; position: absolute">
		            ${configuration.device.model}
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
                        <c:if test="${sessionScope.userLoggedIn.businessPosition eq 'SALES_REP'}">
                            <button class="btn btn-sm btn-danger" disabled>DEL</button>
                        </c:if>
                    </div>
                </div>
                </c:forEach>
            </div>
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
  
	</div>
	
	    <jsp:include page="../../footer.jsp"/>

</body>
</html>