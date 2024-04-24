package it.epicode;

import it.epicode.enums.Category;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        products.add(new Product(1L, "The Lord of the Rings", Category.BOOK, 40.00));
        products.add(new Product(2L, "The Hobbit", Category.BOOK, 25.00));
        products.add(new Product(3L, "Baby's First Words", Category.BABY, 15.00));
        products.add(new Product(4L, "Superhero Action Figure", Category.BOYS, 20.00));
        products.add(new Product(5L, "1984 by George Orwell", Category.BOOK, 18.00));
        products.add(new Product(6L, "Soft Plush Bear", Category.BABY, 22.00));
        products.add(new Product(7L, "Building Block Set", Category.BOYS, 30.00));
        products.add(new Product(8L, "Animal Farm by George Orwell", Category.BOOK, 12.00));
        products.add(new Product(9L, "Musical Mobile for Crib", Category.BABY, 35.00));
        products.add(new Product(10L, "Remote Control Car", Category.BABY, 45.00));
        products.add(new Product(11L, "Brave New World by Aldous Huxley", Category.BOOK, 19.00));

        customers.add(new Customer(1L, "John Doe", 1));
        customers.add(new Customer(2L, "Jane Smith", 2));
        customers.add(new Customer(3L, "Alice Johnson", 3));
        customers.add(new Customer(4L, "Bob Brown", 1));
        customers.add(new Customer(5L, "Emily White", 2));
        customers.add(new Customer(6L, "David Wilson", 3));

        orders.add(new Order(1L, "Shipped", LocalDate.of(2020, 5, 15), LocalDate.of(2020, 5, 20), Arrays.asList(products.get(0), products.get(1)), customers.get(0)));
        orders.add(new Order(2L, "Pending", LocalDate.of(2021, 3, 22), LocalDate.of(2021, 3, 27), Arrays.asList(products.get(1)), customers.get(1)));
        orders.add(new Order(3L, "Delivered", LocalDate.of(2021, 6, 15), LocalDate.of(2021, 6, 20), Arrays.asList(products.get(2), products.get(3)), customers.get(2)));
        orders.add(new Order(4L, "Processing", LocalDate.of(2021, 7, 5), LocalDate.of(2021, 7, 10), Arrays.asList(products.get(4)), customers.get(3)));
        orders.add(new Order(5L, "Cancelled", LocalDate.of(2021, 8, 25), LocalDate.of(2021, 8, 30), Arrays.asList(products.get(5), products.get(6)), customers.get(4)));
        orders.add(new Order(6L, "Shipped", LocalDate.of(2021, 9, 15), LocalDate.of(2021, 9, 20), Arrays.asList(products.get(7)), customers.get(5)));
        orders.add(new Order(7L, "Pending", LocalDate.of(2022, 1, 10), LocalDate.of(2022, 1, 15), Arrays.asList(products.get(8), products.get(9)), customers.get(0)));
        orders.add(new Order(8L, "Delivered", LocalDate.of(2022, 2, 20), LocalDate.of(2022, 2, 25), Arrays.asList(products.get(0)), customers.get(1)));
        orders.add(new Order(9L, "Processing", LocalDate.of(2022, 3, 30), LocalDate.of(2022, 4, 4), Arrays.asList(products.get(1), products.get(2), products.get(3)), customers.get(2)));
        orders.add(new Order(10L, "Cancelled", LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 15), Arrays.asList(products.get(3), products.get(4)), customers.get(3)));


        //***** ESERCIZIO 1 *****

        List<Product> libriCostosi = products.stream()
                .filter(product -> product.getCategory() == Category.BOOK && product.getPrice() > 20)
                .toList();

        System.out.println("Lista di libri con prezzo maggiore di 20");
        libriCostosi.forEach(product -> System.out.println("Prodotto: " + product.getName() + " - Prezzo: " + product.getPrice() + "€"));



        //***** ESERCIZIO 2 *****

        List<Order> ordiniBaby = orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory() == Category.BABY))
                .toList();

        System.out.println();
        System.out.println("Lista di ordini che includano prodotti di categoria Baby");
        ordiniBaby.forEach(order -> {
            System.out.println("ID ordine: " + order.getId());
            order.getProducts().forEach(product -> {
                System.out.println("Prodotto: " + product.getName() + " - Categoria: " + product.getCategory() + " - Prezzo: " + product.getPrice() + "€");
            });
        });

        //***** ESERCIZIO 3 *****

        List<Product> boysToDiscount = products.stream()
                .filter(product -> product.getCategory() == Category.BOYS)
                .map(product -> new Product(product.getId(), product.getName(),product.getCategory(),product.getPrice()*0.9))
                .toList();
        System.out.println();
        System.out.println("Lista di prodotti di categoria Boys scontati del 10%");
        boysToDiscount.forEach(product -> System.out.println("Prodotto: "+ product.getName() + " - Categria: " + product.getCategory() + " - Prezzo Scontato: " + product.getPrice() + "€"));


        //***** ESERCIZIO 4 *****

        List<Product> tier2OrderedProducts = orders.stream()
                .filter(order -> order.getOrderDate() != null && order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0 && order.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                .filter(order -> order.getCustomer() != null && order.getCustomer().getTier() == 2)
                .flatMap(order -> order.getProducts().stream())
                .toList();

        tier2OrderedProducts.forEach(product -> System.out.format("%nLista di prodotti ordinati tra il 01/02/21 e il 01/04/21 da clienti di livello 2%nProdotto: " + product.getName() + " - Categoria: " + product.getCategory() + " - Prezzo: " + product.getPrice() + "€"));
    }





}
