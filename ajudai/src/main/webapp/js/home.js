$('#telefone').mask('(00) 00000-0000');

$('#btProsseguir').click(function () {
    var nomeCompleto = $('#inputNomeCompleto').val();
    var nomeUsuario = $('#inputNomeUsuario').val();
    $.ajax({
        method: "POST",
        url: "cadastrar",
        data:{ }
    })
    .done(function (msg) {
        if(msg.length>0){
            $('#situacaoUsuario').html("Usuário com mesmo nome já existe");
        }else{
            segEtapaCadastro();
        }
    })
})

function segEtapaCadastro() {
    var tela = "<div style=\"background-color: #CED8F6;width: 500px; height: 477px; border-radius: 20px 20px; margin: 45px; padding: 8px\">\n" +
        "                    <div>\n" +
        "                        <h2 style=\"font-family: 'Liberation Serif'; margin-left: 100px\"><b>Continuar cadastro</b></h2>\n" +
        "                        <br/>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"inputNomeCompleto\">E-mail</label>\n" +
        "                            <input name=\"email\" type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"E-mail\" autocomplete=\"off\" required>\n" +
        "                        </div>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"exampleFormControlSelect1\">Tipo de usuario</label>\n" +
        "                            <select class=\"form-control\" id=\"tipoUsuario\">\n" +
        "                                <option>Estudante</option>\n" +
        "                                <option id=\"especialista\">Especialista</option>\n" +
        "                            </select>\n" +
        "                        </div>\n" +
        "                        <label id=\"especialista\"></label>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"senha\">Senha</label>\n" +
        "                            <input name=\"senha\" type=\"password\" class=\"form-control\" id=\"senha\" placeholder=\"Senha\" autocomplete=\"off\" required>\n" +
        "                        </div>\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"conSenha\">Confirmar senha</label>\n" +
        "                            <input name=\"conSenha\" type=\"password\" class=\"form-control\" id=\"conSenha\" placeholder=\"Confirmar senha\" autocomplete=\"off\" required>\n" +
        "                        </div>\n" +
        "                        <div style=\"margin: 20px\" class=\"form-group\">\n" +
        "                            <button style=\"float: right\" class=\"btn btn-primary\">Cadastrar</button>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>";

    $('#panel-cadastro').html(tela);
}

