package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EstoqueDto(
        @NotNull(message = "Não é possivel cadastrar o produto no estoque com o codigo do local em branco!")
        Integer cdLocalEstoque,

        @NotNull(message = "Não é possivel cadastrar o produto no estoque com a quantidade em branco!")
        Integer qtEstoque,

        @Pattern(regexp = "^S|N$", message = "Só é possivel cadastrar no estoque com 'S' ou 'N'!")
        String flAtivo
) {


}
