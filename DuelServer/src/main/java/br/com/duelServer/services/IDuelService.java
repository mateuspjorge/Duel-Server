package br.com.duelServer.services;

import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.entitys.Duel;

public interface IDuelService {

	public Duel startDuel(CampeaoAPI champion, CampeaoAPI rival);

}