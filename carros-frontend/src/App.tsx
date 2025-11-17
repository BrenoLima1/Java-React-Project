import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import CarrosListView from "./views/CarrosListView";
import { CarroFormView } from "./views/CarroFormView";

function App() {
  return (
    <Router>
      <nav>
        <Link to="/carros">Lista de Carros</Link> |{" "}
        <Link to="/carros/novo">Novo Carro</Link>
      </nav>

      <Routes>
        <Route path="/carros" element={<CarrosListView />} />
        <Route path="/carros/novo" element={<CarroFormView />} />
      </Routes>
    </Router>
  );
}

export default App;