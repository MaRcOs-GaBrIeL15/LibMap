import { useLocation } from "react-router-dom";
import BotaoPrecisao from "../../compontente/BotaoPrecisao/BotaoPrecisao";
import Estante from "../../compontente/Estante/Estante";
import "./TelaEstante.css";
import { useEffect, useState } from "react";
import axios from "axios";
import Cabecalho from "../../compontente/Cabecalho/Cabecalho";

function TelaEstante() {
  const [Estantes, setEstantes] = useState([{}]);
  const location = useLocation();
  const dados = location.state.data;
  
  var dadosAndar = [];
  var livroEscolhido;
  useEffect(() => {
    axios
      .get("http://localhost:8080/map/"+ dados.library)
      .then((resposta) => {
        setEstantes(resposta.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [dados.library]);
console.log(Estantes)
  return (
    <div>
    <Cabecalho fixed={true} ></Cabecalho>
      <div className="TelaEstante">
        {Estantes.map((conteudo, i) => {
          if (Array.isArray(conteudo.books) && conteudo.books.length !== 0) {
            if (
              conteudo.books.find((livro) => {
                livroEscolhido = livro;
                return livro.id === dados.id;
              })
            ) {
              livroEscolhido.library = dados.library;
              dadosAndar.push(livroEscolhido);
              dadosAndar.push(conteudo.floor);
              dadosAndar.push(conteudo.books);
              return <Estante key={i} conteudo={conteudo} escolhido={true} />;
            } else {
              return <Estante key={i} conteudo={conteudo} escolhido={false} />;
            }
          } else {
            return <Estante key={i} conteudo={conteudo} escolhido={false} />;
          }
        })}
        <BotaoPrecisao
          localIda="floor"
          dadosIda={dadosAndar}
          localVolta="/book"
          dadosVolta={dados}
        />
      </div>
      </div>
  );
}

export default TelaEstante;
