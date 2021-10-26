package br.com.duelServer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.entitys.Duel;
import br.com.duelServer.repositorys.IDuelRepository;
import br.com.duelServer.services.IDuelService;

@Service
public class DuelServiceImpl implements IDuelService {

	private IDuelRepository duelRepository;

	@Autowired
	public DuelServiceImpl(IDuelRepository duelRepository) {
		super();
		this.duelRepository = duelRepository;
	}

	@Override
	public Duel startDuel(CampeaoAPI champion, CampeaoAPI rival) {
		
		return null;
	}

}