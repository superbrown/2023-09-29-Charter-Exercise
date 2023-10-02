package com.superbrown.charterCodingExercise.rewards.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonthlyPointTotal {

	private Integer month;
	private Integer year;
	private Integer points;
}
