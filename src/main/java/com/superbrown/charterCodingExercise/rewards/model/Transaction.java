package com.superbrown.charterCodingExercise.rewards.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {

	private LocalDateTime timestamp;
	private String customerId;
	private float dollarAmount;
}
