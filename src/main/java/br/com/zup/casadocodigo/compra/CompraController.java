package br.com.zup.casadocodigo.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
public class CompraController {

    @Autowired
    private EntityManager manager;

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new EstadoPertenceAPaisValidator(manager));
    }

    @PostMapping("/compras")
    public String comprar(@RequestBody @Valid NovaCompraRequest novaCompraRequest) {
        return novaCompraRequest.toString();
    }

}
