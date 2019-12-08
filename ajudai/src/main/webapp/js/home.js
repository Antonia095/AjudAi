$('#telefone').mask('(00) 00000-0000');

function direcao(msg){
    switch (msg) {
        default: window.location.href='pages/formulario.jsp';

    }
}

$('#btEntrar').click(function () {
    var usuario_email = $('#usuardio').val();
    var senha = $('#senha').val();
    $.ajax({
        method: "POST",
        url: "login",
        data:{usuario: usuario_email , senha: senha }
    })
    .done(function (msg) {
        direcao(msg);
    })
})

$('#btProsseguir').click(function () {
    console.log("Me clicou");
})

