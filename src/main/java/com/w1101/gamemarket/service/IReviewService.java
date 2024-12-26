package com.w1101.gamemarket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Gameimage;
import com.w1101.gamemarket.entity.Gametype;
import com.w1101.gamemarket.entity.Review;
import com.baomidou.mybatisplus.extension.service.IService;
import com.w1101.gamemarket.vo.reviewVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
public interface IReviewService extends IService<Review> {

//    List<Review> viewselect(Review vo);

    Page<reviewVo> viewselect(reviewVo vo);

    int add(Review review);
}
