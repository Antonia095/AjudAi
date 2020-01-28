$('.dropdown-trigger').dropdown();
$('#telefoneUser').mask('(00) 00000-0000');
$('#search').keypress(function(event){
    if(event.which==13){
        var valor = $('#search').val();
        $.ajax({
            method: "POST",
            url:"/ajudai/buscaconteudo",
            data:{busca:valor}
        })
            .done(function (msg) {
                if(msg.length>2){
                    console.log(JSON.parse(msg))
                }else{
                    $('#painel-direito').html('<h5>Material não encontrado</h5>');
                }
            })

    }
});
$('#tipoPrateleira').formSelect();


$(document).ready(function () {
    $('.modal').modal();
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

    var bodyId = document.querySelector('#body');
    bodyId.addEventListener('click', function () {
        $.ajax({
            method: "POST",
            url: "/ajudai/gatilho",
            data: {valor: 2}
        })
            .done(function (msg) {
                if(msg.length>2){
                    window.location.reload();
                }
            })
    })
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
            var usuario = JSON.parse(msg);
            var dia = (JSON.stringify(usuario.dataNascimento.day).length==1)? "0"+JSON.stringify(usuario.dataNascimento.day):JSON.stringify(usuario.dataNascimento.day);
            var mes = (JSON.stringify(usuario.dataNascimento.month).length==1)? "0"+JSON.stringify(usuario.dataNascimento.month):JSON.stringify(usuario.dataNascimento.month);
            $('#nomeUser').val(usuario.nomeUsuario);
            $('#emailUser').val(usuario.email);
            $('#dataUser').val(dia+"/"+mes+"/"+usuario.dataNascimento.year);
            $('#telefoneUser').val(usuario.telefone);
            $('#nomeComUser').val(usuario.nomeCompleto);
            recuperaImagem();
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

function recuperaImagem(){
    var setImagem = document.querySelector("#imageConta");
    $.ajax({
        method: "POST",
        url: "/ajudai/imagemedit"
    })
    .done(function (msg) {
        setImagem.setAttribute("src","../../"+msg);
    })
}

function resetaMensagemInicio() {
    $.ajax({
        method: "POST",
        url: "/ajudai/gatilho",
        data: {valor: 1}
    })
}

function mostraEstante(){
    var navEstante = "<div class=\"pos-direita\"><button class=\"btn\">Deletar</button><br><br>" +
        "<label class=\"titulo-estante\">Texto</label></div>"
}

async function addEspecialidades() {
    const { value: text } = await Swal.fire({
        input: 'textarea',
        inputPlaceholder: 'Adicione suas especialidades',
        inputAttributes: {
            'aria-label': 'Type your message here'
        },
        confirmButtonText: 'Adicionar',
        cancelButtonText: 'Adicionar depois',
        showCancelButton: true
    })

    if (text) {
        $.ajax({
            method: "POST",
            url: "/ajudai/gatilho",
            data:{valor: 3, descricao: text}
        })
            .done(function () {
                window.location.reload()
            })

    }else{
        $.ajax({
            method: "POST",
            url: "/ajudai/gatilho",
            data:{valor: 4}
        })
            .done(function () {
                window.location.reload();
            })
    }
}

$('#btSubmitLink').click(function () {
    var link = $('#linkConteudo').val();
    var descricaoLink = $('#linkDescricao').val();
    var nomeConteudo = $('#nomeLink').val()
    if((link.trim().length==0)||(descricaoLink.trim().length==0)||(nomeConteudo.trim().length==0)){
        Swal.fire('Erro','Preencha todos os campos','error');
    }else{
        link = (validaLink(link)) ? link : "";
        if(link.length<=0){
            Swal.fire('Aviso','Link inválido','info');
        }else{
            $.ajax({
                method: "POST",
                url: "/ajudai/adicionarlink",
                data:{link: link, descricao: descricaoLink, nomeConteudo: nomeConteudo}
            })
                .done(function (msg) {
                    window.location.reload();
                })
        }
    }

})

function validaLink(link) {
    return link.indexOf("http") >= 0;
}

function geraPainel(conteudos) {
    var painel = '<table>';

    for(var k=0; k<=conteudos.length; k++){
        painel+='<tr>';
        for (var i=1; i<3; i++){
            painel+= '<td>' + geraCard() + '</td>';
        }
        painel+='</tr>';
    }
    painel+='</table>';

    $('#painel-direito').html(painel);
}

