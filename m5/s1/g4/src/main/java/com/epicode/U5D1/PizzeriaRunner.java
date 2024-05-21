package com.epicode.U5D1;

import com.epicode.U5D1.dao.PizzaDao;
import com.epicode.U5D1.entities.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PizzaDao dao;




    @Override
    @Transactional
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApp.class);

        Menu m = (Menu) ctx.getBean("menu");
        m.printMenu();

        popolaDatabase(ctx);

        dao.insert(ctx.getBean("salami_pizza", Pizza.class));


        Order order1 = new Order(4,ctx.getBean("Tavolo1",Table.class));
        order1.addItem(ctx.getBean("salami_pizza", Pizza.class));
        order1.addItem(ctx.getBean("hawaiian_pizza", Pizza.class));
        order1.addItem(ctx.getBean("lemonade", Drink.class));
        order1.addItem(ctx.getBean("wine", Drink.class));


        log.info(String.valueOf(order1));

        log.info("Conto totale: "+ String.valueOf(order1.calculateTotal()) +"€");


        ctx.close();

    }
    private void popolaDatabase(AnnotationConfigApplicationContext ctx) {
        Pizza margherita = ctx.getBean("pizza_margherita", Pizza.class);
        Pizza hawaiian = ctx.getBean("hawaiian_pizza", Pizza.class);
        Pizza salami = ctx.getBean("salami_pizza", Pizza.class);
        Pizza salamiXl = ctx.getBean("salami_pizza_xl", Pizza.class);

        dao.insert(margherita);
        dao.insert(hawaiian);
        dao.insert(salami);
        dao.insert(salamiXl);
    }
}

