import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		double itemPrice, amountTendered, changeOwed;
		int dollarsOwed = 0;
		int centsOwed = 0;
		int twentyCounter = 0, oneCounter = 0;
		int quarterCounter = 0, dimeCounter = 0, pennyCounter = 0;
		int previousDenomination = 0; // TODO switch out with if (changeOwed > dollarsOwed)

		System.out.print("What is the price of the potato? $");
		itemPrice = userInput.nextDouble();
		System.out.print("And how much money did the customer give? $");
		amountTendered = userInput.nextDouble();

		if (amountTendered < itemPrice) {
			saleError(itemPrice - amountTendered);
		} else if (amountTendered == itemPrice) {
			System.out.println("Exact amount tendered. Potato transaction complete.");
		} else {
			changeOwed = amountTendered - itemPrice;
			changeOwed += .001;		// Adjust for rounding
			System.out.printf("Customer is owed $%.2f\n", changeOwed);
			dollarsOwed = (int) changeOwed;
			centsOwed = (int) ((changeOwed % 1) * 100);
//			System.out.println("Value of centsOwed after typecast: " + centsOwed);
			while (dollarsOwed > 0) {
				if (dollarsOwed >= 20) {
					dollarsOwed -= 20;
					twentyCounter++;
					if (twentyCounter == 1 && dollarsOwed < 20) {
						System.out.print("Hand the customer 1 twenty");
						previousDenomination = 1;
					} else if (twentyCounter > 1 && dollarsOwed <= 20) {
						System.out.print("Hand the customer " + twentyCounter + " twenties");
						previousDenomination = 1;
					}
				} else if (dollarsOwed >= 10) {
					dollarsOwed -= 10;
					if (previousDenomination == 0) {												
						System.out.print("Hand the customer 1 ten");
						previousDenomination = 1;
					} else if (previousDenomination == 1 && (dollarsOwed > 0 || centsOwed > 0)){				
						System.out.print(", 1 ten");
					} else if (previousDenomination == 1 && dollarsOwed == 0 && centsOwed == 0){				
						System.out.print(" and 1 ten");
					}
				} else if (dollarsOwed >= 5) {
					dollarsOwed -= 5;
					if (previousDenomination == 0) {
						System.out.print("Hand the customer 1 five");
						previousDenomination = 1;
					} else if (previousDenomination == 1 && (dollarsOwed > 0 || centsOwed > 0)) {
						System.out.print(", 1 five");
					} else if (previousDenomination == 1 && dollarsOwed == 0 && centsOwed == 0){
						System.out.print(" and 1 five");
					}
						
				} else if (dollarsOwed >= 1) {
					dollarsOwed -= 1;
					oneCounter++;
//					System.out.println("oneCounter: " + oneCounter);
//					System.out.println("dollarsOwed: " + dollarsOwed);
					if (previousDenomination == 0 && oneCounter == 1 && dollarsOwed == 0) {
						System.out.print("Hand the customer 1 dollar");
						previousDenomination = 1;
					} else if (previousDenomination == 0 && oneCounter > 1 && dollarsOwed == 0) {
						System.out.print("Hand the customer " + oneCounter + " dollars");
						previousDenomination = 1;
					} else if (previousDenomination == 1 && oneCounter == 1 && (centsOwed > 0 && dollarsOwed == 0)) {
						System.out.print(", 1 dollar");
					} else if (previousDenomination == 1 && oneCounter > 1 && (centsOwed > 0 && dollarsOwed == 0)) {
						System.out.print(", " + oneCounter + " dollars");
					} else if (previousDenomination == 1 && oneCounter == 1 && centsOwed == 0 && dollarsOwed == 0) {
						System.out.print(" and 1 dollar");
					} else if (previousDenomination == 1 && oneCounter > 1 && centsOwed == 0 && dollarsOwed == 0) {
						System.out.print(" and " + oneCounter + " dollars");
					}
				}
			}
			
			
			
			while (centsOwed > 0) {
				if (centsOwed >= 25) {
					centsOwed -= 25;
					quarterCounter++;
//					System.out.println();
//					System.out.println("centsOwed: " + centsOwed);
//					System.out.println("quarterCounter: " + quarterCounter);
//					System.out.println();
					if (previousDenomination == 0 && quarterCounter == 1 && centsOwed < 25) {
						System.out.print("Hand the customer 1 quarter");
						previousDenomination = 1;
					} else if (previousDenomination == 0 && quarterCounter > 1 && centsOwed >= 25) {
						System.out.print("Hand the customer " + quarterCounter + " quarters");
						previousDenomination = 1;
					} else if (previousDenomination == 1 && quarterCounter == 1 && (centsOwed < 25 && centsOwed > 0)) {
						System.out.print(", 1 quarter");
					} else if (previousDenomination == 1 && quarterCounter > 1 && (centsOwed < 25 && centsOwed > 0)) {
						System.out.print(", " + quarterCounter + " quarters");
					} else if (previousDenomination == 1 && quarterCounter == 1 && centsOwed == 0) {
						System.out.print(" and 1 quarter");
					} else if (previousDenomination == 1 && quarterCounter > 1 && centsOwed == 0) {
						System.out.print(" and " + quarterCounter + " quarters");
					}
				} else if (centsOwed >= 10) {
					centsOwed -= 10;
					dimeCounter++;
					if (previousDenomination == 0 && dimeCounter == 1 && centsOwed < 10) {
						System.out.print("Hand the customer 1 dime");
						previousDenomination = 1;
					} else if (previousDenomination == 0 && dimeCounter > 1 && centsOwed < 10) {
						System.out.print("Hand the customer " + dimeCounter + " dimes");
						previousDenomination = 1;
					} else if (previousDenomination == 1 && dimeCounter == 1 && (centsOwed < 10 && centsOwed > 0)) {
						System.out.print(", 1 dime");
					} else if (previousDenomination == 1 && dimeCounter > 1 && (centsOwed < 10 && centsOwed > 0)) {
						System.out.print(", " + dimeCounter + " dimes");
					} else if (previousDenomination == 1 && dimeCounter == 1 && centsOwed == 0) {
						System.out.print(" and 1 dime");
					} else if (previousDenomination == 1 && dimeCounter > 1 && centsOwed == 0) {
						System.out.print(" and " + dimeCounter + " dimes");
					}
				} else if (centsOwed >= 5) {
					centsOwed -= 5;
					if (previousDenomination == 0) {
						System.out.print("Hand the customer 1 nickel");
						previousDenomination = 1;
					} else if (previousDenomination == 1 && (centsOwed > 0 && centsOwed < 5)) {
						System.out.print(", 1 nickel");
					} else if (previousDenomination == 1 && centsOwed == 0) {
						System.out.print(" and 1 nickel.");
					}
				} else if (centsOwed >= 1) {
					centsOwed -= 1;
					pennyCounter++;
					if (previousDenomination == 0 && pennyCounter == 1 && centsOwed == 0) {
						System.out.print("Hand the customer 1 penny");
					} else if (previousDenomination == 0 && pennyCounter > 1 && centsOwed == 0) {
						System.out.print("Hand the customer " + pennyCounter + " pennies");
					} else if (previousDenomination == 1 && pennyCounter == 1 && centsOwed == 0) {
						System.out.print(" and 1 penny");
					} else if (previousDenomination == 1 && pennyCounter > 1 && centsOwed == 0) {
						System.out.print(" and " + pennyCounter + " pennies");
					}
				}

			}
			System.out.print(".\n");
			System.out.print("Potato transaction complete.\n");
			

		}

		userInput.close();

	}

	public static void saleError(double cashNeeded) {
		System.out.println("\n******POTATO SITUATION******");
		System.out.printf("Do not sell the potato! You still need ===> $%.2f <===\n", cashNeeded);
		System.out.println("******POTATO SITUATION******");
	}
}
