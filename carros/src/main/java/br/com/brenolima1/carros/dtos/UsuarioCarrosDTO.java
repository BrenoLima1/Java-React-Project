package br.com.brenolima1.carros.dtos;

import java.util.List;

import br.com.brenolima1.carros.models.Carro;
import br.com.brenolima1.carros.models.Usuario;

public class UsuarioCarrosDTO {
    private Long usuarioId;
    private String username;
    private String email;
    private List<CarroDTO> carros;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CarroDTO> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroDTO> carros) {
        this.carros = carros;
    }

    public UsuarioCarrosDTO(Long usuarioId, String username, String email, List<CarroDTO> carros) {
        this.usuarioId = usuarioId;
        this.username = username;
        this.email = email;
        this.carros = carros;
    }
    public UsuarioCarrosDTO() {}

    public static UsuarioCarrosDTO fromEntity(Usuario usuario, List<Carro> carros) {
    List<CarroDTO> carroDTOs = carros.stream()
        .map(c -> new CarroDTO(c.getId(), c.getModelo(), c.getMarca(), c.getAno(), c.getPreco()))
        .toList();
    return new UsuarioCarrosDTO(usuario.getId(), usuario.getUsername(), usuario.getEmail(), carroDTOs);
}

public Usuario toEntity() {
    Usuario usuario = new Usuario();
    usuario.setId(this.usuarioId);
    usuario.setUsername(this.username);
    usuario.setEmail(this.email);
    return usuario;
}

}

