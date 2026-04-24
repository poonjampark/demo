package com.pzp.util.exception;

import com.pzp.util.response.EnumBaseI;

public class BussinessException extends AppException {
    private static final long serialVersionUID = 1L;

    public BussinessException(Throwable e) {
        super(e);
    }

    public BussinessException(Throwable e, EnumBaseI enumBaseI) {
        super(e);
        this.setEnumBaseI(enumBaseI);
    }

    public static BussinessException newException(Throwable e, EnumBaseI enumBaseI) {
        return new BussinessException(e, enumBaseI);
    }
}
