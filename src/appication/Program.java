package appication;

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

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter Order Data:");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());

		Order order = new Order(new Date(), orderStatus, client);

		System.out.print("How many items to this order?");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " Item Data:");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price:");
			double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}

		System.out.println();
		System.out.println(order);

		sc.close();

	}

}
