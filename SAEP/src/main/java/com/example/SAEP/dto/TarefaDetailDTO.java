package com.example.SAEP.dto;

import com.example.SAEP.entities.Tarefa;
import com.example.SAEP.entities.Usuario;

public record TarefaDetailDTO(Long tarefa_id,
                              Usuario usuario_id,
                              String descricao,
                              String setor,
                              Tarefa.Priority prioridade,
                              Tarefa.Status status) {

    public TarefaDetailDTO(Tarefa tarefa){
        this(tarefa.getId(),
                tarefa.getUsuario(),
                tarefa.getDescricao(),
                tarefa.getSetor(),
                tarefa.getPrioridade(),
                tarefa.getStatus());
    }
}

