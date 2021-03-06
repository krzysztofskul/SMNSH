<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.01.2020
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>SMNSH</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

	<jsp:include page="header.jsp"/>

	<div class="container h-50 pt-3 pb-3" style='background-image: url("/resources/img/img_bg_002_1920×1080px.jpg"); background-size: 100%; background-repeat: no-repeat; opacity: 0.4;'>
		<h1 class="m-5 p-1 pl-5 pr-5 d-inline-block" style="background-color: rgba(128, 128, 128, 0.8)">SMNSH APP. HOME PAGE</h1>
		<p class="langPL">
			Aplikacja wspierająca zarządzanie dokumentacją techniczną oraz koordynjąca komunikację
			pomiędzy Kierownikami projektów, a Projektantami w zakresie przygotowania dokumentacji technicznej,
			potrzebnej do realizacji dostaw i instalacji sprzętu medycznego w pomieszczeniach szpitalnych.
		</p>
		<p class="langEN">
			The application supports technical documentation management and communication
			between Project Managers and Designers/Planners connected,
			with preparation of the project documentation, needed to install medical devices in hospital rooms.
		</p>
	</div>

	<jsp:include page="footer.jsp"/>

</body>
</html>