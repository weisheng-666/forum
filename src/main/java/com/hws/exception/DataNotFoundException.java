package com.hws.exception;

import com.hws.config.ResultStatus;

public class DataNotFoundException extends BusinessException {

	private static final long serialVersionUID = -3590324862250728160L;

	public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public DataNotFoundException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public DataNotFoundException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
