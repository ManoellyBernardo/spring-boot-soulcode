package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listarCliente(){
        return  this.clienteService.listarCliente();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente){
        return this.clienteService.getCliente(idCliente);
    }

    @PostMapping("/clientes")
    public Cliente salvarCliente(@Valid @RequestBody ClienteDTO dto){

        Cliente cliente = this.clienteService.salvar(dto);

        return cliente;
    }

    @PutMapping("/clientes/{idCliente}")
    public Cliente atualizarCliente(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto){
        Cliente clienteAtualizado = this.clienteService.atualizar(idCliente, dto);

        return clienteAtualizado;
    }

    @DeleteMapping("/clientes/{idCliente}")
    public void deletarCliente(@PathVariable Integer idCliente){
        this.clienteService.deletarCliente(idCliente);
    }
}
