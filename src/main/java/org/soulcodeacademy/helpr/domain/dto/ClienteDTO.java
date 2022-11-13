package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotBlank;

public class ClienteDTO extends UsuarioDTO {

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

// @NotNull => só verifica se tem valor ou não (objetos, integer, double)
// @NotBlank => verifica se o telefone está "" (string)