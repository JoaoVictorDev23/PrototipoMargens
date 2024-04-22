package com.tdm.prototipo_margens.main.DTOs;

import com.tdm.prototipo_margens.main.Entidades.ValoresMargem;

public record ValoresMargemDto(
        Float fm,
        Float fe,
        Float fmTruck,
        Float feTruck,
        Float fmBitrem,
        Float feBitrem,
        Float fmCarreta,
        Float feCarreta,
        Float fmGranel,
        Float feGranel,
        Float fmRodotrem,
        Float feRodotrem,

        String idMargem
) {

    public ValoresMargemDto(ValoresMargem valoresMargem){
        this(valoresMargem.getFm(), valoresMargem.getFe(), valoresMargem.getFmTruck(), valoresMargem.getFeTruck(),
                valoresMargem.getFmBitrem(), valoresMargem.getFeBitrem(), valoresMargem.getFmCarreta(), valoresMargem.getFeCarreta(),
                valoresMargem.getFmGranel(), valoresMargem.getFeGranel(), valoresMargem.getFmRodotrem(), valoresMargem.getFeRodotrem(),
                valoresMargem.getIdMargem());
    }
}
