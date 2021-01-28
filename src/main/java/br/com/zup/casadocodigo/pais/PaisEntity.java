package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.estado.EstadoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisEntity that = (PaisEntity) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
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
