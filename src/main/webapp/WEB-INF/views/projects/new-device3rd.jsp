<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 29.02.2020
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

	<!--JQuery  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <!--JS files-->
    <script src="<c:url value="/resources/js/projects/new.js"/>" type="text/javascript"></script>
    <%--
    	<script src="<c:url value="/resources/js/projects/new3testJQuery.js"/>" type="text/javascript"></script>
     --%>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form action="">
            <div class="card">

                <div class="card-header text-center">
                    <p class="langPL">LISTA URZĄDZEŃ OBCYCH</p>
                    <p class="langEN">3RD PARTY DEVICES</p>
                </div>

                <div class="card-body">
					<input type="hidden" name="projectId" cssClass="w-100" value="${projectId}"/>
					
					<c:forEach var="i" begin="1" end="5">
						<hr>
	                    <div class="row mb-1">
	                        <div class="col-4 text-right">
	                            <p class="langPL">PRODUCENT:</p>
	                            <p class="langEN">MANUFACTURER:</p>
	                        </div>
	                        <div class="col-8">
	                            <input path="manufacturerName" class="w-100" value=""/>
	                        </div>
	                    </div>
	                    <div class="row mb-1">
	                        <div class="col-4 text-right">
	                            <p class="langPL">MODEL:</p>
	                            <p class="langEN">MODEL:</p>
	                        </div>
	                        <div class="col-8">
	                            <input path="modelName" class="w-100" value=""/>
	                        </div>
	                    </div>
	                    <div class="row mb-1">
	                        <div class="col-4 text-right">
	                            <p class="langPL">OPIS:</p>
	                            <p class="langEN">DESCRIPTION:</p>
	                        </div>
	                        <div class="col-8">
	                            <input path="description" class="w-100" value=""/>
	                        </div>
	                    </div>
            	        <div class="row mb-1 invisible">
	                        <div class="col-12">
	                   			<button type="BUTTON" id="addNext" class="btn btn-success float-right disabled">+</button>
	                   			<button type="BUTTON" id="del" class="btn btn-danger float-right disabled">-</button>
	                        </div>
            	        </div>
            	        <hr>
                    </c:forEach>
           	        <div class="row mb-1">
                        <div class="col-12">
                   			<button type="BUTTON" id="addNext" class="btn btn-success float-right disabled">+</button>
                   			<button type="BUTTON" id="del" class="btn btn-danger float-right invisible">-</button>
                        </div>
           	        </div>

				</div>

                <div class="card-footer">
                    <c:if test="${backToPage ne null}">
                        <input type="hidden" name="backToPage" value="${backToPage}">
                    </c:if>
                    <a href="#" class="btn btn-warning float-left">
                        <p class="langPL">POMIŃ</p>
                        <p class="langEN">SKIP</p>
                    </a>
                    <button type="submit" id="btnSave" class="btn btn-success float-right">
                        <p class="langPL">ZAPISZ</p>
                        <p class="langEN">SAVE</p>
                    </button>
                </div>

            </div>
        </form>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
