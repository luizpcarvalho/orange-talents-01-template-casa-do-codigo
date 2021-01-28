package br.com.zup.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {
        CategoriaEntity categoria = novaCategoriaRequest.toModel();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().body(new NovaCategoriaResponse(categoria));
    }

}
