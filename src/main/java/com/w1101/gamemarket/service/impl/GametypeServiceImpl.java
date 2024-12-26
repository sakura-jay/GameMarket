package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.w1101.gamemarket.entity.Game;
import com.w1101.gamemarket.entity.Gametype;
import com.w1101.gamemarket.mapper.GametypeMapper;
import com.w1101.gamemarket.service.IGametypeService;
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
public class GametypeServiceImpl extends ServiceImpl<GametypeMapper, Gametype> implements IGametypeService {
@Resource
private  GametypeMapper mapper;
    @Override
    public List<Gametype> gameselect(Gametype vo) {
        QueryWrapper<Gametype> wrapper = new QueryWrapper<>();
        wrapper.eq("game_id",vo.getGameId());
        List<Gametype> list=mapper.selectList(wrapper);
        return list;
    }
}
