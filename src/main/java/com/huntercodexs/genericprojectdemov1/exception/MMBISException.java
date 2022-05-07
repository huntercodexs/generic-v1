package com.huntercodexs.genericprojectdemov1.exception;

public class MMBISException extends RuntimeException {

    int codeError;
    int subCodeError;
    String message;

    public MMBISException(int codeError, int subCodeError, String message) {
        this.codeError = codeError;
        this.subCodeError = subCodeError;
        this.message = message;
    }

    public MMBISException() {
    }

    public MMBISException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public MMBISException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public MMBISException(String arg0) {
        super(arg0);
    }

    public MMBISException(Throwable arg0) {
        super(arg0);
    }

    public int getCodeError() {
        return this.codeError;
    }

    public void setCodeError(int codeError) {
        this.codeError = codeError;
    }

    public int getSubCodeError() {
        return this.subCodeError;
    }

    public void setSubCodeError(int subCodeError) {
        this.subCodeError = subCodeError;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
