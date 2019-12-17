<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<!--Menu-->
<header>
    <nav>
        <div class="nav-wrapper blue-grey darken-4">
            <a href="#" class="brand-logo left"><img src="images/logo.png"></a>
            <div id="nav-mobile" class="right">
                <form action="BuscarConteudo">
                    <ul id="campoBuscar">
                        <li>
                            <input id="campoBusca" type="text" class="validate" placeholder="Buscar conteúdo">
                        </li>

                        <li>
                            <a id="botao" class="waves-effect waves-light btn-small">Buscar</a>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </nav>

</header>
<!--Barra lateral-->
<div class="wrapper">
    <nav id="sidebar">
        <!-- Sidebar Header -->
        <div class="sidebar-header">
            <h3>Estante</h3>
        </div>
        <!-- Sidebar Links -->
        <ul class="list-unstyled components">
            <li>
                <!-- Link with dropdown items -->
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">
                    <h5>Prateleira</h5>
                </a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li><a href="#">Conteúdo</a></li>
                </ul>
            </li>
        </ul>
    </nav>
   <!-- <div id="content">
        <button type="button" id="sidebarCollapse" class="navbar-btn">
            <span></span> <span></span> <span></span>
        </button>
        <div> </div>
    </div>-->
</div>
       <!--Conteúdo-->
       <main>
           <div class= "jumbotron" >
               <h1 class= "display-4" > Hello, world! </h1>
               <p class= "lead" >
                   This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.
               </p> <hr class= "my-4" >
               <p> It uses utility classes for typography and spacing to space content out within the larger container. </p>
               <p class= "lead" >
                   <a class= "btn btn-primary btn-lg" href= "#" role= "button" > Learn more </a>
               </p>
           </div>


       </main>

        <!--Rodapé-->
    <!--
        <footer id="rodape">
            <div class="footer-copyright">
                <div class=" text-lighten-4 lest left">

                    <p style="color:black">© 2019 AjudAí</p>

                </div>
            </div>

      -->
        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
        <script src="js/usuario.js"></script>
</body>



</html>
