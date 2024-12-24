package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@ApiModel(value = "Shoppingcart对象", description = "")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("购物车ID")
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("游戏ID")
    private Integer gameId;

    @ApiModelProperty("游戏数量")
    private Integer quantity;

    @ApiModelProperty("添加日期")
    private LocalDateTime addDate;
}
