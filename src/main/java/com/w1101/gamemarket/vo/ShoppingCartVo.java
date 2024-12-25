package com.w1101.gamemarket.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartVo {
    private int userId;
    private int gameId;
    private String gameTitle;
    private String gameAvatar;
    private double price;
    private BigDecimal nowprice;
    private String addDate;
    private String description;
    private double discountRate;
}
