<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/menuProjectsAll.js"></script>
</head>
<body>

	<div class="container-fluid bg-light border mb-5">

		<ul class="nav nav-pills">
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/0?userId=${param.userId}&view=list">
		   		<p class="langPL">AKWIZYCJA</p>
		   		<p class="langEN">AQUISITION</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/0a?userId=${param.userId}&view=list">
		   		<p class="langPL">UMOWA</p>
		   		<p class="langEN">AGREEMENT</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/1?userId=${param.userId}&view=list">
		   		<p class="langPL">PLANOWANIE INSTALACJI</p>
		   		<p class="langEN">PRELIMINARY PLANNING</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/2?userId=${param.userId}&view=list">
		   		<p class="langPL">OPRACOWYWANIE WYTYCZNYCH</p>
		   		<p class="langEN">FINAL PLANNING</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/3?userId=${param.userId}&view=list">
		   		<p class="langPL">ADAPTACJA POMIESZCZEÅ</p>
		   		<p class="langEN">ROOMS CONVERSION</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/4?userId=${param.userId}&view=list">
		   		<p class="langPL">DOSTAWA URZÄDZEÅ</p>
		   		<p class="langEN">DEVICES DELIVERY</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/5?userId=${param.userId}&view=list">
		   		<p class="langPL">INSTALACJA URZÄDZEÅ</p>
		   		<p class="langEN">DEVICES INSTALLATION</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/6?userId=${param.userId}&view=list">
		   		<p class="langPL">URUCHOMIENIE</p>
		   		<p class="langEN">START UP</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/7?userId=${param.userId}&view=list">
		   		<p class="langPL">SZKOLENIA</p>
		   		<p class="langEN">TRAININGS</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/8?userId=${param.userId}&view=list">
		   		<p class="langPL">ZAKOÅCZONY</p>
		   		<p class="langEN">FINISHED</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all/9?userId=${param.userId}&view=list">
		   		<p class="langPL">ANULOWANY</p>
		   		<p class="langEN">CANCELED</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline" href="/projects/all?userId=${param.userId}&view=list">
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
		    <a class="nav-link btn btn-outline disabled" href="#" id="btnViewCards">
		   		<p class="langPL">WIDOK SIATKI</p>
		   		<p class="langEN">GRID VIEW</p>
			</a>
		  </li>
		  <li class="nav-item ml-auto mr-auto text-center">
		    <a class="nav-link btn btn-outline disabled" href="#" id="btnViewList">
		   		<p class="langPL">WIDOK LISTY</p>
		   		<p class="langEN">LIST VIEW</p>
			</a>
		  </li>
		</ul>
	</div>
</body>
</html>