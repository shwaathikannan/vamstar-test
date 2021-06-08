package com.vamstar.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vamstar.test.model.BMIInput;
import com.vamstar.test.model.BMIResponse;
import com.vamstar.test.model.BMIStatisticsRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BMICalculatorServiceTest {
	
	@Autowired
	private BMICalculatorService service;
	
	@Test
	public void testGetBMI() {
		float result = service.getBmi(70, 155);
		Assert.assertNotEquals(0, result, 0);
	}
	
	@Test
	public void testGetBMIStatistics() {
		BMIInput person1 = new BMIInput();
		person1.setHeightInCms(130);
		person1.setWeightInKgs(65);
		BMIInput person2 = new BMIInput();
		person2.setHeightInCms(160);
		person2.setWeightInKgs(82);
		List<BMIInput> inputs = new ArrayList<BMIInput>();
		BMIStatisticsRequest request = new BMIStatisticsRequest();
		request.setInputs(inputs);
		List<String> result = service.getStatistics(request);
		Assert.assertNotNull(result);
	}
}
