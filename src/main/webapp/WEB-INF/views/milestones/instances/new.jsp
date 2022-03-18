<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        	
        	<form action="/milestones/instances/new" method="post">
        	
        		<input type="text" name="backToPage" value="${param.backToPage}") />
        		<input type="text" name="projectCharterId" value="${param.projectCharterId}" />
        	
	        	<div class="card">
	        	
	        		<div class="card-header text-center">
	        			<p class="langPL">FOMRULARZ TWORZENIA NOWEGO KAMIENIA MILOWEGO</p>
	        			<p class="langEN">NEW MILESTONE FORM</p>
	        		</div>
	        		
	        		<div class="card-body">
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">ID KARTY PROJEKTU:</p>
	        					<p class="langEN">PROJECT CHARTER ID:</p>
	        				</div>
	        				<div class="col">
	        					<input type="text" disabled="disabled" name="projectCharterId" value="${param.projectCharterId}"/>
	        				</div>
	        			</div>
	        			
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">NAZWA KAMIENIA MILOWEGO (PL):</p>
	        					<p class="langEN">MILESTONE NAME (PL):</p>
	        				</div>
	        				<div class="col">
	        					<input type="text" name="namePL"/>
	        				</div>
	        			</div>

	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">NAZWA KAMIENIA MILOWEGO (EN):</p>
	        					<p class="langEN">MILESTONE NAME (EN):</p>
	        				</div>
	        				<div class="col">
	        					<input type="text" name="nameEN"/>
	        				</div>
	        			</div>

	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">OPIS:</p>
	        					<p class="langEN">DESCRIPTION:</p>
	        				</div>
	        				<div class="col">
	        					<textarea name="description" style="width: 100%; min-height: 6em"></textarea>
	        				</div>
	        			</div>

						<hr>

	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">PLANOWANA DATA ROZPOCZĘCIA:</p>
	        					<p class="langEN">DATE START PLANNED:</p>
	        				</div>
	        				<div class="col">
	        					<input type="date" name="dateStartPlanned"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">PLANOWANA DATA ZAKOŃCZENIA:</p>
	        					<p class="langEN">DATE FINISH PLANNED:</p>
	        				</div>
	        				<div class="col">
	        					<input type="date" name="dateFinishPlanned"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">DATA ROZPOCZĘCIA:</p>
	        					<p class="langEN">DATE STARTED:</p>
	        				</div>
	        				<div class="col">
	        					<input type="date" name="dateStarted"/>
	        				</div>
	        			</div>
	        			<div class="row">
	        				<div class="col text-right">
	       						<p class="langPL">DATA ZAKOŃCZENIA:</p>
	        					<p class="langEN">DATE FINISHED:</p>
	        				</div>
	        				<div class="col">
	        					<input type="date" name="dateFinished"/>
	        				</div>
	        			</div>
	        			
	        		</div>
	        		
	        		<div class="card-footer">
	        			<button class="btn btn-outline-warning float-left disabled">
	        				<p class="langPL">ANULUJ</p>
	        				<p class="langEN">CANCEL</p>
	        			</button>
	        			<button class="btn btn-outline-success float-right" type="submit">
	        				<p class="langPL">ZAPISZ</p>
	        				<p class="langEN">SAVE</p>
	        			</button>
	        		</div>
	        		
	        	</div>
        	</form>
        
        </div>
        
	</main>

    <footer>
        <jsp:include page="../../footer.jsp"/>
    </footer>

	
</body>
</html>