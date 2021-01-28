package br.com.zup.casadocodigo.compra;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CompraController {

    @PostMapping("/compra")
    public String comprar(@RequestBody @Valid NovaCompraRequest novaCompraRequest) {
        return "comprando...";
    }

}
