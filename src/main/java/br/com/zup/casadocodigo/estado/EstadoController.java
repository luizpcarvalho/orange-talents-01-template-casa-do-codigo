package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<NovoEstadoResponse> cadastrar(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
        EstadoEntity estado = novoEstadoRequest.toModel(paisRepository);
        estadoRepository.save(estado);

        return ResponseEntity.ok().body(new NovoEstadoResponse(estado));
    }

}
