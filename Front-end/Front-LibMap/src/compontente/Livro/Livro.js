import { useNavigate } from "react-router-dom";
import "./Livro.css";

function Livro(props) {
  const navigate = useNavigate();

  function Textodestaque(texto) {
    if (texto !== null && texto !== undefined && texto !== "") {
      return <h1 className="Caracteristica">{texto}</h1>;
    }
  }

  function nome(nome) {
    nome = nome + "";

    if (
      typeof nome == "string" &&
      nome.slice(0, nome.indexOf("/")).length < 35 &&
      nome.includes("/") &&
      nome.length > 35
    ) {
      return nome.slice(0, nome.slice(0, nome.indexOf("/")).length);
    } else {
      if (nome.length > 35) {
        return nome.substring(0, 35) + " ...";
      }
      return nome;
    }
  }
  return (
    <div
      className="Livro"
      onClick={() => {
        navigate("book", { state: { data: props.livro } });
      }}
    >
      <img src={ props.livro.image !== "" ? props.livro.image : "../../Imagens/LivroGenerico.png" } alt=" "/>
      <div className="nomes">
        <h1 className="nome">{nome(props.livro.name)}</h1>

        {Textodestaque(props.livro.attribute)}
      </div>
    </div>
  );
}

export default Livro;
