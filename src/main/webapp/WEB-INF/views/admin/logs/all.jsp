<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 23.05.2020
  Time: 17:07
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
                    <th scope="col">#</th>
                    <th scope="col">
                        <p class="langPL">UŻYTKOWNIK</p>
                        <p class="langEN">USER</p>
                    </th>
                    <th scope="col">
                        <p class="langPL">DATA</p>
                        <p class="langEN">DATE</p>
                    </th>
                    <th scope="col">
                        <p class="langPL">CZYNNOŚĆ</p>
                        <p class="langEN">ACTION</p>
                    </th>
                    <th scope="col">
                        <p class="langPL">OBJEKT</p>
                        <p class="langEN">OBJECT</p>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${logs}" var="log">
                    <tr>
                        <th scope="row">${log.id}</th>
                        <td style="width: 250px">${log.user.nameFirst} ${log.user.nameLast}</td>
                        <td>
                            <p class="font-weight-bold">${log.localDateTime.toLocalDate()}</p>
                            <p class="font-italic">${log.localDateTime.toLocalTime()}</p>
                        </td>
                        <td>${log.userAction.toString()}</td>
                        <td style="width: 300px">${log.actionAt.toString()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="../../footer.jsp"/>

</body>
</html>
