package com.vamstar.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vamstar.test.model.BMIInput;
import com.vamstar.test.model.BMIStatisticsRequest;

@Component
public class BMICalculatorService {
	
	public float getBmi(int weightInKgs, int heightInCms) {
		float heightInMeters = heightInCms/100;
		return weightInKgs/heightInMeters;
	}
	
	public List<String> getStatistics(BMIStatisticsRequest request) {
		int underweight = 0;
		int normalWeight = 0;
		int overWeight = 0;
		int moderatelyObese = 0;
		int severelyObese = 0;
		int verySeverelyObese = 0;
		if (request != null && request.getInputs() != null) {
			for (BMIInput input : request.getInputs()) {
				float bmi = getBmi(input.getWeightInKgs(), input.getHeightInCms());
				if (bmi < 18.4) {
					underweight++;
				} else if ( bmi >=18.5 && bmi <=24.9) {
					normalWeight++;
				}else if ( bmi >=25 && bmi <=29.9) {
					overWeight++;
				} else if ( bmi >=30 && bmi <=34.9) {
					moderatelyObese++;
				}else if ( bmi >=35 && bmi <=39.9) {
					severelyObese++;
				}else if ( bmi >=40) {
					verySeverelyObese++;
				}
			}
		}
		List<String> results = new ArrayList<String>();
		results.add("UnderWeight count is " + underweight);
		results.add("Normal Weight count is " + normalWeight);
		results.add("Overweight count is " + overWeight);
		results.add("Moderately Obese count is " + moderatelyObese);
		results.add("Severely Obese count is " + severelyObese);
		results.add("Very Severely Obese count is " + verySeverelyObese);
		return results;
	}

}
