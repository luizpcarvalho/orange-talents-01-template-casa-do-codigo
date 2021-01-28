package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.estado.EstadoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "pais")
    private List<EstadoEntity> estados = new ArrayList<>();

    @Deprecated
    public PaisEntity() {
    }

    public PaisEntity(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<EstadoEntity> getEstados() {
        return estados;
    }
}
