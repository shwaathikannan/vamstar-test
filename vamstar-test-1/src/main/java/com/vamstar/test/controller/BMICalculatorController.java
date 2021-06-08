package com.vamstar.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamstar.test.model.BMIResponse;
import com.vamstar.test.model.BMIStatistics;
import com.vamstar.test.model.BMIStatisticsRequest;
import com.vamstar.test.service.BMICalculatorService;

@RestController
@RequestMapping(path="/bmi")
public class BMICalculatorController {
	
	@Autowired
	private BMICalculatorService bmiCalculatorService;
	
	@GetMapping(path="/calculate", produces="application/json")
	public BMIResponse getBMI(@RequestParam int heightInCms,@RequestParam int weightInKgs) {
		float bmi = bmiCalculatorService.getBmi(weightInKgs, heightInCms);
		BMIResponse response = new BMIResponse();
		response.setBmi(bmi + "Kgs/m");
		return response;
	}
	
	@PostMapping(path="/getstatistics", produces="application/json", consumes="application/json")
	public BMIStatistics getStatistics(@RequestBody BMIStatisticsRequest request) {
		List<String> results = bmiCalculatorService.getStatistics(request);
		BMIStatistics statistics = new BMIStatistics();
		statistics.setResults(results);
		return statistics;
	}
	

}
