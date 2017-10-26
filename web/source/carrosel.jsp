<%-- 
    Document   : carrosel
    Created on : 26/10/2017, 18:13:19
    Author     : vinicius caetano
--%>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

        <div class="item active">
            <img src="../image/livro2.jpg" alt="Oferta1" style="width:50%;">
            <div class="carousel-caption">
                <h3>Oferta do Dia</h3>
                <p>De R$: 60.00 por R$: 30,00</p>
            </div>
        </div>
        <div class="item">
            <img src="../image/livro4.jpg" alt="Oferta2" style="width:50%;">
            <div class="carousel-caption">
                <h3>Oferta da Semana</h3>
                <p>De R$: 100.00 por R$: 70,00 </p>
            </div>
        </div>
        <div class="item">
            <img src="../image/livro5.jpg" alt="Oferta3" style="width:50%;">
            <div class="carousel-caption">
                <h3>Oferta do Mes</h3>
                <p>De R$: 300.00 por R$: 200,00</p>
            </div>
        </div>
    </div>
     <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
