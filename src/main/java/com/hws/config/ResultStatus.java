package com.hws.config;

public enum ResultStatus {
    SUCCESS(200, "成功"),
    PARAM_IS_INVALID(400, "无效参数"),
	USER_NOT_LOGGED_IN(401, "用户未登陆"),
	PERMISSION_NO_ACCESS(403, "无权限访问"),
	RESULE_DATA_NONE(404, "数据未找到"),
	DATA_ALREADY_EXISTED(409, "数据已存在"),
	INTERFACE_OUTTER_INVOKE_ERROR(500, "远程访问时出错"),
	SYSTEM_INNER_ERROR(500, "系统内部错误");
	
	
	private int code;
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
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
