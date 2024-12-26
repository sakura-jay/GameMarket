package com.w1101.gamemarket.service;

import com.w1101.gamemarket.entity.Gametype;
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
public interface IGametypeService extends IService<Gametype> {

    List<Gametype> gameselect(Gametype vo);


}
