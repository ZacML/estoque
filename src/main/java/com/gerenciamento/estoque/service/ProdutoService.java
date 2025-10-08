package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.ProdutoDto;
import com.gerenciamento.estoque.model.ProdutoModel;
import com.gerenciamento.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    public ProdutoModel salvar(ProdutoDto dto){
        ProdutoModel produto = new ProdutoModel();
        produto.setNmProduto(dto.nmProduto());
        produto.setDsProduto(dto.dsProduto());
        produto.setFlAtivo(dto.flAtivo());
        return produtoRepository.save(produto);
    }
    public List<ProdutoModel> listarTodas(){
        return produtoRepository.findAll();
    }
    public Optional<ProdutoModel> buscarCdProduto(Integer cdProduto){
        return produtoRepository.findByCdProduto(cdProduto);
    }
    public List<ProdutoModel> listarTodosNomeProdutos(String nmProduto){
        return produtoRepository.findAllByNmProduto(nmProduto);
    }
    public List<ProdutoModel> listarProdutoAtivo(){
        return produtoRepository.findAllByFlAtivo();
    }
    public Optional<ProdutoModel> atualizarDados(Integer cdProduto, ProdutoDto dto){
        return produtoRepository.findByCdProduto(cdProduto).map(produto -> {
            produto.setNmProduto(dto.nmProduto());
            produto.setDsProduto(dto.dsProduto());
            produto.setFlAtivo(dto.flAtivo());
            return produtoRepository.save(produto);
        });
    }
    public void deletarProduto(Integer cdProduto){
        produtoRepository.deleteByCdProduto(cdProduto);
    }
}
