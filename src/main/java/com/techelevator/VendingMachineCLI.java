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

	public ItemReader inventoryReader = new ItemReader();
	public Inventory machineInventory = new Inventory(inventoryReader.createInventory());
	public MachineFunds funds = new MachineFunds();


	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		machineInventory.initializeInventory();
		boolean stay = true;
		System.out.println("\n**************************************\n");
		System.out.println("Welcome to Umbrella Corp. Vendo-Matic 800!");
		while (stay) {
			System.out.println("\n**************************************\n");
			System.out.println("Please make a selection:");
			System.out.println("Enter 1 to display items available. \nEnter 2 to make a purchase. \nEnter 3 to exit this menu.");
			String choiceMenu = userInput.nextLine();

			if (choiceMenu.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventoryReader.invDisplay(machineInventory.getCurrentInventory());

			} else if (choiceMenu.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Please enter the letter and number of the item you'd like to purchase:");
				String choiceItem = userInput.nextLine();
				machineInventory.subtractInventory(choiceItem);
				if(machineInventory.)
				System.out.println( "You have chosen " + machineInventory.getNameFromList(choiceItem));

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
