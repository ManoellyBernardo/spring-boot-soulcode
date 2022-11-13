package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario{

    @Column(length = 25)
    private String telefone;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String senha, String cpf, String telefone) {
        super(id, nome, email, senha, cpf, Perfil.CLIENTE);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
