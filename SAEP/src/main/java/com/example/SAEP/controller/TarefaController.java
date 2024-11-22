package com.example.SAEP.controller;

import com.example.SAEP.dto.TarefaDTO;
import com.example.SAEP.dto.TarefaDetailDTO;
import com.example.SAEP.entities.Tarefa;
import com.example.SAEP.entities.Usuario;
import com.example.SAEP.repository.UserRepository;
import com.example.SAEP.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController


public class TarefaController {

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tarefa/getall")
    @CrossOrigin("http://localhost:3000")
    public List<TarefaDetailDTO> getTarefas() {
        return tarefaService.getAllTarefas().stream().map(TarefaDetailDTO::new).toList();
    }

    @PostMapping("/tarefa/create")
    @CrossOrigin("http://localhost:3000")
    public TarefaDetailDTO createTarefa(@RequestBody TarefaDTO tarefa) {
        Tarefa createdTarefa = tarefaService.createTarefa(tarefa);
        return new TarefaDetailDTO(createdTarefa);
    }

    @GetMapping("/tarefa/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Tarefa> getTarefa(@PathVariable Long id) {
        Tarefa Tarefa = tarefaService.getTarefa(id);
        if (Tarefa != null) {
            return new ResponseEntity<>(Tarefa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/tarefa/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa TarefaDetails) {
        Tarefa updatedTarefa = tarefaService.updateTarefa(id, TarefaDetails);
        if (updatedTarefa != null) {
            return new ResponseEntity<>(updatedTarefa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tarefa/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        tarefaService.deleteTarefa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
