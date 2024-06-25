package com.example.azuredemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableId(type = IdType.AUTO)

    /**登录名*/
    private String loginName;

    /**用户昵称*/
    private String userName;

    /**密码*/
    private String password;

    /**状态(0.禁用 1.启用)*/
    private Integer userStatus;

    /**创建人id*/
    private Integer createBy;

    /**创建人姓名*/
    private String createByName;

    /**创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**修改人id*/
    private Integer updateBy;

    /**修改人姓名*/
    private String updateByName;

    /**修改时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**是否删除*/
    private int isDelete;
}
