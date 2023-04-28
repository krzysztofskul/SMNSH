<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 22.09.2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMNSH</title>
</head>
<body>

    <jsp:include page="../../header.jsp"/>

    <div class="container-fluid">
    
        <div class="mx-auto w-75" id="content-main">
            <form:form method="post" modelAttribute="comment">
                <form:hidden path="id" value="${comment.id}"/>
                <form:hidden path="author.id" value="${comment.author.id}"/>
                <form:hidden path="project.id" value="${comment.project.id}"/>
                <div class="form-group">
                    <label for="comment">
                        <p class="langPL">KOMENTARZ:</p>
                        <p class="langEN">COMMENT:</p>
                    </label>
                    <form:textarea path="message" type="text" class="form-control" id="comment"/>
                </div>
                <div class="row">
                    <div class="col-10"></div>
                    <div class="col-2">
                        <button type="submit" class="btn btn-outline-success float-right">
                            <p class="langPL">ZAPISZ</p>
                            <p class="langEN">SAVE</p>
                        </button>
                    </div>

                </div>
            </form:form>
        </div>

    </div>
    
    <jsp:include page="../../footer.jsp"/>

</body>
</html>
