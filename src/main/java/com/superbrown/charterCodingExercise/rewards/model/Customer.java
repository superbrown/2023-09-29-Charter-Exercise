package com.superbrown.charterCodingExercise.rewards.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Customer {

	private String customerId;
	private List<MonthlyPointTotal> monthlyPointTotals;

	public Integer getTotalPoints() {

		if (monthlyPointTotals == null) {
			return 0;
		}

		Integer totalPoints = monthlyPointTotals.stream()
				.mapToInt(MonthlyPointTotal::getPoints)
				.sum();

		return totalPoints;
	}
}
