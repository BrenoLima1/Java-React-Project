import React, { useEffect, useState } from "react";
import { Carro } from "../models/Carro";
import { buscarCarros } from "../controllers/CarroController";

function CarrosListView() {
    const [loading, setLoading] = useState(true);
    const [carros, setCarros] = useState<Carro[]>([]);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        buscarCarros()
            .then((data) => setCarros(data))
            .catch((error) => setError(String(error)))
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error}</div>;

    return (
        <div>
            {carros.length === 0 ? (
                <div>Não há carros cadastrados</div>
            ) : (
                <div>
                    <h1>Lista de Carros</h1>
                    <ul>
                        {carros.map((carro) => (
                            <li key={carro.id}>
                                {carro.nome} - {carro.marca} ({carro.ano})
                            </li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}

export default CarrosListView;
