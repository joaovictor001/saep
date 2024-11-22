package com.example.SAEP.entities;

import com.example.SAEP.dto.TarefaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name = "tarefa")
@Table(name = "tarefa")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarefa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "tarefa_id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario;

        private String descricao;
        private String setor;

        @Enumerated(EnumType.STRING)
        private Priority prioridade;

        private LocalDateTime dataCadastro;

        @Enumerated(EnumType.STRING)
        private Status status;

        // Getters and setters


    public enum Priority {
        baixa,
        media,
        alta
    }

    public enum Status {
        a_fazer,
        fazendo,
        pronto
    }

    public Tarefa(TarefaDTO data,Usuario uset) {
        this.usuario = uset;
        this.descricao = data.descricao();
        this.setor = data.setor();
        this.prioridade = data.prioridade();
        this.dataCadastro = LocalDateTime.now();
        this.status = data.status();
    }
}
