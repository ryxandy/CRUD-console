package com.wipro.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.wipro.persistence.Collection;
import com.wipro.persistence.Product;
import com.wipro.persistence.SubCollection;

public class Operations {

	//Exit trigger
	boolean exit = false;
	
	//Fundamental variables
	public static ArrayList<Collection> collection = new ArrayList<Collection>();
	public static ArrayList<Product> products = new ArrayList<Product>();
	private Scanner read, keyboard;

	
	public void runMenuBasic() {
		while (!exit) {
			printMenu();
	          int choice = getBasicMenuChoice();
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
	    	System.out.println("1) Product Managment");
	    	System.out.println("2) Collection Managment");
	    }
	 
	  
	  public void printProductManagment() {
		  System.out.println("---------------------------------------------------------------------------------");
		  System.out.println("1) Save a new product, must have: Name, Price, Description, Quantity and Category");
	      System.out.println("2) List of all products ");
	      System.out.println("3) Search for a product name");
	      System.out.println("4) Exit");
	      int choiceProduct = getMenuChoice();
	      performActionManagment(choiceProduct);
	  }
	  
	  public void printCollectionManagment() {
		  System.out.println("---------------------------------------------------------------------------------");
		  System.out.println("1) Create a new Collection");
	      System.out.println("2) Create a sub Collection ");
	      System.out.println("3) Search for a product name");
	      System.out.println("4) Exit");
	      int choiceCollection = getMenuChoice();
	      performActionCollection(choiceCollection);
	  }
	 
	  public void performActionManagment(int choice) {
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
	  
	  
	  public void performActionCollection(int choice) {
	    	
	    	switch (choice) {
	        case 1:
	        	createCollection();
	            break;
	        case 2: {
	        	
	        	createSubCollection();
	        }
	        break;
	        case 3:
	        	showSub();
	            break;
	        case 4:
	        	System.out.println("Thanks for your visit, dont forget to come back later :) ");
	        	System.exit(4);
	            break;
	        default:
	            System.out.println("Unknown error has occured.");
	    	}	
	 	}
	  
	  
	 public void performAction(int choice) {
	    	switch (choice) {
	        case 1:
	        	printProductManagment();
	            break;
	        case 2: {
	        	printCollectionManagment();
	        }
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
	  
	  public int getBasicMenuChoice() {
	        keyboard = new Scanner(System.in);
	        int choice = -1;
	        do {
	            System.out.print("Select an option: ");
	            try {
	                choice = Integer.parseInt(keyboard.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid selection. Numbers only please.");
	            }
	            if (choice < 1 || choice > 2) {
	                System.out.println("Choice outside of range. Please chose again.");
	            }
	        } while (choice < 1 || choice > 2 );
	        return choice;
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
	            if (choice < 1 || choice > 4) {
	                System.out.println("Choice outside of range. Please chose again.");
	            }
	        } while (choice < 1 || choice > 4 );
	        return choice;
	    }
	  
	  
	  //Save a new product to the products static array
		public void save() {
			if (collection.isEmpty() == false) {
			read = new Scanner(System.in);
			try {
				verifySubCollectionToAdd();
			} catch (Exception e) {
				System.out.println("Please, only use numbers to describe prices and quantities :) ");
			}
		}else {
			System.out.println("You cant add a product without a subCollection");
		}
}
		
	//Method to find all data
		public void findAll() {
			if (products.size() != 0) {
				for (int i = 0; i < products.size(); i++) {
					System.out.println(products.get(i).toString());
				}
			}else {
				System.out.println("Your list of products is empty for now :(  ");
			}
		}
		
		
	//Find any product by name
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
						System.out.println(" -Images:" +products.get(i).getImage());
						System.out.println(" -SubCollection: " + products.get(i).getSubCollection());
					}else {
						System.out.println("unfortunately we did not find the product specified, maybe the caps lock is on?");
					}
				}
			}else {
				System.out.println("Cannot search for any product because u dont addedd one yet");
			}
		}
		
	//Method to create a new sub Collection	
		public void createSubCollection() {
			if (collection.size() != 0) {
			SubCollection sub = new SubCollection();
			Scanner read = new Scanner(System.in);
			System.out.println("Whats the name of your Sub Collection?");
			sub.setName(read.nextLine());
			System.out.println("Whats the description?");
			sub.setDescription(read.nextLine());
			System.out.println("Whats the keyword?  ");
			sub.setKeyword(read.nextLine());
			System.out.println("Your Sub Collection was created");
			collection.add(sub);
			}else {
				System.out.println("U cant add a Sub Collection without a Collection");
			}
		}
	//Method to create a big collection
		public void createCollection() {
			Collection col = new Collection();
			Scanner read = new Scanner(System.in);
			System.out.println("Whats the name of your Collection? ");
			col.setName(read.nextLine());
			System.out.println("Whats the description?");
			col.setDescription(read.nextLine());
			System.out.println("Whats the keyword? ");
			col.setKeyword(read.nextLine());
			System.out.println("Your Collection was created ");
			collection.add(col);
		}
		
	//Show the subCollections inside the Collection
	public void showSub() {
		if (products.size() != 0) {
			for (int i = 0; i < products.size(); i++) {
				System.out.println("Name: " + products.get(i).getName() + " SubCollection: " + products.get(i).getSubCollection());
			}
		}else {
			System.out.println("Você ainda não adicionou nenhuma subColeção");
		}
		
	}
	
	public void verifySubCollectionToAdd() {
		//Variables
		Product productAdd = new Product();
		String name, description, category, subCollection = "";
		Double price;
		int quantity, quantityImg = 0;
		
		System.out.println("Em qual Sub Collection deseja adicionar o produto? ");
		subCollection = read.nextLine();
		productAdd.setSubCollection(subCollection);
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i).getName().equals(subCollection) == true) {
				System.out.println("Ok, now lets choose add your product");
				
				//Set the attributes of the new Product
				System.out.printf("What's is the product name?");
				name = read.nextLine();
				productAdd.setName(name);
				
				System.out.printf("What's the description? ");
				description = read.nextLine();
				productAdd.setDescription(description);
				
				System.out.printf("What's the price? ");
				price = read.nextDouble();
				productAdd.setPrice(price);
				
				System.out.printf("What's the quantity? ");
				quantity = read.nextInt();
				productAdd.setQuantity(quantity);
				
				System.out.printf("What's the category? ");
				category = read.next();
				productAdd.setCategory(category);
				//
				verifyAndAddImages(quantityImg,read,productAdd);
				//Adding the product using the collected data
				products.add(productAdd);
				System.out.println("Adding your product...");
				System.out.println("Your product was successefuly saved");
			}else {
				System.out.println("U can only add a product into a existing sub collection");
			}
		}
	}
	
	public void findAllSubCollections(){
		for (int i = 0; i < products.size(); i++) {
			products.get(i).getSubCollection();
		}
	}
	
	public void verifyAndAddImages(int quantityImg, Scanner read, Product productAdd) {
		System.out.println("How many images you wanna add to ur product? ");
		quantityImg = read.nextInt();
		String img, images = "";
		
		if (quantityImg > 5) {
			System.out.println("u cant add more than 5 images to your product");
		}else {
			while (quantityImg != 0) {
				quantityImg --;
				System.out.println("Put the image url: ");
				img = read.next();
				images = images + "|" + img ;
			}
			productAdd.setImage(images);
		}
	}
	
}

