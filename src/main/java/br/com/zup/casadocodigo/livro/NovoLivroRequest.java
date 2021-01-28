package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.AutorEntity;
import br.com.zup.casadocodigo.autor.AutorRepository;
import br.com.zup.casadocodigo.categoria.CategoriaEntity;
import br.com.zup.casadocodigo.categoria.CategoriaRepository;
import br.com.zup.casadocodigo.config.validacao.ExistId;
import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = LivroEntity.class, fieldName = "titulo",
            message = "Já existe um livro cadastrado com este título.")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = LivroEntity.class, fieldName = "isbn",
            message = "Já existe um livro cadastrado com este código ISBN.")
    private String isbn;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @ExistId(domainClass = CategoriaEntity.class, fieldName = "id",
            message = "A categoria informada não existe.")
    private Long idCategoria;
    @NotNull
    @ExistId(domainClass = AutorEntity.class, fieldName = "id",
            message = "O(A) autor(a) informado(a) não existe.")
    private Long idAutor;

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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public LivroEntity toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        @NotNull CategoriaEntity categoria = categoriaRepository.getOne(this.idCategoria);
        @NotNull AutorEntity autor = autorRepository.getOne(this.idAutor);

        Assert.state(autor!=null, "Você está tentando cadastrar um livro para " +
                "um autor que não existe no banco de dados. " + this.idAutor);
        Assert.state(categoria!=null, "Você está tentando cadastrar um livro para " +
                "uma categoria que não existe no banco de dados. " + this.idCategoria);

        return new LivroEntity(this.titulo, this.resumo, this.sumario, this.preco,
                this.numeroPaginas, this.isbn, this.dataPublicacao, categoria, autor);

    }

}
