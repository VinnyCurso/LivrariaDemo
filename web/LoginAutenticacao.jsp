<%-- 
    Document   : LoginAutenticacao
    Created on : 20/10/2017, 01:32:15
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@taglib tagdir="/WEB-INF/tags/"  prefix="tagLiv"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <jsp:include page = "source/headBoostrap.jsp" />
        <script src="js/jsInterno/Menu.js" type="text/javascript"></script>

        <title>Login Autenticacao</title>
    </head>
    <body>
        <div>
            <h1>Livraria Demo Autenticação</h1>
            <div class="container">
                <fieldset>
                    <legend>Login</legend>
                    <div class="imagem">
                        <img src="image/login.png" width="300" alt="cond" title="login">
                    </div>
                    <form method="POST" action="LoginServlet" name="formAutenticacao">

                        <div class="form-group">
                            <label>Usuario :</label>
                            <input type="text" name="login" id="login" class="form-control" placeholder="Email"> <br/>
                        </div>

                        <div class="form-group">
                            <label>Senha :</label>
                            <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha"> <br/>
                        </div>
                        <br>
                        <div>        
                            <div>
                                <div>
                                    <label> <tagLiv:MsgLogin/></label>
                                </div>
                            </div>
                        </div>
                        <div id="myprogresso">
                            <div id="myBar"></div>
                        </div>
                        <br>
                        <div>        
                            <div>
                                <button onclick="exebirbarra()">IniciarBarra</button>
                                <button type="submit" name="Logar">Logar</button>
                                </button>
                            </div>
                        </div>
                    </form>
                </fieldset>
            </div>
        </div>
    </body>
</html>
