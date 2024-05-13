package it.epicode.pizzeria;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private List<Pizza> pizzaList;
    private List<Topping> toppingList;
    //private List<Drink> drinkList;

    public void printMenu() {
        System.out.println("******* Menu *******");
        System.out.println("PIZZE");
        this.pizzaList.forEach(System.out::println);
        System.out.println();

        System.out.println("CONDIMENTI");
        this.toppingList.forEach(System.out::println);
        System.out.println();

//        System.out.println("DRINKS");
//        this.drinkList.forEach(System.out::println);
//        System.out.println();

    }
}
