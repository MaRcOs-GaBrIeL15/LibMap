import './BarraPesquisa.css';

function BarraPesquisa(props){
    return(
        <div className="BarraPesquisa">
            <input onKeyDown={(evento) => {
                if(evento.key === "Enter"){
                props.aoPesquisar(evento.target.value)
                }
                }}/>
            
            <select onClick={(evento) => props.alteraFiltro(evento.target.value) } required>
                <option hidden></option>
                <option>Livro</option>
                <option>Assunto</option>
                <option>Autor</option>
                <option>Biblioteca</option>
                <option>Classificação</option>
            </select>
        </div>
    )
}
export default BarraPesquisa;