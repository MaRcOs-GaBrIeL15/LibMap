import { useNavigate } from "react-router-dom";
import "./BotoesInformacoes.css";

function BotoesInformacoes(props) {
    const navigate = useNavigate();

    function TestaDisponivel(){
     if(props.livro.available && props.biblioteca.id !==undefined && props.biblioteca.id !== -1)
      return(<button
        onClick={() => {
          navigate("/map", { state: { data: props.livro } });
        }}
      >
        localizar
      </button>)
    }

    props.livro.library = props.biblioteca.id;
  return (
    <div className="Botoes">
      <button
        onClick={() => {
          navigate("/");
        }}
      >
        sair
      </button>
      {TestaDisponivel()}
    </div>
  );
}
export default BotoesInformacoes;
