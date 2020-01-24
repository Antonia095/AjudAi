$('.dropdown-trigger').dropdown();

$('#search').keypress(function(event){
    if(event.which==13){
        alert(event.code)
    }
});


$(document).ready(function () {
    $('.modal').modal();
    $('select').formSelect();
    $('#dataUser').datepicker({
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

$('#btCriar').click(function () {
    var nomeEstante = $('#nomeEstante').val();
    var descricao = $('#descricao').val();
    var tipoPrateleira = $('#tipoPrateleira').val();
    if((nomeEstante.trim().length==0)&&(descricao.trim().length==0)){
        Swal.fire({
            title: 'Aviso',
            text: 'Preencha todos os campos',
            icon: "warning"
        });
    }else{
        $.ajax({
            method: "GET",
            url:"/ajudai/criapraleira",
            data:{nome: nomeEstante, descricao: descricao, tipo: tipoPrateleira}
        })
            .done(function () {
                window.location.reload();
            })
    }

});

$('#submitLink').click(function () {
    var linkConteudo = $('#linkConteudo').val();
    var descricaoLink = $('#linkDescricao').val();

    if((linkConteudo.trim().length>0)&&(descricaoLink.trim().length>0)){
        $.ajax({

        })

    }else{
        Swal.fire({
            title: 'Aviso',
            text: 'Preencha todos os campos',
            icon: "warning"
        });
    }
})


$('#btContaDados').click(function () {
    $.ajax({
        method: "GET",
        url: "/ajudai/dados",
        data: {valor: 1}
    })
        .done(function (msg) {
            console.log(msg.nomeUsuario);
            var usuario = JSON.parse(msg);
            var dia = (JSON.stringify(usuario.dataNascimento.day).length==1)? "0"+JSON.stringify(usuario.dataNascimento.day):JSON.stringify(usuario.dataNascimento.day);
            var mes = (JSON.stringify(usuario.dataNascimento.month).length==1)? "0"+JSON.stringify(usuario.dataNascimento.month):JSON.stringify(usuario.dataNascimento.month);
            $('#nomeUser').val(usuario.nomeUsuario);
            $('#emailUser').val(usuario.email);
            $('#dataUser').val(dia+"/"+mes+"/"+usuario.dataNascimento.year);
            $('#telefoneUser').val(usuario.telefone);
            $('#nomeComUser').val(usuario.nomeCompleto);
        })
})

$('#btExcluiConta').click(function () {
    Swal.fire({
        title: 'Exclusão de Conta',
        text: "Tem certeza que dejesa excluir sua conta?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim, desejo!',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.value) {
            $.ajax({
                method: "POST",
                url: "/ajudai/excluirconta"
            })
                .done(function () {
                    window.location.href="/ajudai/index.jsp";
                })
        }
    })
})

$()