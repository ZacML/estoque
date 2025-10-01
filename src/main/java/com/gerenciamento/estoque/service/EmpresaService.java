package com.gerenciamento.estoque.service;


import com.gerenciamento.estoque.dto.EmpresaDto;
import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    public EmpresaModel salvar(EmpresaDto dto){
        EmpresaModel empresa = new  EmpresaModel();
        empresa.setNmFantasia(dto.nmFantasia());
        empresa.setNmRazao(dto.nmRazao());
        empresa.setDsEndereco(dto.dsEndereco());
        empresa.setNuCnpj(dto.nuCnpj());
        empresa.setFlAtivo(dto.flAtivo());
        empresa.setNuTelefone(dto.nuTelefone());
        return empresaRepository.save(empresa);
    }
    public List<EmpresaModel> listarTodas(){
        return empresaRepository.findAll();
    }
    public List<EmpresaModel> listarEmpresasAtivas(){
        return empresaRepository.findAllByFlAtivo();
    }
    public Optional<EmpresaModel> listarByCdEmpresa(Integer cdEmpresa){
        return empresaRepository.findByCdEmpresa(cdEmpresa);
    }
    public Optional<EmpresaModel> listarByNuCnpj(String nuCnpj){
        return empresaRepository.findByNuCnpj(nuCnpj);
    }
    public Optional<EmpresaModel> atualizarDados(Integer cdEmpresa, EmpresaDto empresaDto){
        return empresaRepository.findByCdEmpresa(cdEmpresa).map(empresa -> {
            empresa.setNuCnpj(empresaDto.nuCnpj());
            empresa.setNuEndereco(empresaDto.nuEndereco());
            empresa.setNmFantasia(empresaDto.nmFantasia());
            empresa.setNmRazao(empresaDto.nmRazao());
            empresa.setDsEndereco(empresaDto.dsEndereco());
            empresa.setNuTelefone(empresaDto.nuTelefone());
            empresa.setFlAtivo(empresaDto.flAtivo());
            return empresaRepository.save(empresa);
        });
    }
    public void deletarEmpresa(Integer cdEmpresa){
        empresaRepository.deleteByCdEmpresa(cdEmpresa);
    }

}
