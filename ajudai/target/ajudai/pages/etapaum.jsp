<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/cadastro.css">
    <title>AjudAí - Inscrição</title>
</head>

<body>
<br><br><br><br>
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


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script src="https://unpkg.com/sweetalert@2.1.2/dist/sweetalert.min.js"></script>
<script src="../javascript/cadastro.js"></script>
</body>

</html>
