<%-- 
    Document   : LoginAutenticacao
    Created on : 20/10/2017, 01:32:15
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.mask.min.js" type="text/javascript"></script>
        <script src="js/bootstrap-notify.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <title>Login Autenticacao</title>
    </head>
    <body>
       <div>
        <h1>Livraria Demo Autenticação</h1>
        <fieldset>
            <legend>Login</legend>
            <div class="imagem">
                <img src="image/login.png" width="300" alt="cond" title="login">
        </div>
            <form method="post" action="index.jsp" name="formAutenticacao">
                
                <div>
                <label>Usuario :</label>
                <input type="text" name="email"  placeholder="Email"> <br/>
               </div>
                
                <div>
                <label>Senha :</label>
                <input type="password" name="senha"  placeholder="Senha"> <br/>
               </div>
    <br>
    <div>        
      <div>
        <div>
          <label><input type="checkbox" name="lembrar"> Lembrar-me</label>
        </div>
      </div>
    </div>
    <div>        
      <div>
          <button type="submit" >Logar</button>
      </div>
    </div>
  </form>
        </fieldset>
  <br>
</div>
    </body>
</html>
