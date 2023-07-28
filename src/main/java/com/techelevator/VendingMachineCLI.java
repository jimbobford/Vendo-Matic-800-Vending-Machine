package com.techelevator;

import java.math.BigDecimal;
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
				System.out.println("Enter 1 to add money.");
				System.out.println("Enter 2 to select an item to purchase.");
				System.out.println("Enter 3 to receive change.");
				System.out.println("Enter 4 to return to main menu.");
				String purchaseMenu = userInput.nextLine();
				boolean stay2 = true;
				while(stay2) {
					if(purchaseMenu.equals("1")){
						System.out.println("Enter amount of money to add");
						String amountToAdd = userInput.nextLine();
						BigDecimal amount = new BigDecimal(amountToAdd);
						funds.increaseBalance(amount);
						System.out.println("The balance amount is now $" + funds.getBalance().setScale(2,BigDecimal.ROUND_HALF_UP));
						stay2 = false;
					} else if (purchaseMenu.equals("2")) {
						System.out.println("Please enter the letter and number of the item you'd like to purchase:");
						String choiceItem = userInput.nextLine();
						machineInventory.subtractInventory(choiceItem);
						if (machineInventory.getInvMap().get(machineInventory.getNameFromList(choiceItem)) > 0) {
							funds.decreaseBalance(machineInventory.getPriceFromList(choiceItem));
							machineInventory.subtractInventory(choiceItem);
							logger.write(machineInventory.getNameFromList(choiceItem) + choiceItem + machineInventory.getPriceFromList(choiceItem) + funds.getBalance());
						}
						System.out.println("You have chosen " + machineInventory.getNameFromList(choiceItem));
					} else if (purchaseMenu.equals("3")) {

					} else if (purchaseMenu.equals("4")) {

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
