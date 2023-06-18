# Car Service Station

This is a software program for a car service station that provides various services for different types of cars.

## Features

- Catering to different types of cars: Hatchback, Sedan, SUV.
- Providing different types of services: Basic Service, Engine Fixing, Clutch Fixing, Gear Fixing, Brake Fixing.
- Each service has a service code associated with it and different prices for different types of cars.
- Generating a detailed bill with the total amount for each service request based on the type of car and requested service codes.
- Offering complimentary cleaning if the total service bill is more than ₹10000.

## Usage

1. Run the `CarServiceStation` class to start the program.
2. You will be prompted to select the car type by entering a number (1-3).
3. After selecting the car type, you will be presented with a list of available services.
4. Enter the service codes for the services you want to request, one at a time.
5. To finish selecting services, enter `0`.
6. The program will calculate the total bill and display it along with the car type.
7. If the total bill exceeds ₹10000, a message about complimentary cleaning will be shown.

## Example


Welcome to the Car Service Station
Available Car Types:

Hatchback

Sedan

SUV

Select the Car Type (1-3): 2

Available Services:

BS01 - Basic Servicing

EF01 - Engine Fixing

CF01 - Clutch Fixing

BF01 - Brake Fixing

GF01 - Gear Fixing

Enter the Service Code (or '0' to finish selecting services): BS01

Enter the Service Code (or '0' to finish selecting services): EF01

Enter the Service Code (or '0' to finish selecting services): 0

Type of Car: Sedan

Total Bill: ₹12000

Complimentary cleaning provided.
