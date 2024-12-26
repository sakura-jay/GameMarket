package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.w1101.gamemarket.entity.Discount;
import com.w1101.gamemarket.entity.Gameimage;
import com.w1101.gamemarket.mapper.DiscountMapper;
import com.w1101.gamemarket.service.IDiscountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class DiscountServiceImpl extends ServiceImpl<DiscountMapper, Discount> implements IDiscountService {
@Resource DiscountMapper mapper;
    @Override
    public Discount selectDiscount(Discount vo) {
        QueryWrapper<Discount> wrapper=new QueryWrapper<>();
        wrapper.eq("game_id",vo.getGameId());
        Discount discount=mapper.selectOne(wrapper);
        return discount;
    }
}
