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
@ApiModel(value = "Transaction对象", description = "")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("交易ID")
    @TableId(value = "transaction_id", type = IdType.AUTO)
    private Integer transactionId;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("交易类型")
    private String transactionType;

    @ApiModelProperty("金额")
    private BigDecimal transactionAmount;

    @ApiModelProperty("交易日期")
    private LocalDateTime transactionDate;
}
