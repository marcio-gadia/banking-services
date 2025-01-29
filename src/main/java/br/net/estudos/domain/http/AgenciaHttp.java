package br.net.estudos.domain.http;

public class AgenciaHttp {

    private String nome;
    private String razaoSocial;
    private String cnpj;
    private SituacaoCadastral situacaocadastral;

    protected AgenciaHttp() {
    }

    public AgenciaHttp(String nome, String razaoSocial, String cnpj, SituacaoCadastral situacaocadastral) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.situacaocadastral = situacaocadastral;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public SituacaoCadastral getSituacaocadastral() {
        return situacaocadastral;
    }

    public void setSituacaocadastral(SituacaoCadastral situacaocadastral) {
        this.situacaocadastral = situacaocadastral;
    }

    
}
