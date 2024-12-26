package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.Gametype;
import com.w1101.gamemarket.service.IGametypeService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.gameselectvo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequestMapping("/gametype")
public class GametypeController {
    @Resource
    private IGametypeService gameService;

    @GetMapping("gametypei")
    public Result getGameList(Gametype vo) {
        return Result.success(gameService.gameselect(vo));
    }
}