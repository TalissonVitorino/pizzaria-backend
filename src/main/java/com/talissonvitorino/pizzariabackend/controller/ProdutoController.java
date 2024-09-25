package com.talissonvitorino.pizzariabackend.controller;

import com.talissonvitorino.pizzariabackend.service.ProdutoService;
import com.talissonvitorino.pizzariabackend.entity.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produto")
    public Produto cadastrarNovoProduto(@RequestBody Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @GetMapping("/produto")
    public List<Produto> listarTodosOsProdutos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/produto/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
