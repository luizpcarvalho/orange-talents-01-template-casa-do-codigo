package br.com.zup.casadocodigo.categoria;

public class NovaCategoriaResponse {

    private Long id;
    private String nome;

    public NovaCategoriaResponse(CategoriaEntity categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
