package com.superbrown.charterCodingExercise.rewards.controller;

import com.superbrown.charterCodingExercise.rewards.model.Customer;
import com.superbrown.charterCodingExercise.rewards.model.Transaction;
import com.superbrown.charterCodingExercise.rewards.serrvice.PointCalculationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/rewards")
public class RewardsController {

	@Qualifier("StandardPointCalculationService")
	private PointCalculationService pointCalculationService;

	@PostMapping("/points")
	public ResponseEntity<List<Customer>> calculateCustomerPoints(
			@RequestBody List<Transaction> transactions) {

		List<Customer> customers = pointCalculationService.calculateCustomerPoints(transactions);
		return ResponseEntity.ok(customers);
	}
}
