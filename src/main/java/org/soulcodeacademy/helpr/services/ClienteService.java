package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    public Cliente getCliente(Integer idCliente){
        Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);

        if (cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado!");
        }else{
            return cliente.get();
        }
    }

    public Cliente salvar(ClienteDTO dto){

        Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getCpf(), dto.getTelefone());

        Cliente salvo = this.clienteRepository.save(cliente);

        return salvo;
    }

    public Cliente atualizar(Integer idCliente, ClienteDTO dto){
        Cliente clienteAtual = this.getCliente(idCliente);

        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setSenha(dto.getSenha());
        clienteAtual.setCpf(dto.getCpf());
        clienteAtual.setTelefone(dto.getTelefone());

        Cliente clienteAtualizado = this.clienteRepository.save(clienteAtual);
        return clienteAtualizado;
    }

    public void deletarCliente(Integer idCliente){
        Cliente cliente = this.getCliente(idCliente);
        this.clienteRepository.delete(cliente);
    }
}

// Quando usar entidade e dto?
// Entidade = retorno dos dados
// DTO = entrada de dados
