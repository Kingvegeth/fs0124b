package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
@Slf4j
public class JpaPizzaDao implements PizzaDao{


    @Override
    public void insert(Pizza pizza) {
        log.info("JpaPizzaDao.insert()");
    }

    @Override
    public void update(Pizza pizza) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Pizza getById(Integer id) {
        return null;
    }
}
