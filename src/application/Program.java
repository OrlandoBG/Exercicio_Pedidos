package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {
	
	public static void main(String[]args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		OrderItem orderItem;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Date dataOrder = new Date();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birday date(dd/MM/yyyy): ");
		String date = sc.nextLine();
		
		
		System.out.println("Enter order data: ");
		
		System.out.print("Status: ");
		String Status = sc.nextLine();
		
		Order order = new Order(dataOrder,OrderStatus.valueOf(Status),new Client(name,email,sdf1.parse(date)));
		
		System.out.print("How many items to this order? ");
		int quantityItems = sc.nextInt();
		
		sc.nextLine();
		
		for(int i=0; i<quantityItems ; i++) {
			System.out.println("Enter item data #"+(i+1));
			System.out.print("Product Name: ");
			String nameProduct = sc.nextLine();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			System.out.print("price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			
			orderItem = new OrderItem(quantity,price,new Product(nameProduct,price));
			
			order.addItem(orderItem);
		}
		
		
		System.out.println("SUMMARY: ");
		System.out.println(order);
		
		
				
				
		sc.close();
	}

}
