package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.PaisEntity;

import javax.persistence.*;

@Entity
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    private PaisEntity pais;

    @Deprecated
    public EstadoEntity() {
    }

    public EstadoEntity(String nome, PaisEntity pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public boolean pertenceAPais(PaisEntity pais) {
        return this.pais.equals(pais);
    }
}
