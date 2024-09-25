package com.talissonvitorino.pizzariabackend.service;

import com.talissonvitorino.pizzariabackend.entity.Produto;
import com.talissonvitorino.pizzariabackend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produtoACadastrar) {
        return produtoRepository.save(produtoACadastrar);
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
        produtoRepository.deleteById(id);
    }
}
