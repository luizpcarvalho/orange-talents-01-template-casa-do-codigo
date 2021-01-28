package br.com.zup.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    @Query("SELECT new br.com.zup.casadocodigo.livro.ListaLivrosResponse(l.id, l.titulo) FROM LivroEntity l")
    List<ListaLivrosResponse> findAllLivros();

}
