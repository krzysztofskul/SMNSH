<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: z0041nhm
  Date: 16.01.2022
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMNSH</title>

    <!--jQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>

    <%--bootstrap--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%--css--%>
    <link rel="stylesheet" type="text/css" href="/resources/css/card.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/row.css"/>
    <!--JS files-->
    <script src="<c:url value="/resources/js/projectCharter/projectCharter.js"/>" type="text/javascript"></script>

</head>
<body>

    <header>
        <jsp:include page="../header.jsp"/>
    </header>

    <main>
        <div class="test">
            <h1>Test:</h1>
            <h2>Project charter id: ${projectCharter.id}</h2>
            <h2>For project id: ${projectCharter.project.id} <a href="/projects/details/${projectCharter.project.id}"> >>> </a> </h2>
            <h2>And project name: ${projectCharter.project.projectName}</h2>
            <h3>And project manager name: ${projectCharter.project.projectManager.nameFirst}</h3>
        </div>
        <div class="content container-fluid">
        	
        	<section>
	        	<div class="row p-5">
	        		<!-- PROJECT DETAILS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        					<p class="langPL">SZCZEGÓŁY PROJEKTU</p>
	        					<p class="langen">PROJECT DETAILS</p>
	        				</div>
	        				<div class="card-body">
	        					<div class="row mt-1 mb-1 border-bottom">
	        						<div class="col-4 text-right border-right">
	        							<p class="langPL">NAZWA PROJEKTU:</p>
	        							<p class="langEN">PROJECT NAME:</p>
	        						</div>
	        						<div class="col-8">
	        							<p>${projectCharter.project.projectName}</p>
	        						</div>
	        					</div>
	        					<div class="row mt-1 mb-1 border-bottom">
	        						<div class="col-4 text-right border-right">
	        							<p class="langPL">NR UMOWY:</p>
	        							<p class="langEN">AGREEMENT NO:</p>
	        						</div>
	        						<div class="col-8">
	        							<p>${projectCharter.project.agreementNo}</p>
	        						</div>
	        					</div>
	        					<div class="row mt-1 mb-1">
	        						<div class="col-4 text-right border-right">
	        							<p class="langPL">MIEJSCE DOSTAWY:</p>
	        							<p class="langEN">INSTALLATION PLACE:</p>
	        						</div>
	        						<div class="col-8">
	        							<p>${projectCharter.project.recipient}</p>
	        						</div>
	        					</div>
	        				</div>
	        			</div>
	        		</div>
	        		<!-- MILESTONES -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
		        				<div class="float-left">
		        					<p class="langPL">KAMIENIE MILOWE</p>
		        					<p class="langen">MILESTONES</p>
	        					</div>
	        					<div class="float-right d-inline">
	        						<a href="/milestones/instances/new?projectCharterId=${projectCharter.id}&backToPage=project-charter/${projectCharter.id}">
	        							<button class="btn-sm btn-outline-success">+</button>
	        						</a>
	        					</div>
	        				</div>
	        				<div class="card-body">
	        				<c:choose>
	        				
	        					<c:when test="${null eq projectCharter.milestoneInstanceList || projectCharter.milestoneInstanceList.size() == 0}">
	        						<p class="langPL">BRAK USTANOWIONYCH KAMIENI MILOWYCH</p>
	        						<p class="langEN">NO MILESTONES SET</p>
	        					</c:when>
	        					<c:otherwise>
	        						<c:forEach items="${projectCharter.milestoneInstanceList}" var="milestoneInstance">
		        						<div class="milestone-div m-1">
			        						<div class="row border-top border-dark bg-light">
			        							<div class="col-8">
			        								<p class="langPL">${milestoneInstance.namePL}</p>
			        								<p class="langEN">${milestoneInstance.nameEN}</p>
			        							</div>
	
			        							<div class="col-4 text-right">
			        								<div class="dropdown">
													  <button class="btn-sm btn-outline-secondary dropdown-toggle mt-1" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
													    MENU
													  </button>
													  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
													    <a class="dropdown-item" href="#">
				        									<p class="langPL text-primary">EDYTUJ</p>
				        									<p class="langEN text-primary">EDIT</p>
													    </a>
													    <a class="dropdown-item" href="#">
				        									<p class="langPL text-success">USTAW JAKO WYKONANY</p>
				        									<p class="langEN text-success">SET AS DONE</p>
													    </a>
													    <a class="dropdown-item" href="#">
				        									<p class="langPL text-warning">USTAW JAKO NIEWYKONANY</p>
				        									<p class="langEN text-warning">SET AS TODO</p>
													    </a>
													    <div class="dropdown-divider"></div>
													    <a href="/milestones/instances/delete/${projectCharter.id}/${milestoneInstance.id}?backToPage=project-charter/${projectCharter.id}" class="text-center">
				        									<p class="langPL text-danger">USUŃ</p>
				        									<p class="langEN text-danger">DELETE</p>
			        									</a>
													  </div>
													</div>
			        							</div>
			        						</div>
		        							<div class="row">
		        								<div class="col-4">
		        									<p class="langPL text-black-50">ZAPLANOWANO NA:</p>
		        									<p class="langEN text-black-50">PLANNED AT:</p>
		        								</div>
			        							<div class="col-4">
			        									${milestoneInstance.milestoneTimeline.dateFinishPlanned }
			        							</div>
		        							</div>
		        							<div class="row border-bottom">
		        								<div class="col-4">
		        									<p class="langPL text-black-50">ZREALIZOWANO:</p>
		        									<p class="langEN text-black-50">DONE:</p>
		        								</div>
			        							<div class="col-4">
			        								<c:choose>
				        								<c:when test="${milestoneInstance.milestoneTimeline.dateFinishPlanned eq null}">
				        									<p class="langPL text-warning">NIE ZREALIZOWANO</p>
				        									<p class="langEN text-warning">NOT FINISHED</p>
				        								</c:when>
				        								<c:otherwise>
				        									${milestoneInstance.milestoneTimeline.dateFinished}
			        									</c:otherwise>
		        									</c:choose>
			        							</div>
		        							</div>
	        							</div>
	        						</c:forEach>
	        					</c:otherwise>
        					</c:choose>
	        				</div>
	        			</div>
	        		</div>
					<!-- STAKEHOLDERS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
		        				<div class="float-left">
		        					<p class="langPL">INTERESARIUSZE</p>
		        					<p class="langen">STAKEHOLDERS</p>
	        					</div>
	        					<div class="float-right d-inline">
	        						<a href="#">
	        							<button class="btn-sm btn-outline-success">+</button>
	        						</a>
	        					</div>
	        				</div>
	        				<div class="card-body">
	        					<c:choose>
	        				
	        					<c:when test="${null eq projectCharter.stakeholders || projectCharter.stakeholders.size() == 0}">
	        						<p class="langPL">BRAK INTERESARIUSZY</p>
	        						<p class="langEN">NO STAKEHOLDERS</p>
	        					</c:when>
	        					<c:otherwise>
	        						<c:forEach items="${projectCharter.stakeholders}" var="stakeholder">
		        						<div class="stakeholder-div m-1">
			        						<div class="row border-top border-dark bg-light">
			        							<div class="col-8">
			        								<p class="langPL">${stakeholder.nameFirst} ${stakeholder.nameLast}</p>
			        							</div>
	
			        							<div class="col-4 text-right">
			        								<div class="dropdown">
													  <button class="btn-sm btn-outline-secondary dropdown-toggle mt-1" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
													    MENU
													  </button>
													  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
													    <a class="dropdown-item" href="#">
				        									<p class="langPL text-primary">SZCZEGÓŁY</p>
				        									<p class="langEN text-primary">DETAILS</p>
													    </a>
													    <a class="dropdown-item" href="#">
				        									<p class="langPL text-primary">EDYTUJ</p>
				        									<p class="langEN text-primary">EDIT</p>
													    </a>
													    <div class="dropdown-divider"></div>
													    <a href="#" class="text-center">
				        									<p class="langPL text-danger">USUŃ</p>
				        									<p class="langEN text-danger">DELETE</p>
			        									</a>
													  </div>
													</div>
			        							</div>
			        						</div>
		        							<div class="row">
		        								<div class="col-4">
		        									<p class="langPL text-black-50">STANOWISKO:</p>
		        									<p class="langEN text-black-50">BUSINESS POSITION:</p>
		        								</div>
			        							<div class="col-4">
			        									${stakeholder.stakeholderBusinessPosition}
			        							</div>
		        							</div>
		        							<div class="row border-bottom">
		        								<div class="col-4">
		        									<p class="langPL text-black-50">FIRMA/INSTYTUJCA:</p>
		        									<p class="langEN text-black-50">COMPANY:</p>
		        								</div>
			        							<div class="col-4">
		        									${stakeholder.company}
			        							</div>
		        							</div>
	        							</div>
	        						</c:forEach>
	        					</c:otherwise>
        					</c:choose>
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        	
				<div class="row p-5">
	        		<!-- PROJECT BACKGROUND -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        				<div class="float-left">
	        					<p class="langPL">GENEZA PROJEKTU</p>
	        					<p class="langen">PROJECT BACKGROUND</p>
        					</div>
        					<div class="float-right d-inline">
        						<button class="btn-sm btn-outline-primary">
        							<p class="langPL">EDYTUJ</p>
        							<p class="langEN">EDIT</p>
        						</button>
        					</div>
	        				</div>
	        				<div class="card-body">
	        					<p>
	        						${projectCharter.reasons }
	        					</p>
	        				</div>
	        			</div>
	        		</div>
	        		<!-- PROJECT RISKS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        				<div class="float-left">
	        					<p class="langPL">RYZYKA PROJEKTU</p>
	        					<p class="langen">PROJECT RISKS</p>
        					</div>
	        					<div class="float-right d-inline">
        						<button class="btn-sm btn-outline-primary">
        							<p class="langPL">EDYTUJ</p>
        							<p class="langEN">EDIT</p>
        						</button>
        					</div>
	        				</div>
	        				<div class="card-body">
	        					<p>
	        						${projectCharter.risks }
	        					</p>
	        				</div>
	        			</div>
	        		</div>
					<!-- GOALS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
		        				<div class="float-left">
		        					<p class="langPL">CELE PROJEKTU</p>
		        					<p class="langen">GOALS</p>
	        					</div>
	        					<div class="float-right d-inline">
	        						<button class="btn-sm btn-outline-primary">
	        							<p class="langPL">EDYTUJ</p>
	        							<p class="langEN">EDIT</p>
	        						</button>
        						</div>
	        				</div>
	        				<div class="card-body">
	        					<p>
	        						${projectCharter.goals }
	        					</p>
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        	
        	</section>
        	
        </div>
    </main>

    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>

</body>
</html>
