package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.Gameimage;
import com.w1101.gamemarket.service.IGameimageService;
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
 * @author Lv
 * @since 2024-12-24
 */
@RestController
@RequestMapping("/gameimage")
public class GameimageController {
@Resource
private IGameimageService gameimageService;
@GetMapping("gameimagei")
    public List<Gameimage> getGameImage(Gameimage vo){
    return gameimageService.selectiamge(vo);
}
}
