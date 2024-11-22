package com.example.SAEP.dto;

import com.example.SAEP.entities.Tarefa;
import com.example.SAEP.entities.Usuario;

import java.time.LocalDateTime;

public record TarefaDTO (
         Long usuario,
         String descricao,
         String setor,
         Tarefa.Priority prioridade,
         Tarefa.Status status) {
}
