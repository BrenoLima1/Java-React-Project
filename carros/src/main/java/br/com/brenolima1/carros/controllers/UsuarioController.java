package br.com.brenolima1.carros.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brenolima1.carros.models.Usuario;
import br.com.brenolima1.carros.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario =  usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@Valid @RequestBody Usuario usuario, @PathVariable Long id) {
        usuario.setId(id);
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuario));
    }
}
