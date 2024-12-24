package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lv
 * @since 2024-12-24
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Gametype对象", description = "")
public class Gametype implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("游戏ID")
    @TableId("game_id")
    private Integer gameId;

    @ApiModelProperty("游戏类型")
    private String type;
}
