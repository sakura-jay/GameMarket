package com.w1101.gamemarket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.w1101.entity.Wishlist;
import com.w1101.vo.WishListVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lv
 * @since 2024-12-18
 */
public interface IWishlistService extends IService<Wishlist> {

    List<WishListVo> getlist(Wishlist wishlist);


    List<WishListVo> sort(Integer userId, Integer sortId);

    void delete(Integer userId, Integer gameId);

    boolean add(Integer userId, Integer gameId);
}
