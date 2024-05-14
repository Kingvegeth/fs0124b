package com.epicode.U5D1.entities;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private int tableNumber;
    private int maxPeople;
    private TableStatus status;

}
