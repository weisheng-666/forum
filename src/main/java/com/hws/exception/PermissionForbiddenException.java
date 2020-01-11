package com.hws.exception;

import com.hws.config.ResultStatus;

public class PermissionForbiddenException extends BusinessException {

	private static final long serialVersionUID = 7415782789958572187L;

	public PermissionForbiddenException() {
        super();
    }

    public PermissionForbiddenException(Object data) {
        super();
        super.data = data;
    }

    public PermissionForbiddenException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public PermissionForbiddenException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public PermissionForbiddenException(String msg) {
        super(msg);
    }
}
