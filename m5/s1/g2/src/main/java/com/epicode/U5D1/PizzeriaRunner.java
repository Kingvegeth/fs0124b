package com.epicode.U5D1;

import com.epicode.U5D1.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class PizzeriaRunner implements CommandLineRunner {


//    @Value("${order.seatAmount}")
//    Double seatAmount;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApp.class);

        Menu m = (Menu) ctx.getBean("menu");
        m.printMenu();

        Order order1 = new Order(4,ctx.getBean("Tavolo1",Table.class));
        order1.addItem(ctx.getBean("salami_pizza", Pizza.class));
        order1.addItem(ctx.getBean("hawaiian_pizza", Pizza.class));
        order1.addItem(ctx.getBean("lemonade", Drink.class));
        order1.addItem(ctx.getBean("wine", Drink.class));


        log.info(String.valueOf(order1));

        log.info("Conto totale: "+ String.valueOf(order1.calculateTotal()) +"€");


        ctx.close();

    }
}

