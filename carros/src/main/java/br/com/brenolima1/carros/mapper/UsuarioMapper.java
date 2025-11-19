package br.com.brenolima1.carros.mapper;

import br.com.brenolima1.carros.dtos.usuario.UsuarioRequestDTO;
import br.com.brenolima1.carros.dtos.usuario.UsuarioResponseDTO;
import br.com.brenolima1.carros.exception.RoleException;
import br.com.brenolima1.carros.models.Role;
import br.com.brenolima1.carros.models.Usuario;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        try {
            usuario.setRole(Role.valueOf(dto.getRole().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RoleException("Papel inválido: " + dto.getRole());
        }
        return usuario;
    }

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setRole(usuario.getRole().name());
        if (usuario.getDataCadastro() != null) {
            dto.setDataCadastro(usuario.getDataCadastro().toInstant());
        }
        return dto;
    }

}
