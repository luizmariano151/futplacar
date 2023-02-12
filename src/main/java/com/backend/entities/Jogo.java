package com.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Jogo {
	
	private String hrPartida;
	private String timeCasa;
	private String golsTimeCasa;
	private String timeVisitante;
	private String golsTimeVisitante;

}
