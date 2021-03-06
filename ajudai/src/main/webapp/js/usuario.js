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
                    console.log(JSON.parse(msg));
                    geraPainel(msg)
                }else{
                    $('#painel-direito').html('<h5>Material não encontrado</h5>');
                }
            })

    }
});
$('#tipoPrateleira').formSelect();
$('#prateleiraAddSelect').formSelect();


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

function recuperaCodigo(identificador,pos) {
    return identificador.slice(pos);
}

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

}

function mensagemBotaos(icone, mensagem,titulo) {
    Swal.fire({
        icon: icone,
        title: titulo,
        text: mensagem,
    })
}

function executaBotao(botao, codigo,codPrateleira) {
    $.ajax({
        method: "POST",
        url: "/ajudai/executabotao",
        data:{botao: botao, codigo: codigo, codPra: codPrateleira}
    })
        .done(function (msg) {
            if((msg.length>2)&&(botao==3)){
                mensagemBotaos("info","Sua denuncia será avalidada. Obrigado(a)" +
                    " por contribuir.", "Informação");
            }else if(botao==4){
                if(msg.toUpperCase()!="EXISTEPRATELEIRA"){
                    mensagemBotaos("warning","Você não possui prateleiras para adicionar o conteúdo. Crie uma","Aviso");
                }else{
                    $('#modalPrateleiraAdd').modal();
                    $('#modalPrateleiraAdd').modal('open');
                }
            }else if((msg.toUpperCase()=="ADICAO")&&(botao==1)){
                mensagemBotaos("success","Conteudo foi adicionado a sua prateleira","Sucesso");
                $('#modalPrateleiraAdd').modal('close');
            }else if((msg.toUpperCase()=="ESTAPRATELEIRA")&&(botao==1)){
                mensagemBotaos("error","Conteudo não pode ser adicionado a prateleira pois ele já existe na mesma","Erro");
                $('#modalPrateleiraAdd').modal('close');
            }
        })
}

$('#btPrateleiraAdd').click(function () {
    var select = document.querySelector("#prateleiraAddSelect");
    var optionvalue = select.options[select.selectedIndex].value;
    console.log(recuperaCodigo(optionvalue,2));
    executaBotao(1,"",recuperaCodigo(optionvalue,2));
})

function ativaBotoes(){
    var table = document.querySelector("#tabelaPesquisa");
    table.addEventListener('click',function (event) {
        var identificador = event.target.id;
        if(identificador.indexOf("add")>=0){
            executaBotao(4,recuperaCodigo(identificador,3));
        }else if(identificador.indexOf("btComent")>=0){
            alert(recuperaCodigo(identificador,8));
        }else if(identificador.indexOf("btDenun")>=0){
            executaBotao(3,recuperaCodigo(identificador,7),"")
        }else{
            console.log();
        }
    })
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

function criaListaNotificacao(list) {
    var lista ='<ul>';
    console.log(list)
    for (var k=list.length-1; k>=0; k--){
        var dia = (JSON.stringify(list[k].dataPublicacao.day).length==1)? "0"+JSON.stringify(list[k].dataPublicacao.day):JSON.stringify(list[k].dataPublicacao.day);
        var mes = (JSON.stringify(list[k].dataPublicacao.month).length==1)? "0"+JSON.stringify(list[k].dataPublicacao.month):JSON.stringify(list[k].dataPublicacao.month);
        lista+= '<li>'+getBox(list[k].titulo, list[k].texto, dia+"/"+mes+"/"+list[k].dataPublicacao.year)+'</li><br>';

    }
    lista+='</ul>';
    $('#corpoNotificacao').html(lista)
}

function geraPainel(conteudos) {
    conteudos = JSON.parse(conteudos);
    var painel = '<table id=\"tabelaPesquisa\">';
    var linha = 0;
    var controle = conteudos.nomes.length;
    while(controle!=linha){
        for(var k=0; k<3; k++){
            painel+= '<td>'+geraCard(conteudos.locais[linha], conteudos.nomes[linha], conteudos.descricoes[linha],
                conteudos.codConteudos[linha])+'</td>';
            linha+=1;
            if(linha==controle) break;
        }
        painel+='</tr>';
    }
    painel+='</table>';
    $('#painel-direito').html(painel);
    ativaBotoes();
}

function conteudoAdd() {
    Swal.fire({
        title: 'Sucesso',
        text: 'Conteudo já esta disponível para pesquisa.',
        icon: 'success',
        confirmButtonText: 'Ok!'
    }).then((result) => {
        $.ajax({
            method: "POST",
            url: "/ajudai/gatilho",
            data:{valor: 5}
        })
            .done(function (msg) {
                window.location.reload();
            })
    });
}

$('#btNotifi').click(function () {
    console.log("OI")
    $.ajax({
        method:"POST",
        url: "/ajudai/notificacao"
    })
        .done(function (msg) {
            if(msg.length>2){
                criaListaNotificacao(JSON.parse(msg));
            }else{
                $('#corpoNotificacao').html("");
            }
        })
})

function escutaPrateleira() {
    var estante = document.querySelector("#listaEstante");
    estante.addEventListener('click',function (event) {
        var prateleira = event.target.id;
        if(prateleira.length>1){
            $.ajax({
                method: "POST",
                url: "/ajudai/mostraprateleira",
                data:{valor: 1, codPrateleira: recuperaCodigo(prateleira,2)}
            })
                .done(function (msg) {
                    console.log(msg);
                })
        }
    })
}

escutaPrateleira();


