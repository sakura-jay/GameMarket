package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.entity.Shoppingcart;
import com.w1101.gamemarket.mapper.GameMapper;
import com.w1101.gamemarket.mapper.ShoppingcartMapper;
import com.w1101.gamemarket.service.IShoppingcartService;
import com.w1101.gamemarket.vo.CartItem;
import com.w1101.gamemarket.vo.ShoppingCartVo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ShoppingcartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements IShoppingcartService {
    @Resource
    private ShoppingcartMapper shoppingcartMapper;
    @Autowired
    private GameMapper gameMapper;


    @Override
    public List<ShoppingCartVo> getlist(Shoppingcart shoppingcart) {
        return shoppingcartMapper.getlist(shoppingcart.getUserId());
    }

    @Override
    public boolean add(Integer userId, Integer gameId) {
        if (existShoppingcart(userId, gameId) == 0) {
            shoppingcartMapper.add(userId, gameId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer userId, Integer gameId) {
        shoppingcartMapper.delete(userId, gameId);
    }

    @Override
    public boolean checkout(List<CartItem> items) {
        double totalprice = 0;

        for (CartItem item : items) {
            QueryWrapper<Game> gameQueryWrapper = new QueryWrapper<>();
           Game game = gameMapper.selectOne(gameQueryWrapper.eq("game_id", item.getGameId()));
           item.setNowprice(game.getCost().doubleValue());
           totalprice = totalprice +  game.getCost().doubleValue();
        }
        Integer userId1 = Integer.valueOf(items.get(0).getUserId());
        if(DetemineBalance(userId1,totalprice)==1){
            int i = 0;
            int j = 0;
            try {
                for (CartItem item : items) {
                    if (item != null) {
                        Integer userId = Integer.valueOf(item.getUserId());
                        Integer gameId = Integer.valueOf(item.getGameId());
                        j += existpurchase(userId, gameId);
                        if (j == 0) {
                            shoppingcartMapper.checkout(item);
                            shoppingcartMapper.delete(userId, gameId);
                            i++;
                        }
                        else throw new Exception("购物车中存在重复商品");
                    }
                }
            } catch (Exception e) {
                return false;
            }
            if (i == items.size()) {
//                resetBalance(userId1,totalprice);
                return true;
            } else return false;
        }
       else return false;
    }


//   public void resetBalance(Integer userId, double totalprice) {
//        if(DetemineBalance(userId,totalprice)==1){
//            shoppingcartMapper.resetBalance(userId,totalprice);
//        }
//   }
    public int existpurchase(Integer userId, Integer gameId) {
        return shoppingcartMapper.existpurchase(userId, gameId);
    }

    public int existShoppingcart(Integer userId, Integer gameId) {
        return shoppingcartMapper.existShoppingcart(userId, gameId);
    }

    public int DetemineBalance(Integer userId,double totalprice) {
        return shoppingcartMapper.DetemineBalance(userId,totalprice);
    }
}
