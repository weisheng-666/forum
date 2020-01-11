package com.hws.exception;

import com.hws.config.ResultStatus;

public class UserNotLoginException extends BusinessException {

	private static final long serialVersionUID = 3383166995848288273L;

	public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(Object data) {
        super();
        super.data = data;
    }

    public UserNotLoginException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public UserNotLoginException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }
}
