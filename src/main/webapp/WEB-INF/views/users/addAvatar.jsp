<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="container">
		<form action="/add-avatar" method="post" enctype="multipart/form-data">
		
		<div class="card">
		    <div class="card-header text-center">
		        <p class="langPL">KREATOR NOWEGO UŻYTKOWNIKA</p>
		        <p class="langEN">NEW USER FORM</p>
		    </div>
		    <div class="card-body">

				<!-- INPUT ROW -->
				<div class="row mt-2">
				    <div class="col-6">
				        <p class="langPL">ID użytkownika:</p>
				        <p class="langEN">User ID:</p>
				    </div>
				    <div class="col-6">
				        <input type="text" name="userId" value = "${param.userId}"/>
				    </div>
				</div>
		
				<!-- INPUT ROW -->
				<div class="row mt-2">
				    <div class="col-6">
				        <p class="langPL">ZDJĘCIE PROFILOWE:</p>
				        <p class="langEN">AVATAR:</p>
				    </div>
				    <div class="col-6">
				        <input type="file" name="avatarUpload">
				    </div>
				</div>
			
                <div class="card-footer">
                    <a href="#" class="btn btn-warning float-left">
                        <span><<</span>
                        <p class="langPL">ANULUJ / POMIŃ</p>
                        <p class="langEN">CANCEL / SKIP</p>
                    </a>
                    <input type="submit" value="ZAPISZ / SAVE" class="btn btn-success float-right ml-1"/>
                </div>
				
			</div>
		</div>
    
    	</form>>
   	</div>
    	
    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>