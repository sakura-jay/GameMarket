package com.w1101.gamemarket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Review;
import com.w1101.gamemarket.service.IReviewService;
import com.w1101.gamemarket.utils.Result;
import com.w1101.gamemarket.vo.reviewVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Resource
    private IReviewService reviewService;
    @GetMapping("reviewi")
    public Result ReviewList(reviewVo vo){
        Page<Review> reviewList = reviewService.viewselect(vo);
        return Result.success( reviewList);
    }


    @PutMapping("addReview")
    public Result addReview(Review review){
        int result = reviewService.add(review);
        if (result==0) return Result.fail();
        return Result.success();
    }

}

