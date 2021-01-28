package br.com.zup.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoAutorResponse> cadastrar(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
        AutorEntity autor = novoAutorRequest.toModel();
        autorRepository.save(autor);

        return ResponseEntity.ok().body(new NovoAutorResponse(autor));
    }

}
