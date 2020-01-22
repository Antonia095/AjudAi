$('#telefone').mask('(00) 00000-0000');
$('.modal').modal();

$(document).ready(function () {
    $('select').formSelect();
    $('#nascimento').datepicker({
        format: 'dd/mm/yyyy',
        i18n:{
            cancel: 'Cancelar',
            months: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio',  'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            monthsShort	: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
            weekdays: ['Domingo', 'Segunda-Feira', 'Terça-Feira', 'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira', 'Sábado'],
            weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
            weekdaysAbbrev: ['D','S','T','Q','Q','S','S']
        }
    });
});


$('#btAvancar').click(function () {
    var nomeCompleto = $('#nomeCompleto').val();
    var nomeUsuario = $('#nomeUsuario').val();
    var email = $('#email').val();
    var telefone = $('#telefone').val();
    if((nomeUsuario.trim().length==0)||(email.trim().length==0)||(nomeCompleto.trim().length==0)||(telefone.trim().length==0)){
        swal("Erro!", "Preencha todos os campos", "error");
    }else if(email.search("@")<0){
        swal("Erro!", "Falta o @ no seu email", "error");
    }else{
        $.ajax({
            method: "POST",
            url: "/ajudai/cadastro",
            data:{nomeUsuario: nomeUsuario, nomeCompleto: nomeCompleto, email: email, telefone:telefone, valor: 1}
        })
            .done(function (msg) {
                if(msg.length>2){
                    $('.resposta').html(msg);
                }else{
                    window.location.reload();
                }
            });
    }
})


$('#btEnviar').click(function () {
    var dataNascimento = $('#nascimento').val();
    var senha = $('#senha').val();
    var senhaConfirmacao = $('#conSenha').val();
    var tipoUsuario = $('#usuarioTipo').val();
    console.log(dataNascimento);
    if(senha!=senhaConfirmacao){
        swal("Aviso", "Senhas não estão batendo", "info");
    }else{
        $.ajax({
            method: "POST",
            url: "/ajudai/cadastro",
            data:{nascimento: dataNascimento, senha: senha, tipoUsuario: tipoUsuario, valor: 2},
            beforeSend : function () {
                $('#preloader').html("<div class=\"progress\"><div class=\"indeterminate\"></div></div>")
            }
        })
        .done(function (msg) {
            if(msg.length>2){
                $('.resposta').html(msg);
            }else{
                window.location.reload();
            }
        });
    }
});


$('#btConfirmar').click(function () {
    var codigo = $('#codAcesso').val();
    $.ajax({
        method: "POST",
        url: "/ajudai/cadastro",
        data:{codigo: codigo, valor: 3}
    })
        .done(function (msg) {
            if(msg.length>0){
                $('.resposta').html(msg);
            }else {
                window.location.href = "../pages/usuario/usuario.jsp";
            }

        });
})
