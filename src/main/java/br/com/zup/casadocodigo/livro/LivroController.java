package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.AutorRepository;
import br.com.zup.casadocodigo.categoria.CategoriaRepository;
import br.com.zup.casadocodigo.livro.detalhe.DetalheLivroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoLivroResponse> criar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        LivroEntity livro = novoLivroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.ok().body(new NovoLivroResponse(livro));
    }

    @GetMapping
    public ResponseEntity<List<ListaLivrosResponse>> listar() {
        List<ListaLivrosResponse> listaDeLivros = livroRepository.findAllLivros();
        return ResponseEntity.ok().body(listaDeLivros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id) {
        Optional<LivroEntity> optional = livroRepository.findById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalheLivroResponse(optional.get()));
    }

}
