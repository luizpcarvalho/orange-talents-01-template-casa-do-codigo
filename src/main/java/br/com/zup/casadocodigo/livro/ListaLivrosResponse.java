package br.com.zup.casadocodigo.livro;

public class ListaLivrosResponse {

    private Long id;
    private String titulo;

    public ListaLivrosResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
