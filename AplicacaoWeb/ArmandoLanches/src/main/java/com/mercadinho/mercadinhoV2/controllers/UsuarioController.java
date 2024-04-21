package com.mercadinho.mercadinhoV2.controllers;

import com.mercadinho.mercadinhoV2.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mercadinho.mercadinhoV2.models.Usuario;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(usuario -> ResponseEntity.ok().body(usuario))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizar(Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario existingUsuario = usuarioOptional.get();
            existingUsuario.setName(usuario.getName());
            existingUsuario.setSenha(usuario.getSenha());
            usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok().body(existingUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Usuário cadastrado com sucesso");
    }
}
