package com.techelevator;

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
	public Inventory machineInventory = new Inventory();
	public ItemReader inventoryReader = new ItemReader();

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {

		while (true) {
			System.out.println("Welcome to Umbrella Corp. Vendo-Matic 800!");
			System.out.println("Please make a selection:");
			System.out.println("Enter 1 to display items available. \nEnter 2 to make a purchase. \nEnter 3 to exit this menu.");

			String choice = userInput.nextLine();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				inventoryReader.displayInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// do purchase

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

				System.out.println("Thank you for choosing Umbrella Corp. Vendo-Matic 800!");
				System.out.println("Have a great day!");
				System.exit(0);
			}
			// Remove the break when you've figured out how to setup the input loop
			break;
		}
	}
}
