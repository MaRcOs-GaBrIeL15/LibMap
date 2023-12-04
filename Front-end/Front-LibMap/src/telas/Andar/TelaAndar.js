import { useLocation } from "react-router-dom";
import "./TelaAndar.css";
import Andar from "../../compontente/Andar/Andar";
import BotaoPrecisao from "../../compontente/BotaoPrecisao/BotaoPrecisao";
import Cabecalho from "../../compontente/Cabecalho/Cabecalho";

function TelaAndar() {
  const location = useLocation();
  var dados = location.state.data;
  var teste = [];

  
  for (var x = 0; x < dados[1]; x++) {
    teste.push(x);
  }
  return (
    <div>
    <Cabecalho />
    <div className="TelaAndar">
      <div className="EstanteAndar">
        {teste.map((i) => {
          if (i === dados[0].floor - 1) {
            return <Andar key={i} escolhido={true} />;
          } else {
            return <Andar key={i} escolhido={false} />;
          }
        })}

        <BotaoPrecisao
          localIda="position"
          dadosIda={dados}
          localVolta="/map"
          dadosVolta={dados[0]}
        />
      </div>
    </div>
    </div>
  );
}
export default TelaAndar;
