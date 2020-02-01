<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h1>ADDITIONAL QUESTION SET MRI</h1>

        <form:form modelAttribute="questionSetForMRI" method="post" action="/questionSetMRI/save">
            <div class="card">
                <div class="card-header">
                    ${questionSetForMRI.questionForm.concept.title}
                        <form:hidden path="id"/>
                        <form:hidden path="questionForm.id"/>
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
