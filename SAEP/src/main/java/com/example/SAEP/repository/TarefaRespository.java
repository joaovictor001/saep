package com.example.SAEP.repository;

import com.example.SAEP.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRespository extends JpaRepository<Tarefa,Long> {
}
