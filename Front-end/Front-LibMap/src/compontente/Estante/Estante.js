import "./Estante.css";

function Estante(props) {
  var conteudo = props.conteudo;

  return (
    <div
      className={props.escolhido ? "EstanteEscolhida" : "Estante"}
      key={props.i}
      style={{
        left: conteudo.x,
        top: "calc(6vh + " + conteudo.y + "px)",
        rotate: conteudo.rotate + "deg",
        height: conteudo.height,
        width: conteudo.width,
        borderRadius: conteudo.border,
      }}
  ><h1 className="Identificador" >{conteudo.identifier}</h1></div>
  );
}
export default Estante;
