package com.example.SAEP.service;

import com.example.SAEP.dto.UserDTO;
import com.example.SAEP.entities.Usuario;
import com.example.SAEP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public Usuario createUser(UserDTO user) {
        Usuario usuario = new Usuario(user);
        return userRepository.save(usuario);
    }




}
