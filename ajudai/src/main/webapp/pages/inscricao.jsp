<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>AjudAí - Inscrição</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/inscricao.css">
</head>
<body>
<br><br><br><br>
<c:choose>
    <c:when test="${sessionScope.init==null}">
        <div class="formulario container">
            <div class="center">
                <img class="responsive-img img-logo" src="../images/logo.png" title="AjudAí"/>
                <br><br>
                <label class="resposta"></label>
                <br><br>
                <div class="row container">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">perm_identity</i>
                        <input id="nomeCompleto" type="text" class="validate" autocomplete="off">
                        <label for="nomeCompleto">Nome Completo</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">account_circle</i>
                        <input id="nomeUsuario" type="text" class="validate" autocomplete="off">
                        <label for="nomeUsuario">Nome Usuário</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">email</i>
                        <input id="email" type="email" class="validate" autocomplete="off">
                        <label for="email">E-mail</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">phone</i>
                        <input id="telefone" type="text" class="validate" autocomplete="off">
                        <label for="telefone">Telefone</label>
                    </div>
                </div>
                <button id="btAvancar" class="btn">Avançar</button>
            </div>
        </div>
    </c:when>
    <c:when test="${sessionScope.init==1}">
        <div class="formulario container">
            <div class="center">
            <img class="responsive-img img-logo" src="../images/logo.png" title="AjudAí" />
            <br><br>
            <label class="resposta"></label>
            <br><br>
            <div id="contain" class="row container">
                <div class="input-field col s12">
                    <i class="material-icons prefix">vpn_key</i>
                    <input name="codAcesso" id="codAcesso" type="text" class="validate" required autocomplete="off">
                    <label for="codAcesso">Código de Acesso</label>
                </div>
            <div>
                <button id="btConfirmar" class="btn" type="submit">Confirmar</button>
            </div>
            <br><br><br>
            <p class="mensagem">O código de acesso foi enviado para seu email</p>
        </div>
    </c:when>

    <c:otherwise>
        <div class="formulario container">
            <div class="center">
                <img class="responsive-img img-logo" src="../images/logo.png" title="AjudAí" />
                <br><br>
                <label class="resposta"></label>
                <br><br>
                <div id="contai" class="row container">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">date_range</i>
                        <input name="nascimento" id="nascimento" type="text" class="validate" autocomplete="off" required>
                        <label for="nascimento">Data de nascimento</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock</i>
                        <input name="senha" id="senha" type="password" class="validate" required>
                        <label for="senha">Senha</label>
                    </div>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock</i>
                        <input name="conSenha" id="conSenha" type="password" class="validate" required>
                        <label for="conSenha">Confirmar senha</label>
                    </div>

                    <div class="input-field col s12">
                        <i id="tipoUsuario" class="material-icons prefix icone-usuarios">supervisor_account</i>
                        <select id="usuarioTipo" name="tipo">
                            <option>Estudante</option>
                            <option >Especialista</option>
                        </select>
                        <label>Tipo Usuario</label>
                    </div>
                </div>
                <div>
                    <button id="btEnviar" class="btn" type="submit">Enviar</button>
                </div>
            </div>
            <br>
            <div class="center col s12 container" id="preloader"></div>
        </div>
    </c:otherwise>
</c:choose>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script src="https://unpkg.com/sweetalert@2.1.2/dist/sweetalert.min.js"></script>
<script src="../js/inscricao.js"></script>
</body>
</html>