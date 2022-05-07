package com.huntercodexs.genericv1.exception;

import com.huntercodexs.genericv1.errors.GenericErrors;

public class MMBISExceptionGeneric extends MMBISException {

    public MMBISExceptionGeneric(int codeError, int subCodeError, String message) {
        super(codeError, subCodeError, message);
    }

    public MMBISExceptionGeneric(GenericErrors genericErrors) {
        super(genericErrors.getCodeError(), genericErrors.getSubCodeError(), genericErrors.getMessage());
    }

    public MMBISExceptionGeneric(GenericErrors genericErrors, String msg) {
        super(genericErrors.getCodeError(), genericErrors.getSubCodeError(), genericErrors.getMessage() + ", " + msg);
    }

}
