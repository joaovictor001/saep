package com.example.SAEP.dto;

import com.example.SAEP.entities.Tarefa;

public record TarefaUpdate(
                           String descricao,
                           String setor,
                           Tarefa.Priority prioridade,
                           Tarefa.Status status) {
}
