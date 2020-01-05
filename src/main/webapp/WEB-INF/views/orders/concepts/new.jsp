<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 04.01.2020
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form modelAttribute="conceptNew" method="post" action="/concepts/new">
            <div class="card">
                <div class="card-header">
                    <p>NEW CONCEPT ORDER FORM</p>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            ID:
                        </div>
                        <div class="col">
                            <form:input path="id" disabled="true"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            TITLE:
                        </div>
                        <div class="col">
                            <form:input path="title"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            DEVICE:
                        </div>
                        <div class="col">
<%--                            <form:input path="device.id"/>--%>
                            <form:select path="device.id" items="${devicesAll}" itemLabel="model" itemValue="id"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            ID:
                        </div>
                        <div class="col">
                            <form:input path="" disabled="true"/>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <a href="/concepts/all" class="btn btn-warning float-left">CANCEL/BACK</a>
                    <input type="submit" class="btn btn-success float-right" value="SAVE"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>


</body>
</html>
