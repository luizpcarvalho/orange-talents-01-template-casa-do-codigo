package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.config.validacao.ExistId;
import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.pais.PaisEntity;
import br.com.zup.casadocodigo.pais.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = EstadoEntity.class, fieldName = "nome",
            message = "Já existe um estado cadastrado com este nome.")
    private String nome;
    @NotNull
    @ExistId(domainClass = PaisEntity.class, fieldName = "id",
            message = "O país informado não existe.")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public EstadoEntity toModel(PaisRepository paisRepository){
        PaisEntity pais = paisRepository.getOne(this.idPais);
        return new EstadoEntity(this.nome, pais);
    }

}
