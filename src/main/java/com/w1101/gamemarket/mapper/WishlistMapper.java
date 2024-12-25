package com.w1101.gamemarket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w1101.gamemarket.entity.Wishlist;
import com.w1101.gamemarket.vo.WishListVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lv
 * @since 2024-12-18
 */
public interface WishlistMapper extends BaseMapper<Wishlist> {
    List<WishListVo> getlist(Integer userId);



    List<WishListVo> sort(Integer userId,Integer sortId);


    void delete(Integer userId, Integer gameId);

    void add(Integer userId, Integer gameId);


    int existsWishlist(Integer userId, Integer gameId);
}
