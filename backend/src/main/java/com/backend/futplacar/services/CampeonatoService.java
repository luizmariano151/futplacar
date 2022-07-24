package com.backend.futplacar.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.backend.futplacar.entities.Campeonato;
import com.backend.futplacar.entities.Jogo;

@Service
public class CampeonatoService {

	public List<Campeonato> findTodayMatches(){
		
		List<Campeonato> campeonatos = null;
		try {
			campeonatos = extractChampionships();
		} catch (IOException e) {
			System.out.println("erro conexão");
		}
		return campeonatos;
		
	}
	
	private List<Campeonato> extractChampionships() throws IOException {

		Document requisicao = Jsoup.connect("https://www.placardefutebol.com.br/jogos-de-hoje").get();
		Elements campeonatos = requisicao.getElementById("livescore").getElementsByClass("container content");

		List<Campeonato> todosCampeonatos = new ArrayList<>();
		campeonatos.forEach(campeonato -> {

			Elements jogos = campeonato.getElementsByTag("a");
			String[] nomeCampeonato = jogos.attr("href").split("/");
			String nome = nomeCampeonato[1].replace("-", " ").toUpperCase();
			Campeonato novoCampeonato = new Campeonato(nome, new ArrayList<>());

			jogos.forEach(jogo -> {

				String hrPartida = jogo.getElementsByClass("status-name").text();

				String timeCasa = jogo.getElementsByClass("text-right team_link").text();
				String golsTimeCasa = jogo.getElementsByClass("w-25 p-1 match-score d-flex justify-content-end").text();

				String timeVisitante = jogo.getElementsByClass("text-left team_link").text();
				String golsTimeVisitante = jogo.getElementsByClass("w-25 p-1 match-score d-flex justify-content-start")
						.text();

				Jogo novoJogo = new Jogo(hrPartida, timeCasa, golsTimeCasa, timeVisitante, golsTimeVisitante);
				if(!novoJogo.getHrPartida().equals("")) {
					novoCampeonato.getJogos().add(novoJogo);
				}
			});
			todosCampeonatos.add(novoCampeonato);
		});
		return todosCampeonatos;
		
	}

}
