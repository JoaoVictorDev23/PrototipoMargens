package com.tdm.prototipo_margens.controller;

import com.tdm.prototipo_margens.Errors.ErrorResponse;
import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.services.MargemService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/margem")
public class MargemController {
    @Autowired
    private MargemService margemService;


    @GetMapping
    public ResponseEntity<List<MargemDto>> margemList() {
        return ResponseEntity.ok(margemService.listMargem());
    }


    @PostMapping("/criar")
    public ResponseEntity criarMargem(@Valid @RequestBody MargemDto margem){
        try{
            margemService.createMargem(margem);
            return ResponseEntity.ok().build();
        }
        catch (RuntimeException e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

}
