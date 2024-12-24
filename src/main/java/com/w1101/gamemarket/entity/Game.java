package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.poi.hpsf.Decimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author qihui
 * @since 2024-12-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("game")
@ApiModel(value = "Game对象", description = "")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("游戏ID")
    @TableId(value = "game_id", type = IdType.AUTO)
    private Integer gameId;

    @ApiModelProperty("游戏封面")
    private String gameAvatar;

    @ApiModelProperty("游戏标题")
    private String gameTitle;

    @ApiModelProperty("游戏描述")
    private String description;

    @ApiModelProperty("发布日期")
    private LocalDate releaseDate;

    @ApiModelProperty("原价格")
    private BigDecimal price;

    @ApiModelProperty("销量")
    private Integer volume;

    @ApiModelProperty("游戏运行平台")
    private String platform;

    @ApiModelProperty("游戏评分")
    private Double rate;

    @ApiModelProperty("工厂ID")
    private Integer factoryId;

    @ApiModelProperty("游戏状态")
    private Integer gameStatus;

    @ApiModelProperty("游戏售价")
    private  BigDecimal cost;

    @ApiModelProperty("打折倍率")
    @TableField(exist = false)
    private String discountRate;

    @ApiModelProperty("添加到库的时间")
    @TableField(exist = false)
    private LocalDate addTime;

}
