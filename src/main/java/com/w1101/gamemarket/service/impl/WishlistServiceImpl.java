package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w1101.entity.Wishlist;
import com.w1101.mapper.WishlistMapper;
import com.w1101.service.IWishlistService;
import com.w1101.vo.WishListVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lv
 * @since 2024-12-18
 */
@Service
public class WishlistServiceImpl extends ServiceImpl<WishlistMapper, Wishlist> implements IWishlistService {
    @Resource
    private WishlistMapper wishlistMapper;


    @Override
    public List<WishListVo> getlist(Wishlist wishlist) {
        List<WishListVo> list = wishlistMapper.getlist(wishlist.getUserId());
        return list;
    }

    @Override
    public List<WishListVo> sort(Integer userId, Integer sortId) {
        List<WishListVo> list = wishlistMapper.sort(userId, sortId);
        return list;
    }

    @Override
    public void delete(Integer userId, Integer gameId) {
      wishlistMapper.delete(userId, gameId);
    }

    @Override
    public boolean add(Integer userId, Integer gameId) {
       if(existsWishlist(userId, gameId)==0){
           wishlistMapper.add(userId, gameId);
           return true;
       }
       else{
           return false;
       }
    }
    public int existsWishlist(Integer userId, Integer gameId){
        return wishlistMapper.existsWishlist(userId, gameId);
    }

}
