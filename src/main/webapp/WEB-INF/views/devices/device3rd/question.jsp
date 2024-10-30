<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 25.01.2020
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../../header.jsp"/>

    <div class="container text-center">
        <p class="langPL">CZY CHCESZ DODAĆ TERAZ URZĄDZENIA TRZECIE..?</p>
        <p class="langEN">DO YOU WANT TO ADD 3RD PARTY DEVICES NOW..?</p>
        <div class="row d-inline block">
        	<a href="/projects/details/${projectId}" class="btn btn-outline-warning d-inline-block float-left">
		        <p class="langPL">NIE</p>
		        <p class="langEN">NO</p>
        	</a>
        	<a href="/device3rd/new?projectId=${projectId}" class="btn btn-outline-success d-inline-block float-right">
		        <p class="langPL">TAK</p>
		        <p class="langEN">YES</p>
        	</a>
        </div>
    </div>
	<br>

    <jsp:include page="../../footer.jsp"/>

</body>
</html>
