import { useNavigate } from "react-router-dom";
import "./Cabecalho.css";

function Cabecalho(props) {
  const navigate = useNavigate();

  return (
    
    <header className={props.fixed ? "CabecalhoFixo" : "Cabecalho" }>
      <img 
        src="../../Imagens/logo-libmap.png"
        alt=""
        onClick={() => {
          navigate("/");
        }}
      />
    </header>

  );
}
export default Cabecalho;
