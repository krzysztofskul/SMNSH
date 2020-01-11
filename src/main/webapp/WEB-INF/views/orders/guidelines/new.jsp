<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 11.01.2020
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="guidelineNew">
            <div class="card">
                <div class="card-header">
                    NEW GUIDELINE ORDER FORM
                </div>
                <div class="card-body">

                    <form>
                        <form:hidden path="id"/>
                        <form:hidden path="concept.id"/>
                        <form:hidden path="device.id"/>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="author">Author:</label>
                                <form:select path="author.id" id="author" cssClass="form-control">
                                    <c:forEach items="${usersAll}" var="user">
                                        <form:option value="${user.id}" label="${user.nameFirst} ${user.nameLast}"/>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="priority">Priority:</label>
                                <form:input path="priority" id="priority" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-6">
                                <label for="dateTimeDeadline">Date deadline:</label>
                                <input type="date" id="dateTimeDeadline" class="form-control" disabled/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="title">Titile:</label>
                                <form:input path="title" id="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-row d-block">
                            <div class="form-group col-sm-12">
                                <label for="remarks">Remarks:</label>
                                <form:textarea path="remarks" cssClass="form-control" id="remarks"/>
                            </div>
                        </div>

                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-warning float-left">CANCEL/BACK</a>
                    <input type="submit" class="btn btn-success float-right" value="SAVE"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
