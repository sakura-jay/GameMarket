package com.w1101.gamemarket.controller;

import com.w1101.gamemarket.entity.Discount;
import com.w1101.gamemarket.service.IDiscountService;
import com.w1101.gamemarket.utils.Result;
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
@RequestMapping("/discount")
public class DiscountController {
@Resource
private IDiscountService discountService;
@GetMapping("discounti")
    public Discount GetDiscount(Discount vo){
    return discountService.selectDiscount(vo);
    }
}
