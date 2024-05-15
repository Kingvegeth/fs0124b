package com.epicode.U5D1.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Order {
    private int orderNumber;
    private List<Item> orderList;
    private int seatNumber;
    private Double seatAmount = 2.0;
    private Date orderTime;
    private OrderStatus status;
    private Table table;

    public Order(int seatNumber, Table table){
        this.orderNumber = new Random().nextInt(1,1000);
        this.orderList = new ArrayList<>();
        this.seatNumber = seatNumber;
        this.orderTime = new Date();
        this.status = OrderStatus.PENDING;
        this.table = table;

    }

     public Double calculateTotal(){
        Double tot = seatAmount*seatNumber;
       for (Item e:orderList){
           tot+=e.getPrice();
       }
        return tot;
     }

     public void addItem(Item item){
        this.orderList.add(item);
     }

}
