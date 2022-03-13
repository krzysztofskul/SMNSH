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
        
        	<!-- OLD VERSION -->
        	<%-- 
            <div class="card smnshCard">

                <div class="card-header">
                    <div class="row smnshRow">
                        <div class="col">
                            <p class="langPL">ID karty projektu</p>
                            <p class="langEN">Project charter ID</p>
                            <p id="projectCharterId">${projectCharter.id}</p>
                        </div>
                        <div class="col">
                            <p class="langPL">ID projektu</p>
                            <p class="langEN">Project ID</p>
                            <p id="projectId">${projectCharter.project.id}</p>
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                            <p class="langPL">Nazwa projektu</p>
                            <p class="langEN">Project name</p>
                            <a href="/projects/details/${projectCharter.project.id}">
                                <p>${projectCharter.project.projectName}</p>
                            </a>
                        </div>
                        <div class="col">
                            <button class="btn btn-outline-primary float-right" id="btnEdit">
                                <p class="langPL">EDYCJA</p>
                                <p class="langEN">EDIT</p>
                            </button>
                        </div>
                    </div>
                </div>

                <div class="card-body">
                    <div class="input-group m-1">
                        <div class="input-group-text">
                            <div>
                                <div class="langPL">GENEZA PROJEKTU</div>
                                <div class="langEN">BACKGROUND</div>
                            </div>
                        </div>
                        <textarea class="form-control" disabled aria-label="REASONS" id="reasons">${projectCharter.reasons}</textarea>
                    </div>
                    <div class="input-group m-1">
                        <div class="input-group-text">
                            <div>
                                <div class="langPL">CELE PROJEKTU</div>
                                <div class="langEN">GOAL STATEMENT</div>
                            </div>
                        </div>
                        <textarea class="form-control" disabled aria-label="GOALS" id="goals">${projectCharter.goals}</textarea>
                    </div>
                    <div class="input-group m-1">
                        <div class="input-group-text">
                            <div>
                                <div class="langPL">RYZYKA PROJEKTU</div>
                                <div class="langEN">RISKS</div>
                            </div>
                        </div>
                        <textarea class="form-control" disabled aria-label="RISKS" id="risks">${projectCharter.risks}</textarea>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="row smnshRow">
                        <div class="col">
                            <button class="btn btn-outline-warning" disabled id="btnCancel">
                                <p class="langPL">ANULUJ</p>
                                <p class="langEN">CANCEL</p>
                            </button>
                        </div>
                        <div class="col"></div>
                        <div class="col"></div>
                        <div class="col"></div>
                        <div class="col">
                            <button class="btn btn-outline-success float-right" disabled id="btnSave">
                                <p class="langPL">ZAPISZ</p>
                                <p class="langEN">SAVE</p>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        	 --%>
        	<!--  -->
        	
        	<!-- NEW VERSION -->
        	<section class="new-version">
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
	        							<p class="langEN">DELIVERY TO:</p>
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
	        					<p class="langPL">KAMIENIE MILOWE</p>
	        					<p class="langen">MILESTONES</p>
	        				</div>
	        				<div class="card-body">
	        				</div>
	        			</div>
	        		</div>
					<!-- STAKEHOLDERS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        					<p class="langPL">INTERESARIUSZE</p>
	        					<p class="langen">STAKEHOLDERS</p>
	        				</div>
	        				<div class="card-body">
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        	
				<div class="row p-5">
	        		<!-- PROJECT BACKGROUND -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        					<p class="langPL">GENEZA PROJEKTU</p>
	        					<p class="langen">PROJECT BACKGROUND</p>
	        				</div>
	        				<div class="card-body">
	        				</div>
	        			</div>
	        		</div>
	        		<!-- PROJECT RISKS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        					<p class="langPL">RYZYKA PROJEKTU</p>
	        					<p class="langen">PROJECT RISKS</p>
	        				</div>
	        				<div class="card-body">
	        				</div>
	        			</div>
	        		</div>
					<!-- GOALS -->
	        		<div class="col m-1">
	        			<div class="card">
	        				<div class="card-header">
	        					<p class="langPL">CELE PROJEKTU</p>
	        					<p class="langen">GOALS</p>
	        				</div>
	        				<div class="card-body">
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
