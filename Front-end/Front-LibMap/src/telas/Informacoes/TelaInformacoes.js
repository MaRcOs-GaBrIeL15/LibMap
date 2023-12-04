import BotoesInformacoes from "../../compontente/BotoesInformacoes/BotoesInformacoes";
import Cabecalho from "../../compontente/Cabecalho/Cabecalho";
import Informacoes from "../../compontente/Informacoes/Informacoes";
import "./TelaInformacoes.css";
import axios from "axios";
import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

function TelaInformacoes() {
  const location = useLocation();
  const dados = location.state.data;
  const [Biblioteca, setBiblioteca] = useState({});
  
    useEffect(() => {
      axios
        .get("http://localhost:8080/Book/"+dados.id)
        .then((resposta) => {
          setBiblioteca(resposta.data);
        })
        .catch((error) => {
          console.log(error);
        });
      
    }, [dados.id]);
  return (
  
    <div>
    <Cabecalho />
      <div className="TelaInformacoes">
        <img src={dados.image !== "" ? dados.image : "../../Imagens/LivroGenerico.png"} className="imagem" alt=""/>
        <div  className="Informacoes">
        <Informacoes informacoes = {dados} biblioteca = {Biblioteca}/>
        <BotoesInformacoes id={dados.id} livro= {dados} biblioteca = {Biblioteca}/>
        </div>
      </div>
    </div>
  );
}
export default TelaInformacoes;
