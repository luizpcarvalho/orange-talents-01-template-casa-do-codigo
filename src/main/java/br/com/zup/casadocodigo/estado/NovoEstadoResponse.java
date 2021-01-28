package br.com.zup.casadocodigo.estado;

public class NovoEstadoResponse {

    private Long id;
    private String nome;
    private String pais;

    public NovoEstadoResponse(EstadoEntity estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
}
