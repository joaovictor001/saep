package com.example.SAEP.controller;

import com.example.SAEP.dto.UserDTO;
import com.example.SAEP.entities.Usuario;
import com.example.SAEP.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping("/usuario/getall")
    @CrossOrigin("http://localhost:3000")
    public List<Usuario> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/usuario/create")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        Usuario createdUser = userService.createUser(user);
        return ResponseEntity.ok(user);
    }
}
