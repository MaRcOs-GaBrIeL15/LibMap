import Livro from "../Livro/Livro";
import "./Categoria.css";
function Categoria(props) {
  return (
    <div className="CategoriaDiv">
      <h1 className={props.evento ? "NomeEvento" : "Categoria"} > {props.categoria} </h1>
      <div className="Livros">
        {props.livro.map((conteudo, i) => {
          if (conteudo !== undefined) {
            return <Livro key={i} livro={conteudo} />;
          } else {
            return <></>;
          }
        })}
      </div>
    </div>
  );
}

export default Categoria;
