import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './telas/App/App'
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import TelaInformacoes from './telas/Informacoes/TelaInformacoes';
import TelaBusca from './telas/Busca/TelaBusca';
import TelaEstante from './telas/Estante/TelaEstante';
import TelaAndar from './telas/Andar/TelaAndar';
import TelaPosicao from './telas/Posicao/TelaPosicao';

const router = createBrowserRouter([{
  path: "/",
  element: <App />,
  
  children:[
  {
    path: "/",
    element: <TelaBusca />
  },
  {
    path: "book",
    element: <TelaInformacoes />
  },
  {
    path: "map",
    element: <TelaEstante />
  },
  {
    path: "map/floor",
    element: <TelaAndar />
  },
  {
    path: "map/floor/position",
    element: <TelaPosicao />
  }
  ],
},]);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router}/>
  </React.StrictMode>
);