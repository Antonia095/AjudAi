<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Tela Inicial</title>
    <link rel="stylesheet"  type="text/css" href="Estilo.css">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


</head>
<body>

    <!--Menu-->
    <header>
        <nav>
            <div class="nav-wrapper blue-grey darken-4">
                <a href="#" class="brand-logo"><img src="img/logo.png"></a>
                <div id="nav-mobile" class="right">
                    <form action="LoginServlet">
                        <ul id="campoLogin">
                             <li>
                                <i class="material-icons">account_circle</i>
                                <input id="campoEmail" type="email" class="validate" placeholder="Email">
                            </li>
                            <li>
                                <i class="material-icons">https</i>
                                <input id="campoSenha" type="password" class="validate" placeholder="Senha">
                            </li>
                            <li>
                                <a id="botao" class="waves-effect waves-light btn-small">Entrar</a>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </nav>

    </header>
    <!--Conteúdo-->
    <main>
        <section id="campoAssunto">
            <h1>AjudAí</h1>
            <p id="assunto">
                Obtenha materiais de estudos na área de TI,<br>
                sejam estes: vídeos, apostila, artigos, TCCs e etc,<br> em um repositório que facilite a pesquisa.
            </p>
        </section>
        <section id="campoCadastro">
            <center>
                <h5>Criar conta</h5>
            </center>
            <div class="row">
                <form class="col s12">
                  <div class="row">
                        <div class="input-field col s12">
                          <label id="tx">Nome</label>
                          <input placeholder="Informe seu nome completo" id="nome" type="text" class="validate">
                        </div>

                        <div class="input-field col s12">
                          <label id="tx">Email</label>
                          <input placeholder="Informe seu email" id="email" type="email" class="validate">
                        </div>
                        
                        <div class="input-field col s12">
                          <label id="tx">Telefone</label>
                          <input placeholder="Informe seu telefone" id="telefone" type="text" class="validate">
                        </div>
                        
                        <div class="input-field col s12">
                          <label id="tx">Data de <br> nascimento</label>
                          <input id="nascimento" type="date" class="validate">
                        </div>

                        
                  </div>
                  <button id="bt" class="btn right
                  " type="submit" name="btProximo" >
                        <i class="material-icons right">arrow_forward</i>
                        <a id="texto" href="SegundaTela.html">Próximo</a>
                        
                  </button>

                </form>
          </div>
            
        </section>

    </main>

    <!--Rodapé-->
    <footer id="rodape">
        <div class="footer-copyright">
            <div class=" text-lighten-4 lest left">

                <p style="color:black">© 2019 AjudAí</p>

            </div>
        </div>

    </footer>

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"/>

    </body>
</html>
