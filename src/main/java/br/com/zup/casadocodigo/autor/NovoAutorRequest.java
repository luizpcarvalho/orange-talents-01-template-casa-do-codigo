package br.com.zup.casadocodigo.autor;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @UniqueValue(domainClass = AutorEntity.class, fieldName = "email",
            message = "Já existe um(a) outro(a) autor(a) com o mesmo e-mail.")
    private String email;
    @NotBlank
    @Size(min = 10, max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public AutorEntity toModel() {
        AutorEntity autor = new AutorEntity(this.nome, this.email, this.descricao);
        return autor;
    }

}
