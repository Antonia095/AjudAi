$(document).ready(function () {
    $('#painel-esquerdo').particleground({
        dotColor: '#5cbdaa',
        lineColor: '#5cbdaa'
    });
    $('#intro').css({
        'margin-top': -($('#intro').height() / 2)
    });
    $('.modal').modal();
});

$('#btLogin').click(function () {
    login();
});

function login(){
    var usEmail = $('#usEmail').val();
    var senha = $('#senha').val();
    $.ajax({
        method: "POST",
        url: "login",
        data:{id:usEmail, senha:senha}
    })
        .done(function (msg) {
            if(msg.toUpperCase()=="SUCESSO"){
                window.location.href="ajudai/../pages/usuario/usuario.jsp";
            }else{
                console.log(msg);
                $('#situacao').html(msg);
            }
        })
}

$('#usEmail').keypress(function (event) {
    if(event.which==13){
        login();
    }
});

$('#senha').keypress(function (event) {
    if(event.which==13){
        login();
    }
})


