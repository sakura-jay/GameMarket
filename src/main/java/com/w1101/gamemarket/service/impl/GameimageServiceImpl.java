package com.w1101.gamemarket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.w1101.gamemarket.entity.Gameimage;
import com.w1101.gamemarket.mapper.GameimageMapper;
import com.w1101.gamemarket.mapper.GametypeMapper;
import com.w1101.gamemarket.service.IGameimageService;
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
public class GameimageServiceImpl extends ServiceImpl<GameimageMapper, Gameimage> implements IGameimageService {
    @Resource
    private GameimageMapper mapper;
    @Override
    public List<Gameimage> selectiamge(Gameimage vo) {
        QueryWrapper<Gameimage> wrapper=new QueryWrapper<>();
        wrapper.eq("game_id",vo.getGameId());
        List<Gameimage> list=mapper.selectList(wrapper);
        return list;
    }
}
