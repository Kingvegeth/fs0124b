package it.epicode.pizzeria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyAppConfig {


    @Bean(name = "toppings_pomodoro")
    public Topping toppingPomodoroBean() { return new Topping(0.0,20,"Pomodoro"); }
    @Bean(name = "toppings_mozzarella")
    public Topping toppingMozzarellaBean() { return new Topping(0.0,60,"Mozzarella"); }
    @Bean(name = "toppings_salame")
    public Topping toppingSalameBean() { return new Topping(1.2,150,"Salame"); }
    @Bean(name = "toppings_cipolla")
    public Topping toppingCipollaBean() { return new Topping(0.5,5,"Cipolla"); }
    @Bean(name = "toppings_salsiccia")
    public Topping toppingSalsicciaBean() { return new Topping(1.5,213,"Salsiccia"); }
    @Bean(name = "toppings_funghi")
    public Topping toppingFunghiBean() { return new Topping(0.8,45,"Funghi"); }
    @Bean(name = "toppings_tonno")
    public Topping toppingTonnoBean() { return new Topping(1.3,127,"Tonno"); }


    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargheritaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(toppingPomodoroBean());
        listaTopping.add(toppingMozzarellaBean());
        return new Pizza("Pizza Margherita",listaTopping);
    }

    @Bean(name = "pizza_diavola")
    public Pizza pizzaDiavolaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(toppingPomodoroBean());
        listaTopping.add(toppingMozzarellaBean());
        listaTopping.add(toppingSalameBean());
        return new Pizza("Pizza Diavola",listaTopping);
    }

    @Bean(name = "pizza_tonno_cipolla")
    public Pizza pizzaTonnoCipollaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(toppingPomodoroBean());
        listaTopping.add(toppingMozzarellaBean());
        listaTopping.add(toppingTonnoBean());
        listaTopping.add(toppingCipollaBean());
        return new Pizza("Pizza Tonno e Cipolla",listaTopping);
    }
    @Bean(name = "pizza_boscaiola")
    public Pizza pizzaBoscaiolaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(toppingPomodoroBean());
        listaTopping.add(toppingMozzarellaBean());
        listaTopping.add(toppingFunghiBean());
        listaTopping.add(toppingSalsicciaBean());
        return new Pizza("Pizza Boscaiola",listaTopping);
    }


    @Bean(name = "menu")
    public Menu menuBean(){
        List<Pizza> pizzaList = new ArrayList<>();
        List<Topping> toppingsList = new ArrayList<>();

        pizzaList.add(pizzaMargheritaBean());
        pizzaList.add(pizzaDiavolaBean());
        pizzaList.add(pizzaBoscaiolaBean());
        pizzaList.add(pizzaTonnoCipollaBean());

        toppingsList.add(toppingFunghiBean());
        toppingsList.add(toppingMozzarellaBean());
        toppingsList.add(toppingTonnoBean());
        toppingsList.add(toppingCipollaBean());
        toppingsList.add(toppingSalameBean());
        toppingsList.add(toppingSalsicciaBean());
        toppingsList.add(toppingPomodoroBean());

        return new Menu(pizzaList,toppingsList);
    }

}
