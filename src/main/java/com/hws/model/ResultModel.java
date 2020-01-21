package com.hws.model;

import java.io.Serializable;

import com.hws.config.ResultStatus;
import com.hws.exception.BusinessException;

/**
 * 自定义返回结果
 * @author XieEnlong
 * @date 2015/7/14.
 */
@SuppressWarnings("serial")
public class ResultModel implements Serializable{

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    /**
     * 返回内容
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
    
 

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = "";
    }

    public ResultModel(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel(ResultStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = "";
    }

    public ResultModel(ResultStatus status, Object data) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }

    public static ResultModel ok(Object data) {
        return new ResultModel(ResultStatus.SUCCESS, data);
    }

    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel error(BusinessException exception) {
        return new ResultModel(exception.getCode(),exception.getMessage(),exception.getData());
    }
}
