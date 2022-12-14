package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//DTO - Objeto de transferência de dados
//É util para validarmos as informações transferias pelo cliente
public class CargoDTO {

    @NotBlank(message = "Campo nome é obrigatório.") //Essa anotação impede que o valor do nome seja "" (vazio), por exemplo
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório.")
    private String descricao;
    @NotNull(message = "Campo salário é obrigatório.") //Impede que o valor seja null
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo salário inválido")
    private Double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
