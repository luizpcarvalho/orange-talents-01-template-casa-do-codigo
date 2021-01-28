package br.com.zup.casadocodigo.pais;

public class NovoPaisResponse {

    private Long id;
    private String nome;

    public NovoPaisResponse(PaisEntity pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
