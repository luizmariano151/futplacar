import { FlatList } from "react-native";
import { Campeonato } from "../../models/campeonato";
import { Jogo } from "../../models/jogo";
import styled from "styled-components/native";

export const Container = styled.View`
  flex: 1;
`;

export const Card = styled.View`
  background-color: #eeeeee;
  border-radius: 10px;
  padding: 20px;
  margin-vertical: 8px;
  margin-horizontal: 16px;
`;

export const TituloCampeonato = styled.Text`
  font-size: 24px;
`;

export const TextoHorario = styled.Text`
  font-size: 20px;
`;

export const TextoPatida = styled.Text`
  font-size: 17px;
  margin-bottom: 10px;

`;

export const CampeonatosList = styled(
  FlatList as new () => FlatList<Campeonato>
)`
  padding: 20px;
`;

export const JogosList = styled(FlatList as new () => FlatList<Jogo>)`
  padding: 20px;
`;
