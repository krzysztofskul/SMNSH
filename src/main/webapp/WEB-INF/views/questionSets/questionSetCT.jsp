<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 31.01.2020
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="../header.jsp"/>
    <div class="container">
        <form:form modelAttribute="questionSetForCT" method="post" action="/questionSetCT/save">
            <div class="card">
                <div class="card-header text-center">
                    <div class="row m-3">
                        <div class="col-12">
                            <p class="langPL">DODATKOWY FORMULARZ DOT. ZAMÓWIENIA PROJEKTU KONCEPCJNEGO DLA APARATU CT</p>
                            <p class="langEN">ADDITIONAL QUESTION SET FOR ORDER FOR CONCEPTUAL (PRELIMINARY) PROJECT OF CT INSTALLATION</p>
                        </div>
                    </div>
                    <div class="row border-top p-2">
                        <div class="col-12">
                            ${questionSetForCT.questionForm.concept.title}
                            <form:hidden path="id"/>
                            <form:hidden path="questionForm.id"/>
                            <c:if test="${questionSetForCT.questionForm.backToPage ne null}">
                                <input type="hidden" name="backToPage" value="/projects/details/${conceptNew.project.id}">
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <p class="langPL">WYMAGANY PROJEKT OCHORNY RADIOLOG.:</p>
                            <p class="langEN">XRAY PROTECTION DESIGN NEEDED:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="xrayProtectionToDesign"/>
                        </div>
                    </div>

                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
                    <form:button class="btn btn-success float-right ml-1">
                        <span> >> </span>
                        <p class="langPL">ZAPISZ</p>
                        <p class="langEN">SAVE</p>
                    </form:button>
                </div>
            </div>
        </form:form>
        
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
