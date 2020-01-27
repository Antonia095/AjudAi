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

<body id="body">

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
            <li><a class="dropdown-trigger" href="#" data-target="upload"><img class="icones-nav" src="../../images/publish.svg" title="Upload"></a></li>
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
            <a class="bt-prateleira modal-trigger" href="#modalPrateleira"><img class="img-add" src="../../images/add.svg">Criar prateleira</a>
        </div>
        <div class="container center">
            <ul id="listaEstante">
                <c:forEach items="${sessionScope.estante.prateleiras}" var="list" >
                    <li><a id="${list.codString()}" href="#">${list.nome.toUpperCase()}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
<!--Estante-->

    <div class="col s9">
        <div id="painel-direito" class="container center">
        </div>
    </div>
</div>

<!--Corpo do drop-down-->
<ul id='informacoes' class='dropdown-content'>
    <li><a id="btContaDados" href="#modalConta" class="modal-trigger">Conta</a></li>
    <li class="divider" tabindex="-1"></li>
    <li><a class="bt-sair" href="/ajudai/logout">Sair</a></li>
</ul>
<!--Corpo do drop-down-->

<!--Corpo do drop-down de upload-->
<ul id='upload' class='dropdown-content'>
    <li><a href="#modalLinkConteudo" class="modal-trigger">Link</a></li>
    <li class="divider" tabindex="-1"></li>
    <li><a href="#modalMaterial" class="modal-trigger">Material</a></li>
</ul>
<!--Corpo do drop-down de upload-->


<!--Modais de upload-->
<div id="modalLinkConteudo" class="modal tam-modal">
    <div class="modal-content center row">
        <div class="input-field col s12">
            <i class="material-icons prefix">http</i>
            <input id="linkConteudo" type="text" placeholder="Link para o conteúdo">
            <label for="linkConteudo"></label>
        </div>
        <div class="input-field col s12">
            <input id="nomeLink" placeholder="Nome do conteúdo">
        </div>
        <div class="input-field col s12">
            <textarea id="linkDescricao" placeholder="Descrição..."></textarea>
        </div>
    </div>
    <div class="center">
        <button id="btSubmitLink" class="btn btn-modal ">Enviar</button>
    </div>
</div>

<div id="modalMaterial" class="modal tam-modal">
    <div class="modal-content center row">
        <form action="/ajudai/adicionaconteudo" method="post" enctype="multipart/form-data">
            <div class="input-field col s12">
                <input name="nomeConteudo" type="text" placeholder="Nome" required>
            </div>
            <div class="input-field col s12">
                <div class="file-field input-field">
                    <span class="material-icons prefix image-image">class</span>
                    <input name="conteudo" class="input-file" type="file" accept=".pdf,.doc,.docx,.ppt,.pptx" required>
                    <div class="file-path-wrapper">
                        <input class="file-path validate input-file" type="text" placeholder="Selecione imagem">
                    </div>
                </div>
            </div>
            <div class="input-field col s12">
                <textarea name="descricao" placeholder="Descrição..." required></textarea>
            </div>

            <div class="center">
                <button type="submit" class="btn btn-modal ">Enviar</button>
            </div>
        </form>
    </div>
</div>
<!--Modais de upload-->


<!--Corpo modal prateleira-->
<div id="modalPrateleira" class="modal">
    <div class="modal-content center row">
        <div class="input-field col s12">
            <input id="nomeEstante" type="text" placeholder="Nome">
        </div>
        <div class="input-field col s12">
            <textarea id="descricao" placeholder="Descrição..."></textarea>
        </div>
        <div class="input-field col s12">
            <select id="tipoPrateleira">
                <option>Programação Web</option>
                <option>Banco de Dados</option>
                <option>Arquitetura de Sistema</option>
                <option>Sistemas Distribuidos</option>
                <option>Sistemas Operacionais</option>
                <option>Estrutura de Dados</option>
                <option>Análise e Projeto de Software</option>
            </select>
        </div>
    </div>
    <div class="modal-footer">
        <button id="btCriar" class="btn">Criar</button>
    </div>
</div>
<!--Corpo modal prateleira-->

<!--Corpo modal conta-->
<div id="modalConta" class="modal">
    <br><br>
    <div class="modal-content center row">
        <img id="imageConta" src="" class="circle icon-user">
        <form action="/ajudai/dados" method="POST" enctype="multipart/form-data">
            <div class="file-field input-field center">
                <div class="form-group">
                    <label for="fupload" class="btn-edit">Editar foto</label>
                    <input type="file" id="fupload" name="fupload" accept="image/*" />
                </div>
            </div>
            <div class="modal-content center row">
                <div class="input-field col s6">
                    <input name="nomeUser" id="nomeUser" type="text" readonly>
                </div>
                <div class="input-field col s6">
                    <input name="emailUser" id="emailUser" type="text" readonly>
                </div>
                <div class="input-field col s6">
                    <input name="nascimentoUser" id="dataUser" type="text">
                </div>
                <div class="input-field col s6">
                    <input name="telefoneUser" id="telefoneUser" type="text">
                </div>
                <div class="input-field col s6">
                    <input name="nomeComUser" id="nomeComUser" type="text">
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-conta">Editar</button>
            </div>
        </form>
        <div class="modal-footer">
            <button id="btExcluiConta" class="btn btn-conta">Excluir Conta</button>
        </div>
    </div>
</div>
<!--Corpo modal conta-->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script src="../../js/cards.js"></script>
<script src="../../js/usuario.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<c:if test="${sessionScope.bemVindo==true}">
    <script>
        Swal.fire({
            title: 'Bem-Vindo',
            text: 'Obrigado por fazer parte do AjudAí. O melhor repositório online de conteúdos acadêmicos.',
            imageUrl: '../../images/logo.png',
            imageWidth: 100,
            imageHeight: 110,
            confirmButtonText: 'Ok!'
        }).then((result) => {
            resetaMensagemInicio();
        });
    </script>
</c:if>
<c:if test="${sessionScope.especialidade==true}">
    <script>
        addEspecialidades();
    </script>
</c:if>
</body>
</html>