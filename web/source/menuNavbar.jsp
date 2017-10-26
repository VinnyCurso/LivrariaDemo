 <%@taglib tagdir="/WEB-INF/tags/"  prefix="tagLiv"%>    

<nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Livraria Demo</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">Home</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="Acabamento.jsp">Acabamento</a></li>
                            <li><a href="Autor.jsp">Autor</a></li>
                            <li><a href="Editora.jsp">Editora</a></li>
                            <li><a href="Genero.jsp">Genero</a></li>
                            <li><a href="Idioma.jsp">Idioma</a></li>
                            <li><a href="Cliente.jsp">Cliente</a></li>
                            <li><a href="Livro.jsp">Livro</a></li>
                            <li><a href="Usuario.jsp">Usuario</a></li>
                            <li><a href="Venda.jsp">Venda</a></li>
                        </ul>
                    </li>
                     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Listagem <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="listAcabamento.jsp">Lista Acabamento</a></li>
                            <li><a href="listAutor.jsp">Lista Autor</a></li>
                            <li><a href="listEditora.jsp">Lista Editora</a></li>
                            <li><a href="listGenero.jsp">Lista Genero</a></li>
                            <li><a href="listIdioma.jsp">Lista Idioma</a></li>
                            <li><a href="listCliente.jsp">Lista Cliente</a></li>
                            <li><a href="listLivro.jsp">Lista Livro</a></li>
                            <li><a href="listUsuario.jsp">Lista Usuario</a></li>
                            <li><a href="listVenda.jsp">Lista Venda</a></li>
                        </ul>
                    </li>
                </ul>
                
                 <ul class="nav navbar-nav navbar-right">
                    <li>
                        <label class="navbar-brand">Usuario:<tagLiv:StatusLogado/></label>
                        <img src="image/usuario.png" width="50" alt="logado" title="logado">
                    </li>
                </ul>
    
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/Sair"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="../LoginAutenticacao.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </nav>

