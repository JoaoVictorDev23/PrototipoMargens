package com.tdm.prototipo_margens.controller;

import com.tdm.prototipo_margens.Errors.ErrorResponse;
import com.tdm.prototipo_margens.main.DTOs.ValoresMargemDto;
import com.tdm.prototipo_margens.services.ValoresMargemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valoresmargem")
public class ValoresMargemController {
    @Autowired
    private ValoresMargemService valoresMargemService;

    @GetMapping("/{idMargem}")
    public ResponseEntity<ValoresMargemDto> findbyValores(@PathVariable String idMargem) {
        return valoresMargemService.findbyValores(idMargem);
    }

    @PostMapping("/criar")
    public ResponseEntity criarValoresMargem (@Valid @RequestBody ValoresMargemDto valoresMargemDto){
        try {
            valoresMargemService.createValores(valoresMargemDto);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
