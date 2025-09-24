package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmpresaDto (
        @NotBlank(message = "Não é possivel salvar a empresa sem razão social!")
        String nmRazao,
        String nmFantasia,
        @NotBlank(message = "Não é possivel salvar a empresa sem um CNPJ!")
        String nuCnpj,
        String nuTelefone,
        @NotBlank(message = "Não é possivel dalvar a empresa sem um endereço!")
        String dsEndereco,
        String nuEndereco,
        @Pattern(regexp = "^S|N$", message = "Só é possivel salvar a empresa com 'S' ou 'N'!")
        String flAtivo
)
{}
