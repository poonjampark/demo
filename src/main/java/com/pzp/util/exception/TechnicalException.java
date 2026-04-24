package com.pzp.util.exception;

import com.pzp.util.response.EnumBaseI;

public class TechnicalException extends AppException {
    private static final long serialVersionUID = 1L;

    public TechnicalException(Throwable e) {
        super(e);
    }

    public TechnicalException(Throwable e, EnumBaseI enumBaseI) {
        super(e);
        this.setEnumBaseI(enumBaseI);
    }

    public static TechnicalException newException(Throwable e, EnumBaseI enumBaseI) {
        return new TechnicalException(e, enumBaseI);
    }
}
