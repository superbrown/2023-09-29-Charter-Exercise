package com.superbrown.charterCodingExercise;

import com.superbrown.charterCodingExercise.rewards.serrvice.PointCalculationService;
import com.superbrown.charterCodingExercise.rewards.serrvice.PointCalculationService_StandardAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean("StandardPointCalculationService")
	public PointCalculationService createPointCalculationService() {
		return new PointCalculationService_StandardAlgorithm();
	}
}
