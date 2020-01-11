package com.hws.exception;

import com.hws.config.ResultStatus;

public class DataConflictException extends BusinessException {

	private static final long serialVersionUID = 609882980798513455L;

	public DataConflictException() {
        super();
    }

    public DataConflictException(Object data) {
        super();
        super.data = data;
    }

    public DataConflictException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public DataConflictException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public DataConflictException(String msg) {
        super(msg);
    }
}
