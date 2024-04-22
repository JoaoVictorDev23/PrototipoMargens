package com.tdm.prototipo_margens.main.Entidades;

import com.tdm.prototipo_margens.main.DTOs.ClienteDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(name = "grupo_cliente")
    private String grupoCliente;

    @Column(name="nome_cliente")
    private String nomeCliente;

    @Column(name = "observacao_cliente")
    private String observacaoCliente;

    public Cliente(@Valid ClienteDto clienteDto){
        this.grupoCliente = clienteDto.grupoCliente();
        this.nomeCliente = clienteDto.nomeCliente();
        this.observacaoCliente = clienteDto.observacaoCliente();
    }
}
