package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Pizza;

public interface PizzaDao {

    public void insert(Pizza pizza);
    public void update(Pizza pizza);
    public void delete(Integer id);
    public Pizza getById(Integer id);

}
