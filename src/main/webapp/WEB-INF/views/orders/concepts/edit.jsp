<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 05.01.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form modelAttribute="concept" method="post">
            <div class="card">
                <div class="card-header">
                    <%--${concept.id}--%> <form:input path="id" disabled="true" cssStyle="max-width: 50px"/> | <%--${concept.title}--%> <form:input path="title"/>
                    <form:hidden path="dateTimeCreated"/>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            AUTHOR:
                        </div>
                        <div class="col">
                            <%--${concept.author.nameFirst} ${concept.author.nameLast}--%> <form:select path="author.id" items="${usersAll}" itemLabel="id" itemValue="id"/>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col">
                            DEVICE:
                        </div>
                        <div class="col">
                            ${concept.device.model}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            DESCRIPTION:
                        </div>
                        <div class="col">
                                <%--${concept.description}--%> <form:textarea path="description"/>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/concepts/details/${concept.id}" class="btn btn-warning float-left">CANCEL/BACK</a>
                    <input type="submit" class="btn btn-success float-right" value="SAVE/UPDATE"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
