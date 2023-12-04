import { useNavigate } from "react-router-dom";
import "./BotaoPrecisao.css";

function setaVolta(props, navigate) {
  if (props.localVolta !== null && props.localVolta !== undefined) {
    return (
      <button
        onClick={() => {
          navigate(props.localVolta, { state: { data: props.dadosVolta } });
        }}
      >
        <div className="volta" />
      </button>
    );
  }
}

function setaIda(props, navigate) {
  if (props.localIda !== null && props.localIda !== undefined) {
    return (
      <button
        onClick={() => {
          navigate(props.localIda, { state: { data: props.dadosIda } });
        }}
      >
        <div className="ida" /> 
      </button>
    );
  } else {
    return <button></button>;
  }
}

function BotaoPrecisao(props) {
  const navigate = useNavigate();

  return (
    <div className="BotaoPrecisao">
      {setaVolta(props, navigate)}

      <div className="Lupa" />

      {setaIda(props, navigate)}
    </div>
  );
}
export default BotaoPrecisao;
