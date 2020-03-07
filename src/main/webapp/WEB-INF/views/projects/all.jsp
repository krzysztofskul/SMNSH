<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 29.02.2020
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">


        <div class="card">

            <div class="card-header text-center">
                <p class="langPL">LISTA WSZYSTKICH PROJEKTÓW</p>
                <p class="langEN">LIST OF ALL PROJECTS</p>
            </div>

            <c:forEach items="${projectsAll}" var="project">

                <div class="card-body">
                    <div class="row border-top border-bottom pt-1 pb-1">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-1">
                                    ${project.id}
                                </div>
                                <div class="col-8 font-weight-bold">
                                    <div class="row">
                                        <div class="col">
                                                ${project.investor}
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                                ${project.recipient}
                                        </div>
                                    </div>
                                </div>
                                <div class="col-3 border-bottom pb-1">
                                    <a href="#" class="btn btn-danger float-right ml-1">
                                        <p class="langPL">USUŃ</p>
                                        <p class="langEN">DEL</p>
                                    </a>
                                    <a href="/projects/details/${project.id}" class="btn btn-primary float-right">
                                        <p class="langPL">SZCZEGÓŁY</p>
                                        <p class="langEN">DETAILS</p>
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <div class="row">
                                        <div class="col">
                                                ${project.agreementNo}
                                        </div>
                                        <div class="col">
                                                ${project.projectName}
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                                ${project.sls}
                                        </div>
                                        <div class="col">
                                                ${project.projectManager.nameFirst} ${project.projectManager.nameLast}
                                        </div>
                                    </div>
                                    <c:forEach items="${project.deviceList}" var="device">
                                        <div class="row">
                                            <div class="col-1 bg-light">
                                                    ${device.deviceCategory.code}
                                            </div>
                                            <div class="col-11">
                                                ${device.deviceCategory.name} ${device.model}
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="row">
                                        <div class="col">
                                                ${project.status.toString()}
                                        </div>
                                        <div class="col">
                                                ${project.deadline.toLocalDate()} ${project.deadline.toLocalTime()}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>

            <div class="card-footer">
                <a href="/projects/new" class="btn btn-success float-right">
                    <p class="langPL">NOWY PROJEKT</p>
                    <p class="langEN">NEW PROJECT</p>
                </a>
            </div>

        </div>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
