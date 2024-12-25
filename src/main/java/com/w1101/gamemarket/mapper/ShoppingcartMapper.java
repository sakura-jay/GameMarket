package com.w1101.gamemarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w1101.gamemarket.entity.Shoppingcart;
import com.w1101.gamemarket.vo.CartItem;
import com.w1101.gamemarket.vo.ShoppingCartVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lv
 * @since 2024-12-18
 */
public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {

    List<ShoppingCartVo> getlist(Integer userId);

    void add(Integer userId, Integer gameId);

    void delete(Integer userId, Integer gameId);

    int existShoppingcart(Integer userId, Integer gameId);

    int existpurchase(Integer userId, Integer gameId);

    boolean checkout(CartItem item);

    int DetemineBalance(Integer userId,double totalprice);

//    void resetBalance(Integer userId, double totalprice);
}
