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
        <%--@elvariable id="questionSetForXRAY" type="pl.krzysztofskul.questionnaire.questionSet.QuestionSetForXRAY"--%>
        <form:form modelAttribute="questionSetForXRAY" method="post" action="/questionSetXRAY/save">
            <div class="card">
                <div class="card-header text-center">
                    <div class="row m-3">
                        <div class="col-12">
                            <p class="langPL">DODATKOWY FORMULARZ DOT. ZAMÓWIENIA PROJEKTU KONCEPCJNEGO DLA APARATU RTG</p>
                            <p class="langEN">ADDITIONAL QUESTION SET FOR ORDER FOR CONCEPTUAL (PRELIMINARY) PROJECT OF X-RAY INSTALLATION</p>
                        </div>
                    </div>
                    <div class="row border-top p-2">
                        <div class="col-12">
                            ${questionSetForXRAY.questionForm.concept.title}
                            <form:hidden path="id"/>
                            <form:hidden path="questionForm.id"/>
<%--                            <c:if test="${questionSetForXRAY.questionForm.backToPage ne null}">--%>
<%--                                <input type="hidden" name="backToPage" value="/projects/details/${conceptNew.project.id}">--%>
                                <input type="hidden" name="backToPage" value="${backToPage}">
<%--                            </c:if>--%>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <p class="langPL">WYMAGANY PROJEKT OCHORNY RADIOLOG.:</p>
                            <p class="langEN">XRAY PROTEXRAYION DESIGN NEEDED:</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="xrayProtectionToDesign"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <p class="langPL">WYMAGANY SID.:</p>
                            <p class="langEN">SID REQUIRED:</p>
                        </div>
                        <div class="col-6">
                            <form:input path="sourceImageDistanceRequired"/>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <input type="hidden" name="backToPage" value="${backToPage}"/>
                    <a href="#" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / WSTECZ</p>
                        <p class="langEN">CANCEL / BACK</p>
                    </a>
                    <form:button id="questionSetSaveBtn" class="btn btn-success float-right ml-1">
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
