<%@ page import="pl.krzysztofskul.user.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 03.01.2020
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>SMNSH</title>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>

<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>--%>
<%--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>--%>

    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="/resources/css/smnshStyles.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/row.css"/>
    <script type="text/javascript" src="<c:url value="/resources/js/demoMode.js"/>"></script>
</head>
<body>
    <div class="container-fluid border-bottom pt-4 pb-1 mb-5 bg-light">
        <div id="tooltipDemoInfo"></div>
        <div class="text-left" id="headerTitle">
            <h4 class="pl-5 font-weight-bold" style="letter-spacing: 15px; color: dimgrey">SMNSH APP.</h4>
            <div>
                <div id="demoCounterTitle" class="d-inline-block">
                    <p class="langPL">Tryb demo aktywny - wykonano kroków:</p>
                    <p class="langEN">Demo mode activated - steps done:</p>
                </div>
                <span>
                    <p id="demoCounter" class="d-inline-block ml-5" style="font-size: 40px">${sessionScope.demoSession.toString()}</p>
                </span>
            </div>
            <div>
                <a id="demoModeReset" class="d-inline-block btn btn-outline-dark invisible disabled" href="/demoModeReset">DEMO MODE RESET</a>
                <a id="demoModeOFF" class="d-inline-block btn btn-outline-dark invisible" href="/demoModeOff">DEMO MODE OFF</a>
            </div>
        </div>
        <div class="text-right">
            <%
                if (session.getAttribute("userLoggedIn") != null) {
                    User user = (User) session.getAttribute("userLoggedIn");
                    out.print(
                            "<span>ID: </span>"+"<span id='userLoggedIn'>"+user.getId()+"</span>"+"<span> | </span>"+
                            user.getNameFirst()+" "+
                            user.getNameLast()+" "+
                            "<a href='/users/details/"+user.getId()+"' class='btn btn-primary ml-2 mr-2'>" +
                                "<div class='langPL text-white'>MÓJ PROFIL</div>" +
                                "<div class='langEN text-dark'>MY PROFILE</div>" +
                            "</a>"+
                            "<a id ='logoutBtn' href='/logout' class='btn btn-danger'>" +
                                "<div class='langPL text-white'>WYLOGUJ</div>" +
                                "<div class='langEN text-dark'>LOG OUT</div>" +
                            "</a>"
                    );
                } else {
                    out.print(
                            "<div class='dropdown show'>"+
                    		  "<a class='btn btn-secondary dropdown-toggle' href='#' role='button' id='dropdownMenuLink' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>"+
                    		    "<p class='langPL'>ZALOGUJ JAKO GOŚĆ:</p>"+
                    		    "<p class='langEN'>LOGIN AS A GUEST:</p>"+
                    		  "</a>"+
                    		  "<div class='dropdown-menu' aria-labelledby='dropdownMenuLink'>"+
                    		    "<a class='dropdown-item' href='/login?guest=salesRep-wg'>"+
                            		    "<p class='langPL'>PRZEDSTAWICIEL HANDLOWY WOJCIECH G.</p>"+
                            		    "<p class='langEN'>SALES REP. WOJCIECH G.</p>"+
                    		  	"</a>"+
                    		    "<a class='dropdown-item' href='/login?guest=salesRep-rg'>"+
                            		    "<p class='langPL'>PRZEDSTAWICIEL HANDLOWY RYSZARD G.</p>"+
                            		    "<p class='langEN'>SALES REP. RYSZARD G.</p>"+
                    		  	"</a>"+
                    		  	"<div class='dropdown-divider'></div>"+
								"<a class='dropdown-item' href='/login?guest=projectManager-ewm'>"+
                            		    "<p class='langPL'>KIEROWNIK PROJEKTU EWA W-M.</p>"+
                            		    "<p class='langEN'>PROJECT MANAGER EWA W-M.</p>"+
                    		  	"</a>"+
                    		  	"<a class='dropdown-item' href='/login?guest=projectManager-sk'>"+
                            		    "<p class='langPL'>KIEROWNIK PROJEKTU SEBASTIAN K.</p>"+
                            		    "<p class='langEN'>PROJECT MANAGER SEBASTIANK.</p>"+
                    		  	"</a>"+
                    		  	"<a class='dropdown-item' href='/login?guest=projectManager-hs'>"+
                            		    "<p class='langPL'>KIEROWNIK PROJEKTU HENRYK S.</p>"+
                            		    "<p class='langEN'>PROJECT MANAGER HENRYK S.</p>"+
                    		  	"</a>"+
                    		  	"<div class='dropdown-divider'></div>"+
								"<a class='dropdown-item' href='/login?guest=designer-md'>"+
                            		    "<p class='langPL'>PROJEKTANT MACIEJ D.</p>"+
                            		    "<p class='langEN'>DESIGNER MACIEJ D.</p>"+
                    		  	"</a>"+
								"<a class='dropdown-item' href='/login?guest=designer-kd'>"+
                            		    "<p class='langPL'>PROJEKTANT KAROL D.</p>"+
                            		    "<p class='langEN'>DESIGNER KAROL D.</p>"+
                    		  	"</a>"+
								"<a class='dropdown-item' href='/login?guest=designer-kk'>"+
                            		    "<p class='langPL'>PROJEKTANT KRZYSZTOF K.</p>"+
                            		    "<p class='langEN'>DESIGNER KRZYSZTOF K.</p>"+
                    		  	"</a>"+
                    		  "</div>"+
                    		"</div>"
                    );

                }
            %>
        </div>
        <div class="mt-3 pt-1 border-top">
            <jsp:include page="menuMain.jsp"/>
        </div>
    </div>
</body>
</html>
