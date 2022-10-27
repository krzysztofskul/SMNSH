<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container-fluid">
    	<!-- TEST -->
    	<section class="test">
    		<div class="row">
    			<div class="col-3">
    				<a href="/investors/allwithprojects?sortBy=nameAsc">Sortuj wg nazwy rosnąco</a>
    			</div>
    			<div class="col-3">
    				<a href="/investors/allwithprojects?sortBy=nameDesc">Sortuj wg nazwy malejąco</a>
    			</div>
    			<div class="col-3">
    				<a href="/investors/allwithprojects?sortBy=sapNoAsc">Sortuj wg numeru SAP rosnąco</a>
    			</div>
    			<div class="col-3">
    				<a href="/investors/allwithprojects?sortBy=sapNoDesc">Sortuj wg numeru SAP malejąco</a>
    			</div>
    		</div>
    	
    		<c:forEach items="${investors}" var="investor">
    			<div class="bg-light border m-2 p-2">
	    			<p>
	    				<span class="font-weight-bold">${investor.name}</span>
	    				<span class="float-right">SAP no.: ${investor.sapInfo.sapNo}</span>
	    			</p>
					<p>
						<span>${investor.postalCode}</span>
						<span>${investor.city}</span>
					</p>
					<p>
						<span>${investor.contact}</span>
					</p>
					<p>Projekty: <span>${investor.projectList.size() }</span> </p>
					<c:forEach items="${investor.projectList}" var="project">
						<div class="d-inline-block border p-1">
							<a href="/projects/details/${project.id}">${project.projectName}</a>
						</div>
					</c:forEach>
				</div>
    		</c:forEach>
    	
    	</section>
    	
    </div>

    <jsp:include page="../footer.jsp"/>	

</body>
</html>
