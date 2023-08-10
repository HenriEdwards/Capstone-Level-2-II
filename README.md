# Food Quick - Food Delivery System
Food Quick is a food delivery company that requires a program to manage their orders and distribute them efficiently. This project aims to create a food delivery system for Food Quick, allowing them to track orders and assign them to drivers based on load and location. The program will also generate an invoice for customers.

## Customer Information
Food Quick stores the following information for each customer:

* Order number
* Customer name
* Customer contact number
* Customer address
* Customer location (city)
* Customer email address
* Restaurant name
* Restaurant location
* Restaurant contact number
* Quantity of each meal ordered
* List of meals ordered and their prices
* Special preparation instructions from the customer
* Total amount to be paid
* Driver Information

## Drivers
The information about the drivers is stored in a text file called drivers.txt. Each line in the file represents a driver and follows the format:
* John Krill, Cape Town, 4

## Invoice
Program generates an invoice based on customer input data. The invoice will contain the order number, customer details (name, email, phone number, location), the list of meals ordered with their respective quantities and prices, any special instructions, the total amount to be paid, and the driver assigned for the delivery.

## Program Files
The project consists of several Java files:

1. Main.java: This file serves as the entry point for the program and is responsible for calling the relevant classes.
2. Customer.java: This class handles functionality related to requesting and storing customer information.
3. Restaurant.java: This class handles functionality related to requesting and storing restaurant information provided by the customer.
4. Meal.java: This class handles functionality related to requesting and storing meal information provided by the customer.
5. Invoice.java: This class handles the generation of the invoice based on the customer input.
6. DeliveryDriver.java: This class handles functionality related to determining the appropriate driver for the delivery based on the customer's location.

This project is part of the level 2 Captstone project II.
