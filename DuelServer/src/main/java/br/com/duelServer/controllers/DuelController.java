package br.com.duelServer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.duelServer.dtos.DuelDTO;
import br.com.duelServer.exceptions.CampeaoException;
import br.com.duelServer.exceptions.DuelException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface DuelController {

	@ApiOperation(value = "Registra um duelo de campeões")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna dto de duelo com o vencedor"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Retornara uma mensagem amigável para o usuária"),
	})
	public ResponseEntity<DuelDTO> startDuel(@RequestBody DuelDTO duelDto) throws CampeaoException, DuelException;

}