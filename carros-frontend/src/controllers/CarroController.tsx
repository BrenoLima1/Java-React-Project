import { Carro } from "../models/Carro";

export async function buscarCarros() {
    try {
        const response = await fetch('/api/carros');
        if (!response.ok) {
         throw new Error('Erro HTTP: ' + response.status)   ;
        }
            const data = await response.json();
            return data;
    } catch (error) {
        console.error('Erro ao buscar carros:', error);
    }
}

export async function criarCarro(carro: Omit<Carro, "id">) {
  const response = await fetch("/api/carros", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(carro),
  });
  if (!response.ok) throw new Error("Erro HTTP: " + response.status);
  return await response.json();
}