package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Usuario {
    //Gera uma coluna dtype para indicar qual é a subclasse
    //Coluna foto não é obrigatória
    private String foto;
    @ManyToOne //Muitos funcionario para um cargo
    @JoinColumn(name = "idCargo") //Cria uma coluna nova que é a chave estrangeira de Cargo
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String email, String senha, String cpf, String foto, Cargo cargo) {
        super(id, nome, email, senha, cpf, Perfil.FUNCIONARIO); //
        this.foto = foto;
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

//Anotações de relacionamento
//@OneToOne - 1:1
//@ManyToOne ou @OneToMany - 1:N
//@ManyToMany - N:N

// Relacionamento Unidirecional = apenas uma das entidades "conhece" a outra.
// Relacionamento Bidirecional = as duas entidades se "conhecem".