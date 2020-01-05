<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 05.01.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
        <div class="card">
            <div class="card-header">
                ${concept.id} | ${concept.title}
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        AUTHOR:
                    </div>
                    <div class="col">
                        ${concept.author.nameFirst} ${concept.author.nameLast}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col">
                        DEVICE:
                    </div>
                    <div class="col">
                        ${concept.device.model}
                    </div>
                </div>
            </div>
            <div class="card-footer">
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
