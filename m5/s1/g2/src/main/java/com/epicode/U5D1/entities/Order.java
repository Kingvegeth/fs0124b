package com.epicode.U5D1.entities;

import lombok.*;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Order {
    private int orderNumber;
    private List<Item> orderList;
    private Double totalCost;
    private int peopleNumber;
    private Date orderTime;
    private OrderStatus status;

    public Order(int orderNumber, List<Item> orderList, int peopleNumber){
        this.orderNumber = orderNumber;
        this.orderList = orderList;
        this.peopleNumber = peopleNumber;
        this.orderTime = new Date();
        this.status = OrderStatus.PENDING;
        this.totalCost = calculateTotal(orderList);
    }

     public Double calculateTotal(List<Item> orderList){
        Double tot = 0.0;
       for (Item e:orderList){
           tot+=e.getPrice();
       }
        return tot;
     }
}
