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
           <form action="salvar" method="post">
               <label for="inlineCheckbox2">Áreas</label>
               <div class="form-group">
                   <c:forEach items="${especialidades}" var="especialidade">
                       <div class="form-check form-check-inline">
                           <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="opcao2">
                           <label class="form-check-label" for="inlineCheckbox2">${especialidade}</label>
                       </div>
                   </c:forEach>
               </div>
               <div class="form-group">
                   <label for="validationTextarea">Descricao</label>
                   <textarea name="descricao" class="form-control is-invalid" id="validationTextarea" placeholder="Realize a descricao" required></textarea>
               </div>

               <div class="text-right">
                   <button type="submit" class="btn btn-primary">Salvar</button>
               </div>
           </form>
       </div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
