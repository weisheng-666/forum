package com.hws.config;

public enum ResultStatus {
    SUCCESS(200, "成功",0L),
    PARAM_IS_INVALID(400, "无效参数",0L),
	USER_NOT_LOGGED_IN(401, "用户未登陆",0L),
	PERMISSION_NO_ACCESS(403, "无权限访问",0L),
	RESULE_DATA_NONE(404, "数据未找到",0L),
	DATA_ALREADY_EXISTED(409, "数据已存在",0L),
	INTERFACE_OUTTER_INVOKE_ERROR(500, "远程访问时出错",0L),
	SYSTEM_INNER_ERROR(500, "系统内部错误",0L);
	
	private long total;
	private int code;
    private String message;

    ResultStatus(int code, String message,long total) {
        this.code = code;
        this.message = message;
        this.total = total;
    }

    public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
