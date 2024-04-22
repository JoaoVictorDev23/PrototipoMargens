package com.tdm.prototipo_margens.main.Entidades;

import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="margem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Margem {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String Id;

    @Column(name = "cliente")
    private String cliente;


    @Column(name ="linha")
    private String linha;

    @Column(name="origem")
    private String origem;

    @Column(name="destino")
    private String destino;

    @Column(name="margem")
    private String margem;

    @Column(name="margem_agr")
    private String margemAgr;

    @Column(name = "kilometragem")
    private Float kilometragem;

    @Column(name = "peso_ton")
    private Float pesoTon;

    @Column(name= "frete")
    private Float frete;

    @Column(name = "icms")
    private Float icms;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "cadastrado_por")
    private String cadastradoPor;

    public Margem(@Valid MargemDto margemDto){
        this.Id = margemDto.Id();
        this.cliente = margemDto.cliente();
        this.linha = margemDto.linha();
        this.origem = margemDto.origem();
        this.destino = margemDto.destino();
        this.margem = margemDto.margem();
        this.margemAgr = margemDto.margemAgr();
        this.kilometragem = margemDto.kilometragem();
        this.pesoTon = margemDto.pesoTon();
        this.frete = margemDto.frete();
        this.icms = margemDto.icms();
        this.observacao = margemDto.observacao();
        this.cadastradoPor = margemDto.cadastradoPor();
     }

}
