package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    public List<Funcionario> listarFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionario(Integer idFuncionario){
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(idFuncionario);

        if (funcionario.isEmpty()){
            throw new RuntimeException("O funcionario não foi encontrado!");
        } else {
            return funcionario.get();
        }
    }

    public Funcionario salvar(FuncionarioDTO dto) {
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo()); // verifica se o cargo existe mesmo.
        //transferindo informações do DTO para nossa entidade
        Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), cargo);
        Funcionario salvo = this.funcionarioRepository.save(funcionario);
        return salvo; //
    }

    public Funcionario atualizar(Integer idFuncionario, FuncionarioDTO dto){
        Funcionario funcionarioAtual = this.getFuncionario(idFuncionario);
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        funcionarioAtual.setNome(dto.getNome());
        funcionarioAtual.setEmail(dto.getEmail());
        funcionarioAtual.setSenha(dto.getSenha());
        funcionarioAtual.setCpf(dto.getCpf());
        funcionarioAtual.setFoto(dto.getFoto());
        funcionarioAtual.setCargo(cargo);

        Funcionario atualizado = this.funcionarioRepository.save(funcionarioAtual);
        return atualizado;
    }

    public void deletar(Integer idFuncionario){
        Funcionario funcionario = this.getFuncionario(idFuncionario);
        this.funcionarioRepository.delete(funcionario);
    }
}
