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
        <%--@elvariable id="questionSetForMRI" type="pl.krzysztofskul.questionnaire.questionSet.QuestionSetForMRI"--%>
        <form:form modelAttribute="questionSetForMRI" method="post" action="/questionSetMRI/save">
            <div class="card">
                <div class="card-header text-center">
                    <div class="row m-3">
                        <div class="col-12">
                            <p class="langPL">DODATKOWY FORMULARZ DOT. ZAMÓWIENIA PROJEKTU KONCEPCJNEGO DLA APARATU MRI</p>
                            <p class="langEN">ADDITIONAL QUESTION SET FOR ORDER FOR CONCEPTUAL (PRELIMINARY) PROJECT OF MRI INSTALLATION</p>
                        </div>
                    </div>
                    <div class="row border-top p-2">
                        <div class="col-12">
                                ${questionSetForMRI.questionForm.concept.title}
                            <form:hidden path="id"/>
                            <form:hidden path="questionForm.id"/>
<%--                            <c:if test="${questionSetForMRI.questionForm.backToPage ne null}">--%>
<%--                                <input type="hidden" name="backToPage" value="/projects/details/${conceptNew.project.id}">--%>
                                <input type="hidden" name="backToPage" value="${backToPage}">
<%--                            </c:if>--%>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <p class="langPL">WYMAGANY PROJEKT KLATKI FARADAYA</p>
                            <p class="langEN">FARADAY CAGE DESIGN NEEDED</p>
                        </div>
                        <div class="col-6">
                            <form:checkbox path="faradayCageToDesign"/>
                        </div>
                    </div>

                </div>
                <div class="card-footer">
<%--                    <input type="hidden" name="backToPage" value="${backToPage}"/>--%>
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
