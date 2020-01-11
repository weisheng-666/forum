package com.hws.exception;

import com.hws.config.ExceptionEnum;
import com.hws.config.ResultStatus;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -3098668133429370117L;

	protected int code;

    protected String message;

    protected ResultStatus resultStatus;

    protected Object data;

    public BusinessException() {
        ExceptionEnum exceptionEnum = ExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultStatus = exceptionEnum.getResultStatus();
            code = exceptionEnum.getResultStatus().getCode();
            message = exceptionEnum.getResultStatus().getMessage();
        }

    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(ResultStatus resultStatus, Object data) {
        this(resultStatus);
        this.data = data;
    }

    public BusinessException(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
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

	public ResultStatus getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(ResultStatus resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
