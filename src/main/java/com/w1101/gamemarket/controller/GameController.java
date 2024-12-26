package com.w1101.gamemarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.service.IGameService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
@RestController
@RequestMapping("/game")
public class GameController {
     @Resource
     private IGameService gameService;

    @GetMapping("/main")
    public Result main(){

        List<Game> gameList = gameService.selectMainList();

        return Result.success(gameList);
    }

    @GetMapping("goodGame")
    public Result goodGame(){
        List<carouselVo> gameList =  gameService.selectCarouselList();
        return Result.success(gameList);
    }

    @GetMapping("userGameList")
    public Result getGameList(pageVo vo){
        return Result.success(gameService.selectUserGameList(vo));
    }

    @GetMapping("gamei")
    public Result getGameList(gameselectvo vo){
        return Result.success(gameService.gameselect(vo));
    }




    @GetMapping("/factory-name")
    public String getFactoryName(@RequestParam("gameId") Integer gameId) {
        try {
            // 调用服务层获取工厂名称
            String factoryName = gameService.getFactoryNameByGameId(gameId);

            if (factoryName != null) {
                return factoryName; // 返回工厂名称
            } else {
                return "游戏不存在"; // 游戏不存在时返回错误信息
            }
        } catch (Exception e) {
            return "查询失败：" + e.getMessage(); // 异常时返回错误信息
        }
    }




    @GetMapping("/alllist")
    public Result AllList(gamevo vo) {
        System.out.println (vo.getTitle());
        Page<Game> list = gameService.selectlist(vo);
        return Result.success(list);
    }

    @GetMapping("/typelist")
    public Result typeList( typevo vo) {

        typevo list = gameService.selecttypelist(vo);
        return Result.success(list);
    }



}
