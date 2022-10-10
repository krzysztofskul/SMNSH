<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 29.02.2020
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container-fluid">
	
	
			<div>
			
				<!-- MENU PROJECTS ALL	 -->
				<div class="row">
				
					<c:if test="${param.userId ne null}">
						<div class="col-12">
							<jsp:include page="../menuProjectsAll.jsp">
								<jsp:param name="projectsAll" value="${projectsAll}"/>
								<jsp:param name="userId" value="${param.userId}"/>
							</jsp:include>
						</div>
					</c:if>
				
				</div>
				
				<!-- MAIN CONTENT -->	

					<!-- HEADER: LISTA PROJEKTÓW -->
		            <div class="row bg-light mt-1 pt-1 border" style="height: 60px">		            	
		            	
		            	<div class="col text-center">
		                	<p class="langPL">LISTA PROJEKTÓW</p>
		                	<p class="langEN">LIST PROJECTS</p>
		            	</div>
		
						<!-- BUTTON: NOWY PROJEKT -->
			            <div class="col position-absolute">
			                <c:choose>
			                    <c:when test="${param.userId ne null}">
			                        <c:set var="link" value="/projects/new?userId=${param.userId}&backToPage=/projects/all?userId=${param.userId}"/>
			                    </c:when>
			                    <c:otherwise>
			                        <c:set var="link" value="/projects/new"/>
			                    </c:otherwise>
			                </c:choose>
			                <a id="newProjectBtn" href="${link}" class="btn btn-success float-right">
			                    <p class="langPL">NOWY PROJEKT</p>
			                    <p class="langEN">NEW PROJECT</p>
			                </a>
			            </div>
					</div>
		            
		            
		            <c:choose>
		                <c:when test="${projectsAll ne null}">
		                <div class="mr-auto ml-auto text-center">
		                    <c:forEach items="${projectsAll}" var="project">
		                    	
		                    	<c:choose>

			                    	<%-- CARDS VIEW --%> 
			                    	<c:when test="${param.view eq 'cards'}">
			                        <div class="card m-5 d-inline-block text-left border-dark" style="width: 750px; height:500px">
			                        	<div class="card-body pt-1">
				                            <div class="row">
				                                <div class="col-12">
				                                    <div class="row border-top border-bottom bg-light">
				                                        <div class="col-1 border-right align-right p-0 text-muted">
				                                            ID: ${project.id}
				                                        </div>
				                                        <div class="col-8 font-weight-bold">
				                                            <div class="row">
				                                                <div class="col-3 text-right">
				                                                        <p class="langPL">INWESTOR</p>
				                                                        <p class="langEN">INVESTOR</p>
				                                                </div>
				                                                <div class="col float-left">
				                                                        ${project.investor.name} ${project.investor.companyType.name}
				                                                </div>
				                                            </div>
				                                            <div class="row">
				                                                <div class="col-3 text-right">
				                                                    <p class="langPL">MIEJSCE DOSTAWY</p>
				                                                    <p class="langEN">CONSUMER</p>
				                                                </div>
				                                                <div class="col float-left">
				                                                        ${project.recipient}
				                                                </div>
				                                            </div>
				                                        </div>
				                                        <div class="col-3 pb-1 border-left">
				                                            <a href="/projects/details/${project.id}" class="projectDetailsBtn btn btn-outline-primary float-right">
				                                                <p class="langPL">SZCZEGÓŁY</p>
				                                                <p class="langEN">DETAILS</p>
				                                            </a>
				                                            <a href="/projects/delete/${project.id}" class="btn btn-outline-danger float-right ml-1">
				                                                <p class="langPL">USUŃ</p>
				                                                <p class="langEN">DEL</p>
				                                            </a>
				                                        </div>
				                                    </div>
				                                    <div class="row">
				                                        <div class="col-12">
				                                            <div class="row pt-1 pb-1">
				                                                <div class="col-2 text-right">
				                                                    <p class="langPL">Nr Umowy:</p>
				                                                    <p class="langEN">Agreement No:</p>
				                                                </div>
				                                                <div class="col-3">
				                                                        ${project.agreementNo}
				                                                </div>
				                                                <div class="col-2 text-right">
				                                                    <p class="langPL">Nazwa projektu:</p>
				                                                    <p class="langEN">Project name:</p>
				                                                </div>
				                                                <div class="projectNameDiv col-3">
				                                                        ${project.projectName}
				                                                </div>
				                                            </div>
				                                            <div class="row pb-2">
				                                                <div class="col-2 text-right">
				                                                    <p class="langPL">SLS:</p>
				                                                    <p class="langEN">Sales rep.:</p>
				                                                </div>
				                                                <div class="col-3">
				                                                        ${project.sls.nameFirst} ${project.sls.nameLast}
				                                                </div>
				                                                <div class="col-2 text-right">
				                                                    <p class="langPL">Kierownik projektu:</p>
				                                                    <p class="langEN">Project manager:</p>
				                                                </div>
				                                                <div class="col-3">
				                                                        ${project.projectManager.nameFirst} ${project.projectManager.nameLast}
				                                                </div>
				                                            </div>
				                                            <div class="row h-25">
				                                                <div class="col-2 text-right">
				                                                    <p class="langPL">Urządzenia:</p>
				                                                    <p class="langEN">Devices:</p>
				                                                </div>
				                                                <div class="col-10">
				                                                    <c:forEach items="${project.deviceList}" var="device">
				                                                        <div class="row">
				                                                            <div class="col">
				                                                                <span class="p-1 m-1 font-weight-bold">
				                                                                        ${device.deviceCategory.code}
				                                                                </span>
				                                                                <span>${device.deviceCategory.name} ${device.model}</span>
				                                                            </div>
				                                                        </div>
				                                                    </c:forEach>
				                                                </div>
				                                            </div>
				                                            <div class="row border-top mt-5 pt-2 pb-3 bg-light">
				                                                <div class="col-8 text-right">
				                                                    <p class="langPL">Termin realizacji:</p>
				                                                    <p class="langEN">Deadline:</p>
				                                                </div>
				                                                <div class="col-4 pt-1" style="font-size: 18px">
				                                                    <span class="font-weight-bold">
				                                                        ${project.deadline.toLocalDate()}
				                                                    </span>
				                                                    <span class="ml-2 text-black-50">
				                                                        <%--${project.deadline.toLocalTime()}--%>
				                                                    </span>
				                                                </div>
				                                            </div>
				                                            <div class="row pt-1 bg-light">
				                                                <div class="col-8 text-right">
				                                                    <p class="langPL">Status projektu:</p>
				                                                    <p class="langEN">Project status:</p>
				                                                </div>
				                                                <div class="col-4 font-weight-bold" style="font-size: 12px">
				                                                        <p class="langPL">${project.status.getNamePL()}</p>
				                                                        <p class="langEN">${project.status.getNameEN()}</p>
				                                                </div>
				                                            </div>
				                                        </div>
				                                    </div>
				                                </div>
				                            </div>
			                        	</div>
			                        </div>
			                    	</c:when>
			                    	
			                    	<%-- PROJECT LIST VIEW --%>
			                    	<c:when test="${param.view eq 'list'}">
										<div class="card">
											<div class="row no-gutters">
												<div class="col-md-1">
													<div class="card-body">
														${project.id}
													</div>
												</div>
												<div class="col-md-2">
													<div class="card-body">
														${project.agreementNo}
													</div>
												</div>
												<div class="col-md-2 text-left">
													<div class="card-body">
														<div class="row font-weight-bold">
																${project.investor.name} ${project.investor.companyType.name}
														</div>
														<div class="row">
																${project.recipient}
														</div>
													</div>
												</div>
												<div class="col-md-2">
													<div class="card-body">
                                                        <p class="langPL">${project.deadline.toLocalDate()}</p>
                                                    </div>
												</div>
												<div class="col-md-3">
													<div class="card-body">
                                                        <p class="langPL">${project.status.getNamePL()}</p>
                                                        <p class="langEN">${project.status.getNameEN()}</p>
                                                     </div>
												</div>
												<div class="col-md-2">
													<div class="card-body">
														<a href="/projects/details/${project.id}">
                                                        	<button class="btn btn-outline-primary mb-1">SZCZEGÓŁY</button>
                                                        </a>
                                                        <button class="btn btn-outline-danger">USUŃ</button>
                                                       </div>
												</div>
												
											</div>
										</div>
			                    	</c:when>
			                    	
			                    	<%-- OTHER VIEW --%>
			                    	<c:otherwise>
			                    		<h4>TEST OTHER VIEW</h4>
			                    	</c:otherwise>
			                    	
		                    	</c:choose>
		                    	
		                    </c:forEach>
		                </div>
		                </c:when>
		                <c:otherwise>
		                    <div>
		                        <p class="langPL">BRAK PROJEKTÓW DLA TEGO UŻYTKOWNIKA</p>
		                        <p class="langPL">NO PROJECTS FOR THIS USER</p>
		                    </div>
		                </c:otherwise>
		            </c:choose>
		
		            <div class="card-footer" style="height: 75px">
		                <a id="newProjectBtnFooter" href="/projects/new" class="btn btn-success float-right">
		                    <p class="langPL">NOWY PROJEKT</p>
		                    <p class="langEN">NEW PROJECT</p>
		                </a>
		            </div>
	        
	        
	        </div>
	
	
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
