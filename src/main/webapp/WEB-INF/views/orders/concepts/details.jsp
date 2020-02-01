<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="card-header font-weight-bold">
                ${concept.id} | ${concept.title}
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">AUTOR:</p>
                        <p class="langEN">AUTHOR:</p>
                    </div>
                    <div class="col-6">
                        ${concept.author.nameFirst} ${concept.author.nameLast}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">KLIENT</p>
                        <p class="langEN">CUSTOMER:</p>
                    </div>
                    <div class="col-6">
                        ${concept.client}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">TERMIN REALIZAZJI:</p>
                        <p class="langEN">DEADLINE:</p>
                    </div>
                    <div class="col-6">
                        ${concept.dateTimeDeadline.toLocalDate()} ${concept.dateTimeDeadline.toLocalTime()}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">PRIORYTET:</p>
                        <p class="langEN">PRIORITY:</p>
                    </div>
                    <div class="col-6">
                        ${concept.priority}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">PROJEKTANT/PLANISTA:</p>
                        <p class="langEN">DESIGNER/PLANNER:</p>
                    </div>
                    <div class="col-6">
                        ${concept.planner.nameFirst} ${concept.planner.nameLast}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">STATUS:</p>
                        <p class="langEN">STATUS:</p>
                    </div>
                    <div class="col-6">
                        ${concept.status.toString()}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">APARAT:</p>
                        <p class="langEN">DEVICE:</p>
                    </div>
                    <div class="col-6">
                        ${concept.device.model}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">OPIS:</p>
                        <p class="langEN">DESCRIPTION:</p>
                    </div>
                    <div class="col-6">
                        ${concept.description}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">PODKŁAD ARCHITEKTONICZNY:</p>
                        <p class="langEN">ARCHITECTURAL LAYOUT:</p>
                    </div>
                    <div class="col-6">
                        ${concept.layout}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">WIZJA LOKALNA:</p>
                        <p class="langEN">ON SITE VISITED:</p>
                    </div>
                    <div class="col-6">
                        ${concept.onSiteVisited}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">MOŻLIWOŚĆ INGERENCJI W UKŁAD ŚCIAN:</p>
                        <p class="langEN">WALL INTERFERENCE POSSIBILITY:</p>
                    </div>
                    <div class="col-6">
                        ${concept.wallInterferencePossible}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">SUGESTIE KLIENTA:</p>
                        <p class="langEN">CUSTOMER SUGGESTIONS:</p>
                    </div>
                    <div class="col-6">
                        <c:if test="${concept.customerSuggestions eq null}">
                            <p class="langPL">BRAK SUGESTII KLIENTA</p>
                            <p class="langEN">NO SUGESTIONS FROM CUSTOMER</p>
                        </c:if>
                        <c:if test="${concept.customerSuggestions ne null}">
                            ${concept.customerSuggestions}
                        </c:if>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">WYZNACZENIE DROGI TRANSPORTOWEJ:</p>
                        <p class="langEN">TRANSPORT ROUTE TO MARK:</p>
                    </div>
                    <div class="col-6">
                        ${concept.transportRouteDesignNeeded}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">WSKAZANO MIEJSCE TABLICY ELEKTR.:</p>
                        <p class="langEN">ELECTRICAL BOX PLACE SPECIFIED:</p>
                    </div>
                    <div class="col-6">
                        ${concept.electricBoxSpecified}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">ZAPROJEKTOWANIE DODATKOWYCH POMIESZCZEŃ:</p>
                        <p class="langEN">ADDITIONAL ROOMS TO DESIGN:</p>
                    </div>
                    <div class="col-6">
                        <c:if test="${concept.additionalRoomsToDesign eq null}">
                            <p class="langPL">BRAK DODATKOWYCH POMIESZCZEŃ DO ZAPROJEKTOWANIA</p>
                            <p class="langEN">NO ADDITIONAL ROOM NEEDED</p>
                        </c:if>
                        <c:if test="${concept.additionalRoomsToDesign ne null}">
                            ${concept.additionalRoomsToDesign}
                        </c:if>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">INNE UWAGI KIEROWNIKA PROJEKTU:</p>
                        <p class="langEN">PROJECT MANAGER OTHER REMARKS:</p>
                    </div>
                    <div class="col-6">
                        ${concept.remarks}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-6 text-right">
                        <p class="langPL">WYTYCZNE:</p>
                        <p class="langEN">GUDELINE:</p>
                    </div>
                    <div class="col-6">
                        ID: ${concept.guideline.id}
                    </div>
                </div>
                <!-- ***** ADD. QUESTION SET ****** -->
                <div class="row border-top border-bottom border-warning">
                    <!-- IF MRI -->
<%--                    <c:if test="${concept.device.deviceCategory eq 'MRI'}">--%>
                        <div class="row">
                            <div class="col-6 text-right">
                                <p class="langPL">DODATKOWY KWESTIONARIUSZ DLA MRI (PROJEKT KLATKI FARADAYA):</p>
                                <p class="langEN">MRI QUESTION SET (FARADY CAGE TO DESIGN):</p>
                            </div>
                            <div class="col-6">
                                ${concept.questionForm.questionSetForMRI.faradayCageToDesign}
                            </div>
                        </div>
<%--                    </c:if>--%>
                    <!-- IF CT -->
<%--                    <c:if test='${concept.device.deviceCategory == "CT"}'>--%>
                        <div class="row">
                            <div class="col-6 text-right">
                                <p class="langPL">DODATKOWY KWESTIONARIUSZ DLA CT (PROJEKT OSŁON RADIOLOG.):</p>
                                <p class="langEN">MRI QUESTION SET (XRAY PROTECTION PROJECT TO PREPARE):</p>
                            </div>
                            <div class="col-6">
                                    ${concept.questionForm.questionSetForCT.xrayProtectionToDesign}
                            </div>
                        </div>
<%--                    </c:if>--%>
                    <!-- IF XRAY -->
                        <%--                    <c:if test='${concept.device.deviceCategory == "XRAY"}'>--%>
                        <div class="row">
                            <div class="col-6 text-right">
                                <p class="langPL">DODATKOWY KWESTIONARIUSZ DLA XRAY (PROJEKT OSŁON RADIOLOG.):</p>
                                <p class="langEN">MRI QUESTION SET (XRAY PROTECTION PROJECT TO PREPARE):</p>
                            </div>
                            <div class="col-6">
                                ${concept.questionForm.questionSetForXRAY.xrayProtectionToDesign}
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6 text-right">
                                <p class="langPL">DODATKOWY KWESTIONARIUSZ DLA XRAY (WYMAGANY SID):</p>
                                <p class="langEN">MRI QUESTION SET (SID REQUIRED):</p>
                            </div>
                            <div class="col-6">
                                ${concept.questionForm.questionSetForXRAY.sourceImageDistanceRequired}
                            </div>
                        </div>
                    <%--                    </c:if>--%>
                </div>
                <!--- ********** END ADD. QUESTION SET ******** -->
            </div>
            <div class="card-footer">
                <a href="/concepts/all" class="btn btn-warning">
                    <p class="langPL">WSTECZ</p>
                    <p class="langEN">BACK</p>
                </a>
                <a href="/concepts/edit/${concept.id}" class="btn btn-primary float-right">
                    <p class="langPL">EDYCJA</p>
                    <p class="langEN">EDIT</p>
                </a>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
