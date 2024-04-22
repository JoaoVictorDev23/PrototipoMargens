package com.tdm.prototipo_margens.main.DTOs;

import com.tdm.prototipo_margens.main.Entidades.Margem;
import jakarta.persistence.Column;

public record MargemDto(
 String Id,

 String cliente,
  String linha,

 String origem,

 String destino,

 Float margem,
 Float margemAgr,
 Float kilometragem,
 Float pesoTon,

 Float frete,
 Float icms,

 String observacao,
 String cadastradoPor
)
{
    public MargemDto(Margem margem){
        this(margem.getId(), margem.getCliente(), margem.getLinha(), margem.getOrigem(),
                margem.getDestino(), margem.getMargem(), margem.getMargemAgr(),margem.getKilometragem(),
                margem.getPesoTon(),margem.getFrete(),margem.getIcms(),
                margem.getObservacao(), margem.getCadastradoPor());
    }
}
