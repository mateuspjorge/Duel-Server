package br.com.duelServer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.duelServer.dtos.CampeaoAPI;
import br.com.duelServer.exceptions.CampeaoException;

@FeignClient(value = "http://champion-serve/capeao")
public interface IChampionFeign {

	@GetMapping(value = "/encotrar/{email}")
	public ResponseEntity<CampeaoAPI> retornaCampeao(@PathVariable String email) throws CampeaoException;

}