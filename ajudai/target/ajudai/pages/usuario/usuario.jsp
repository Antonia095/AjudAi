<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../../css/usuario.css">
    <title>AjudAí - Página Inicial</title>
</head>

<body>

<!--Cabeçalho da página-->
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo"><img class="imagem-logo responsive-img" src="../../images/logo.png"
                                            title="AjudAí" /></a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><img class="icon-search" src="../../images/search.svg" alt=""></li>
            <li><input type="search" name="" id="search" placeholder="Pesquisar"></li>
            <li><a class="dropdown-trigger" href="#" data-target="informacoes"><img
                    class="icone-imagem circle responsive-img"
                    src="../../${sessionScope.usuario.imagem}"
                    title="${sessionScope.usuario.nomeCompleto}"></a></li>
            <li><a href="#"><img class="icones-nav" src="../../images/notification.svg" title="notificação"></a>
            </li>
            <li><a href="#"><img class="icones-nav" src="../../images/publish.svg" title="Upload"></a></li>
        </ul>
    </div>
</nav>
<!--Cabeçalho da página-->
<br/>

     <div class="row">

    <!--Estante-->
    <div class="col s3 estante">
        <div class="container center">
            <img src="../../images/estant.png"><br><br>
            <a class="bt-prateleira" href="#"><img class="img-add" src="../../images/add.svg">Criar prateleira</a>
        </div>
    </div>
    <!--Estante-->


    <div class="col s9">
        <div class="container center">
        </div>
    </div>
    </div>

    <!--Corpo do drop-down-->
<ul id='informacoes' class='dropdown-content'>
    <li><a href="#!">Conta</a></li>
    <li class="divider" tabindex="-1"></li>
    <li><a class="bt-sair" href="/ajudai/logout">Sair</a></li>
</ul>
    <!--Corpo do drop-down-->


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="../../javascript/usuario.js"></script>
</body>

</html>