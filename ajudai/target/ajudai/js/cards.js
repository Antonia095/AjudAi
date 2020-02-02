function geraCard(link,titulo,descricao,codigo) {
    return  "<div class=\"card\">\n" +
        "        <div class=\"card-image waves-effect waves-block waves-light\">\n" +
        "            <iframe class=\"activator total\" src=\""+link+"\">Abrir</a></p>\n" +
        "            </div>\"></iframe>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"card-content\">\n" +
        "            <span class=\"card-title activator grey-text text-darken-4\">"+titulo+"<i\n" +
        "                    class=\"material-icons right\">more_vert</i></span>\n" +
        "            <a class=\"btn-floating halfway-fab waves-effect waves-light red\"><i id=\"add"+codigo+"\" class=\"material-icons\">add</i></a>\n" +
        "            <p><a href=\""+link+"\">Abrir</a></p>\n" +
        "        </div>\n" +
        "        <div class=\"card-reveal\">\n" +
        "            <span class=\"card-title grey-text text-darken-4\">"+titulo+"<i class=\"material-icons right\">close</i></span>\n" +
        "            <p>"+descricao+"</p>\n" +
        "        </div>\n" +
        "        <div class=\"card-action\">\n" +
        "            <a id=\"btComent"+codigo+"\" href=\"#modal1\" class=\"btn modal-trigger btn-card\">Comentar</a>\n" +
        "            <a id=\"btDenun"+codigo+"\" href=\"#\" class=\"right btn btn-card\">Denunciar</a>\n" +
        "        </div>\n" +
        "    </div>"
}


function getBox(titulo, texto, data) {
    return "<div class=\"mensagem-box\"><label class=\"titulo-not\">"+titulo+"</label><br>" +
        "<p class=\"corpoInfo\">"+texto+"</p><label>"+data+"</label></div>"
}

function setaConteudos(conteudos) {
    conteudos = JSON.parse(conteudos);
    var painel = '<table id=\"tabelaPesquisa\">';
    var linha = 0;
    var controle = conteudos.nomes.length;
    while(controle!=linha){
        for(var k=0; k<3; k++){
            painel+= '<td>'+geraCard(conteudos[linha].local, conteudos[linha].nome,conteudos[linha].descricao,"")+'</td>';
            linha+=1;
            if(linha==controle) break;
        }
        painel+='</tr>';
    }
    painel+='</table>';
    return painel;
}


function estante() {

}