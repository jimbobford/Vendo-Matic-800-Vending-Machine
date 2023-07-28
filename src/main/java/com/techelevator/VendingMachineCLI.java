package com.techelevator;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

	private Scanner userInput = new Scanner(System.in);
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "1";
	private static final String MAIN_MENU_OPTION_PURCHASE = "2";
	private static final String MAIN_MENU_OPTION_EXIT = "3";

	public ItemReader inventoryReader = new ItemReader();
	public Inventory machineInventory = new Inventory(inventoryReader.createInventory());
	public MachineFunds funds = new MachineFunds();


	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		Logger logger = new Logger("Log.txt");
		MachineFunds funds = new MachineFunds();
		boolean discount = false;
		BigDecimal discountDollar = new BigDecimal("1.00");
		logger.write("Machine has been turned on");

		machineInventory.initializeInventory();
		boolean stay = true;
		System.out.println("\n**************************************\n");
		System.out.println("Welcome to Umbrella Corp. Vendo-Matic 800!");
		while (stay) {
			System.out.println("\n**************************************\n");
			System.out.println("Please make a selection:");
			System.out.println("Enter 1 to display items available. \nEnter 2 to enter the purchase menu. \nEnter 3 to exit this menu.");
			String choiceMenu = userInput.nextLine();

			if (choiceMenu.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventoryReader.invDisplay(machineInventory.getCurrentInventory());

			} else if (choiceMenu.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean stay2 = true;

				while(stay2) {
					System.out.println("Enter 1 to add money.");
					System.out.println("Enter 2 to select an item to purchase.");
					System.out.println("Enter 3 to receive change and return to main menu.");
					String purchaseMenu = userInput.nextLine();

					if(purchaseMenu.equals("1")){
						System.out.println("Enter amount of money to add");
						String amountToAdd;
						BigDecimal amount = null;
						try {
							amountToAdd = userInput.nextLine();
							amount = new BigDecimal(amountToAdd);
						} catch (NumberFormatException e) {
							System.out.println("Sorry, please enter a numeric value of dollars.");
							break;
						}
						funds.increaseBalance(amount);
						System.out.println("The balance amount is now $" + funds.getBalance().setScale(2,BigDecimal.ROUND_HALF_UP));
						logger.write("Added $" + amount.setScale(2,BigDecimal.ROUND_HALF_UP) + " to balance. New balance is $" + funds.getBalance().setScale(2,BigDecimal.ROUND_HALF_UP));
					} else if (purchaseMenu.equals("2")) {
						System.out.println("Please enter the letter and number of the item you'd like to purchase:");
						String choiceItem = userInput.nextLine().toUpperCase();
						if ((machineInventory.getInventoryFromList(choiceItem) > 0 && funds.getBalance().compareTo(machineInventory.getPriceFromList(choiceItem)) == 1  || (machineInventory.getInventoryFromList(choiceItem) > 0 && funds.getBalance().compareTo(machineInventory.getPriceFromList(choiceItem).subtract(discountDollar))  == 1))) {
							if(discount) {
								BigDecimal discountedPrice = machineInventory.getPriceFromList(choiceItem).subtract(discountDollar);
								funds.decreaseBalance(discountedPrice);
								machineInventory.subtractInventory(choiceItem);
								logger.write(machineInventory.getNameFromList(choiceItem) + ", " + choiceItem + ", $" + discountedPrice +  " (discounted from $" + machineInventory.getPriceFromList(choiceItem) + " by $1 for BOGO sale), $" + funds.getBalance());
								System.out.println("You chose " + machineInventory.getNameFromList(choiceItem) + " from " + choiceItem + ". " + machineInventory.getMessageFromList(choiceItem));
								System.out.println("The total after $1 off was $" + discountedPrice + " and your remaining balance is $" + funds.getBalance());
								discount = false;
							} else if (!discount) {
								funds.decreaseBalance(machineInventory.getPriceFromList(choiceItem));
								machineInventory.subtractInventory(choiceItem);
								logger.write(machineInventory.getNameFromList(choiceItem) + ", " + choiceItem + ", $" + machineInventory.getPriceFromList(choiceItem) + ", $" + funds.getBalance());
								System.out.println("You chose " + machineInventory.getNameFromList(choiceItem) + " from " + choiceItem + ". " + machineInventory.getMessageFromList(choiceItem));
								System.out.println("The total was $" + machineInventory.getPriceFromList(choiceItem) + " and your remaining balance is $" + funds.getBalance());
								discount = true;
							}
						} else if (discount && funds.getBalance().compareTo(machineInventory.getPriceFromList(choiceItem).subtract(discountDollar)) == -1) {
							System.out.println("Not enough money entered. Please add more money to purchase " + machineInventory.getNameFromList(choiceItem));
						} else if (!discount && funds.getBalance().compareTo(machineInventory.getPriceFromList(choiceItem)) == -1) {
							System.out.println("Not enough money entered. Please add more money to purchase " + machineInventory.getNameFromList(choiceItem));
						} else if (machineInventory.getInventoryFromList(choiceItem) == 0) {
							System.out.println("Sorry, " + machineInventory.getNameFromList(choiceItem) + " is out of stock.");
						}
					} else if (purchaseMenu.equals("3")) {
						logger.write("Dispensed change. Balance was $" + funds.getBalance().setScale(2,BigDecimal.ROUND_HALF_UP) + ", new balance is $0.00");
						funds.dispenseChange();
						stay2 = false;
					} else {
						System.out.println("Invalid selection");
					}
				}
			} else if (choiceMenu.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for choosing Umbrella Corp. Vendo-Matic 800!");
				System.out.println("Have a great day!");
				stay = false;
			} else {
				System.out.println("Invalid input. ");
			}
		}
	}
}
