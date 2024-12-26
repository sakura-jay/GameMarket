package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Gametype;
import com.w1101.gamemarket.entity.Review;
import com.w1101.gamemarket.mapper.ReviewMapper;
import com.w1101.gamemarket.service.IReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.w1101.gamemarket.vo.reviewVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements IReviewService {
    @Resource
    private ReviewMapper mapper;

//    @Override
//    public List<Review> viewselect(Review vo){
//        QueryWrapper<Review> wrapper = new QueryWrapper<>();
//        wrapper.eq("game_id",vo.getGameId());
//        List<Review> list=mapper.selectList(wrapper);
//        return list;
//    }
    @Override
    public Page<Review> viewselect(reviewVo vo){
        Page<Review> page=new Page<>(vo.getPageNum(),vo.getPageSize());
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        wrapper.eq("game_id",vo.getGameId());
//        List<Review> list=mapper.selectList(wrapper);
        Page<Review> reviewPage=mapper.selectPage(page,wrapper);
        return reviewPage;
    }

    @Override
    public int add(Review review) {

        return mapper.insert(review);
    }

}
