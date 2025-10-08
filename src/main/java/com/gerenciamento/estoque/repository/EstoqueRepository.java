package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.EstoqueModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
    Optional<EstoqueModel> findByCdEstoque (Integer cdEstoque);

    Optional<EstoqueModel> findAllByCdLocalEstoque(Integer cdLocalEstoque);

    @Query("SELECT emp FROM EstoqueModel emp WHERE emp.flAtivo = 'S'")
    List<EstoqueModel> findAllEstoque();

    @Transactional
    Optional<EstoqueModel> deleteByCdEstoque (Integer cdEstoque);
}
