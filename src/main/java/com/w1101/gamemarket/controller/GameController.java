package com.w1101.gamemarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.service.IGameService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
