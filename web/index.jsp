<%-- 
    Document   : index
    Created on : 18/10/2017, 14:55:48
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page = "source/headBoostrap.jsp" />
        <title>Livraria Demo</title>
    </head>
    <body>
        <div class="container">
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Livraria Demo</h1>
        
        <jsp:forward page="LoginAutenticacao.jsp" />
        </div>
    </body>
</html>
