$('#telefone').mask('(00) 00000-0000');
$('.modal').modal();

$(document).ready(function () {
    $('select').formSelect();
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
            url: "/ajudai/etapaum",
            data:{nomeCompleto: nomeCompleto, nomeUsuario: nomeUsuario, email: email, telefone: telefone, tipo: 1}
        })
            .done(function (msg) {
                if(msg.length==0){
                    window.location.href="etapadois.jsp";
                }else {
                    $('.resposta').html(msg);
                }
            })
    }

});