import { useLocation } from "react-router-dom";
import "./TelaPosicao.css";
import BotaoPrecisao from "../../compontente/BotaoPrecisao/BotaoPrecisao";
import LivroEstante from "../../compontente/LivroEstante/LivroEstante";
import Cabecalho from "../../compontente/Cabecalho/Cabecalho";

function TelaPosicao() {
  const location = useLocation();
  var dados = location.state.data;
  dados[2].sort((a, b) => {
    return a.position - b.position;
  });

  return (
    <div>
    <Cabecalho />
      <div className="TelaPosicao">
        <div className="PosicaoEstante">
          {dados[2].map((livro, i) => {
            if (livro.available && livro.id === dados[0].id) {
              return <LivroEstante key={i} escolhido={true} />;
            } else {
              if (livro.available) {
                return <LivroEstante key={i} />;
              }
              return <div key={i}></div>;
            }
          })}

          <BotaoPrecisao
            localIda={null}
            dadosIda={null}
            localVolta="/map/floor"
            dadosVolta={dados}
          />
        </div>
      </div>
    </div>
  );
}

export default TelaPosicao;
