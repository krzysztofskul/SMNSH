<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 20.09.2020
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMNSH</title>
</head>
<body>

    <div class="container">

        <jsp:include page="../../header.jsp"/>

        <div id="projectShortDetailsDiv"></div>

        <div class="card" id="commentsDiv">
            <div class="card-header">
                PROJECT ID: ${projectWithComments.id}
            </div>
            <div class="card-body">
                <c:forEach items="${projectWithComments.commentList}" var="comment">
                    <div class="row border-top">Comment author:${comment.author.nameFirst} ${comment.author.nameLast} Comment created:${comment.dateOfCreation}</div>
                    <div class="row border-bottom font-italic">${comment.message}</div>
                </c:forEach>
            </div>
            <div class="card-footer"></div>
        </div>

        <jsp:include page="../../footer.jsp"/>

    </div>

</body>
</html>