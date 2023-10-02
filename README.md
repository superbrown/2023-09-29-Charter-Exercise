

•    Solve using Spring Boot

•    Create a RESTful endpoint

•    Make up a data set to best demonstrate your solution

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

Good test data:
```
[
  { "timestamp": "2023-01-01T00:00:00.000Z", "customerId": "A", "dollarAmount": -10 },
  { "timestamp": "2023-02-01T00:00:00.000Z", "customerId": "B", "dollarAmount": 0 },
  { "timestamp": "2023-03-01T00:00:00.000Z", "customerId": "C", "dollarAmount": 25 },
  { "timestamp": "2023-04-01T00:00:00.000Z", "customerId": "D", "dollarAmount": 50 },
  { "timestamp": "2023-05-01T00:00:00.000Z", "customerId": "E", "dollarAmount": 52.25 },
  { "timestamp": "2023-06-01T00:00:00.000Z", "customerId": "F", "dollarAmount": 52.75 },
  { "timestamp": "2023-07-01T00:00:00.000Z", "customerId": "G", "dollarAmount": 100 },
  { "timestamp": "2023-08-01T00:00:00.000Z", "customerId": "H", "dollarAmount": 150 },

  { "timestamp": "2023-02-01T00:00:00.000Z", "customerId": "I", "dollarAmount": 55 },
  { "timestamp": "2023-02-02T00:00:00.000Z", "customerId": "I", "dollarAmount": 120 },

  { "timestamp": "2023-03-01T00:00:00.000Z", "customerId": "J", "dollarAmount": 60 },
  { "timestamp": "2023-03-04T00:00:00.000Z", "customerId": "J", "dollarAmount": 60.72 },
  { "timestamp": "2023-04-23T00:00:00.000Z", "customerId": "J", "dollarAmount": 1200.00 }
]

```
