package com.w1101.gamemarket.vo;

import lombok.Data;

/**
 * 发送给前端的数据
 */
@Data
public class WishListVo {
    private String gameId;
    private String gameTitle;
    private String description;
    private String gameAvatar;
    private String addDate;
    private double price;
    private double discountRate ;
    private double nowprice;

}
