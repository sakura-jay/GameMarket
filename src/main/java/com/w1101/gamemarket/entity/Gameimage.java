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
@ApiModel(value = "Gameimage对象", description = "")
public class Gameimage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("game_id")
    private Integer gameId;

    @ApiModelProperty("游戏图片链接")
    private String image;
}
