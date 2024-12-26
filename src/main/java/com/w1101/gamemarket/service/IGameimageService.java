package com.w1101.gamemarket.service;

import com.w1101.gamemarket.entity.Gameimage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
public interface IGameimageService extends IService<Gameimage> {

    List<Gameimage> selectiamge(Gameimage vo);
}
