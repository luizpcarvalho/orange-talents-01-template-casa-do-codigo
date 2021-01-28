package br.com.zup.casadocodigo.livro.detalhe;

import br.com.zup.casadocodigo.livro.LivroEntity;
import br.com.zup.casadocodigo.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/produtos/{id}")
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id) {
        Optional<LivroEntity> optional = livroRepository.findById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalheLivroResponse(optional.get()));
    }

}
