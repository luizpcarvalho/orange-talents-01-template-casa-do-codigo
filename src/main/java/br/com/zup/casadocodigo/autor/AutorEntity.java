package br.com.zup.casadocodigo.autor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Deprecated
    public AutorEntity() {
    }

    public AutorEntity(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorEntity that = (AutorEntity) o;
        return id.equals(that.id) && nome.equals(that.nome) && email.equals(that.email) && descricao.equals(that.descricao) && dataCriacao.equals(that.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, descricao, dataCriacao);
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

}
