import Disponivel from "../Disponivel/Disponivel";
import "./Informacoes.css";

function Informacoes(props) {
  function textoInformacoes(nome, conteudo) {
    if (conteudo !== null && conteudo !== undefined && conteudo !== "") {
      return (
        <h1>
          {nome}: {conteudo}{" "}
        </h1>
      );
    }
  }

  return (
    <div className="informacoes">
      {textoInformacoes("Nome", props.informacoes.name)}
      {textoInformacoes("Autor(s)", props.informacoes.author)}
      {textoInformacoes("Assunto", props.informacoes.topic)}
      {textoInformacoes("Classificação", props.informacoes.classification)}
      {textoInformacoes("Numero de paginas", props.informacoes.pageNumber)}
      {textoInformacoes("Ano de publicação", props.informacoes.year)}
      {textoInformacoes("Edição", props.informacoes.edition)}
      {textoInformacoes("Local de publiçao", props.informacoes.publication)}
      {textoInformacoes("Caracteristica", props.informacoes.attribute)}
      {textoInformacoes("Imagem", props.informacoes.image)}
      {textoInformacoes("Biblioteca", props.biblioteca.name)}
      <Disponivel disponivel={props.informacoes.available} />
    </div>
  );
}

export default Informacoes;
