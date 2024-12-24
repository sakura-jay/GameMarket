package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "Purchase对象", description = "")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("交易ID")
    @TableId(value = "purchase_id", type = IdType.AUTO)
    private Integer purchaseId;

    @ApiModelProperty("游戏ID")
    private Integer gameId;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("购买日期")
    private LocalDateTime purchaseDate;

    @ApiModelProperty("实际支付金额")
    private BigDecimal purchaseAmount;
}
