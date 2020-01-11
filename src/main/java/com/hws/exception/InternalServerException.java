package com.hws.exception;

import com.hws.config.ResultStatus;

public class InternalServerException extends BusinessException {

	private static final long serialVersionUID = -7561966012991363128L;

	public InternalServerException() {
        super();
    }

    public InternalServerException(Object data) {
        super();
        super.data = data;
    }

    public InternalServerException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public InternalServerException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public InternalServerException(String msg) {
        super(msg);
    }
}
