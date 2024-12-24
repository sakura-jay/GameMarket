package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
 * @author qihui
 * @since 2024-12-24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("library")
@ApiModel(value = "Library对象", description = "")
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("game_id")
    private Integer gameId;

    private Integer userId;

    private LocalDate addTime;
}
