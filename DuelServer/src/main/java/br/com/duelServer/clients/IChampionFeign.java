package br.com.duelServer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.duelServer.dtos.CampeaoAPI;

@FeignClient(value = "http://server/capeao")
public interface IChampionFeign {

	@GetMapping("/internal/search-by/{championId}")
	@ResponseBody
	public ResponseEntity<CampeaoAPI> searchCampeaoById(@PathVariable("championId") Long championId);

}