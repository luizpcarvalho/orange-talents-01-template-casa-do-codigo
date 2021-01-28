package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.estado.EstadoEntity;
import br.com.zup.casadocodigo.pais.PaisEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    public EstadoPertenceAPaisValidator(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) o;
        PaisEntity pais = manager.find(PaisEntity.class, request.getIdPais());
        EstadoEntity estado = manager.find(EstadoEntity.class, request.getIdEstado());

        if(!estado.pertenceAPais(pais)) {
            errors.rejectValue("idEstado", null, "Este estado não é do país selecionado.");
        }
    }
}
