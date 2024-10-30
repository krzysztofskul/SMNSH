<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- BOOTSTRAP CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

	<jsp:include page="../header.jsp"/>
	
		<div class="container-fluid">
		
			<form:form modelAttribute="company" method="post" action="/smnsh4/companies/save">
			
			<form:select path="companyCategoryList" multiple="true" style="width: 100%" class="d-none">
				<c:forEach items="${company.companyCategoryList}" var="companyCategory">
					<form:option label="${companyCategory.companyCategoryEnum.nameEN}" value="${companyCategory.id}" selected="true"/>
				</c:forEach>			
			</form:select>
			
			<table class="table ">
			
				<thead class="thead-light">
					<tr>
						<th style="width: 100px;">
							<p class="langPL">ID</p>
							<p class="langEN">id</p>
						</th>
						<th colspan="4">
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:hidden path="id" readonly="true"/>
								</c:when>
								<c:otherwise>
									<span>${company.id}</span>
								</c:otherwise>
							</c:choose>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>
							<p class="langPL">NAZWA</p>
							<p class="langEN">name</p>
						</th>
						<td>
						
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="name"/>
								</c:when>
								<c:otherwise>
									${company.name}
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th rowspan="3">
							<p class="langPL">DANE ADRESOWE</p>
							<p class="langEN">address details</p>
						</th>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="contactDetails.address.country"/>
								</c:when>
								<c:otherwise>
									${company.contactDetails.address.country}
								</c:otherwise>
							</c:choose>						
						</td>
					</tr>
					<tr>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="contactDetails.address.zipCode"/>
								</c:when>
								<c:otherwise>
									${company.contactDetails.address.zipCode}
								</c:otherwise>
							</c:choose>
							
						</td>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="contactDetails.address.city"/>
								</c:when>
								<c:otherwise>
									${company.contactDetails.address.city}
								</c:otherwise>
							</c:choose>
							
						</td>
					</tr>
					<tr>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="contactDetails.address.streetName"/>
								</c:when>
								<c:otherwise>
									${company.contactDetails.address.streetName}
								</c:otherwise>
							</c:choose>
						
						</td>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="contactDetails.address.streetNo"/>
								</c:when>
								<c:otherwise>
									${company.contactDetails.address.streetNo}
								</c:otherwise>
							</c:choose>
							
						</td>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<form:input path="contactDetails.address.flatNo"/>
								</c:when>
								<c:otherwise>
									${company.contactDetails.address.flatNo}
								</c:otherwise>
							</c:choose>
							
						</td>
					</tr>
					<tr>
						<th>
							<p class="langPL">DANE KONTAKTOWE</p>
							<p class="langEN">contact details</p>
						</th>
						<td>
							<p class="langPL">W OPRACOWANIU...</p>
							<p class="langEN">in progress...</p>
							<!-- 
							<a href="/inprogress" class="btn btn-sm btn-outline-primary">

							</a> 
							-->
						</td>
					</tr>
					<!-- QUALITY RATE PARAM. -->
					<tr>
						<th>
							<p class="langPL">WIARYGODNOŚĆ</p>
							<p class="langEN">quality rate</p>
						</th>
						<td>
							<c:choose>
								<c:when test="${param.edit=='true'}">
									<p class="langPL">W OPRACOWANIU...</p>
									<p class="langEN">in progress...</p>
									<form:hidden path="qualityrate.id"/>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${company.qualityrate.qualityrateEnum.nameEN.equals('WHITE')}">
											<p class="qualityrate d-inline-block" style="width:20px; height:40px; border:1px solid gray; background-color:white; color: white; margin-top: 0px">X</p>
											<p class="qualityrate d-inline-block" style="width:20px; height:40px; border:1px solid gray; background-color:green; color: green; margin-top: 0px">G</p>
											<p class="qualityrate d-inline-block" style="width:20px; height:40px; border:1px solid gray; background-color:yellow; color: yellow; margin-top: 0px">Y</p>
											<p class="qualityrate d-inline-block" style="width:20px; height:40px; border:1px solid gray; background-color:red; color: red; margin-top: 0px">R</p>
											<p class="qualityrate d-inline-block" style="width:20px; height:40px; border:1px solid gray; background-color:black; color: black; margin-top: 0px">B</p>
											<div class="qualityrateName d-none">
												<p class="langPL">${company.qualityrate.qualityrateEnum.namePL}</p>
												<p class="langEN">${company.qualityrate.qualityrateEnum.nameEN}</p>
											</div>
										</c:when>
									</c:choose>

								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tfoot>
						<tr>
							<td colspan="4">
								<c:choose>
									<c:when test="${param.edit=='true'}">
										<form:button type="submit" class="btn btn-sm btn-outline-success float-right">SAVE</form:button>
										<button type="button" class="btn btn-sm btn-outline-warning disabled">CANCEL</button>
									</c:when>
									<c:otherwise>
										<a href="/smnsh4/companies/details/${company.id}?edit=true" class="btn btn-sm btn-outline-success float-right">EDIT</a>
										<button type="button" class="btn btn-sm btn-outline-warning disabled">BACK</button>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tfoot>

				</tbody>

			</table>
			</form:form>
		
		</div><!-- end div container -->
	
	<jsp:include page="../footer.jsp"/>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>