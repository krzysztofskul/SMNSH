<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 02.03.2020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <div class="card">

            <div class="card-header">
                <div class="row border-bottom pb-2">
                    <div class="col-12 text-center">
                        <p class="langPL">SZCZEGÓŁY PROJEKTU</p>
                        <p class="langEN">PROJECT DETAILS</p>
                    </div>
                </div>
                <div class="row border-bottom">
                    <div class="col-sm-1 text-right pt-2">
                        <p class="langPL"> ID:</p>
                        <p class="langEN"> ID:</p>
                    </div>
                    <div class="col-sm-1 text-left pt-2">
                        ${project.id}
                    </div>
                    <div class="col-2 text-right pt-2">
                        <p class="langPL">NAZWA PROJEKTU:</p>
                        <p class="langEN">PROJECT NAME:</p>
                    </div>
                    <div class="col-2 text-left pt-2">
                        ${project.projectName}
                    </div>
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">NR UMOWY:</p>
                        <p class="langEN">AGREEMENT NO.:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.agreementNo}
                    </div>
                </div>

                <div class="row border-bottom">
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">INWESTOR:</p>
                        <p class="langEN">INVESTOR.:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.investor}
                    </div>
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">MIEJSCE DOSTAWY:</p>
                        <p class="langEN">CUSTOMER:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.recipient}
                    </div>
                </div>

                <div class="row border-bottom">
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">HANDLOWIEC:</p>
                        <p class="langEN">SALES REP.:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.sls}
                    </div>
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">KIEROWNIK PROJEKTU:</p>
                        <p class="langEN">PROJECT MANAGER:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.projectManager.nameFirst} ${project.projectManager.nameFirst}
                    </div>
                </div>

                <div class="row border-bottom">
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">WYKONAWCA ADAPTACJI:</p>
                        <p class="langEN">BUILDING CONTRACTOR:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.buildingContractor}
                    </div>
                    <div class="col-3 text-right pt-2">
                        <p class="langPL">TERMIN REALIZACJI:</p>
                        <p class="langEN">DEADLINE:</p>
                    </div>
                    <div class="col-3 text-left pt-2">
                        ${project.deadline.toLocalDate()} ${project.deadline.toLocalTime()}
                    </div>
                </div>
                <div class="row">
                    <div class="col-6"></div>
                    <div class="col-3 text-right pt-2 float-right">
                        <p class="langPL">STATUS:</p>
                        <p class="langEN">STATUS:</p>
                    </div>
                    <div class="col-3 pt-2 float-right">
                        ${project.status}
                    </div>
                </div>

            </div>

            <div class="card-body">
                <div class="row border-bottom">
                    <div class="col-12 text-center">
                        <p class="langPL">URZĄDZENIA PLANOWANE DO INSTALACJI:</p>
                        <p class="langEN">DEVICES PLANNED FOR INSTALLATION:</p>
                    </div>
                </div>
                <c:forEach items="${project.deviceList}" var="device">
                    <div class="row">
                        <div class="col-12">
                            <span class="font-weight-bold">${device.deviceCategory.name}</span> ${device.model}
                        </div>
                    </div>
                </c:forEach>
                <div class="row border-bottom border-top">
                    <div class="col-12 text-center">
                        <p class="langPL">UWAGI DO PROJEKTU</p>
                        <p class="langEN">REMARKS</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <span class="font-italic">${project.remarks}</span>
                    </div>
                </div>
            </div>

            <div class="card-footer">
                <a href="/projects/all" class="btn btn-warning float-left">
                    <p class="langPL">WSTECZ</p>
                    <p class="langEN">BACK</p>
                </a>
                <a href="#" class="btn btn-success float-right disabled">
                    <p class="langPL">EDYCJA</p>
                    <p class="langEN">EDIT</p>
                </a>
            </div>

        </div>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
