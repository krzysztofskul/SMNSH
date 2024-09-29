<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
			<table class="table">
				<thead class="thead-light">
					<c:choose>
					    <c:when test="${param.category=='investor'}">
							<th colspan="4" class="text-center">
								<p class="langPL">INWESTORZY</p>
								<p class="langEN">investors</p>
							</th>
					    </c:when>    
					    <c:when test="${param.category=='subcontractor'}">
							<th colspan="4" class="text-center">
								<p class="langPL">PODWYKONAWCY</p>
								<p class="langEN">subcontractors</p>
							</th>
					    </c:when>    
					    <c:otherwise>
							<th colspan="4" class="text-center">
								<p class="langPL">FIRMY</p>
								<p class="langEN">companies</p>
							</th>

					    </c:otherwise>
					</c:choose>
				</thead>
				<thead class="thead-light">
					<th style="width: 50px">
						<p class="langPL">ID</p>
						<p class="langEN">id</p>
					</th>
					<th>
						<p class="langPL">NAZWA</p>
						<p class="langEN">name</p>
					</th>
					<th>
						<a href="#" class="btn btn-sm btn-outline-success float-right">
							<p class="langPL">NOWY</p>
							<p class="langEN">new</p>
						</a>
					</th>
				</thead>
				<tbody>
					<c:forEach items="${companyList}" var="company">
					<tr>
						<th scope="row">${company.id}</th>
						<td>${company.name}</td>
						<td>
							<button class="btn-sm btn-outline-danger float-right">
								<p class="langPL">USUŃ</p>
								<p class="langEN">delete</p>
							</button>
							<a href="/smnsh4/companies/details/${company.id}" class="btn-sm btn-outline-primary float-right">
								<p class="langPL">SZCZEGÓŁY</p>
								<p class="langEN">details</p>
							</button>

						</td>
					</tr>
					</c:forEach>
				</tbody>	
				<tfoot>
					<tr>
						<td>
							<a href="/smnsh4/companies/new?category=${param.category}&edit=true" class="btn btn-sm btn-outline-success float-right">
								<p class="langPL">NOWY</p>
								<p class="langEN">new</p>
							</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	
	<jsp:include page="../footer.jsp"/>
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
    
    