import React from 'react';
import './App.css';

function App() {
  const [mensagem, setMensagem] = React.useState('');

  React.useEffect(() => {
    fetch('/api/hello/Breno')
      .then((response) => response.text())
      .then((mensagem) => setMensagem(mensagem))
      .catch((error) => console.error(error));
  }, []);


  return (
    <div>
      <h1>{mensagem}</h1>
    </div>
  );
}

export default App;
