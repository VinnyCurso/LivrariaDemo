<%-- 
    Document   : StatusLogado
    Created on : 26/10/2017, 09:38:27
    Author     : vinicius caetano
--%>

<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test = "${sessaoUsuario != null}">
            ${sessaoUsuario}   
    </c:when>
    
    <c:otherwise>
        Não Logado
    </c:otherwise>
</c:choose>