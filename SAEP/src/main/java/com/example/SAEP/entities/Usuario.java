package com.example.SAEP.entities;

import com.example.SAEP.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "usuario_id")

        private Long id;

        @Column(unique = true, nullable = false)
        private String nome;

        @Column(unique = true, nullable = false)
        private String email;

        // Getters and setters


        public Usuario(UserDTO data) {
                this.nome = data.nome();
                this.email = data.email();
        }
}
