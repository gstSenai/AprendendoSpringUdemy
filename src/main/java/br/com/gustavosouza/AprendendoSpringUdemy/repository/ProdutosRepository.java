package br.com.gustavosouza.AprendendoSpringUdemy.repository;

import br.com.gustavosouza.AprendendoSpringUdemy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, String> {


}
