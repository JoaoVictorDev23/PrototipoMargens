package com.tdm.prototipo_margens.main.DTOs;

import com.tdm.prototipo_margens.main.Entidades.Cliente;
import jakarta.validation.constraints.NotBlank;

public record ClienteDto(
   @NotBlank String grupoCliente,
   @NotBlank String nomeCliente,
   @NotBlank  String observacaoCliente
) {
    public ClienteDto(Cliente cliente){
        this(cliente.getGrupoCliente(), cliente.getNomeCliente(), cliente.getObservacaoCliente());
    }

}
