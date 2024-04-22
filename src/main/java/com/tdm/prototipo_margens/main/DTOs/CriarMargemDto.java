package com.tdm.prototipo_margens.main.DTOs;

import jakarta.validation.constraints.NotNull;

public record CriarMargemDto (@NotNull MargemDto margemDto,
                              @NotNull ValoresMargemDto valoresMargemDto){
}
