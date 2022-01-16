<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: z0041nhm
  Date: 16.01.2022
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMNSH</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

    <header>
        <jsp:include page="../header.jsp"/>
    </header>

    <main>
        <div class="test">
            <h1>Test:</h1>
            <h2>Project charter id: ${projectCharter.id}</h2>
            <h2>For project id: ${projectCharter.project.id} <a href="/projects/details/${projectCharter.project.id}"> >>> </a> </h2>
            <h2>And project name: ${projectCharter.project.projectName}</h2>
            <h3>And project manager name: ${projectCharter.project.projectManager.nameFirst}</h3>
        </div>
    </main>

    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>

</body>
</html>
