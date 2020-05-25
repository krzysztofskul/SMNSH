<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 25.05.2020
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <table class="table">
            <thead class="thead-light">
            <tr class="text-center">
                <th colspan="6">
                    <p>PROJEKTY NA ETAPIE ${projectStatus}</p>
                </th>
            </tr>
            <tr>
                <th scope="col">
                    <p>ID</p>
                </th>
                <th scope="col">
                    <p>INWESTOR</p>
                </th>
                <th scope="col">URZĄDZENIA</th>
                <th scope="col">KIEROWNIK PROJEKTU</th>
                <th scope="col">TERMIN REALIZACJI</th>
                <th scope="col">MENU</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${projectsAllByStatus}" var="project">
                <tr>
                    <th scope="row">${project.id}</th>
                    <td>
                        <p>${project.investor}</p>
                        <p>${project.recipient}</p>
                    </td>
                    <td>
                        <c:forEach items="${project.deviceList}" var="device">
                            <p>${device.model}</p>
                        </c:forEach>
                    </td>
                    <td>${project.projectManager.nameFirst} ${project.projectManager.nameLast}</td>
                    <td>${project.deadline.toLocalDate()}<br> ${project.deadline.toLocalTime()}</td>
                    <td>
                        <a href="/projects/details/${project.id}" class="btn btn-outline-primary">
                            <p class="langPL">SZCZEGÓŁY</p>
                            <p class="langEN">DETAILS</p>
<%--                            <svg class="bi bi-arrow-right-square" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">--%>
<%--                                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>--%>
<%--                                <path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>--%>
<%--                                <path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>--%>
<%--                            </svg>--%>
                        </a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>

        </table>


    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
