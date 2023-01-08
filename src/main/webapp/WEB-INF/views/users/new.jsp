<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 18.01.2020
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="user" enctype="multipart/form-data">
            <div class="card">
                <div class="card-header text-center">
                    <p class="langPL">KREATOR NOWEGO UŻYTKOWNIKA</p>
                    <p class="langEN">NEW USER FORM</p>
                </div>
                <div class="card-body">
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">ID:</p>
                            <p class="langEN">ID:</p>
                        </div>
                        <div class="col-6">
                            <form:input cssClass="w-100" path="id" disabled="true"/>
                        </div>
                    </div>
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">IMIĘ:</p>
                            <p class="langEN">FIRST NAME:</p>
                        </div>
                        <div class="col-6">
                            <form:input cssClass="w-100" path="nameFirst"/>
                            <div class="error">
                                <form:errors path="nameFirst" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">NAZWISKO:</p>
                            <p class="langEN">LAST NAME:</p>
                        </div>
                        <div class="col-6">
                            <form:input cssClass="w-100" path="nameLast"/>
                            <div>
                                <form:errors path="nameLast" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">STANOWISKO:</p>
                            <p class="langEN">BUSINESS POSITION:</p>
                        </div>
                        <div class="col-6">
                            <form:select cssClass="w-100" path="businessPosition">
                                <c:forEach items="${userBusinessPositionList}" var="businessPosition">
                                    <c:if test="${businessPosition.toString() ne 'ADMINI / ADMIN'}">
                                        <form:option value="${businessPosition}" label="${businessPosition.toString()}"/>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">E-MAIL:</p>
                            <p class="langEN">E-MAIL:</p>
                        </div>
                        <div class="col-6">
                            <form:input cssClass="w-100" path="email"/>
                            <div>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">HASŁO:</p>
                            <p class="langEN">PASSWORD:</p>
                        </div>
                        <div class="col-6">
                            <form:password cssClass="w-100" path="password"/>
                            <%--<div>
                                <form:errors cssClass="error" path="password"/>
                            </div>--%>
                        </div>
                    </div>
                    <!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">POTWIERDŹ HASŁO:</p>
                            <p class="langEN">CONFIRM PASSWORD:</p>
                        </div>
                        <div class="col-6">
                            <form:password cssClass="w-100" path="passwordConfirmation"/>
                            <div>
                                <%--<form:errors path="passwordConfirmation" cssClass="error"/>--%>
                                <c:if test="${errorPasswordConfirm eq true}">
                                    <p class="error">(m) Wpisz ponownie hasło poprawnie / Re-type your password correctly!</p>
                                </c:if>
                            </div>

                        </div>
                    </div>
                    
                    <%--<!-- INPUT ROW -->
                    <div class="row mt-2">
                        <div class="col-6">
                            <p class="langPL">ZDJĘCIE PROFILOWE:</p>
                            <p class="langEN">AVATAR:</p>
                        </div>
                        <div class="col-6">
                            <input type="file" name="avatarUpload">
                        </div>
                    </div>--%>
                    
                </div>
                <div class="card-footer">
                    <a href="/users/all" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
                    <form:button class="btn btn-success float-right ml-1">
                        <span>.</span>
                        <p class="langPL">ZAPISZ</p>
                        <p class="langEN">SAVE</p>
                    </form:button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>