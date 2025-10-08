package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProdutoDto(
        @NotBlank(message = "Não é possivel cadastrar o produto com o nome em branco!")
        String nmProduto,

        @NotBlank(message = "Não é possível cadastrar o produto com a descrção em branco!")
        String dsProduto,

        @Pattern(regexp = "^S|N$", message = "Só é possivel salvar o produto com 'S' ou 'N'!")
        String flAtivo
) {
}
