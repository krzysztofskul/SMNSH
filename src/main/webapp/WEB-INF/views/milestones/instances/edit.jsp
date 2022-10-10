<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

    <header>
        <jsp:include page="../../header.jsp"/>
    </header>

    <main>
        
        <div class="test invisible position-absolute">
            <h1>Test for new milestone instance page</h1>
            <h2>Project charter id: ${param.projectCharterId}</h2>
            <h2>Back to page: ${param.backToPage}</h2>
        </div>
        
        <div class="content container-sm">
        	
        	<form:form action="/milestones/instances/saveEdited?backToPage=${param.backToPage}" method="post" modelAttribute="milestoneInstance">
        	
	        	<div class="card">
	        	
	        		<div class="card-header text-center">
	        			<p class="langPL">FOMRULARZ EDYCJI NOWEGO KAMIENIA MILOWEGO</p>
	        			<p class="langEN">EDIT MILESTONE FORM</p>
	        		</div>
	        		

	        		<div class="card-body">
	        			
	        			<%-- <form:input path="codeName"/>
		        		<form:input path="namePL"/>
		        		<form:input path="nameEN"/>
		        		<form:input path="Description"/> 
		        		--%>
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">-:</p>
	        					<p class="langEN">CODE NAME:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="id"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">-:</p>
	        					<p class="langEN">CODE NAME:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="codeName"/>
	        				</div>
	        			</div>
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">NAZWA KAMIENIA MILOWEGO (PL):</p>
	        					<p class="langEN">MILESTONE NAME (PL):</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="namePL"/>
	        				</div>
	        			</div>

	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">NAZWA KAMIENIA MILOWEGO (EN):</p>
	        					<p class="langEN">MILESTONE NAME (EN):</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="nameEN"/>
	        				</div>
	        			</div>

	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">OPIS:</p>
	        					<p class="langEN">DESCRIPTION:</p>
	        				</div>
	        				<div class="col">
	        					<form:textarea path="description" style="width: 100%; min-height: 6em"/>
	        				</div>
	        			</div>

						<hr>
						
						
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">PLANOWANA DATA ROZPOCZĘCIA:</p>
	        					<p class="langEN">DATE START PLANNED:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="milestoneTimeline.dateStartPlanned"/>
	        				</div>
	        			</div>
	        			
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">PLANOWANA DATA ZAKOŃCZENIA:</p>
	        					<p class="langEN">DATE FINISH PLANNED:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="milestoneTimeline.dateFinishPlanned"/>
	        				</div>
	        			</div>
	        			
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">DATA ROZPOCZĘCIA:</p>
	        					<p class="langEN">DATE STARTED:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="milestoneTimeline.dateStarted"/>
	        				</div>
	        			</div>
	        			
	        			
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">DATA ZAKOŃCZENIA:</p>
	        					<p class="langEN">DATE FINISHED:</p>
	        				</div>
	        				<div class="col">
	        					<form:input path="milestoneTimeline.dateFinished"/>
	        				</div>
	        			</div>

	        			 
	        		</div>
	        		
	        		
	        		<div class="card-footer">
	        			<a href="/project-charter/${projectCharterId}" class="btn btn-outline-warning float-left">
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