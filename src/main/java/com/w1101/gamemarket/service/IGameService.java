package com.w1101.gamemarket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.baomidou.mybatisplus.extension.service.IService;
import com.w1101.gamemarket.vo.carouselVo;
import com.w1101.gamemarket.vo.gamevo;
import com.w1101.gamemarket.vo.pageVo;
import com.w1101.gamemarket.vo.typevo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
public interface IGameService extends IService<Game> {

    List<Game> selectMainList();

    List<carouselVo> selectCarouselList();

    pageVo selectUserGameList(pageVo vo);

    Page<Game> selectlist(gamevo vo);

    typevo selecttypelist(typevo vo);

    int addGame();
}
