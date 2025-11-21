package br.com.brenolima1.carros.mapper;

import br.com.brenolima1.carros.dtos.carro.CarroRequestDTO;
import br.com.brenolima1.carros.dtos.carro.CarroResponseDTO;
import br.com.brenolima1.carros.models.Carro;
import br.com.brenolima1.carros.models.Usuario;

public class CarroMapper {
    public static Carro toEntity(CarroRequestDTO dto, Usuario dono) {
        Carro carro = new Carro();
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());
        carro.setPreco(dto.getPreco());
        carro.setMarca(dto.getMarca());
        carro.setDono(dono);
        return carro;
    }

    public static CarroResponseDTO toDTO(Carro carro) {
        CarroResponseDTO dto = new CarroResponseDTO();
        dto.setId(carro.getId());
        dto.setModelo(carro.getModelo());
        dto.setAno(carro.getAno());
        dto.setPreco(carro.getPreco());
        dto.setMarca(carro.getMarca());
        dto.setDonoUsername(carro.getDono().getUsername());
        return dto;
    }
}
