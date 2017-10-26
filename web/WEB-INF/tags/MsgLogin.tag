<%-- 
    Document   : MsgLogin
    Created on : 26/10/2017, 09:50:46
    Author     : vinicius caetano
--%>

<%@tag body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test = "${mensagem != null}">
            ${mensagem}   
    </c:when>
    
    <c:otherwise>
        Entre com o seu Usuario/Senha
    </c:otherwise>
</c:choose>