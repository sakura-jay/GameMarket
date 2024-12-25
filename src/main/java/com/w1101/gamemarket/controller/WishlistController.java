package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.Wishlist;
import com.w1101.gamemarket.service.IWishlistService;
import com.w1101.gamemarket.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
@Slf4j//用于使用log.info
@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private IWishlistService iWishlistService;

    @GetMapping("/getlist")
    public Result getlist(Wishlist wishlist) {
        log.info("查询愿望单数据");
        List<WishListVo> list = iWishlistService.getlist(wishlist);
        return Result.success(list);
    }

    @PostMapping("/sort")
    public Result sort(@RequestParam("userId") Integer userId, @RequestParam("sortId") Integer sortId) {
        log.info("查询功能调用");
        List<WishListVo> list = iWishlistService.sort(userId, sortId);

    return Result.success(list);
    }

    @PostMapping("/add")
    public Result add(@RequestParam("userId") Integer userId, @RequestParam("gameId") Integer gameId) {
        log.info("添加到愿望单数据");
        if(iWishlistService.add(userId, gameId)){
           return Result.success("添加成功");
        }
        else {
            return Result.success("添加失败");
        }
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("userId") Integer userId, @RequestParam("gameId") Integer gameId) {
        log.info("删除愿望单数据");
        iWishlistService.delete(userId, gameId);
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        return Result.success(getlist(wishlist)
        );
    }

}
