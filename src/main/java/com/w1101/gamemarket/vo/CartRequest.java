package com.w1101.gamemarket.vo;

import java.util.List;
public class CartRequest {
    private List<CartItem> items;

    // Getters 和 Setters
    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
