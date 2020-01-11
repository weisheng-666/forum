package com.hws.exception;

import com.hws.config.ResultStatus;

public class RemoteAccessException extends BusinessException {

	private static final long serialVersionUID = -6079030229028813987L;

	public RemoteAccessException() {
        super();
    }

    public RemoteAccessException(Object data) {
        super();
        super.data = data;
    }

    public RemoteAccessException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public RemoteAccessException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public RemoteAccessException(String msg) {
        super(msg);
    }
}
