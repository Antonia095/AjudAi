package br.com.ifpb.ajudai.model.entities;

public class ConteudoEstante {
    private int idEstante;
    private int codPrateleira;
    private int codConteudo;

    public ConteudoEstante(int idEstante, int codPrateleira, int codConteudo) {
        this.idEstante = idEstante;
        this.codPrateleira = codPrateleira;
        this.codConteudo = codConteudo;
    }

    public int getIdEstante() {
        return idEstante;
    }

    public void setIdEstante(int idEstante) {
        this.idEstante = idEstante;
    }

    public int getCodPrateleira() {
        return codPrateleira;
    }

    public void setCodPrateleira(int codPrateleira) {
        this.codPrateleira = codPrateleira;
    }

    public int getCodConteudo() {
        return codConteudo;
    }

    public void setCodConteudo(int codConteudo) {
        this.codConteudo = codConteudo;
    }
}
