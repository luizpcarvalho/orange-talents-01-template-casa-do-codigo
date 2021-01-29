package br.com.zup.casadocodigo.compra;

import br.com.zup.casadocodigo.pais.PaisEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class PaisPossuiEstadosValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovaCompraRequest request = (NovaCompraRequest) o;

        if(errors.hasErrors() || request.getIdEstado() != null) {
            return;
        }

        PaisEntity pais = manager.find(PaisEntity.class, request.getIdPais());

        Query query = manager.createQuery("SELECT e FROM EstadoEntity e WHERE e.pais = :idPais");
        query.setParameter("idPais", pais);
        List<?> list = query.getResultList();

        if(list.size() > 0) {
            errors.rejectValue("idEstado", null, "Estado é obrigatório para o país selecionado.");
        }
    }
}
