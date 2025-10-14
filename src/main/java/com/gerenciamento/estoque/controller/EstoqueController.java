package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.service.EstoqueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/estoque")
public class EstoqueController {

    public final EstoqueService estoqueService;
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<EstoqueModel> criar(@Valid @RequestBody EstoqueDto dto) {
        EstoqueModel estoqueModel = estoqueService.salvar(dto);
        return ResponseEntity.ok(estoqueModel);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueModel>> listarTodos() {
        return ResponseEntity.ok(estoqueService.listarTodos());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<EstoqueModel>>  listarAtivas() {
        return ResponseEntity.ok(estoqueService.listarEstoqueAtivo());
    }

    @GetMapping("/{cdEstoque}")
    public ResponseEntity<EstoqueModel> listarPorCdEstoque
            (@PathVariable Integer cdEstoque) {
        return estoqueService.findByCdEstoque(cdEstoque)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
