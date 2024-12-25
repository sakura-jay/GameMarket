package com.w1101.gamemarket.vo;

import lombok.Data;

@Data
public class CartItem {
    private int userId;
    private int gameId;
    private double nowprice;
}
