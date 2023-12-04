import "./LivroEstante.css";

function LivroEstante(props) {
  return (
    <div
      className={props.escolhido ? "LivroEstanteEscolhido" : "LivroEstante"}
    ></div>
  );
}
export default LivroEstante;
