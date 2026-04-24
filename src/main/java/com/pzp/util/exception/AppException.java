package com.pzp.util.exception;

import com.pzp.util.response.EnumBaseI;

public class AppException extends RuntimeException {
    private EnumBaseI enumBaseI;
    private static final long serialVersionUID = 1L;

    public AppException(Throwable e) {
        super(e);
    }

    public AppException(String errorMsg) {
        super(errorMsg);
    }

    public EnumBaseI getEnumBaseI() {
        return this.enumBaseI;
    }

    public void setEnumBaseI(EnumBaseI enumBaseI) {
        this.enumBaseI = enumBaseI;
    }
}

