<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/home.css">
    <title>AjudAí - entre ou cadastre-se </title>
</head>

<body>
<div class="row">
    <!--Tela da esquerda-->
    <div id="painel-esquerdo" class="col s5 painel-esquerda hide-on-small-only">
        <div class="row posicao-texto">
            <ul id="intro" class="container center">
                <li>
                    <img class="img-icones" src="images/search.svg">
                    <label class="letra-painel"> &nbsp Encontre os melhores materiais.</label>
                </li>
                <br /><br />
                <li>
                    <img class="img-icones" src="images/description.svg">
                    <label class="letra-painel"> &nbsp Compartilhe conteúdos importantes.</label>
                </li>
                <br /><br />
                <li>
                    <img class="img-icones" src="images/edit.svg">
                    <label class="letra-painel"> &nbsp Estude em qualquer lugar.</label>
                </li>
                <br /><br />
            </ul>
        </div>
    </div>
    <!--Tela da esquerda-->

    <!--Tela direira-->
    <div class="col s7 ">
        <div class="container painel-direitos">
            <div class="center">
                <div class="imagem">
                    <img class="imagem-logo responsive-img" src="images/logo.png" title="AjudAí" />
                </div>

                <div class="text-logo">
                    <p>Obtenha materiais de estudo na área da T.I,</p>
                    <p>vídeos, apostilas, artigos, TCCs e vários outros</p>
                    <p>em um repositório que facilite a sua pesquisa.</p>
                </div>
            </div>
            <br><br>
            <div class="botaos center">
                <a href="inscricao"><button class="botao-inscrever bt1">Inscreva-se</button></a>
                <br><br>
                <a class="modal-trigger" href="#modaLogin"><button class="botao-entrar bt2">Entrar</button></a>
            </div>
        </div>
    </div>
</div>

<!-- Modal corpo -->
<div id="modaLogin" class="modal">
    <div class="center">
        <img class="img-logo" src="images/logo.png" />
    </div>
    <div class="modal-content center row">
        <div class="input-field col s12">
            <i class="material-icons prefix">account_circle</i>
            <input id="usEmail" type="text" class="validate">
            <label for="usEmail">Usuario ou E-mail</label>
        </div>
        <div class="input-field col s12">
            <i class="material-icons prefix">lock</i>
            <input id="senha" type="password" class="validate">
            <label for="senha">Senha</label>
        </div>
        <label id="situacao"></label>
    </div>
    <div class="modal-footer">
        <button id="btLogin" class="btn">Login</button>
    </div>
</div>
<!-- Modal corpo -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="js/particleground.js"></script>
<script src="js/home.js"></script>
</body>

</html>
