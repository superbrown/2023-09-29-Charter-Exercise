package com.superbrown.charterCodingExercise.rewards.serrvice;

import com.superbrown.charterCodingExercise.rewards.model.Customer;
import com.superbrown.charterCodingExercise.rewards.model.Transaction;

import java.util.List;

public interface PointCalculationService {

	List<Customer> calculateCustomerPoints(List<Transaction> transactions);
}
