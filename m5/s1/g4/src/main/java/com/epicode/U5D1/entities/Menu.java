package com.epicode.U5D1.entities;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
	private List<Pizza> pizzaList;
	private List<Drink> drinkList;
	private List<Topping> toppingList;

	public void printMenu() {
		System.out.println("******* Menu *******");
		System.out.println("PIZZAS");
		this.pizzaList.forEach(System.out::println);
		System.out.println();

		System.out.println("TOPPINGS");
		this.toppingList.forEach(System.out::println);
		System.out.println();

		System.out.println("DRINKS");
		this.drinkList.forEach(System.out::println);
		System.out.println();

	}
}
