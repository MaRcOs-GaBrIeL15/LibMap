import './Andar.css'

function Andar(props){
    
    return(
        <div className={props.escolhido ? 'AndarEscolhido': 'Andar'}>
        </div>
    )
}

export default Andar;