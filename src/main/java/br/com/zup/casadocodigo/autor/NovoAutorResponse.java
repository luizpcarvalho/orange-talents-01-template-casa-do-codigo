package br.com.zup.casadocodigo.autor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NovoAutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private String dataCriacao;

    public NovoAutorResponse(AutorEntity autorEntity) {
        this.id = autorEntity.getId();
        this.nome = autorEntity.getNome();
        this.email = autorEntity.getEmail();
        this.descricao = autorEntity.getDescricao();
        this.dataCriacao = autorEntity.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
}
