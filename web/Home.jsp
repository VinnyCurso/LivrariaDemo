<%-- 
    Document   : Home
    Created on : 26/10/2017, 17:28:39
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
        
        <jsp:include page = "source/carrosel.jsp" />
        <jsp:include page = "source/links.jsp" />
        </div>
        <jsp:include page = "source/footer.jsp" />
    </body>
</html>
