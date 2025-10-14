package com.gerenciamento.estoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBPRODUTO")

public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDPRODUTO")
    private Integer cdProduto;
    @Column(name = "NMPRODUTO", length = 100, nullable = false)
    private String nmProduto;
    @Column(name = "DSPRODUTO", length = 100)
    private String dsProduto;
    @Column(name = "FLATIVO")
    private String flAtivo;
}
