import React, { useEffect, useState } from "react";
import { Carro } from "../models/Carro";
import { criarCarro } from "../controllers/CarroController";
import { useNavigate } from "react-router-dom";

export function CarroFormView() {
    const [carro, setCarro] = useState<Omit<Carro, "id">>({
        nome: "",
        marca: "",
        ano: 0,
    });

    const navigate = useNavigate();

    async function handleSubmit(e: React.FormEvent) {
        e.preventDefault();
        try {
            const novoCarro = await criarCarro(carro);
            if (novoCarro) {
                setCarro({ nome: "", marca: "", ano: 0 });
            }
            alert('Carro criado com sucesso!');
            navigate('/carros');

        } catch (error) {
            alert('Erro ao criar carro ' + error);
        }
    }

    return (
        <div>
            <h1>Novo Carro</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Nome"
                    value={carro.nome}
                    onChange={(e) => setCarro({ ...carro, nome: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Marca"
                    value={carro.marca}
                    onChange={(e) => setCarro({ ...carro, marca: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Ano"
                    value={carro.ano}
                    onChange={(e) => setCarro({ ...carro, ano: parseInt(e.target.value) })}
                />
                <button type="submit">Salvar</button>
            </form>
        </div>
    );
}  
