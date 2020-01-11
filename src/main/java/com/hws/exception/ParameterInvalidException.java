package com.hws.exception;

import com.hws.config.ResultStatus;

public class ParameterInvalidException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public ParameterInvalidException() {
        super();
    }

    public ParameterInvalidException(Object data) {
        super();
        super.data = data;
    }

    public ParameterInvalidException(ResultStatus resultStatus) {
        super(resultStatus);
    }

    public ParameterInvalidException(ResultStatus resultStatus, Object data) {
        super(resultStatus, data);
    }

    public ParameterInvalidException(String msg) {
        super(msg);
    }
}
