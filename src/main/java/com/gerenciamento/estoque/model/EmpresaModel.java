package com.gerenciamento.estoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBEMPRESA")

public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEMPRESA")
    private Integer cdEmpresa;
    @Column(name = "NMRAZAO", length = 100, nullable = false, unique = true)
    private String nmRazao;
    @Column(name = "NMFANTASIA", length = 100)
    private String nmFantasia;
    @Column(name = "NUCNPJ", length = 20)
    private String nuCnpj;
    @Column(name = "NUTELEFONE", length = 14)
    private String nuTelefone;
    @Column(name = "DSENDERECO", length = 100)
    private String dsEndereco;
    @Column(name = "NUENDERECO")
    private String nuEndereco;
    @Column(name = "FLATIVO", length = 1, nullable = false)
    private String flAtivo;

    public String buscaCdEmpresa() {

    }

    public String buscaNuCnpj() {

    }

    public String buscaFlAtivo() {

    }

    public Integer deletarCdEmpresa() {

    }

    public void buscaTodos() {
    }

    public void salvar() {
    }
}
