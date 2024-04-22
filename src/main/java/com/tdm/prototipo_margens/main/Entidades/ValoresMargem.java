package com.tdm.prototipo_margens.main.Entidades;

import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import com.tdm.prototipo_margens.main.DTOs.ValoresMargemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "valores_margem")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValoresMargem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_valores")
    private String IdValores;

    @Column(name = "fm")
    private Float fm;
    @Column(name = "fe")
    private Float fe;
    @Column(name= "fm_truck")
    private Float fmTruck;
    @Column(name= "fe_truck")
    private Float feTruck;
    @Column(name = "fm_bitrem")
    private Float fmBitrem;
    @Column(name = "fe_bitrem")
    private Float feBitrem;
    @Column(name = "fm_carreta")
    private Float fmCarreta;
    @Column(name = "fe_carreta")
    private Float feCarreta;
    @Column(name = "fm_granel")
    private Float fmGranel;
    @Column(name = "fe_granel")
    private Float feGranel;
    @Column(name = "fm_rodotrem")
    private Float fmRodotrem;
    @Column(name = "fe_rodotrem")
    private Float feRodotrem;

    @Column(name = "cadastrado_por")
    private String cadastradoPor;

    @Column(name = "id_margem")
    private String idMargem;

    public ValoresMargem(ValoresMargemDto valoresMargemDto){
        this.fe = valoresMargemDto.fe();
        this.fm = valoresMargemDto.fm();

        this.feTruck = valoresMargemDto.feTruck();
        this.fmTruck = valoresMargemDto.fmTruck();

        this.feBitrem = valoresMargemDto.feBitrem();
        this.fmBitrem = valoresMargemDto.fmBitrem();

        this.feCarreta = valoresMargemDto.feCarreta();
        this.fmCarreta = valoresMargemDto.fmCarreta();

        this.feGranel = valoresMargemDto.feGranel();
        this.fmGranel = valoresMargemDto.fmGranel();

        this.feRodotrem = valoresMargemDto.feRodotrem();
        this.fmRodotrem = valoresMargemDto.fmRodotrem();

        this.cadastradoPor = valoresMargemDto.idMargem();
        this.idMargem = valoresMargemDto.idMargem();
     }



}
