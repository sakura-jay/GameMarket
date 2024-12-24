package com.w1101.gamemarket.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.w1101.gamemarket.entity.Game;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w1101.gamemarket.vo.pageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
public interface GameMapper extends BaseMapper<Game> {
    Page<Game> selectByPage(@Param("page") Page<Game> page, @Param("userId") Integer userId);

    int selectPageTotal(pageVo vo);
}
