package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.ProdutoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
    Optional<ProdutoModel> findByCdProduto(Integer cdProduto);

    List<ProdutoModel> findAllByNmProduto(String nmProduto);

    @Query("SELECT emp FROM ProdutoModel emp WHERE emp.flAtivo = 'S'")
    List<ProdutoModel> findAllByFlAtivo();

    @Transactional
    Optional<ProdutoModel> deleteByCdProduto (Integer cdProduto);
}
