package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.Shoppingcart;
import com.w1101.gamemarket.service.IShoppingcartService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.CartItem;
import com.w1101.gamemarket.vo.CartRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lv
 * @since 2024-12-18
 */
@Slf4j
@RestController
@RequestMapping("/shoppingcart")
public class ShoppingcartController {
    @Autowired
    private IShoppingcartService iShoppingcartService;

    @GetMapping("/getlist")
    public Result getlist(Shoppingcart shoppingcart) {
        return Result.success(iShoppingcartService.getlist(shoppingcart));
    }

    @PostMapping("/add")
    public Result add(@RequestParam("userId") Integer userId, @RequestParam("gameId") Integer gameId) {
        log.info("添加购物车数据");
        if (iShoppingcartService.add(userId, gameId)) {
            Shoppingcart shoppingcart = new Shoppingcart();
            shoppingcart.setUserId(userId);
            return Result.success(getlist(shoppingcart));
        } else {
            return Result.success("添加失败");
        }
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("userId") Integer userId, @RequestParam("gameId") Integer gameId) {
        iShoppingcartService.delete(userId, gameId);
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setUserId(userId);
        return Result.success(getlist(shoppingcart));
    }

    @PostMapping("/checkout")
    public Result checkout(@RequestBody CartRequest cartRequest) {
        List<CartItem> items = cartRequest.getItems();
        if (iShoppingcartService.checkout(items)) {
            return Result.success("结算成功");
        } else {
            return Result.success("结算失败(可能存在已购买商品或余额不足）");
        }

    }
}
