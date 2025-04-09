package com.valtech.training.resultservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.resultservice.service.ResultService;
import com.valtech.training.resultservice.vos.ResultVO;

@RestController
@RequestMapping("/api/v1/results")
public class ResultControllers {
	
	private ResultService resultService;
	
	@GetMapping("/{quizId}")
	public ResultVO getQuizResult(@PathVariable("quizId")int quizId) {
		return resultService.testResults(quizId);
	}

}
