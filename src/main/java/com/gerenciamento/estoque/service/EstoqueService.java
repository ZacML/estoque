package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.repository.EstoqueRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<EstoqueModel> listarTodos(){ return estoqueRepository.findAllEstoque(); }
    public Optional<EstoqueModel>  findByCdEstoque(Integer cdEstoque){
        return estoqueRepository.findByCdEstoque(cdEstoque);
    }
    public Optional<EstoqueModel>  findAllByCdLocalEstoque(Integer cdLocalEstoque){
        return estoqueRepository.findAllByCdLocalEstoque(cdLocalEstoque);
    }
    public List<EstoqueModel> listarEstoqueAtivo(){
        return estoqueRepository.findAllEstoque();
    }
    public Optional<EstoqueModel> atualizarDados(Integer cdEstoque, EstoqueDto dto){
        return estoqueRepository.findByCdEstoque(cdEstoque).map(estoque -> {
            estoque.setQtEstoque(dto.qtEstoque());
            estoque.setCdLocalEstoque(dto.cdLocalEstoque());
            estoque.setFlAtivo(dto.flAtivo());
            return estoqueRepository.save(estoque);
        });
    }
    public void deletarEstoque(Integer cdEstoque){estoqueRepository.deleteByCdEstoque(cdEstoque);}

}
