package com.dio.ponto.controller;

import com.dio.ponto.model.JornadaTrabalho;
import com.dio.ponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornardaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    @GetMapping(value = "/{idjornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("id") Long idjornada) throws Exception{
        return ResponseEntity.ok(jornadaService.getById(idjornada).orElseThrow( () -> new Exception("Jornada não encontrada.")));
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornadaById(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return ResponseEntity.ok(jornadaService.updateJornada(jornadaTrabalho));
    }

    @DeleteMapping("/{idjornada}")
    public ResponseEntity<?> deleteJornadaById(@PathVariable("id") Long idjornada){
                    return ResponseEntity.ok().build();

    }


}
