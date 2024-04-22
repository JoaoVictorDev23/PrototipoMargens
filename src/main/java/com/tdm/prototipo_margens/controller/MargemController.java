package com.tdm.prototipo_margens.controller;

import com.tdm.prototipo_margens.Errors.ErrorResponse;
import com.tdm.prototipo_margens.main.DTOs.CriarMargemDto;
import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.services.MargemService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/margem")
public class MargemController {
    @Autowired
    private MargemService margemService;


    @GetMapping
    public ResponseEntity<List<CriarMargemDto>> margemList() {
        return ResponseEntity.ok(margemService.listAllMargens());
    }


    @PostMapping("/criar")
    public ResponseEntity criarMargem(@Valid @RequestBody CriarMargemDto margem){
        try{
            margemService.createMargem(margem);
            return ResponseEntity.ok().build();
        }
        catch (RuntimeException e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity updateMargem(@PathVariable String id, @RequestBody CriarMargemDto margemDto) {
        try {
            margemService.updateMargem(id, margemDto);
            return ResponseEntity.ok().build();

        }
        catch (RuntimeException e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

}
