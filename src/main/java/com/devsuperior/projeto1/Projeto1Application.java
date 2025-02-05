package com.devsuperior.projeto1;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.projeto1.entities.Order;
import com.devsuperior.projeto1.services.OrderService;

@SpringBootApplication
public class Projeto1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Dados do pedido:");
		System.out.print("Código: ");
		int code = sc.nextInt();
		System.out.print("Valor básico: ");
		double basic = sc.nextDouble();
		System.out.print("Porcentagem de desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		double total = orderService.total(order);

		System.out.println("Pedido código: " + order.getCode());
		System.out.printf("Valor total: $%.2f%n", total);

		System.out.println("Fim!");
		sc.close();
	}
}