<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>SMNSH</title>	
    <!--jQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <%--bootstrap--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%--css--%>
    <link rel="stylesheet" type="text/css" href="/resources/css/card.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/row.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/cards-in-columns.css"/>
    <!--JS files-->
    <script src="<c:url value="/resources/js/projectCharter/projectCharter.js"/>" type="text/javascript"></script>
</head>

<body>

    <header>
        <jsp:include page="../header.jsp"/>
    	<jsp:include page="../projects/project-menu.jsp">
    		<jsp:param value="${projectCharter}" name="projectCharter"/>
    	</jsp:include>
    </header>

	<div class="content container-fluid">
	
		<c:forEach items="${project.deviceList}" var="device">
		<c:set var="matched" value="false"/>
		<div class="card m-5">
			<div class="card-header">
				<div class="row">
					<div class="col-8">
						<span class="font-weight-bold">${device.deviceCategory.code}</span> ${device.deviceCategory.name} <span class="font-weight-bold">${device.model}</span>
					</div>
					<div class="col-4 text-right">
						<a href="/concepts/new?userId=${sessionScope.userLoggedIn.id}&projectId=${project.id}&backToPage=/projects/${project.id}/technical-documentation">
							<button class="btn btn-outline-success">+</button>
						</a>
					</div>
				</div>
			</div>
			<div class="card-body">
			
				<div class="row cards-in-columns">
				
					<div class="col">
						<c:forEach items="${conceptList}" var="concept" varStatus="loopStatus">
							<c:choose>
							<c:when test="${concept.device.id eq device.id }">
								<c:set var="matched" value="true"/>
								<div class="card">
									<div class="card-header">
										<div class="col-12">
											<p class="langPL">PROJEKT KONCEPCYJNY</p>
											<p class="langEN">CONCEPTUAL PROJECT</p>
										</div>
									</div>
									<div class="card-body">
										<div class="row middle-row">

											<div class="col-2 col-title">
												<p class="langPL">WYSŁANO</p>
												<p class="langEN">SENT</p>
											</div>
											<div class="col-2 col-value">
												${concept.dateTimeCreated.toLocalDate()}
											</div>
											<div class="col-2 col-title">
												<p class="langPL">PROJEKTANT</p>
												<p class="langEN">DESIGNER</p>
											</div>
											<div class="col-6 col-value">
												${concept.planner.nameFirst} ${concept.planner.nameLast}
											</div>
										</div>
										<div class="row middle-row">
	
											<div class="col-2 col-title">
												<p class="langPL">TERMIN REALIZACJI</p>
												<p class="langEN">DEADLINE</p>
											</div>
											<div class="col-2 col-value">
												${concept.dateTimeDeadline.toLocalDate()}
											</div>
	
	
											<div class="col-2 col-title">
												<p class="langPL">STATUS</p>
												<p class="langEN">STATUS</p>
											</div>
											<div class="col-6 col-value">
												${concept.status.getNamePL()}
											</div>
										</div>
									</div>
								</div>						
							</c:when>
							<c:otherwise>
								<c:if test="${matched eq false && loopStatus.isLast() eq true}">
									<p class="langPL">BRAK PROJEKTÓW KONCEPCJI</p>
									<p class="langEN">NO CONCEPTUAL DESIGNS</p>
								</c:if>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
	
		
				</div>
			</div>
		</div>
		</c:forEach>	
	</div>

    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>

</body>
</html>