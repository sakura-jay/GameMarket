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
@ApiModel(value = "Discount对象", description = "")
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("折扣ID")
    @TableId(value = "discount_id", type = IdType.AUTO)
    private Integer discountId;

    @ApiModelProperty("游戏ID")
    private Integer gameId;

    @ApiModelProperty("折扣率")
    private BigDecimal discountRate;

    @ApiModelProperty("开始日期")
    private LocalDateTime startDate;

    @ApiModelProperty("结束日期")
    private LocalDateTime endDate;
}
