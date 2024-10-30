<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	
		<!--JQuery  -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
	
	</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="content container-fluid">
    	<!-- FORM -->
    	<form:form action="/attachments/new" method="post" modelAttribute="attachment" enctype="multipart/form-data">
   		<!-- CARD IN COLUMN -->
		<div class="row cards-in-columns">
		<div class="col"></div>
   		<div class="col">
	   		<div class="card">
	   			<div class="card-header">
	   				<p class="langPL">NOWY ZAŁĄCZNIK</p>
	   				<p class="langEN">NEW ATTACHMENT</p>
	   			</div>
	   			<div class="card-body">
	   					<form:hidden path="project.id"/>
	   					<div class="row mb-1">
	   						<div class="col-4 text-right">
				   				<p class="langPL">OPIS:</p>
				   				<p class="langEN">DESCRIPTION:</p>
	   						</div>
	   						<div class="col-8">
	   							<form:textarea type="text" path="description" cssClass="w-100"/>
	   						</div>
	   					</div>				
						<div class="row mb-1">
	                        <div class="col-4 text-right">
	                            <p class="langPL">PLIK:</p>
	                            <p class="langEN">FILE:</p>
	                        </div>
	                        <div class="col-8">
	                            <input type="file" name="fileUpload"/>
	                        </div>
	                    </div>
	   			</div>
	   			<div class="card-footer">
	   				<button type="button" class="btn btn-outline-warning float-left">
						<p class="langPL">ANULUJ</p>
						<p class="langEN">CANCEL</p>
	   				</button>
	   				<button type="submit" class="btn btn-outline-success float-right">
						<p class="langPL">ZAPISZ</p>
						<p class="langEN">SAVE</p>
	   				</button>
	   			</div>
	   		</div>
   		</div>
   		<div class="col"></div>
   		</div>
    	</form:form>
    </div>

    <jsp:include page="../footer.jsp"/>
    
    </body>
</html>