package br.com.gustavosouza.AprendendoSpringUdemy.controller;

import br.com.gustavosouza.AprendendoSpringUdemy.model.Produto;
import br.com.gustavosouza.AprendendoSpringUdemy.repository.ProdutosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @PostMapping("/")
    public Produto salvarProduto(@RequestBody Produto produto) {
        System.out.println("Produto salvo com sucesso" + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtosRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto obterProdutoPorId(@PathVariable("id") String id) {
//        Optional<Produto> produto = produtosRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;

        return produtosRepository.findById(id).orElse(null);
    }

}
