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

        <div id="projectShortDetailsDiv">

        </div>

        <div class="card" id="commentsDiv">
            <div class="card-header">
                <div class="text-center">
                    <p class="langPL">KOMENTARZE</p>
                    <p class="langEN">COMMENTS</p>
                </div>
            </div>
            <div class="card-body">
                <c:forEach items="${projectWithComments.commentList}" var="comment">
                    <div class="row border-top border-dark bg-light p-2">
                        <div class="col-2 font-weight-bold">
                            ${comment.author.nameFirst} ${comment.author.nameLast}
                        </div>
                        <div class="col-8"></div>
                        <div class="col-2 text-right text-black-50">
                            ${comment.dateOfCreation.toLocalDate()} ${comment.dateOfCreation.toLocalTime()}
                        </div>
                    </div>
                    <div class="row border-bottom font-italic p-3">
                            ${comment.message}
                    </div>
                </c:forEach>
            </div>
            <div class="card-footer">
                <a href="/projects/details/${projectWithComments.id}" class="btn btn-outline-warning">
                    <p class="langPL">POWRÓT DO PROJEKTU</p>
                    <p class="langEN">BACK TO THE PROJECT</p>
                </a>
                <a href="/projects/details/${projectWithComments.id}/comments/new" class="btn btn-outline-success float-right">
                    <p class="langPL">NOWY KOMENTARZ</p>
                    <p class="langEN">NEW COMMENT</p>
                </a>
            </div>
        </div>

        <jsp:include page="../../footer.jsp"/>

    </div>

</body>
</html>