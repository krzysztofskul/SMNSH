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
			<p>
				Amount of attachments: ${project.attachmentList.size()}
			</p>
			
			<c:forEach items="${project.attachmentList}" var="attachment">
				<a href="/attachments/download/${attachment.getId()}">
				<div class="btn btn-outline-info" style="width:100px;height: 100px">
						${attachment.fileName} ${attachment.attachmentCategory.attCategoryNamePL}
				</div>
				</a>
			</c:forEach>
			
			
		</div>
	</div>

    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>

</body>
</html>