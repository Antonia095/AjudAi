<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>AjudAí - entre ou cadastre-se</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<!--barra superior-->
    <nav class="navbar bg-dark text-white">
        <label class="navbar-brand">
            <img src="imagens/logo.png" width="35px" height="42px" class="d-inline-block align-top">
            <label style="font-family: Ani; font-size: 23px">AjudAí</label>
        </label>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Usuário ou e-mail">
            <input class="form-control mr-sm-2" type="password" placeholder="Senha">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Entrar</button>
        </form>
    </nav>
    <br/><br/>
<!--barra superior-->
        <div style="float: left; margin: 450px; padding: 55px;position: relative; top: -450px;">
            <img style="width: 240px; height: 240px" src="imagens/logo.png" title="AjudAí">
        </div>
        <!--Formulário de inscrição-->
       <div style="background-color: honeydew; width: 500px; float: right; margin: 55px; padding: 8px;position: relative; top: -55px; border-radius: 20px 20px">
           <h1 class="text-center" style="font-family: Ani; font-size: 45px">Abra sua conta</h1>
           <br/><br/>
           <form action="continuar" method="POST">
               <div class="form-group">
                   <label for="inputNome">Nome completo</label>
                   <input name="nome" type="text" class="form-control" id="inputNome" placeholder="Seu nome completo" required>
               </div>
               <div class="form-group">
                   <label for="inputNomeUsuario">Data Nascimento</label>
                   <input name="nomeUsuario" type="text" class="form-control" id="inputNomeUsuario" placeholder="Nome usuário" required>
               </div>
               <div class="form-group">
                   <label for="inputEmail">E-mail</label>
                   <input name="email" type="email" class="form-control" id="inputEmail" placeholder="Email" required>
               </div>
               <div class="form-group">
                   <label for="inputTelefone">Telefone</label>
                   <input name="telefone" type="tel" class="form-control" id="inputTelefone" placeholder="Telefone" required>
               </div>
               <div class="form-group">
                   <label for="inputTipo">Tipo de Usuario</label>
                   <select name="tipo" class="form-control" id="inputTipo">
                       <option>Estudante</option>
                       <option id="especialista">Especialista</option>
                   </select>
               </div>
               <div class="form-group">
                   <label for="inputNascimento">Data Nascimento</label>
                   <input name="dataNascimento" type="date" class="form-control datepicker" id="inputNascimento" placeholder="Data Nascimento" required>
               </div>
               <div class="form-group">
                   <label for="inputSenha">Senha</label>
                   <input name="senha" type="password" class="form-control datepicker" id="inputSenha" placeholder="Senha" required>
               </div>
               <div class="form-group">
                   <label for="inputConf">Confirmar senha</label>
                   <input type="password" class="form-control datepicker" id="inputConf" placeholder="Confirmar senha" required>
               </div>
               <div class="text-right">
                   <button type="submit" class="btn btn-primary">Próximo</button>
               </div>
           </form>
       </div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
