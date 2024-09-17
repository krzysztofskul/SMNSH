<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--JQuery  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <!--JS files-->
    <script src="<c:url value="/resources/js/projects/new.js"/>" type="text/javascript"></script>
</head>
<body>

    <jsp:include page="../../header.jsp"/>

     <div class="container">

        <form:form method="post" action="/device3rd/new" modelAttribute="device3rd">
            <div class="card">

                <div class="card-header text-center">
                    <p class="langPL">FORMULARZ DODAWANIA URZĄDZENIA OBCEGO DO PROJEKTU</p>
                    <p class="langEN">3RD PARTY DEVICES ADDING TO THE PROJECT FORM</p>
                </div>
				<div class="card-body">
                    <div class="row mb-1 invisible">
                        <div class="col-4 text-right">
                            <p class="langPL">ID:</p>
                            <p class="langEN">ID:</p>
                        </div>
                        <div class="col-8">
                            <form:hidden path="id" class="w-100" readonly="true"/>
                        </div>
                    </div>
                    <div class="row mb-1 invisible">
                        <div class="col-4 text-right">
                            <p class="langPL">ID PROJEKTU:</p>
                            <p class="langEN">PROJECT ID:</p>
                        </div>
                        <div class="col-8">
                            <form:hidden path="project.id" class="w-100"/>
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">PRODUCENT:</p>
                            <p class="langEN">MANUFACTURER:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="manufacturerName" class="w-100"/>
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">MODEL:</p>
                            <p class="langEN">MODEL:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="modelName" class="w-100"/>
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">OPIS:</p>
                            <p class="langEN">DESCRIPTION:</p>
                        </div>
                        <div class="col-8">
                            <form:textarea path="description" class="w-100" rows="5"/>
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">NR SERYJNY:</p>
                            <p class="langEN">SERIAL NO:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="serialNo" class="w-100"/>
                        </div>
                    </div>
                    <div class="row mb-1">
                        <div class="col-4 text-right">
                            <p class="langPL">GWARANCJA [m-cy]:</p>
                            <p class="langEN">WARRANTY [months]:</p>
                        </div>
                        <div class="col-8">
                            <form:input path="warranty" class="w-25"/>
                        </div>
                    </div>
                    <!--  
           	        <div class="row mb-1">
                        <div class="col-12">
                   			<button type="submit" class="btn btn-danger float-right disabled">-</button>
                        </div>
           	        </div>
					<hr>
           	        <div class="row mb-1">
                        <div class="col-12">
                   			<button type="button" class="btn btn-danger float-right disabled">+</button>
                        </div>
           	        </div>
           	        -->
				</div>
				
                <div class="card-footer">
                    <c:if test="${backToPage ne null}">
                        <input type="hidden" name="backToPage" value="${backToPage}">
                    </c:if>
                    <a href="#" class="btn btn-warning float-left">
                        <p class="langPL">POMIŃ</p>
                        <p class="langEN">SKIP</p>
                    </a>
<!--					<button type="submit" id="btnSave" class="btn btn-success float-right">
                        <p class="langPL">ZAPISZ I DODAJ NASTĘPNY</p>
                        <p class="langEN">SAVE AND ADD NEXT</p>
                    </button> -->
                    <button type="submit" id="btnSave" class="btn btn-success float-right">
                        <p class="langPL">ZAPISZ I ZAKOŃCZ</p>
                        <p class="langEN">SAVE AND FINISH</p>
                    </button>
                </div>

            </div>
        </form:form>

    </div>

    <jsp:include page="../../footer.jsp"/>

</body>
</html>