package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.service.IGameService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.carouselVo;
import com.w1101.gamemarket.vo.pageVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
