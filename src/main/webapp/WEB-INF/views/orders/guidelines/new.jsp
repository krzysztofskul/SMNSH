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
    <link rel="stylesheet" href="<c:url value="/resources/css/smnshStyles.css"/>"/>
</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="guidelineNew">
            <div class="card">
                <div class="card-header text-center">
                    <h4 class="langPL">KREATOR ZAMÓWIENIA WYTYCZNYCH DO PROJEKTU KONECPJI O ID:${guidelineNew.concept.id} </h4>
                    <h4 class="langEN">ORDER FORM FOR GUIDELINES PROJECT TO CONCEPTUAL PROJECT WITH ID:${guidelineNew.concept.id}</h4>
                </div>
                <div class="card-body">
                    <form:hidden path="id"/>
                    <form:hidden path="author.id"/>
                    <form:hidden path="client"/>
                    <form:hidden path="concept.id"/>
                    <form:hidden path="device.id"/>
                    <div class="form-row">
                        <div class="form-group col-sm-8 ml-auto mr-auto">
                            <label for="title">
                                <p class="langPL">TYTUŁ:</p>
                                <p class="langEN">TITLE:</p>
                            </label>
                            <form:input path="title" id="title" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-8 ml-auto mr-auto">
                            <label for="dateOfAcceptation">
                                <p class="langPL">DATA AKCEPTACJI KLIENTA:</p>
                                <p class="langEN">DATE OF ACCEPTATION BY CUSTOMER:</p>
                            </label>
                            <input type="date" id="dateOfAcceptation" class="form-control" disabled/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-8 ml-auto mr-auto">
                            <label for="personAccepting">
                                <p class="langPL">ZAAKCEPTOWAŁ:</p>
                                <p class="langEN">PERSON ACCEPTING:</p>
                            </label>
                            <form:input path="personAccepting" id="personAccepting" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-8 ml-auto mr-auto">
                            <label for="priority">
                                <p class="langPL">PRIORYTET:</p>
                                <p class="langEN">PRIORTY:</p>
                            </label>
                            <form:input path="priority" id="priority" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-sm-8 ml-auto mr-auto">
                            <label for="dateTimeDeadline">
                                <p class="langPL">TERMIN REALIZACJI:</p>
                                <p class="langEN">DEADLINE:</p>
                            </label>
                            <input type="date" id="dateTimeDeadline" class="form-control" disabled/>
                        </div>
                    </div>
                    <div class="form-row d-block">
                        <div class="form-group col-sm-8 ml-auto mr-auto">
                            <label for="remarks">
                                <p class="langPL">UWAGI:</p>
                                <p class="langEN">REMARKS:</p>
                            </label>
                            <form:textarea path="remarks" cssClass="form-control" id="remarks"/>
                        </div>
                    </div>
                </div>
                <!-- *** FOOTER SECTION *** -->
                <div class="card-footer">
                    <a href="/users/details/${guidelineNew.author.id}" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
                        <%--                    <input type="submit" class="btn btn-success float-right" value="SAVE"/>--%>
                    <form:button class="btn btn-success float-right">
                        <span>.</span>
                        <p class="langPL">ZAMÓW</p>
                        <p class="langEN">ORDER</p>
                    </form:button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
