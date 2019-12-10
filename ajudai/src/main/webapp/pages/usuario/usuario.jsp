<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Usuario</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<!--Menu-->
<header>
    <nav>
        <div class="nav-wrapper blue-grey darken-4">
            <a href="#" class="brand-logo left">
                <img id="logo" src="images/logo.png">
            </a>
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

<!--Conteúdo-->
<main>
    <h1>Bem vindo!</h1>
</main>

<!--Rodapé-->
<footer id="rodape">
    <div class="footer-copyright">
        <div class=" text-lighten-4 lest left">

            <p style="color:black">© 2019 AjudAí</p>

        </div>
    </div>

</footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
</body>
</html>
