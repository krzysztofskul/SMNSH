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

    <%--bootstrap--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%--css--%>
    <link rel="stylesheet" type="text/css" href="/resources/css/card.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/row.css"/>
    <!--jQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <!--JS files-->
    <script src="/resources/js/projectCharter/projectCharter.js" type="text/javascript"></script>

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
        <div class="content">
            <div class="card smnshCard">

                <div class="card-header">
                    <div class="row smnshRow">
                        <div class="col">
                            <p class="langPL">ID karty projektu</p>
                            <p class="langEN">Project charter ID</p>
                            <p>${projectCharter.id}</p>
                        </div>
                        <div class="col">
                            <p class="langPL">ID projektu</p>
                            <p class="langEN">Project ID</p>
                            <p>${projectCharter.project.id}</p>
                        </div>
                        <div class="col">
                        </div>
                        <div class="col">
                            <p class="langPL">Nazwa projektu</p>
                            <p class="langEN">Project name</p>
                            <a href="/projects/details/${projectCharter.project.id}">
                                <p>${projectCharter.project.projectName}</p>
                            </a>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                </div>

                <div class="card-body">
                    <div class="input-group">
                        <div class="input-group-text">
                            <div>
                                <div class="langPL">GENEZA PROJEKTU</div>
                                <div class="langEN">BUSINESS CASE</div>
                            </div>
                        </div>
                        <textarea class="form-control" aria-label="REASONS">${projectCharter.reasons}</textarea>
                    </div>
                    <div class="input-group">
                        <div class="input-group-text">
                            <div>
                                <div class="langPL">CELE PROJEKTU</div>
                                <div class="langEN">GOAL STATEMENT</div>
                            </div>
                        </div>
                        <textarea class="form-control" aria-label="REASONS">${projectCharter.goals}</textarea>
                    </div>
                    <div class="input-group">
                        <div class="input-group-text">
                            <div>
                                <div class="langPL">RYZYKA PROJEKTU</div>
                                <div class="langEN">RISKS</div>
                            </div>
                        </div>
                        <textarea class="form-control" aria-label="REASONS">${projectCharter.risks}</textarea>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="row smnshRow">
                        <div class="col">
                            <button class="btn btn-outline-warning">
                                <p class="langPL">ANULUJ</p>
                                <p class="langEN">CANCEL</p>
                            </button>
                        </div>
                        <div class="col"></div>
                        <div class="col"></div>
                        <div class="col"></div>
                        <div class="col">
                            <button class="btn btn-outline-success float-right">
                                <p class="langPL">ZAPISZ</p>
                                <p class="langEN">SAVE</p>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>

</body>
</html>
