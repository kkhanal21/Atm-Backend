<%-- 
    Document   : index
    Created on : 14-Nov-2017, 15:54:24
    Author     : kamal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Atms!!</h1>
        <div id="map" style="height: 300px; width: 400px; align-content:center"></div>
        <script>
            function initMap() {

                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 4,

                });

            <c:forEach var="at" items="${atms}">
                var lnlat = {lat: ${at.latitude}, lng: ${at.longitude}
                var marker = new google.maps.Marker({
                position: uluru,
                        map: map
            });
            </c:forEach>

        </script>



        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB9ab5g3RLRbO1chz0rwQADcK6kGIwR-00&callback=initMap">
        </script>
    </body>
</html>
