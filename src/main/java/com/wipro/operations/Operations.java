package com.wipro.operations;

import java.util.ArrayList;
import java.util.Scanner;

import com.wipro.persistence.Product;

public class Operations {

	//Exit trigger
	boolean exit = false;
	
	//Fundamental variables
	public static ArrayList<Product> products = new ArrayList<Product>();
	private Scanner read, keyboard;

	
	public void runMenu() {
		while (!exit) {
	          printMenu();
	          int choice = getMenuChoice();
	          performAction(choice);
			}
		} 
	 
	//To print the "Welcome message"
	  public void Header() {
	    	System.out.println("+-----------------------------------+");
	        System.out.println("|   Welcome to your Wipro Shop      |");
	        System.out.println("|                                   |");
	        System.out.println("+-----------------------------------+");
	    }
	
	  //Show the menu options  
	  public void printMenu() {
	    	displayHeader("Hello, whats our next step? ");
	          System.out.println("1) Save a new product, must have: Name, Price, Description, Quantity and Category");
	          System.out.println("2) List of all products ");
	          System.out.println("3) Search for a product name");
	          System.out.println("4) Exit");
	    }
	 
	 
	 public void performAction(int choice) {
	    	switch (choice) {
	        case 1:
	            save();
	            break;
	        case 2: {
	        	 findAll();
	        }
	        break;
	        case 3:
	        	  findByName();
	            break;
	        case 4:
	        	System.out.println("Thanks for your visit, dont forget to come back later :) ");
	        	System.exit(4);
	            break;
	        default:
	            System.out.println("Unknown error has occured.");
	    	}	
	 	}

	  public void displayHeader(String message){
	        System.out.println();
	        int width = message.length() + 6;
	        StringBuilder stringbuilder = new StringBuilder();
	        stringbuilder.append("+");
	        for(int i = 0; i < width; ++i){
	            stringbuilder.append("-");
	        }
	        stringbuilder.append("+");
	        System.out.println(stringbuilder.toString());
	        System.out.println("|   " + message + "   |");
	        System.out.println(stringbuilder.toString());
	    }
	    
	  public int getMenuChoice() {
	        keyboard = new Scanner(System.in);
	        int choice = -1;
	        do {
	            System.out.print("Select an option: ");
	            try {
	                choice = Integer.parseInt(keyboard.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid selection. Numbers only please.");
	            }
	            if (choice < 0 || choice > 4) {
	                System.out.println("Choice outside of range. Please chose again.");
	            }
	        } while (choice < 0 || choice > 4);
	        return choice;
	    }
	  
	  //Save a new product to the products static array
		public void save() {
			read = new Scanner(System.in);
			try {
				//Variables
				String name, description, category;
				Double price;
				int quantity;
				
				Product productAdd = new Product();
				
				//Set the attributes of the new Product
				System.out.printf("Whats is the product name?");
				name = read.nextLine();
				productAdd.setName(name);
				
				System.out.printf("Whats the description? ");
				description = read.nextLine();
				productAdd.setDescription(description);
				
				System.out.printf("Whats the price? ");
				price = read.nextDouble();
				productAdd.setPrice(price);
				
				System.out.printf("Whats the quantity ");
				quantity = read.nextInt();
				productAdd.setQuantity(quantity);
				
				System.out.printf("Whats the category? ");
				category = read.next();
				productAdd.setCategory(category);
				
				//Adding the product using the collected data
				products.add(productAdd);
				System.out.println("Adding your product...");
				System.out.println("Your product was successefuly saved");
			} catch (Exception e) {
				System.out.println("Please, only use numbers to describe prices and quantities :) ");
			}
		}
		
		public void findAll() {
			if (products.size() != 0) {
				for (int i = 0; i < products.size(); i++) {
					System.out.println(products.get(i).toString());
				}
			}else {
				System.out.println("Your list of products is empty for now :(  ");
			}
		}
		
		public void findByName() {
			
			if (products.size() != 0) {
				String name;
				System.out.println("Whats the name of the product? ");
				name = read.next();
				
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getName().contains(name) == true) {
						System.out.println("Product found! heres some information about it: ");
						System.out.println(" -Price: " + products.get(i).getPrice());
						System.out.println(" -Description: " + products.get(i).getDescription());
					}else {
						System.out.println("unfortunately we did not find the product specified, maybe the caps lock is on?");
					}
				}
			}else {
				System.out.println("Cannot search for any product because u dont addedd one yet");
			}
		}
}

