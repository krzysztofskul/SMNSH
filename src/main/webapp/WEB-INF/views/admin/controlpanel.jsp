<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.05.2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/passwordVerification.js"/>"></script>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <c:forEach items="${listEmailSMNSH}" var="emailSMNSH">
            <p>${emailSMNSH.email} | ${emailSMNSH.password}</p>
        </c:forEach>

        <div>
            <p>PSWD SETTER:</p>
        </div>
        <form:form modelAttribute="emailSMNSH" method="post">
            <form:hidden path="id"/>
            <form:hidden path="email"/>
            <form:password id="password" path="password"/>
            <form:button id="buttonSave" class="btn btn-success invisible">SAVE</form:button>
        </form:form>

        <input type="password" id="passwordVerification"/>

    </div>

    <jsp:include page="../footer.jsp"/>


</body>
</html>
