package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = PaisEntity.class, fieldName = "nome",
            message = "Já existe um país cadastrado com este nome.")
    private String nome;

    public String getNome() {
        return nome;
    }

    public PaisEntity toModel() {
        return new PaisEntity(this.nome);
    }
}
