<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SMNSH</title>	
</head>

<body>

    <header>
        <jsp:include page="../header.jsp"/>
    	<jsp:include page="../projects/project-menu.jsp">
    		<jsp:param value="${projectCharter}" name="projectCharter"/>
    	</jsp:include>
    </header>

	<div class="content container-fluid">
		<div class="test">
			<div class="row cards-in-columns">
				<div class="col">
				
					<div class="card">
						<div class="card-header">
							<p class="langPL">
								OFERTY
							</p>
							<p class="langEN">
								OFFERS
							</p>		
						</div>
						<div class="card-body">					
							<c:forEach items="${project.attachmentList}" var="attachment">
								<c:if test="${attachment.attachmentCategory.attCategoryCode eq 'DOC-OFFER'}">
									<a href="/attachments/download/${attachment.getId()}">
									<div class="btn btn-outline-info" style="width:100px;height: 100px">
											${attachment.fileName} ${attachment.attachmentCategory.attCategoryNamePL}
									</div>
									</a>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>

				<div class="col">
				
					<div class="card">
						<div class="card-header">
							<p class="langPL">
								ZAMÓWIENIA
							</p>
							<p class="langEN">
								ORDERS
							</p>		
						</div>
						<div class="card-body">
							...
						</div>
					</div>
				</div>
			</div>	
			
			
		</div>
	</div>

    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>

</body>
</html>