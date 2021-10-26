package br.com.duelServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.duelServer.clients.IChampionFeign;
import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.dtos.DuelDTO;
import br.com.duelServer.services.IDuelService;

@RestController
@RequestMapping(path = "/duel")
public class DuelController {

	private IDuelService duelService;
	private IChampionFeign championFeign;

	@Autowired
	public DuelController(IDuelService duelService, IChampionFeign championFeign) {
		super();
		this.duelService = duelService;
		this.championFeign = championFeign;
	}

	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<DuelDTO> startDuel(@RequestBody DuelDTO duelDto) {
		CampeaoAPI champion = championFeign.searchCampeaoById(duelDto.getChampion()).getBody();
		champion.setId(duelDto.getChampion());
		CampeaoAPI rival = championFeign.searchCampeaoById(duelDto.getRival()).getBody();
		rival.setId(duelDto.getRival());
		return null;
	}

}