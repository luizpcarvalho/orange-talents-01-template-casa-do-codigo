package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.config.validacao.CPFOuCNPJ;
import br.com.zup.casadocodigo.config.validacao.ExistId;
import br.com.zup.casadocodigo.estado.EstadoEntity;
import br.com.zup.casadocodigo.pais.PaisEntity;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompraRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPFOuCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistId(domainClass = PaisEntity.class, fieldName = "id",
            message = "Esse país não está cadastrado.")
    private Long idPais;
    @ExistId(domainClass = EstadoEntity.class, fieldName = "id",
            message = "Esse estado não está cadastrado")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
