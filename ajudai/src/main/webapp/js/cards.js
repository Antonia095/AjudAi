function geraCard(link,titulo,descricao) {
    return  "<div class=\"card\">\n" +
        "        <div class=\"card-image waves-effect waves-block waves-light\">\n" +
        "            <iframe class=\"activator total\" src=\""+link+"\">Abrir</a></p>\n" +
        "            </div>\"></iframe>\n" +
        "        </div>\n" +
        "\n" +
        "        <div class=\"card-content\">\n" +
        "            <span class=\"card-title activator grey-text text-darken-4\">"+titulo+"<i\n" +
        "                    class=\"material-icons right\">more_vert</i></span>\n" +
        "            <a class=\"btn-floating halfway-fab waves-effect waves-light red\"><i class=\"material-icons\">add</i></a>\n" +
        "            <p><a href=\""+link+"\">Abrir</a></p>\n" +
        "        </div>\n" +
        "        <div class=\"card-reveal\">\n" +
        "            <span class=\"card-title grey-text text-darken-4\">"+titulo+"<i class=\"material-icons right\">close</i></span>\n" +
        "            <p>"+descricao+"</p>\n" +
        "        </div>\n" +
        "        <div class=\"card-action\">\n" +
        "            <a href=\"#modal1\" class=\"btn modal-trigger btn-card\">Comentar</a>\n" +
        "            <a href=\"#\" class=\"right btn btn-card\">Denunciar</a>\n" +
        "        </div>\n" +
        "    </div>"
}