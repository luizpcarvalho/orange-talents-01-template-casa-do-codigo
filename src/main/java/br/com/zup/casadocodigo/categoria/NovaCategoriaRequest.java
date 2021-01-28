package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = CategoriaEntity.class, fieldName = "nome",
            message = "Já existe uma categoria cadastrada com este nome.")
    private String nome;

    public CategoriaEntity toModel() {
        CategoriaEntity categoria = new CategoriaEntity(this.nome);
        return categoria;
    }

    public String getNome() {
        return nome;
    }
}
