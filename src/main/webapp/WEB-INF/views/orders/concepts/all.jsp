<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 04.01.2020
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container-fluid">

        <div class="row text-center mb-2">
            <div class="col-12">
                <h1 class="langPL">LISTA ZAMÓWIONYCH KONCEPCJI</h1>
                <h1 class="langEN">LIST OF ORDERS FOR CONCEPTUAL DESIGN</h1>
            </div>
        </div>
        <jsp:include page="menuConcepts.jsp"/>
        
        <c:forEach items="${conceptsAll}" var="concept">
            <c:if test="${sessionScope.userLoggedIn.getId() eq concept.author.id || sessionScope.userLoggedIn.businessPosition ne 'PROJECT_MANAGER'}">
            <div class="card m-5">
                <div class="card-header">
                	<div class="row">
	                    <div class="col-2 col-title">
	                    	<p class="langPL">APARAT</p>
	                    	<p class="langEN">DEVICE</p>
                    	</div>
	                    <div class="col-10 col-value">
	                    	<span class="font-weight-bold"">
	                    		${concept.device.deviceCategory.code}
                    		</span>
                    		<span>
                    		 	${concept.device.deviceCategory.name}
                    		 </span> 
                    		 <span class="font-weight-bold"">
                    		 	${concept.device.model}
               		 		</span>
                   		 </div>
                    </div>
                	<div class="row">
	                    <div class="col-2 col-title">
	                    	<p class="langPL">NAZWA PROJEKTU</p>
	                    	<p class="langEN">PROJECT NAME</p>
                    	</div>
	                    <div class="col-10 col-value">
	                    	<span class="font-weight-bold"">
	                    		${concept.project.projectName}
                    		</span>
                   		 </div>
                    </div>
                	<div class="row">
	                    <div class="col-2 col-title">
	                    	<p class="langPL">INWESTOR</p>
	                    	<p class="langEN">INVESTOR</p>
                    	</div>
	                    <div class="col-10 col-value">${concept.project.investor.name} ${concept.project.investor.companyType.name}</div>
                    </div>

                </div>
                <div class="card-body">
                    <div class="row">
	                    <div class="col-2 col-title">
	                        <p class="langPL">KIEROWNIK PROJEKTU</p>
	                        <p class="langen">PROJECT MANAGER</p>
	                    </div>
	                    <div class="col-3 col-value">
	                        ${concept.project.projectManager.nameFirst} ${concept.project.projectManager.nameLast}
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="col-2 col-title">
	                        <p class="langPL">DATA UTWORZENIA ZAMÓWIENIA</p>
	                        <p class="langen">ORDER CREATED</p>
	                    </div>
	                    <div class="col-3 col-value">
	                        ${concept.dateTimeCreated.toLocalDate()}
                        </div>
	                    <div class="col-2 col-title">
	                        <p class="langPL">TERMIN REALIZACJI KONCEPCJI</p>
	                        <p class="langen">DEADLINE OF CONCEPTUAL DESIGN</p>
	                    </div>
	                    <div class="col-3 col-value">
	                        ${concept.dateTimeDeadline.toLocalDate()}
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="col-2 col-title">
	                    </div>
	                    <div class="col-3 col-value">
	                    </div>
	                    <div class="col-2 col-title">
	                        <p class="langPL">STATUS ZAMÓWIENIA KOCEPCJI</p>
	                        <p class="langen">STATUS OF THE ORDER</p>
	                    </div>
	                    <div class="col-3 col-value">
							<c:if test="${concept.status.toString() eq 'OCZEKUJE / WAITING'}">
							    <div class="d-inline-block text-danger">${concept.status.getNamePL()}</div>
							    <div class="d-inline-block float-right">
	                    			<a href="/concepts/setDesigner/${concept.id}/${sessionScope.userLoggedIn.id}?backToPage=concepts/all?filter=inProgress">
	                    				<button class="btn btn-sm btn-outline-success">
	                    					<p class="langPL">ZACZNIJ PROJEKT</p>
	                    					<p class="langEN">BEGIN DESIGNING</p>
	                    				</button>
	                    			</a>
							    </div>
							</c:if>
							<c:if test="${concept.status.toString() eq 'W TOKU / IN PROGRESS'}">
							    <div class="d-inline-block text-warning">${concept.status.getNamePL()}</div>
							    <div class="d-inline-block float-right">
	                    			<a href="/concepts/setStatusFinished/${concept.id}?backToPage=concepts/all?filter=finished">
	                    				<button class="btn btn-sm btn-outline-success">
	                    					<p class="langPL">ZAKOŃCZ PROJEKT</p>
	                    					<p class="langEN">FINISH DESIGNING</p>
	                    				</button>
	                    			</a>
							    </div>
							</c:if>
							<c:if test="${concept.status.toString() eq 'ZAKOŃCZONY / FINISHED'}">
							    <div class="d-inline-block text-success">${concept.status.getNamePL()}</div>
							</c:if>
	                    </div>
                    </div>
                    <div class="row">
	                    <div class="col-2 col-title">
	                    </div>
	                    <div class="col-3 col-value">
	                    </div>
	                    <div class="col-2 col-title">
	                        <p class="langPL">PROJEKTANT</p>
	                        <p class="langen">DESIGNER</p>
	                    </div>
	                    <div class="col-3 col-value">
	                    	<c:if test="${concept.planner eq null}">
	                    			-
	                    	</c:if>
	                    	<c:if test="${concept.planner ne null}">
	                        	${concept.planner.nameFirst} ${concept.planner.nameLast}
	                        </c:if>
	                    </div>
                    </div>
                </div>
                
            
            </div>
            </c:if>
        </c:forEach>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
