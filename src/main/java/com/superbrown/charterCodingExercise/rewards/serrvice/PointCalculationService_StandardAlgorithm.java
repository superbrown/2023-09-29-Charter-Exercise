package com.superbrown.charterCodingExercise.rewards.serrvice;

import com.superbrown.charterCodingExercise.rewards.model.Customer;
import com.superbrown.charterCodingExercise.rewards.model.MonthlyPointTotal;
import com.superbrown.charterCodingExercise.rewards.model.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class PointCalculationService_StandardAlgorithm implements PointCalculationService {

	@Override
	public List<Customer> calculateCustomerPoints(
			List<Transaction> transactions) {

		Map<String, Map<LocalDate, Integer>> pointsPerCustomerPerMonth =
				calculatePointsPerCustomerPerMonth(transactions);

		List<Customer> customers = toCustomers(pointsPerCustomerPerMonth);

		return customers;
	}

	// I realize declaring this protected is unconventional. I do so so that my preferred testing
	// framework, Spock, can access them. It doesn't so much matter, as long as these can be unit
	// tested directly.
	protected Map<String, Map<LocalDate, Integer>> calculatePointsPerCustomerPerMonth(
			List<Transaction> transactions) {

		// map of point totals per customer per year per month
		Map<String, Map<LocalDate, Integer>> pointsPerCustomerPerMonth = new HashMap<>();

		for (Transaction transaction : transactions) {

			String customerId = transaction.getCustomerId();
			int year = transaction.getTimestamp().getYear();
			int month = transaction.getTimestamp().getMonth().getValue();
			float dollarAmount = transaction.getDollarAmount();

			// I'm setting the day to 1 just because it has to be something. I'm using the
			// data structure to embody the year and month combination.
			LocalDate yearMonth = LocalDate.of(year, month, 1);

			int newPoints = calculateTransactionPoints(dollarAmount);

			Map<LocalDate, Integer> pointsPerMonth =
					pointsPerCustomerPerMonth.getOrDefault(customerId, new HashMap<>());
			pointsPerCustomerPerMonth.put(customerId, pointsPerMonth);

			Integer currentPoints = pointsPerMonth.getOrDefault(yearMonth, 0);

			pointsPerMonth.put(yearMonth, currentPoints + newPoints);
		}

		return pointsPerCustomerPerMonth;
	}

	// I realize declaring this protected is unconventional. I do so so that my preferred testing
	// framework, Spock, can access them. It doesn't so much matter, as long as these can be unit
	// tested directly.
	protected List<Customer> toCustomers(
			Map<String, Map<LocalDate, Integer>> pointsPerCustomerPerMonth) {

		List<Customer> customers = new ArrayList<>();

		for (String customerId : pointsPerCustomerPerMonth.keySet()) {

			Map<LocalDate, Integer> pointsPerMonth = pointsPerCustomerPerMonth.get(customerId);

			Customer customer = new Customer();
			customer.setCustomerId(customerId);
			customer.setMonthlyPointTotals(new ArrayList<>());

			customers.add(customer);

			for (LocalDate month : pointsPerMonth.keySet()) {

				Integer points = pointsPerMonth.get(month);

				MonthlyPointTotal monthlyPointTotal = MonthlyPointTotal.builder()
						.year(month.getYear())
						.month(month.getMonthValue())
						.points(points)
						.build();

				customer.getMonthlyPointTotals().add(monthlyPointTotal);
			}
		}

		return customers;
	}

	// I realize declaring this protected is unconventional. I do so so that my preferred testing
	// framework, Spock, can access them. It doesn't so much matter, as long as these can be unit
	// tested directly.
	protected int calculateTransactionPoints(float transactionAmountInDollars) {

		int points = 0;

		// I'm making an assumption here as to how to handle non-whole
		// dollar transaction amounts

		int dollarsOver50 = Math.round(transactionAmountInDollars - 50) < 0 ?
				0 :
				Math.round(transactionAmountInDollars - 50);

		int dollarsOver100 = Math.round(transactionAmountInDollars - 100) < 0 ?
				0 :
				Math.round(transactionAmountInDollars - 100);

		int dollarsBetween50And100 =
				dollarsOver50 == 0 ?  0 : dollarsOver50 - dollarsOver100;

		points += dollarsBetween50And100 * 1;  // 1 points each
		points += dollarsOver100 * 2;  // 2 points each

		return points;
	}
}
