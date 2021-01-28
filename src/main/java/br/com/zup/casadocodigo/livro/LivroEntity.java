package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.AutorEntity;
import br.com.zup.casadocodigo.categoria.CategoriaEntity;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false, length = 500)
    private String resumo;
    @Column(nullable = false)
    private String sumario;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false)
    private Integer numeroPaginas;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private LocalDate dataPublicacao;
    @ManyToOne
    private CategoriaEntity categoria;
    @ManyToOne
    private AutorEntity autor;

    @Deprecated
    public LivroEntity() {
    }

    public LivroEntity(String titulo, String resumo, String sumario, BigDecimal preco,
                       Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                       @Valid CategoriaEntity categoria, @Valid AutorEntity autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public AutorEntity getAutor() {
        return autor;
    }
}
