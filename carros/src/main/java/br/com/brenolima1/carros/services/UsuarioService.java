package br.com.brenolima1.carros.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.brenolima1.carros.exception.UsuarioNaoEncontradoException;
import br.com.brenolima1.carros.models.Usuario;
import br.com.brenolima1.carros.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(usuario.getId())
            .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario.getId()));

        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setRole(usuario.getRole());

        return usuarioRepository.save(usuarioExistente);
    }
}
