package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.*;

@Entity
@Table(name = "usuarios") //coloca um nome especifico na tabela
public abstract class Usuario { //Não será possivel criar objetos dessa classe

    @Id //Torna o campo abaixo um PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //preenche o campo id com AUTO_INCREMENT
    protected Integer id;
    @Column(nullable = false, length = 150)
    protected String nome;
    @Column(nullable = false, unique = true, length = 120)
    protected String email;
    @Column(nullable = false)
    protected String senha;
    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;
    @Enumerated(EnumType.STRING)//representa os valores do ENUM como texto
    protected Perfil perfil; //indica o que o usuário é no sistema

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, String cpf, Perfil perfil){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
