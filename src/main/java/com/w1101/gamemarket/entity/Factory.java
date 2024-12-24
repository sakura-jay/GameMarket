package com.w1101.gamemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value = "Factory对象", description = "")
public class Factory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("工厂ID")
    @TableId(value = "factory_id", type = IdType.AUTO)
    private Integer factoryId;

    @ApiModelProperty("工厂名称")
    private String factoryName;

    @ApiModelProperty("联系方式")
    private String contactInfo;
}
