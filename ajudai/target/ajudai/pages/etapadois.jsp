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
        <img class="responsive-img img-logo" src="../images/logo.png" title="AjudAí" />
        <br><br>
        <label class="resposta"></label>
        <br><br>
        <form action="/ajudai/etapadois" method="post" enctype="multipart/form-data">
            <div id="contai" class="row container">
                <div class="input-field col s12">
                    <i class="material-icons prefix">date_range</i>
                    <input name="nascimento" id="nascimento" type="date" class="validate" required>
                    <label for="nascimento">Data de nascimento</label>
                </div>
                <div class="input-field col s12">
                    <i class="material-icons prefix">lock</i>
                    <input name="senha" id="senha" type="password" class="validate" required>
                    <label for="senha">Senha</label>
                </div>
                <div class="input-field col s12">
                    <i id="tipoUsuario" class="material-icons prefix icone-usuarios">supervisor_account</i>
                    <select name="tipo">
                        <option>Estudante</option>
                        <option >Especialista</option>
                    </select>
                    <label>Tipo Usuario</label>
                </div>
                <div class="input-field col s12">
                    <div class="file-field input-field">
                        <span class="material-icons prefix image-image">image</span>
                        <input name="foto" class="input-file" type="file" accept="image/png, image/jpeg" required>
                        <div class="file-path-wrapper">
                            <input class="file-path validate input-file" type="text" placeholder="Selecione imagem">
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <button class="btn" type="submit">Enviar</button>
            </div>


        </form>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
<script src="https://unpkg.com/sweetalert@2.1.2/dist/sweetalert.min.js"></script>
<script src="../javascript/cadastro.js"></script>
</body>

</html>