package com.w1101.gamemarket.mapper;

import com.w1101.gamemarket.entity.Factory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
public interface FactoryMapper extends BaseMapper<Factory> {

    String findFactoryNameById(@Param("factoryId") Integer factoryId);
}
