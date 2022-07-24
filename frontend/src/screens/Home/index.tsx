import axios from "axios";
import { useEffect, useState } from "react";
import { ListRenderItem } from "react-native";
import { Campeonato } from "../../models/campeonato";
import { Jogo } from "../../models/jogo";
import {
  Container,
  Card,
  TituloCampeonato,
  CampeonatosList,
  JogosList,
  TextoHorario,
  TextoPatida,
} from "./styles";

const DATA = [
  {
    nome: "FLORIDA CUP",
    jogos: [
      {
        hrPartida: "HOJE 21:00",
        timeCasa: "Arsenal",
        golsTimeCasa: "",
        timeVisitante: "Chelsea",
        golsTimeVisitante: "",
      },
    ],
  },
  {
    nome: "BRASILEIRAO SERIE A",
    jogos: [
      {
        hrPartida: "HOJE 19:00",
        timeCasa: "São Paulo",
        golsTimeCasa: "",
        timeVisitante: "Goiás",
        golsTimeVisitante: "",
      },
      {
        hrPartida: "HOJE 21:00",
        timeCasa: "Botafogo",
        golsTimeCasa: "",
        timeVisitante: "Athletico-PR",
        golsTimeVisitante: "",
      },
    ],
  },
];

const renderJogo: ListRenderItem<Jogo> = ({ item }) => (
  <>
    <TextoHorario>{item.hrPartida}</TextoHorario>
    <TextoPatida>
      {item.timeCasa} {item.golsTimeCasa} X {item.golsTimeVisitante}{" "}
      {item.timeVisitante}
    </TextoPatida>
  </>
);

const ItemCampeonato = ({ data }: { data: Campeonato }) => (
  <Card>
    <TituloCampeonato>{data.nome}</TituloCampeonato>
    <JogosList data={data.jogos} renderItem={renderJogo} />
  </Card>
);

function Home() {
  const [campeonatos, setCampeonatos] = useState<Campeonato[]>([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/campeonatos/jogos-de-hoje")
      .then((response) => {
        console.log(response.data);
      })
      .catch((erro) => {
        console.log(erro.status);
      });
  }, []);

  const renderItem: ListRenderItem<Campeonato> = ({ item }) => (
    <ItemCampeonato data={item} />
  );

  return (
    <Container>
      <CampeonatosList
        data={DATA}
        renderItem={renderItem}
        keyExtractor={(item: Campeonato) => item.nome}
      />
    </Container>
  );
}

export default Home;
