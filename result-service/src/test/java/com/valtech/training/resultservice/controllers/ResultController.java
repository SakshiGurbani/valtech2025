package com.valtech.training.resultservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.resultservice.vos.ResultVO;

@RestController
@RequestMapping("/api/v1/results")
public class ResultController {
	
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void test() {
		String url = "http://localhost:"+port+"/api/v1/results/12";	
		ResultVO resultVO = restTemplate.getForObject(url, ResultVO.class);
		}

}
