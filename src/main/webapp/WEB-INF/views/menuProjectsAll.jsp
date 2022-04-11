<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

	<div class="container-fluid bg-light border mb-5">

		<ul class="nav nav-pills">
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/0?userId=${param.userId}">
		   		<p class="langPL">AKWIZYCJA</p>
		   		<p class="langEN">AQUISITION</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/1?userId=${param.userId}">
		   		<p class="langPL">PLANOWANIE INSTALACJI</p>
		   		<p class="langEN">PRELIMINARY PLANNING</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/2?userId=${param.userId}">
		   		<p class="langPL">OPRACOWYWANIE WYTYCZNYCH</p>
		   		<p class="langEN">FINAL PLANNING</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/3?userId=${param.userId}">
		   		<p class="langPL">ADAPTACJA POMIESZCZEŃ</p>
		   		<p class="langEN">ROOMS CONVERSION</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/4?userId=${param.userId}">
		   		<p class="langPL">DOSTAWA URZĄDZEŃ</p>
		   		<p class="langEN">DEVICES DELIVERY</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/5?userId=${param.userId}">
		   		<p class="langPL">INSTALACJA URZĄDZEŃ</p>
		   		<p class="langEN">DEVICES INSTALLATION</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/6?userId=${param.userId}">
		   		<p class="langPL">URUCHOMIENIE</p>
		   		<p class="langEN">START UP</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/7?userId=${param.userId}">
		   		<p class="langPL">SZKOLENIA</p>
		   		<p class="langEN">TRAININGS</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/8?userId=${param.userId}">
		   		<p class="langPL">ZAKOŃCZONY</p>
		   		<p class="langEN">FINISHED</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/9?userId=${param.userId}">
		   		<p class="langPL">ANULOWANY</p>
		   		<p class="langEN">CANCELED</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all?userId=${param.userId}">
		   		<p class="langPL">WSZYSTKIE</p>
		   		<p class="langEN">ALL</p>
			</a>
		  </li>
		</ul>
		
		<ul class="nav nav-pills">
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline disabled" href="#">
		   		<p class="langPL">SORTUJ WG STATUSU</p>
		   		<p class="langEN">SORT BY STATUS</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline disabled" href="#">
				<p class="langPL">SORTUJ WG TERMINU REALIZACJI</p>
		   		<p class="langEN">SORT DEADLINE</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline disabled" href="#">
		   		<p class="langPL">WIDOK SIATKI</p>
		   		<p class="langEN">GRID VIEW</p>
			</a>
		  </li>
		</ul>
	</div>
</body>
</html>