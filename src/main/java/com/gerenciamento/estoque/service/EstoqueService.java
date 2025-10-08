package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.repository.EstoqueRepository;
import com.gerenciamento.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    public EstoqueService(EstoqueRepository estoqueRepository) {this.estoqueRepository = estoqueRepository;}
    public EstoqueModel salvar(EstoqueDto dto){
        EstoqueModel estoque = new EstoqueModel();
        estoque.setCdLocalEstoque(dto.cdLocalEstoque());
        estoque.setQtEstoque(dto.qtEstoque());
        estoque.setFlAtivo(dto.flAtivo());
        return estoqueRepository.save(estoque);
    }
}
