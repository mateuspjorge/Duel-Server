package br.com.duelServer.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.duelServer.clients.IChampionFeign;
import br.com.duelServer.controllers.DuelController;
import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.dtos.DuelDTO;
import br.com.duelServer.exceptions.CampeaoException;
import br.com.duelServer.services.IDuelService;

@RestController
@RequestMapping(path = "/duel")
public class DuelControllerImpl implements DuelController {

	private IDuelService duelService;
	private IChampionFeign championFeign;

	@Autowired
	public DuelControllerImpl(IDuelService duelService, IChampionFeign championFeign) {
		super();
		this.duelService = duelService;
		this.championFeign = championFeign;
	}

	@PostMapping("/register")
	@ResponseBody
	@Override
	public ResponseEntity<DuelDTO> startDuel(@RequestBody DuelDTO duelDto) throws CampeaoException {
		CampeaoAPI champion = championFeign.retornaCampeao(duelDto.getChampion()).getBody();
		CampeaoAPI rival = championFeign.retornaCampeao(duelDto.getRival()).getBody();
		DuelDTO registeredDuel = DuelDTO.convertDuelToDto(duelService.startDuel(champion, rival));
		return new ResponseEntity<>(registeredDuel, HttpStatus.CREATED);
	}

}