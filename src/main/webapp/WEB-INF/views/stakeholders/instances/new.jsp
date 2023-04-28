<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <header>
        <jsp:include page="../../header.jsp"/>
    </header>

    <main>
        <div class="test invisible position-absolute">
            <h1>Test for new stakeholder instance page</h1>
            <h2>Project charter id: ${param.projectCharterId}</h2>
            <h2>Back to page: ${param.backToPage}</h2>
        </div>
        
        <div class="content container-sm">
        
		  	<form:form action="/stakeholders/instances/new?projectCharterId=${param.projectCharterId}&backToPage=project-charter/${param.projectCharterId}" method="post" modelAttribute="stakeholder">
        		
        		<form:hidden path="id"/>
        		<%-- <form:hidden path="user.id"/> --%>
        		
        		<%-- <form:hidden path="projectCharters"/> --%>
				<c:forEach items="${stakeholder.projectCharters}" var="projectCharter">
				   <%-- ${projectCharter.id} <form:checkbox path="projectCharters" value="${projectCharter.id}" checked="checked"/> --%>
				</c:forEach>
        		
        		<!-- TODO
        		<form:hidden path="stakeholderInProjectDetailsList"/>
        		-->
        		
        		<%-- <input type="text" name="backToPage" value="${param.backToPage}") hidden/> --%>
        		<%-- <input type="text" name="projectCharterId" value="${param.projectCharterId}" hidden/> --%>
        		
        		<div class="card">

	        		<div class="card-header text-center">
	        			<p class="langPL">FOMRULARZ DODAWANIA INTERESARIUSZA DO PROJEKTU</p>
	        			<p class="langEN">NEW STAKEHOLDER FORM</p>
	        		</div>

	        		<div class="card-body">
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">ID KARTY PROJEKTU:</p>
	        					<p class="langEN">PROJECT CHARTER ID:</p>
	        				</div>
	        				<div class="col">
	        					<%-- <input type="text" disabled="disabled" name="projectCharterId" value="${param.projectCharterId}"/> --%>
	        					${param.projectCharterId}
	        				</div>
	        			</div>
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">IMIĘ:</p>
	        					<p class="langEN">FIRST NAME:</p>
	        				</div>
	        				<div class="col">
	        					<!-- <input type="text" name="nameFirst"/> -->
	        					<form:input path="nameFirst"/>
	        				</div>
	        			</div>

	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">MAZWISKO:</p>
	        					<p class="langEN">SURNAME:</p>
	        				</div>
	        				<div class="col">
	        					<!-- <input type="text" name="nameLast"/> -->
	        					<form:input path="nameLast"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">FIRMA:</p>
	        					<p class="langEN">COMPANY:</p>
	        				</div>
	        				<div class="col">
	        					<!-- <input type="text" name="company"/> -->
	        					<form:input path="company"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">STANOWISKO:</p>
	        					<p class="langEN">BUSINESS POSITION:</p>
	        				</div>
	        				<div class="col">
	        					<!-- <input type="text" name="stakeholderBusinessPosition"/> -->
	        					<form:input path="stakeholderBusinessPosition"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">E-MAIL:</p>
	        					<p class="langEN">E-MAIL:</p>
	        				</div>
	        				<div class="col">
	        					<!-- <input type="text" name="email"/> -->
	        					<form:input path="email"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">Nr  tel.:</p>
	        					<p class="langEN">Phone no.:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="phoneNo"/>
	        				</div>
	        			</div>
	        			
	        		</div>
	        		
	        		<div class="card-footer">
	        			<a href="/project-charter/${param.projectCharterId}" class="btn btn-outline-warning float-left">
	        				<p class="langPL">ANULUJ</p>
	        				<p class="langEN">CANCEL</p>
	        			</a>
	        			<button class="btn btn-outline-success float-right" type="submit">
	        				<p class="langPL">ZAPISZ</p>
	        				<p class="langEN">SAVE</p>
	        			</button>
	        		</div>
	        		
	        	</div>
        		
        	</form:form>
        </div>
        
	</main>

    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>

</body>
</html>