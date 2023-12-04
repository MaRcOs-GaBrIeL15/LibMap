import "./Disponivel.css";

function Disponivel(props) {
  return (
    <h1>
      Disponivel:
      <div className={props.disponivel ? "disponivel" : "indisponivel"}></div>
    </h1>
  );
}

export default Disponivel;
