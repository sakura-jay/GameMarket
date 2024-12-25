package com.w1101.gamemarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.w1101.entity.Shoppingcart;
import com.w1101.vo.CartItem;
import com.w1101.vo.ShoppingCartVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lv
 * @since 2024-12-18
 */
public interface IShoppingcartService extends IService<Shoppingcart> {

    List<ShoppingCartVo> getlist(Shoppingcart shoppingcart);

    boolean add(Integer userId, Integer gameId);

    void delete(Integer userId, Integer gameId);

    boolean checkout(List<CartItem> items);

//    boolean checkout(ShoppingCartVo shoppingcartvo);
}
