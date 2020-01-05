<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 04.01.2020
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">AUTHOR</th>
                    <th scope="col">DEVICE</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">OPTIONS</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${conceptsAll}" var="concept">
                    <tr>
                        <th scope="row">${concept.id}</th>
                        <td>${concept.author.nameFirst} ${concept.author.nameLast}</td>
                        <td>${concept.device.model}</td>
                        <td>${concept.title}</td>
                        <td>
                            <a href="/concepts/details/${concept.id}" class="btn btn-primary">DETAILS</a>
                            <a href="#" class="btn btn-danger disabled">DEL</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr class="text-right">
                    <td colspan="5">
                        <a href="/concepts/new" class="btn btn-success">NEW</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
