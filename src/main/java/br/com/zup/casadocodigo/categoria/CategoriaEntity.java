package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.livro.LivroEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public CategoriaEntity() {
    }

    public CategoriaEntity(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
