package com.example.SAEP.service;

import com.example.SAEP.dto.TarefaDTO;
import com.example.SAEP.entities.Tarefa;
import com.example.SAEP.entities.Usuario;
import com.example.SAEP.repository.TarefaRespository;
import com.example.SAEP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRespository tarefaRespository;
    @Autowired
    private UserRepository userRepository;


    public List<Tarefa> getAllTarefas() {

        return tarefaRespository.findAll();
    }

    public Tarefa createTarefa(TarefaDTO tarefa) {
        Usuario user = userRepository.findById(tarefa.usuario()).orElseThrow(()-> new RuntimeException("nao acjou o use"));
        Tarefa tarefa1 = new Tarefa(tarefa,user);
        if (tarefa1.getStatus() == null){
            tarefa1.setStatus(Tarefa.Status.a_fazer);
        }
        return tarefaRespository.save(tarefa1);
    }

    public Tarefa getTarefa(Long id) {
        return tarefaRespository.findById(id).orElse(null);
    }

    public Tarefa updateTarefa(Long id, Tarefa TarefaDetails) {
        Tarefa Tarefa = getTarefa(id);
        if (Tarefa != null) {
            Tarefa.setDescricao(TarefaDetails.getDescricao());
            Tarefa.setSetor(TarefaDetails.getSetor());
            Tarefa.setPrioridade(TarefaDetails.getPrioridade());
            Tarefa.setStatus(TarefaDetails.getStatus());
            return tarefaRespository.save(Tarefa);
        }
        return null;
    }

    public void deleteTarefa(Long id) {
        tarefaRespository.deleteById(id);
    }
}
