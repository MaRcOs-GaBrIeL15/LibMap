import "./TelaBusca.css";
import BarraPesquisa from "../../compontente/BarraPesquisa/BarraPesquisa";
import Categoria from "../../compontente/Categoria/Categoria";
import axios from "axios";
import { useEffect, useState } from "react";
import Cabecalho from "../../compontente/Cabecalho/Cabecalho";

function TelaBusca() {
  const [Livros, setLivros] = useState([{}]);
  const [Pesquisa, setPesquisa] = useState("");
  const [Filtro, setFiltro] = useState();
  const [Evento, setEvento] = useState();
  var listaTopicos = [];

  useEffect(() => {
    if (Pesquisa === "") {
      axios
        .get("http://localhost:8080/Book")
        .then((resposta) => {
          setLivros(resposta.data);
          setEvento(false);
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      if (
        Filtro === "" ||
        Filtro === null ||
        Filtro === undefined ||
        Filtro === "Livro"
      ) {
        axios
          .get("http://localhost:8080/Name/" + Pesquisa)
          .then((resposta) => {
            setLivros(resposta.data);
            setEvento(false);
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        if (Filtro === "Assunto") {
          axios
            .get("http://localhost:8080/Topic/" + Pesquisa)
            .then((resposta) => {
              setLivros(resposta.data);
              setEvento(false);
            })
            .catch((error) => {
              console.log(error);
            });
        } else {
          if (Filtro === "Autor") {
            axios
              .get("http://localhost:8080/Author/" + Pesquisa)
              .then((resposta) => {
                setLivros(resposta.data);
                setEvento(false);
              })
              .catch((error) => {
                console.log(error);
              });
          } else {
            if (Filtro === "Biblioteca") {
              axios
                .get("http://localhost:8080/Library/" + Pesquisa)
                .then((resposta) => {
                  setLivros(resposta.data);
                  setEvento(true);
                })
                .catch((error) => {
                  console.log(error);
                });
            } else {
              if (Filtro === "Classificação") {
                axios
                  .get("http://localhost:8080/Classification/" + Pesquisa)
                  .then((resposta) => {
                    setLivros(resposta.data);
                    setEvento(false);
                  })
                  .catch((error) => {
                    console.log(error);
                  });
              }
            }
          }
        }
      }
    }
  }, [Filtro, Pesquisa]);

  Livros.forEach((livro) => {
    if (
      !listaTopicos.includes(livro.topic) &&
      livro.topic !== "" &&
      livro.topic !== null &&
      livro.topic !== undefined
    ) {
      listaTopicos.push(livro.topic);
    }

    for (let valor of listaTopicos) {
      if (Evento && !(
        (typeof valor === "object" && valor.nome === livro.event) ||
        livro.event === "" ||
        livro.event == null ||
        livro.event === undefined
      )) {
        listaTopicos.unshift({ nome: livro.event });
        break;
      }
      break;
    }
    
  });

  console.log(listaTopicos);

  return (
    <div>
      <Cabecalho />
      <div className="TelaBusca">
        <BarraPesquisa
          aoPesquisar={(pesquisa) => setPesquisa(pesquisa)}
          alteraFiltro={(filtro) => setFiltro(filtro)}
        />

        {listaTopicos.map((topico, i) => {
          if (typeof topico !== "object") {
            return (
              <Categoria
                event={false}
                key={i}
                categoria={topico}
                livro={Livros.filter((conteudo) => {
                  return conteudo.topic === topico;
                })}
              />
            );
          } else {
            return (
              <Categoria
                evento={true}
                key={i}
                categoria={topico.nome}
                livro={Livros.filter((conteudo) => {
                  return conteudo.event === topico.nome;
                })}
              />
            );
          }
        })}
      </div>
    </div>
  );
}

export default TelaBusca;
