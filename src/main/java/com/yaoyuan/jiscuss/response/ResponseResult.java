package com.yaoyuan.jiscuss.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一的公共响应体
 *
 * @author NULL
 * @date 2019-12-16
 */
@Data
@AllArgsConstructor
public class ResponseResult implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

}
