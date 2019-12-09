<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>AjudAí - entre ou cadastre-se</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
<!--barra superior-->
    <nav class="navbar bg-dark text-white">
        <label class="navbar-brand">
            <img src="images/logo.png" width="35px" height="42px" class="d-inline-block align-top" title="AjudAí">
        </label>
        <div class="form-inline my-2 my-lg-0">
            <form>
                <input id="usuardio" class="form-control mr-sm-2" type="text" placeholder="Usuário ou e-mail" autocomplete="off" required>
                <input id="senha" class="form-control mr-sm-2" type="password" placeholder="Senha" autocomplete="off" required>
                <button class="btn btn-primary my-2 my-sm-0" type="submit">Entrar</button>
            </form>

        </div>
    </nav>
<!--barra superior-->
        <div class="row">
            <div class="col">
            </div>
            <div class="col-6">
                <div>
                    <br/><br/><br/>
                    <img style="margin-left: 55px" src="images/logo.png" title="AjudAí">
                    <div class="container"></div>
                    <p style="color: #6959CD ; font-weight: bold; font-family: 'Liberation Serif'; font-size: 21px">
                       <label style="margin-right: 75px">Obtenha materiais de estudos na área de T.I,</label> <br/>
                        <label>sejam estes: vídeos, apostilas, artigos TCC's, entre vários outros.</label><br/>
                        <label style="margin-right: 75px">Em um repositório que facilite a pesquisa.</label>
                    </p>
                </div>
            </div>
            <div id="panel-cadastro" class="col float-right">
                <div style="background-color: honeydew;width: 500px; height: 477px; border-radius: 20px 20px; margin: 45px; padding: 8px">
                    <div>
                        <h2 style="font-family: 'Liberation Serif'; margin-left: 145px"><b>Abra sua conta</b></h2>
                        <br/>
                        <div class="form-group">
                            <label for="inputNomeCompleto">Nome completo</label>
                            <input name="nomeCompleto" type="text" class="form-control" id="inputNomeCompleto" placeholder="Nome completo" autocomplete="off" required>
                        </div>
                        <div class="form-group">
                            <label for="inputNomeUsuario">Nome de usuário</label>
                            <input name="nomeUsuario" type="text" class="form-control" id="inputNomeUsuario" placeholder="Nome de usuário" autocomplete="off" required>
                            <label id="situacaoUsuario"></label>
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone</label>
                            <input name="telefone" type="tel" class="form-control" id="telefone" placeholder="Telefone" autocomplete="off" required>
                        </div>
                        <div class="form-group">
                            <label for="dataNascimento">Data de nascimento</label>
                            <input name="dataNascimento" type="date" class="form-control" id="dataNascimento" autocomplete="off" required>
                        </div>
                        <div style="margin: 20px" class="form-group">
                            <button style="float: right" class="btn btn-primary" id="btProsseguir" title="Prosseguir">
                                <svg style="fill: #ffffff" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                                        <path fill="none" d="M0 0h24v24H0V0z"/>
                                        <path d="M4.01 6.03l7.51 3.22-7.52-1 .01-2.22m7.5 8.72L4 17.97v-2.22l7.51-1M2.01 3L2 10l15 2-15 2 .01 7L23 12 2.01 3z"/>
                                </svg>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
    <script src="js/home.js"></script>
    </body>
</html>
