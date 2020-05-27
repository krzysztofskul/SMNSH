<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 26.05.2020
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../../header.jsp"/>

    <div class="container">
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th scope="col">LOG ID</th>
                    <th scope="col">DATE TIME</th>
                    <th scope="col">ACTION</th>
                    <th scope="col">USER</th>
                </tr>
            </thead>
            <c:forEach items="${projectLogs}" var="log">
            <tbody>
                <tr>
                    <th scope="row">${log.id}</th>
                    <td>${log.localDateTime.toLocalDate()} ${log.localDateTime.toLocalTime()}</td>
                    <td>${log.actionEN}</td>
                    <td>${log.actionBy}</td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>

    <jsp:include page="../../footer.jsp"/>

</body>
</html>
